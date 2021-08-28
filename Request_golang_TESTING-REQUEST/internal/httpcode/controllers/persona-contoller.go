package controllers

import (
	"encoding/json"
	"log"
	"net/http"

	"github.com/alejandrosubero/resquest_golang/internal/conmons"
	"github.com/alejandrosubero/resquest_golang/internal/httpcode/handler"
	"github.com/alejandrosubero/resquest_golang/internal/models"
	"github.com/gorilla/mux"
)

func GetALL(writer http.ResponseWriter, request *http.Request) {

	personas := []models.Persona{}
	db := conmons.GetConnection()
	defer db.Close()
	db.LogMode(true)
	db.Preload("Direcciones").Find(&personas)
	json, _ := json.Marshal(personas)
	handler.SendResponse(writer, http.StatusOK, json)
	db.LogMode(false)
}

func Save(writer http.ResponseWriter, request *http.Request) {
	persona := models.Persona{}
	db := conmons.GetConnection()

	db.LogMode(true)
	defer db.Close()

	error := json.NewDecoder(request.Body).Decode(&persona)
	if error != nil {
		log.Fatal(error)
		handler.SendError(writer, http.StatusBadRequest)
		return
	}

	error = db.Save(&persona).Error
	if error != nil {
		log.Fatal(error)
		handler.SendError(writer, http.StatusInternalServerError)
		return
	}

	json, _ := json.Marshal(persona)
	handler.SendResponse(writer, http.StatusCreated, json)
	db.LogMode(false)
}

func Delete(writer http.ResponseWriter, request *http.Request) {

	persona := models.Persona{}
	db := conmons.GetConnection()
	defer db.Close()
	id := mux.Vars(request)["id"]

	// db.Find(&persona, id)
	db.Preload("Direcciones").Find(&persona, id)

	if persona.ID > 0 {
		db.Delete(persona)
		handler.SendResponse(writer, http.StatusOK, []byte(`{}`))
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
}

func Get(writer http.ResponseWriter, request *http.Request) {
	persona := models.Persona{}
	id := mux.Vars(request)["id"]
	db := conmons.GetConnection()
	db.LogMode(true)
	defer db.Close()

	db.Preload("Direcciones").Find(&persona, id)
	// db.Find(&persona, id)

	if persona.ID > 0 {
		json, _ := json.Marshal(persona)
		handler.SendResponse(writer, http.StatusOK, json)
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
	db.LogMode(false)
}

func GetByApellido(writer http.ResponseWriter, request *http.Request) {
	persona := models.Persona{}
	apellido := mux.Vars(request)["apellido"]
	db := conmons.GetConnection()
	db.LogMode(true)
	defer db.Close()
	// db.Find(&persona, apellido)
	db.Preload("Direcciones").Find(&persona, apellido)

	if persona.ID > 0 {
		json, _ := json.Marshal(persona)
		handler.SendResponse(writer, http.StatusOK, json)
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
	db.LogMode(false)
}

func GetByNombre(writer http.ResponseWriter, request *http.Request) {
	persona := models.Persona{}
	nombre := mux.Vars(request)["nombre"]
	db := conmons.GetConnection()
	db.LogMode(true)
	defer db.Close()

	// db.Find(&persona, nombre)
	db.Preload("Direcciones").Find(&persona, nombre)

	if persona.ID > 0 {
		json, _ := json.Marshal(persona)
		handler.SendResponse(writer, http.StatusOK, json)
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
	db.LogMode(false)
}

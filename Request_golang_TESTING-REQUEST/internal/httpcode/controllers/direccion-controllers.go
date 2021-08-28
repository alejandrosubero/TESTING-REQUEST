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

func Pink(writer http.ResponseWriter, request *http.Request) {
	json, _ := json.Marshal("<h1>Conectado.... ---- Funcionando....</h1>")
	handler.SendResponse(writer, http.StatusOK, json)
}

func GetALLDireccion(writer http.ResponseWriter, request *http.Request) {

	direccion := []models.Direccion{}
	db := conmons.GetConnection()
	defer db.Close()
	db.LogMode(true)
	db.Find(&direccion)
	json, _ := json.Marshal(direccion)
	handler.SendResponse(writer, http.StatusOK, json)
	db.LogMode(false)
}

func GetDireccion(writer http.ResponseWriter, request *http.Request) {
	direccion := models.Direccion{}
	id := mux.Vars(request)["id"]
	db := conmons.GetConnection()
	db.LogMode(true)
	defer db.Close()
	db.Find(&direccion, id)

	if direccion.ID > 0 {
		json, _ := json.Marshal(direccion)
		handler.SendResponse(writer, http.StatusOK, json)
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
	db.LogMode(false)
}

func SaveDireccion(writer http.ResponseWriter, request *http.Request) {
	direccion := models.Direccion{}
	db := conmons.GetConnection()
	db.LogMode(true)
	defer db.Close()

	error := json.NewDecoder(request.Body).Decode(&direccion)
	if error != nil {
		log.Fatal(error)
		handler.SendError(writer, http.StatusBadRequest)
		return
	}

	error = db.Save(&direccion).Error
	if error != nil {
		log.Fatal(error)
		handler.SendError(writer, http.StatusInternalServerError)
		return
	}

	json, _ := json.Marshal(direccion)
	handler.SendResponse(writer, http.StatusCreated, json)
	db.LogMode(false)
}

func DeleteDireccion(writer http.ResponseWriter, request *http.Request) {

	direccion := models.Direccion{}

	db := conmons.GetConnection()
	defer db.Close()
	id := mux.Vars(request)["id"]

	db.Find(&direccion, id)

	if direccion.ID > 0 {
		db.Delete(direccion)
		handler.SendResponse(writer, http.StatusOK, []byte(`{}`))
	} else {
		handler.SendError(writer, http.StatusNotFound)
	}
}

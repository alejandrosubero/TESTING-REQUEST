package controller

import (
	"bytes"
	"encoding/json"
	"fmt"
	"log"
	"net"
	"net/http"
	"strconv"
	"sync"
	"time"

	"github.com/alejandrosubero/cliente/internal/httpcode/handler"
	"github.com/alejandrosubero/cliente/internal/models"
	"github.com/alejandrosubero/cliente/internal/pkg"
	"github.com/gorilla/mux"
)

var netClient = &http.Client{}

func starCliente(numCoroutines int) {
	tr := &http.Transport{
		Proxy: http.ProxyFromEnvironment,
		DialContext: (&net.Dialer{
			Timeout:   100 * time.Second,
			KeepAlive: 100 * time.Second,
		}).DialContext,
		MaxIdleConnsPerHost:   numCoroutines,
		MaxIdleConns:          100,
		IdleConnTimeout:       90 * time.Second,
		TLSHandshakeTimeout:   10 * time.Second,
		ExpectContinueTimeout: 1 * time.Second,
	}
	netClient = &http.Client{Transport: tr}
}

// RETURN THE HELLO SERVER
func Base(writer http.ResponseWriter, request *http.Request) {
	log.Println("Inicio de la llamada al server ")
	writer.Header().Set("Content-Type", "text/html")
	fmt.Fprint(writer, "<h1>Hello CREATOR FROM Golang!</h1>")
	log.Println("fin de la llamada al server")
}

func Save(writer http.ResponseWriter, request *http.Request) {

	port := mux.Vars(request)["port"]
	number := mux.Vars(request)["number"]
	i, _ := strconv.Atoi(number)
	persona := models.Persona{}
	personas := []models.Persona{}
	gs := i
	var wg sync.WaitGroup

	wg.Add(gs)

	// http.DefaultTransport.(*http.Transport).MaxIdleConnsPerHost = numCoroutines
	// http.DefaultTransport.(*http.Transport).MaxIdleConnsPerHost = gs
	starCliente(gs)

	for i := 0; i < gs; i++ {
		h := i
		go func() {
			persona = call(port, h)
			personas = append(personas, persona)
			log.Printf("%v", persona)
			defer wg.Done()
		}()
	}
	wg.Wait()
	json, _ := json.Marshal(personas)
	handler.SendResponse(writer, http.StatusOK, json)
}

func call(port string, numero int) models.Persona {

	persona := pkg.NewPersona()

	json_data, err := json.Marshal(persona)
	if err != nil {
		log.Println("ocurrio un log faltal en el envio del post de testing")
		log.Fatal(err)
	}
	log.Println("(" + strconv.Itoa(numero) + ")" + "http://localhost:" + port + "/persona/api/save")

	resp, err := netClient.Post("http://localhost:"+port+"/persona/api/save", "application/json", bytes.NewBuffer(json_data))
	if err != nil {
		log.Println("ocurrio un log faltal en la respuesta del el envio del post de testing")
		log.Fatal(err)
	}

	json.NewDecoder(resp.Body).Decode(&persona)

	return persona
}

func All(writer http.ResponseWriter, request *http.Request) {

	port := mux.Vars(request)["port"]
	personas := []models.Persona{}

	resp, err := http.Get("http://localhost:" + port + "/persona/api/GetAllPersona")
	if err != nil {
		log.Println("ocurrio un log faltal en la respuesta del el envio del post de testing")
		log.Fatal(err)
	}

	json.NewDecoder(resp.Body).Decode(&personas)

	json, _ := json.Marshal(personas)
	handler.SendResponse(writer, http.StatusOK, json)
}

func FindByIdDinamic(writer http.ResponseWriter, request *http.Request) {

	var wg sync.WaitGroup
	persona := models.Persona{}
	port := mux.Vars(request)["port"]
	number := mux.Vars(request)["number"]

	gs, _ := strconv.Atoi(number)
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		h := i + 1
		go func() {
			persona = callGet("http://localhost:" + port + "/persona/api/GetPersona/" + strconv.Itoa(h))
			log.Printf("Persona(%v) = id: %v, Nombre: %v, Apellido: %v, Calle: %v, Casa: %v, Ciudad: %v ", h, persona.ID, persona.Nombre, persona.Apellido, persona.Direcciones.Calle, persona.Direcciones.Casa, persona.Direcciones.Ciudad)
			wg.Done()
		}()
	}
	wg.Wait()

	json, _ := json.Marshal(persona)
	handler.SendResponse(writer, http.StatusOK, json)
}

func FindById(writer http.ResponseWriter, request *http.Request) {

	var wg sync.WaitGroup
	persona := models.Persona{}
	port := mux.Vars(request)["port"]
	number := mux.Vars(request)["number"]
	campo := mux.Vars(request)["campo"]

	gs, _ := strconv.Atoi(number)
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		h := i + 1
		go func() {
			persona = callGet("http://localhost:" + port + "/persona/api/GetPersona/" + campo)
			log.Printf("Persona(%v) = id: %v, Nombre: %v, Apellido: %v, Calle: %v, Casa: %v, Ciudad: %v ", h, persona.ID, persona.Nombre, persona.Apellido, persona.Direcciones.Calle, persona.Direcciones.Casa, persona.Direcciones.Ciudad)

			wg.Done()
		}()
	}
	wg.Wait()
	json, _ := json.Marshal(persona)
	handler.SendResponse(writer, http.StatusOK, json)
}

func FindByGetNombre(writer http.ResponseWriter, request *http.Request) {

	var wg sync.WaitGroup
	persona := models.Persona{}
	port := mux.Vars(request)["port"]
	number := mux.Vars(request)["number"]
	campo := mux.Vars(request)["campo"]
	gs, _ := strconv.Atoi(number)

	wg.Add(gs)

	for i := 0; i < gs; i++ {
		h := i + 1
		go func() {
			persona = callGet("http://localhost:" + port + "/persona/api/GetNombre/" + campo)
			log.Printf("Persona(%v) = id: %v, Nombre: %v, Apellido: %v, Calle: %v, Casa: %v, Ciudad: %v ", h, persona.ID, persona.Nombre, persona.Apellido, persona.Direcciones.Calle, persona.Direcciones.Casa, persona.Direcciones.Ciudad)

			wg.Done()
		}()
	}
	wg.Wait()
	json, _ := json.Marshal(persona)
	handler.SendResponse(writer, http.StatusOK, json)
}

func FindByGetApellido(writer http.ResponseWriter, request *http.Request) {

	var wg sync.WaitGroup
	persona := models.Persona{}
	port := mux.Vars(request)["port"]
	number := mux.Vars(request)["number"]
	campo := mux.Vars(request)["campo"]

	gs, _ := strconv.Atoi(number)

	wg.Add(gs)
	for i := 0; i < gs; i++ {
		h := i + 1
		go func() {
			persona = callGet("http://localhost:" + port + "/persona/api/GetApellido/" + campo)
			log.Printf("Persona(%v) = id: %v, Nombre: %v, Apellido: %v, Calle: %v, Casa: %v, Ciudad: %v ", h, persona.ID, persona.Nombre, persona.Apellido, persona.Direcciones.Calle, persona.Direcciones.Casa, persona.Direcciones.Ciudad)

			wg.Done()
		}()
	}
	wg.Wait()
	json, _ := json.Marshal(persona)
	handler.SendResponse(writer, http.StatusOK, json)
}

func callGet(url string) models.Persona {
	persona := models.Persona{}
	resp, err := http.Get(url)
	if err != nil {
		log.Println("ocurrio un log faltal en la respuesta del el envio del post de testing")
		log.Fatal(err)
	}
	json.NewDecoder(resp.Body).Decode(&persona)
	return persona
}

package main

import (
	"log"
	"net/http"

	"github.com/alejandrosubero/resquest_golang/internal/conmons"
	"github.com/alejandrosubero/resquest_golang/internal/httpcode/routes"
	"github.com/gorilla/mux"
)

func main() {
	conmons.Migrate()

	router := mux.NewRouter()
	routes.SetRoutes(router)

	server := http.Server{
		Addr:    ":9001",
		Handler: router,
	}

	log.Println("ejecutansose servidor en el puerto 9001")
	log.Panicln(server.ListenAndServe())
}

package routes

import (
	"github.com/alejandrosubero/cliente/internal/httpcode/controller"
	"github.com/gorilla/mux"
)

func SetRoutes(router *mux.Router) {
	subRoutePersona := router.PathPrefix("/cliente/api").Subrouter()
	subRoutePersona.HandleFunc("/hello", controller.Base).Methods("GET")
	subRoutePersona.HandleFunc("/save/{port}/{number}", controller.Save).Methods("GET")
	subRoutePersona.HandleFunc("/all/{port}", controller.All).Methods("GEt")
	subRoutePersona.HandleFunc("/ids/{port}/{number}", controller.FindByIdDinamic).Methods("GEt")
	// subRoutePersona.HandleFunc("/id/{port}/{number}", ).Methods("GEt")
	// subRoutePersona.HandleFunc("/nombre/{port}/{number}/{campo}", ).Methods("GEt")
	// subRoutePersona.HandleFunc("/apellido/{port}/{number}/{campo}", ).Methods("GEt")
}

/*
http://localhost:5001/cliente/api/save/9001/2
http://localhost:5001/cliente/api/ids/9001/2
http://localhost:5001/cliente/api/all/9001
**/

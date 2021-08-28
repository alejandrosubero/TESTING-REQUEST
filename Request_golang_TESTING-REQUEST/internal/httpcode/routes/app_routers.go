package routes

import (
	"github.com/alejandrosubero/resquest_golang/internal/httpcode/controllers"
	"github.com/gorilla/mux"
)

func SetRoutes(router *mux.Router) {
	subRoutePersona := router.PathPrefix("/persona/api").Subrouter()
	subRoutePersona.HandleFunc("/GetAllPersona", controllers.GetALL).Methods("GEt")
	subRoutePersona.HandleFunc("/save", controllers.Save).Methods("POST")
	subRoutePersona.HandleFunc("/delete/{id}", controllers.Delete).Methods("POST")
	subRoutePersona.HandleFunc("/GetPersona/{id}", controllers.Get).Methods("GEt")
	subRoutePersona.HandleFunc("/GetNombre/{nombre}", controllers.GetByApellido).Methods("GEt")
	subRoutePersona.HandleFunc("/GetApellido/{apellido}", controllers.GetByNombre).Methods("GEt")

	subRouteDirection := router.PathPrefix("/Direccion/api").Subrouter()
	subRouteDirection.HandleFunc("/", controllers.Pink).Methods("GEt")
	subRouteDirection.HandleFunc("/all", controllers.GetALLDireccion).Methods("GEt")
	subRouteDirection.HandleFunc("/save", controllers.SaveDireccion).Methods("POST")
	subRouteDirection.HandleFunc("/delete/{id}", controllers.DeleteDireccion).Methods("POST")
	subRouteDirection.HandleFunc("/find/{id}", controllers.GetDireccion).Methods("GEt")
}

/* Falta implementar

   @GetMapping("/Getnombrecontain/{nombre}")  findByNombreContain(@PathVariable("nombre") String  nombre)

   @GetMapping("/Getapellidocontain/{apellido}") findByApellidoContain(@PathVariable("apellido") String  apellido)

   @PostMapping("/findDirecion") findRelacionDireccion(@RequestBody DireccionPojo direccion)

*/

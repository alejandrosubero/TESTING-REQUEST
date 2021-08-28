package main

import (
	"log"
	"net/http"

	routes "github.com/alejandrosubero/cliente/internal/httpcode/routers"
	"github.com/gorilla/mux"
	"github.com/rs/cors"
)

func main() {

	port := ":5001"
	router := mux.NewRouter()
	routes.SetRoutes(router)

	//MANEJO DE LOS CROS PERMITIDOS PARA EL PROYECTO
	c := cors.New(cors.Options{
		AllowedOrigins:   []string{"*"},
		AllowedMethods:   []string{"GET", "POST", "PUT", "DELETE", "OPTIONS"},
		AllowCredentials: true,
		AllowedHeaders:   []string{"Accept", "Content-Type", "Content-Length", "Accept-Encoding", "X-CSRF-Token", "Authorization"},
	})

	log.Printf("ejecutansose servidor en el puerto %v", port)
	http.ListenAndServe(port, c.Handler(router))

}

type MyServer struct {
	r *mux.Router
}

func (s *MyServer) ServeHTTP(rw http.ResponseWriter, req *http.Request) {
	if origin := req.Header.Get("Origin"); origin != "" {
		rw.Header().Set("Access-Control-Allow-Origin", origin)
		rw.Header().Set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
		rw.Header().Set("Access-Control-Allow-Headers",
			"Accept, Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization")
	}

	if req.Method == "OPTIONS" {
		return
	}

	s.r.ServeHTTP(rw, req)
}

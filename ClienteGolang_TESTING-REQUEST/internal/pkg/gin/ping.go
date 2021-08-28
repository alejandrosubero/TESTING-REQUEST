package gin

import (
	"bytes"
	"encoding/json"
	"log"
	"net/http"
	"strconv"
	"sync"

	"github.com/alejandrosubero/cliente/internal/models"
	"github.com/alejandrosubero/cliente/internal/pkg"
	"github.com/gin-gonic/gin"
)

func PingGET() gin.HandlerFunc {

	return func(c *gin.Context) {
		c.JSON(http.StatusOK, map[string]string{
			"hello": "fond me",
		})
	}
}

func Save() gin.HandlerFunc {

	return func(c *gin.Context) {

		port := c.Param("port")
		number := c.Param("number")
		i, _ := strconv.Atoi(number)

		persona := models.Persona{}
		personas := []models.Persona{}
		gs := i
		var wg sync.WaitGroup

		wg.Add(gs)

		for i := 0; i < gs; i++ {
			go func() {
				persona = call(port)
				personas = append(personas, persona)
				wg.Done()
			}()

		}
		wg.Wait()
		c.JSON(http.StatusOK, personas)
	}
}

func call(port string) models.Persona {

	persona := pkg.NewPersona()

	json_data, err := json.Marshal(persona)
	if err != nil {
		log.Println("ocurrio un log faltal en el envio del post de testing")
		log.Fatal(err)
	}

	resp, err := http.Post("http://localhost:"+port+"/persona/api/save", "application/json", bytes.NewBuffer(json_data))
	if err != nil {
		log.Println("ocurrio un log faltal en la respuesta del el envio del post de testing")
		log.Fatal(err)
	}

	json.NewDecoder(resp.Body).Decode(&persona)

	//var res map[string]interface{}
	//json.NewDecoder(resp.Body).Decode(&res)
	//fmt.Println(res["json"])
	//c.JSON(http.StatusOK, res)
	//	fmt.Println(persona)

	return persona
}

func All() gin.HandlerFunc {

	return func(c *gin.Context) {
		port := c.Param("port")
		personas := []models.Persona{}

		resp, err := http.Get("http://localhost:" + port + "/persona/api/GetAllPersona")
		if err != nil {
			log.Println("ocurrio un log faltal en la respuesta del el envio del post de testing")
			log.Fatal(err)
		}

		json.NewDecoder(resp.Body).Decode(&personas)
		c.JSON(http.StatusOK, personas)
	}
}

func FindByIdDinamic() gin.HandlerFunc {

	return func(c *gin.Context) {
		var wg sync.WaitGroup
		persona := models.Persona{}

		port := c.Param("port")
		number := c.Param("number")

		gs, _ := strconv.Atoi(number)

		wg.Add(gs)

		for i := 0; i < gs; i++ {
			h := i + 1
			go func() {
				persona = callGet("http://localhost:" + port + "/persona/api/GetPersona/" + strconv.Itoa(h))
				// persona.Nombre = persona.Nombre + "#" + strconv.Itoa(h)
				log.Printf("Persona(%v) = id: %v, Nombre: %v, Apellido: %v, Calle: %v, Casa: %v, Ciudad: %v ", h, persona.ID, persona.Nombre, persona.Apellido, persona.Direcciones.Calle, persona.Direcciones.Casa, persona.Direcciones.Ciudad)
				wg.Done()
			}()
		}
		wg.Wait()
		c.JSON(http.StatusOK, persona)
	}
}

func FindById() gin.HandlerFunc {

	return func(c *gin.Context) {
		var wg sync.WaitGroup
		persona := models.Persona{}

		port := c.Param("port")
		number := c.Param("number")
		campo := c.Param("campo")

		gs, _ := strconv.Atoi(number)

		wg.Add(gs)

		for i := 0; i < gs; i++ {
			go func() {
				persona = callGet("http://localhost:" + port + "/persona/api/GetPersona/" + campo)
				persona.Nombre = persona.Nombre + "#" + strconv.Itoa(i)
				wg.Done()
			}()
		}
		wg.Wait()
		c.JSON(http.StatusOK, persona)
	}
}

func FindByGetNombre() gin.HandlerFunc {

	return func(c *gin.Context) {
		var wg sync.WaitGroup
		persona := models.Persona{}

		port := c.Param("port")
		number := c.Param("number")
		campo := c.Param("campo")
		gs, _ := strconv.Atoi(number)

		wg.Add(gs)

		for i := 0; i < gs; i++ {
			go func() {
				persona = callGet("http://localhost:" + port + "/persona/api/GetNombre/" + campo)
				persona.Nombre = persona.Nombre + "#" + strconv.Itoa(i)
				wg.Done()
			}()
		}
		wg.Wait()
		c.JSON(http.StatusOK, persona)
	}
}

func FindByGetApellido() gin.HandlerFunc {

	return func(c *gin.Context) {
		var wg sync.WaitGroup
		persona := models.Persona{}

		port := c.Param("port")
		number := c.Param("number")
		campo := c.Param("campo")

		gs, _ := strconv.Atoi(number)

		wg.Add(gs)

		for i := 0; i < gs; i++ {
			go func() {
				persona = callGet("http://localhost:" + port + "/persona/api/GetApellido/" + campo)
				persona.Nombre = persona.Nombre + "#" + strconv.Itoa(i)
				wg.Done()
			}()
		}
		wg.Wait()
		c.JSON(http.StatusOK, persona)
	}
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

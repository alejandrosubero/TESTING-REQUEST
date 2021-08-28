package gin

// import (
// 	"github.com/alejandrosubero/cliente/internal/httpcode/handler"
// 	"github.com/gin-gonic/gin"
// )

// func mainxxx() {

// 	r := gin.Default()
// 	api := r.Group("/api")
// 	{
// 		api.GET("/ping", handler.PingGET())
// 		api.GET("/all/:port", handler.All())
// 		api.GET("/save/:port/:number", handler.Save())
// 		api.GET("/ids/:port/:number", handler.FindByIdDinamic())
// 		api.GET("/id/:port/:number/:campo", handler.FindById())
// 		api.GET("/nombre/:port/:number/:campo", handler.FindByGetNombre())
// 		api.GET("/apellido/:port/:number/:campo", handler.FindByGetApellido())
// 		// api.GET("/user/:name/:action", func(c *gin.Context) {
// 		// 	name := c.Param("name")
// 		// 	action := c.Param("action")
// 		// 	i, _ := strconv.Atoi(name)
// 		// 	calculo := i + 1
// 		// 	log.Printf(" calculo: %v", calculo)
// 		// 	c.String(http.StatusOK, "Hello %s port: %s", name, action)
// 		// })
// 		// api.GET("/newsfeed", handler.NewsfeedGET(feed))
// 		// api.POST("/newsfeed", handler.NewsfeedPOST(feed))
// 	}

// 	r.Run("0.0.0.0:5001") // listen and serve on 0.0.0.0:8080 (for windows http://localhost:5001/api)
// }

/*
http://localhost:5001/api/ids/9001/10
http://localhost:5001/api/all
http://localhost:5001/api/save/9001/100000

*/

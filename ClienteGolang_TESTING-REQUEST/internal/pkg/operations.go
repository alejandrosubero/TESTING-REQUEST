package pkg

import (
	as "crypto/rand"
	"strconv"

	"math/big"

	"github.com/alejandrosubero/cliente/internal/models"
)

func NewPersona() models.Persona {

	persona := models.Persona{}

	persona.Nombre = RandString2(4)
	persona.Apellido = RandString2(6)
	persona.Direcciones.Calle = "calle: " + StreeRand(1000)
	persona.Direcciones.Casa = "departamento  " + RandString2(1) + "-" + StreeRand(15)
	persona.Direcciones.Ciudad = "Buenos aires"
	persona.ID = 0
	persona.Direcciones.ID = 0
	return persona
}

func StreeRand(ranod int64) string {
	numero := ""
	for i := 0; i < 1; i++ {
		result, _ := as.Int(as.Reader, big.NewInt(ranod))
		numero = result.String()
	}
	return numero
}

// RandString genera una cadena aleatoria
func RandString2(len int) string {

	bytes := make([]byte, len)

	for i := 0; i < len; i++ {
		b, _ := as.Int(as.Reader, big.NewInt(26))
		calculo, _ := strconv.Atoi(b.String())
		c := calculo + 65
		bytes[i] = byte(c)
	}
	return string(bytes)
}

package main

import (
	"fmt"

	"github.com/alejandrosubero/cliente/internal/pkg"
)

func main() {

	for i := 0; i < 5; i++ {
		fmt.Println(pkg.NewPersona())
	}

}

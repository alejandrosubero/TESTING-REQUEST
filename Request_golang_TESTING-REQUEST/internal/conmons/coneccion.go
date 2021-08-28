package conmons

import (
	//	"database/sql"
	"log"

	"github.com/alejandrosubero/resquest_golang/internal/models"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func GetConnection() *gorm.DB {
	//	db, err := sql.Open("mysql", "root:admin@/testserver?charset=utf8")
	db, err := gorm.Open("mysql", "root:admin@/testserver?charset=utf8")
	if err != nil {
		log.Fatal(err)
	}

	// sqlDB := db.DB()
	// if err != nil {
	// 	log.Fatal(err)
	// }
	// // SetMaxIdleConns sets the maximum number of connections in the idle connection pool.
	// sqlDB.SetMaxIdleConns(100)
	// // SetMaxOpenConns sets the maximum number of open connections to the database.
	// sqlDB.SetMaxOpenConns(500)

	return db
}

func Migrate() {
	db := GetConnection()
	defer db.Close()

	log.Println("migrando.....")
	db.AutoMigrate(&models.Persona{})
	db.AutoMigrate(&models.Direccion{})
}

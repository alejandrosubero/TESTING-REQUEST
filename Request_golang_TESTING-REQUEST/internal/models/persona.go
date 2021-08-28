package models

type Persona struct {
	// gorm.Model
	ID          int64     `json:"id" gorm:"primary_key;auto_incremet"`
	Nombre      string    `json:"nombre"`
	Apellido    string    `json:"apellido"`
	DireccionID int64     `json:"direccionId"`
	Direcciones Direccion `gorm:"foreignKey:DireccionID"`
}

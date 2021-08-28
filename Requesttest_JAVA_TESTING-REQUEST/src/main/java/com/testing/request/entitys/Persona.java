/*
Create on 2021-08-03 07:07:06.0196615 -0300 -03 m=+0.003913901
*Copyright (C) 2021.
@author Alejandro
@author Subero
@author ANACODE AND IVANCODE
@since   11.0
@version 1.0.0.0
*<p>Description: prueba de request  </p>
*/

package com.testing.request.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;

import com.testing.request.entitys.Direccion;


@Entity
@Table(name = "persona")
public class Persona implements Serializable {

private static final long serialVersionUID = 566028617L;

		@Id
		@GeneratedValue(generator = "sequence_mat_id_generator")
		@SequenceGenerator(name="sequence_mat_id_generator", initialValue= 25, allocationSize=1000)
		@Column(name = "id", updatable = true, nullable = false, length = 25)
		private Long id;


		@Column(name = "nombre", updatable = true, nullable = true, length = 200)
		private String nombre;


		@Column(name = "apellido", updatable = true, nullable = true, length = 200)
		private String apellido;


		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )

		private Direccion direcion;


		public Long getId() { 
			return id;
		}
		public void setId(Long  id) {
			this.id = id;
		}
		public String getNombre() { 
			return nombre;
		}
		public void setNombre(String  nombre) {
			this.nombre = nombre;
		}
		public String getApellido() { 
			return apellido;
		}
		public void setApellido(String  apellido) {
			this.apellido = apellido;
		}
		public Direccion getdirecion() { 
			return direcion;
		}
		public void setdirecion(Direccion  direcion) {
			this.direcion = direcion;
		}
			public boolean equalsPersona(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					Persona persona = (Persona) o;
						return 			Objects.equals(id, persona.id) ||
			Objects.equals(nombre, persona.nombre) ||
			Objects.equals(apellido, persona.apellido);

  }
}
 /*
 Copyright (C) 2008 Google Inc.
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


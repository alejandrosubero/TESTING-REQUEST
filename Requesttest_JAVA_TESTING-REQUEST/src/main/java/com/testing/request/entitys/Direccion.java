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



@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

private static final long serialVersionUID = 566028617L;

		@Id
		@GeneratedValue(generator = "sequence_mat_id_generator")
		@SequenceGenerator(name="sequence_mat_id_generator", initialValue= 25, allocationSize=1000)
		@Column(name = "id", updatable = true, nullable = false, length = 25)
		private Long id;


		@Column(name = "calle", updatable = true, nullable = true, length = 200)
		private String calle;


		@Column(name = "casa", updatable = true, nullable = true, length = 200)
		private String casa;


		@Column(name = "ciudad", updatable = true, nullable = true, length = 200)
		private String ciudad;


		public Long getId() { 
			return id;
		}
		public void setId(Long  id) {
			this.id = id;
		}
		public String getCalle() { 
			return calle;
		}
		public void setCalle(String  calle) {
			this.calle = calle;
		}
		public String getCasa() { 
			return casa;
		}
		public void setCasa(String  casa) {
			this.casa = casa;
		}
		public String getCiudad() { 
			return ciudad;
		}
		public void setCiudad(String  ciudad) {
			this.ciudad = ciudad;
		}
			public boolean equalsDireccion(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					Direccion direccion = (Direccion) o;
						return 			Objects.equals(id, direccion.id) ||
			Objects.equals(calle, direccion.calle) ||
			Objects.equals(casa, direccion.casa) ||
			Objects.equals(ciudad, direccion.ciudad);

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


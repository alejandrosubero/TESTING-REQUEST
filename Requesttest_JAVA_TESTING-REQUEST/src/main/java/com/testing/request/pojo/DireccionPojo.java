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

package com.testing.request.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;



public class DireccionPojo implements Serializable {

private static final long serialVersionUID = 566028617L;

		private Long id;

		private String calle;

		private String casa;

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
			public boolean equalsDireccionPojo(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					DireccionPojo direccionPojo = (DireccionPojo) o;
						return 			Objects.equals(id, direccionPojo.id) ||
			Objects.equals(calle, direccionPojo.calle) ||
			Objects.equals(casa, direccionPojo.casa) ||
			Objects.equals(ciudad, direccionPojo.ciudad);

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


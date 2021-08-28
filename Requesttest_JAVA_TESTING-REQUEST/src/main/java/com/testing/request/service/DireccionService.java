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


package com.testing.request.service;

import java.util.Optional;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import com.testing.request.entitys.Direccion;



public interface DireccionService{
 
		public Direccion  findByCalle(String calle);

		public Direccion  findByCasa(String casa);

		public Direccion  findByCiudad(String ciudad);

		public List<Direccion>  findByCalleContaining(String calle);

		public List<Direccion>  findByCasaContaining(String casa);

		public List<Direccion>  findByCiudadContaining(String ciudad);

		public Direccion findById(Long id);
		public boolean saveDireccion(Direccion direccion);
		public List<Direccion> getAllDireccion();
		public boolean updateDireccion(Direccion direccion);
 		public boolean saveOrUpdateDireccion(Direccion direccion);

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



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



package com.testing.request.repository;

import java.util.List;import java.util.Date;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.testing.request.entitys.Direccion;

public interface DireccionRepository extends CrudRepository< Direccion, Long> {
 
		public Optional<Direccion> findByCalle(String calle);
		public List<Direccion> findByCalleContaining(String calle);
		public Optional<Direccion> findByCasa(String casa);
		public List<Direccion> findByCasaContaining(String casa);
		public Optional<Direccion> findByCiudad(String ciudad);
		public List<Direccion> findByCiudadContaining(String ciudad);

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



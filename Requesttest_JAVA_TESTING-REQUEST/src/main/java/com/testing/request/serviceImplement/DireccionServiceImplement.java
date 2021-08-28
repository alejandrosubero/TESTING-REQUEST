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


package com.testing.request.serviceImplement ;

import com.testing.request.service.DireccionService;
import com.testing.request.repository.DireccionRepository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.testing.request.entitys.Direccion;



@Service
public class DireccionServiceImplement implements DireccionService {

protected static final Log logger = LogFactory.getLog(DireccionServiceImplement.class);
@Autowired
private DireccionRepository direccionrepository;
		@Override
		public Direccion findByCalle(String calle){

		logger.info("Starting getDireccion");
			Direccion direccionEntity = new Direccion();
		Optional<Direccion> fileOptional1 = direccionrepository.findByCalle(calle);

		if (fileOptional1.isPresent()) { 
				try {
			direccionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return direccionEntity;	}
		@Override
		public Direccion findByCasa(String casa){

		logger.info("Starting getDireccion");
			Direccion direccionEntity = new Direccion();
		Optional<Direccion> fileOptional1 = direccionrepository.findByCasa(casa);

		if (fileOptional1.isPresent()) { 
				try {
			direccionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return direccionEntity;	}
		@Override
		public Direccion findByCiudad(String ciudad){

		logger.info("Starting getDireccion");
			Direccion direccionEntity = new Direccion();
		Optional<Direccion> fileOptional1 = direccionrepository.findByCiudad(ciudad);

		if (fileOptional1.isPresent()) { 
				try {
			direccionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return direccionEntity;	}



		@Override
		public List<Direccion> getAllDireccion(){
		logger.info("Get allProyect");
			List<Direccion> listaDireccion = new ArrayList<Direccion>();
				direccionrepository.findAll().forEach(direccion -> listaDireccion.add(direccion));
			return listaDireccion;
}

		@Override
		public boolean saveDireccion(Direccion direccion){
		logger.info("Save Proyect");

				try {
				direccionrepository.save(direccion);
				return true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				return false;
				}
		}




		@Override
		public boolean updateDireccion(Direccion  direccion ){
			logger.info("Update Proyect");
			boolean clave = false;
		Direccion empre = findById(direccion.getId());
			empre = direccion;
				try {
				direccionrepository.save(empre);
						clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}

					return clave;
	}


		@Override
		public Direccion findById( Long id){
				return  direccionrepository.findById(id).get();
		}


		@Override
		public boolean saveOrUpdateDireccion(Direccion  direccion ){
			logger.info("Update Proyect"+direccion);
			boolean clave = false;
			Optional<Direccion> fileOptional2 = direccionrepository.findById(direccion.getId());
			if (fileOptional2.isPresent()) { 
				clave = this.updateDireccion(direccion);
				logger.info(" is update");
			} else {
					clave = this.saveDireccion(direccion);
					logger.info(" is save");
 				}
 		return clave;
		}


		@Override
		public List<Direccion> findByCalleContaining(String calle){
			logger.info("Get allProyect");
 			List<Direccion> listaDireccion = new ArrayList<Direccion>();
			listaDireccion = direccionrepository.findByCalleContaining(calle);
  			return listaDireccion;
		}

		@Override
		public List<Direccion> findByCasaContaining(String casa){
			logger.info("Get allProyect");
 			List<Direccion> listaDireccion = new ArrayList<Direccion>();
			listaDireccion = direccionrepository.findByCasaContaining(casa);
  			return listaDireccion;
		}

		@Override
		public List<Direccion> findByCiudadContaining(String ciudad){
			logger.info("Get allProyect");
 			List<Direccion> listaDireccion = new ArrayList<Direccion>();
			listaDireccion = direccionrepository.findByCiudadContaining(ciudad);
  			return listaDireccion;
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



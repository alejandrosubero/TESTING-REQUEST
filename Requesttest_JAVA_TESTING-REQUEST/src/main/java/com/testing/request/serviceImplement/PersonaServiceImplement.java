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

import com.testing.request.service.PersonaService;
import com.testing.request.repository.PersonaRepository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.testing.request.entitys.Persona;
import com.testing.request.entitys.Direccion;



@Service
public class PersonaServiceImplement implements PersonaService {

protected static final Log logger = LogFactory.getLog(PersonaServiceImplement.class);
private Long count = 0l;

@Autowired
private PersonaRepository personarepository;
		@Override
		public Persona findByNombre(String nombre){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByNombre(nombre);

		if (fileOptional1.isPresent()) { 
				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}
		@Override
		public Persona findByApellido(String apellido){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByApellido(apellido);

		if (fileOptional1.isPresent()) { 
				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}



		@Override
		public List<Persona> getAllPersona(){
		logger.info("Get allProyect");
			List<Persona> listaPersona = new ArrayList<Persona>();
				personarepository.findAll().forEach(persona -> listaPersona.add(persona));
			return listaPersona;
}

		@Override
		public boolean savePersona(Persona persona){
	     		try {
					count++;
					logger.info("Save Proyect "+"("+count+")");
					personarepository.save(persona);

					return true;
				} catch (DataAccessException e) {
	     			e.printStackTrace();
					// logger.error(" ERROR : " + e);
					return false;
				}
		}




		@Override
		public boolean updatePersona(Persona  persona ){
			logger.info("Update Proyect");
			boolean clave = false;
		Persona empre = findById(persona.getId());
			empre = persona;
				try {
				personarepository.save(empre);
						clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}

					return clave;
	}


		@Override
		public Persona findById( Long id){
				return  personarepository.findById(id).get();
		}


		@Override
		public boolean saveOrUpdatePersona(Persona  persona ){
			logger.info("Update Proyect"+persona);
			boolean clave = false;
			Optional<Persona> fileOptional2 = personarepository.findById(persona.getId());
			if (fileOptional2.isPresent()) { 
				clave = this.updatePersona(persona);
				logger.info(" is update");
			} else {
					clave = this.savePersona(persona);
					logger.info(" is save");
 				}
 		return clave;
		}


		@Override
		public List<Persona> findByNombreContaining(String nombre){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByNombreContaining(nombre);
  			return listaPersona;
		}

		@Override
		public List<Persona> findByApellidoContaining(String apellido){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByApellidoContaining(apellido);
  			return listaPersona;
		}




			@Override
			public List<Persona> findByRelacionDireccion(Direccion direccion){
				List<Persona> listaPersona = new ArrayList<Persona>();
				for (Persona persona : this.getAllPersona()) {
					if(persona.getdirecion().equalsDireccion(direccion)){
						listaPersona.add(persona);
					}
				}
				return listaPersona;
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



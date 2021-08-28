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


package com.testing.request.controller;

import com.testing.request.entitys.Persona;
import com.testing.request.validation.PersonaValidation;
import com.testing.request.mapper.PersonaMapper;
import com.testing.request.service.PersonaService;
import com.testing.request.mapper.MapperEntityRespone;
import com.testing.request.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.testing.request.pojo.PersonaPojo;
import com.testing.request.entitys.Direccion;
import com.testing.request.validation.DireccionValidation;
import com.testing.request.mapper.DireccionMapper;
import com.testing.request.pojo.DireccionPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona/api")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaValidation personaValidationService;

    @Autowired
    PersonaMapper personaMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    DireccionValidation direccionValidationService;

    @Autowired
    DireccionMapper direccionMapper;


    @GetMapping("/GetPersona/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findById(personaValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @PostMapping("/save")
    private Boolean savePersona(@RequestBody PersonaPojo persona) {
        return personaService.savePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)));
    }

    @GetMapping("/GetNombre/{nombre}")
    private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String nombre) {
        String busca = (String) personaValidationService.validation(nombre);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByNombreContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/GetApellido/{apellido}")
    private ResponseEntity<EntityRespone> findByApellidoContain(@PathVariable("apellido") String apellido) {
        String busca = (String) personaValidationService.validation(apellido);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByApellidoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/GetAllPersona")
    private ResponseEntity<EntityRespone> getAllPersona() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.getAllPersona());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }





    @GetMapping("/Getid/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") Long id) {
        Long busca = (Long) personaValidationService.validation(id);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findById(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }







    @PostMapping("/Update")
    private Long UpdatePersona(@RequestBody PersonaPojo persona) {
        personaService.updatePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)));
        return persona.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdatePersona(@RequestBody PersonaPojo persona) {
        return personaService.saveOrUpdatePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)));
    }


    @PostMapping("/finddirecion")
    private ResponseEntity<EntityRespone> findRelacionDireccion(@RequestBody DireccionPojo direccion) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByRelacionDireccion(direccionMapper.PojoToEntity(direccionValidationService.valida(direccion))));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
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



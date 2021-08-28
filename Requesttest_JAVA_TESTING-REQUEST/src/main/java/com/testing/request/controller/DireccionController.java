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
import com.testing.request.entitys.Direccion;
import com.testing.request.validation.DireccionValidation;
import com.testing.request.mapper.DireccionMapper;
import com.testing.request.service.DireccionService;
import com.testing.request.mapper.MapperEntityRespone;
import com.testing.request.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.testing.request.pojo.DireccionPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    DireccionService direccionService;

    @Autowired
    DireccionValidation direccionValidationService;

    @Autowired
   DireccionMapper direccionMapper;

    @Autowired
   MapperEntityRespone mapperEntityRespone;



        @GetMapping("/Getid/{id}")
        private  ResponseEntity<EntityRespone> findById(@PathVariable("id") Long  id) {
        Long busca = (Long) direccionValidationService.validation(id);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(direccionService.findById(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }


        @GetMapping("/Getcallecontain/{calle}")
        private ResponseEntity<EntityRespone> findByCalleContain(@PathVariable("calle") String  calle) {
              String busca = (String) direccionValidationService.validation(calle);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(direccionService.findByCalleContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getcasacontain/{casa}")
        private ResponseEntity<EntityRespone> findByCasaContain(@PathVariable("casa") String  casa) {
              String busca = (String) direccionValidationService.validation(casa);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(direccionService.findByCasaContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getciudadcontain/{ciudad}")
        private ResponseEntity<EntityRespone> findByCiudadContain(@PathVariable("ciudad") String  ciudad) {
              String busca = (String) direccionValidationService.validation(ciudad);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(direccionService.findByCiudadContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }


        @GetMapping("/GetDireccion/{id}")
          private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
          EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(direccionService.findById(direccionValidationService.valida_id(id))); 
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
          }


        @GetMapping("/GetAllDireccion")
        private  ResponseEntity<EntityRespone> getAllDireccion(){
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(direccionService.getAllDireccion());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK); }



        @PostMapping("/save")
        private Boolean  saveDireccion(@RequestBody DireccionPojo  direccion){ 
            return direccionService.saveDireccion(direccionMapper.PojoToEntity(direccionValidationService.valida(direccion)) ); }



        @PostMapping("/Update")
        private Long UpdateDireccion(@RequestBody DireccionPojo  direccion){ 
        direccionService.updateDireccion(direccionMapper.PojoToEntity(direccionValidationService.valida(direccion)));
            return direccion.getId(); }


        @PostMapping("/saveOrUpdate")
        private boolean saveOrUpdateDireccion(@RequestBody DireccionPojo  direccion){ 
            return direccionService.saveOrUpdateDireccion(direccionMapper.PojoToEntity(direccionValidationService.valida(direccion)) ); }

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



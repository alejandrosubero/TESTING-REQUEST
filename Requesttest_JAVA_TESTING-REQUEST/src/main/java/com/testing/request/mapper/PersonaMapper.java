
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


package com.testing.request.mapper;
import com.testing.request.entitys.Persona;
import com.testing.request.pojo.PersonaPojo;
import com.testing.request.entitys.Direccion;
import com.testing.request.pojo.DireccionPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;


    @Component
    public class PersonaMapper {

      @Autowired
      private DireccionMapper direccionmapper;


        public Persona PojoToEntity(PersonaPojo pojo) {
           Persona entity = new Persona();
          entity.setId(pojo.getId());
          entity.setNombre(pojo.getNombre());
          entity.setApellido(pojo.getApellido());
        List<Direccion> listdirecion = new ArrayList<Direccion>();
        entity.setdirecion(direccionmapper.PojoToEntity(pojo.getdirecion()));
            return entity;
        }


    public PersonaPojo entityToPojo(Persona entity) {
        PersonaPojo pojo = new PersonaPojo();
        List<DireccionPojo> listdirecion = new ArrayList<DireccionPojo>();
        pojo.setId(entity.getId());
        pojo.setNombre(entity.getNombre());
        pojo.setApellido(entity.getApellido());

        pojo.setdirecion(direccionmapper.entityToPojo(entity.getdirecion()));
            return pojo;
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



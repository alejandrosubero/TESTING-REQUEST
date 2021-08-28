
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


package com.testing.request.validation ;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;import java.util.Date;

import com.testing.request.entitys.Direccion;import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.testing.request.pojo.DireccionPojo;import com.testing.request.pojo.DireccionPojo;import com.testing.request.pojo.DireccionPojo;import com.testing.request.pojo.DireccionPojo;


    @Service
    public class DireccionValidation {

        public DireccionPojo valida(DireccionPojo direccion) {
        DireccionPojo pojo = null;
        try {
             if (direccion != null) {
              if (
        direccion.getId() != null &&
        direccion.getCalle() != null &&
        direccion.getCasa() != null &&
        direccion.getCiudad() != null        ) {
        pojo = direccion;
         }
        }
            return pojo;
        } catch (Exception e) {
            e.printStackTrace();
            return pojo;
        }
    }
// remplace de name of variable for you proyecte
    public Long valida_id( String poder) {
             Long id_Delete = 0l;        try {
          if (poder != null) {
          if (poder.length() > 0 && !Pattern.matches("[a-zA-Z]+", poder)) {
         id_Delete = Long.parseLong(poder);            }
        }
            return id_Delete;
        } catch (Exception e) {
            e.printStackTrace();
            return id_Delete;
        }
    }
    public <T> Object validation(T t) {
         T elemento = null;
        try {
        if (t != null) {
            elemento = t;
        }
            return elemento;
        } catch (Exception e) {
            e.printStackTrace();
            return elemento;
        }
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



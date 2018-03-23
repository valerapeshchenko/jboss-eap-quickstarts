/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.helloworld;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Pete Muir
 *
 */

import java.util.Enumeration;
import java.net.*;
import java.io.*;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class HelloService {

    String createHelloMessage(String name) {
        String return_string = "Hello " + name + "!\n System information: ";
      //Manifest manifest = new Manifest(resources.nextElement().openStream());
      // check that this is your manifest and do what you need or get the next one        
        try {
        Manifest mf = new Manifest();
        mf.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));

        Attributes atts = mf.getMainAttributes();        
        return_string += "Implementation-Version: " + atts.getValue("Implementation-Version");
        return_string += "Implementation-Build: " + atts.getValue("Implementation-Build");
        return_string += "Specification-Vendor: " + atts.getValue("Specification-Vendor");
        } catch(Exception e) {
      
    }
        return return_string;
    }

}

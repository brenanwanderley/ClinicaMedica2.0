/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.auxClasses;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Danilo
 */
public class JsonProcessor {
    private JsonReader reader;
    private JsonObject object;
    
    public JsonProcessor(String jsonContent){
        reader = Json.createReader(new StringReader(jsonContent));
        object = reader.readObject();
    }
    private JsonProcessor(JsonObject object){
        this.object=object;
    }
    public String getJsonParam(String param){
        return object.getString(param);
    }
    public JsonProcessor getObjectJsonParam(String param){
        return new JsonProcessor(object.getJsonObject(param));
    }
}

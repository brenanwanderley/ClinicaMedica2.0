/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

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
    private String jsonContent;
    
    public JsonProcessor(String jsonContent){
        this.jsonContent=jsonContent;
        reader = Json.createReader(new StringReader(jsonContent));
        object = reader.readObject();
    }
    public String getJsonParam(String param){
        return object.getString(param);
    }
}

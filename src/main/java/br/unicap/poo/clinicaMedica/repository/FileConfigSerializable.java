/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class FileConfigSerializable<T extends Serializable> {
    private final String path;
    
    public FileConfigSerializable(String path) throws IOException{
        this.path=path+".dat";
        File file = new File(this.path);
        
        if(!file.exists()){
            file.createNewFile();
        }
    }
    public T Load(){
        T config=null;
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);
            config = (T)oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConfigSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(FileConfigSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(FileConfigSerializable.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return config;
    }
    public void save(T config){
        try{
            FileOutputStream fo;
            fo = new FileOutputStream(path);

            ObjectOutputStream oo;
            oo = new ObjectOutputStream(fo);
            oo.writeObject(config);
            
            oo.close();
            fo.close();
        }catch (FileNotFoundException ex) {
                Logger.getLogger(FileConfigSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(FileConfigSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

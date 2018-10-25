/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.TipoExame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class TipoExameDAO implements TipoExameRepBridge{
    private ArrayList<TipoExame> dataBase;
    private static TipoExameDAO instance;
    
    private TipoExameDAO(){
        dataBase = new ArrayList();
    }
    public synchronized static TipoExameDAO getInstance(){
        if(instance==null)
            instance = new TipoExameDAO();
        return instance;
    } 
    @Override
    public boolean inserir(TipoExame item) {
        return dataBase.add(item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(TipoExame item) {
        int cont=0;
        
        for(TipoExame data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(TipoExame item) {
        int cont=0;
        for(TipoExame data : dataBase){
            if(item.getCodigo()==data.getCodigo()){
                dataBase.remove(cont);
                return true;
            }else if(item.getCodigo()<data.getCodigo()){
                return false;
            }
            cont++;
        }
        return false;
    }

    @Override
    public List<TipoExame> listar() {
        return dataBase;
    }

    @Override
    public TipoExame selecionar(int codigo) {
        int cont = 0;
        
        for(TipoExame data : dataBase){
            if(data.getCodigo()==codigo){
                return dataBase.get(cont);
            }
            cont++;
        }
        return null;
    }
    private int lastCode(){
        if(dataBase.isEmpty()){
            return -1;
        }
        return dataBase.get(dataBase.size()-1).getCodigo();
    }
}

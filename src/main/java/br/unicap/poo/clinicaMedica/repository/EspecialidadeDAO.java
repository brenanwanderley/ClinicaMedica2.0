/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class EspecialidadeDAO implements EspecialidadeRepBridge{
    private ArrayList<Especialidade> dataBase;
    private static EspecialidadeDAO instance;
    
    private EspecialidadeDAO(){
        dataBase = new ArrayList();
    }
    public synchronized static EspecialidadeDAO getInstance(){
        if(instance==null){
            instance = new EspecialidadeDAO();
        }
        return instance;
    }
    @Override
    public boolean inserir(Especialidade item) {
        return dataBase.add(item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(Especialidade item) {
        int cont=0;
        
        for(Especialidade data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Especialidade item) {
        int cont=0;
        for(Especialidade data : dataBase){
            if(item.getCodigo()==data.getCodigo()){
                dataBase.remove(cont);
                return true;
            }else if(item.getCodigo()<data.getCodigo()){
                return false;
            }
            cont++;
        }
        return false;    }

    @Override
    public List<Especialidade> listar() {
        return dataBase;
    }

    @Override
    public Especialidade selecionar(int codigo) {
        int cont = 0;
        
        for(Especialidade data : dataBase){
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

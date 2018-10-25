/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class MedicoDAO implements MedicoRepBridge{
    private ArrayList<Medico> dataBase;
    private static MedicoDAO instance;
    
    private MedicoDAO(){
        dataBase = new ArrayList();
    }
    public synchronized static MedicoDAO getInstance(){
        if(instance==null)
            instance = new MedicoDAO();
        return instance;
    }
    @Override
    public boolean inserir(Medico item) {
        return dataBase.add(item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(Medico item) {
        int cont=0;
        
        for(Medico data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Medico item) {
        return dataBase.remove(item);
    }

    @Override
    public List<Medico> listar() {
        return dataBase;
    }

    @Override
    public Medico selecionar(int codigo) {
        int cont = 0;
        
        for(Medico data : dataBase){
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

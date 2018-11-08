/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Consulta;
/**
 *
 * @author Danilo
 */
public class ConsultaDAO implements ConsultaRepBridge {
    
    private ArrayListIterada<Consulta> dataBase;
    private static ConsultaDAO instance;
    
    private ConsultaDAO(){
        dataBase = new ArrayListIterada();
    }
    public synchronized static ConsultaDAO getInstance(){
        if(instance==null){
            instance = new ConsultaDAO();
        }
        return instance;
    }
    @Override
    public boolean inserir(Consulta item) {
        return dataBase.add((Consulta)item.clonar(lastCode()+1));
    }

    @Override
    public boolean alterar(Consulta item) {
        int cont=0;
        
        for(Consulta data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Consulta item) {
        int cont=0;
        for(Consulta data : dataBase){
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
    public Iterador<Consulta> listar() {
        return dataBase;
    }

    @Override
    public Consulta selecionar(int codigo) {
        int cont = 0;
        
        for(Consulta data : dataBase){
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

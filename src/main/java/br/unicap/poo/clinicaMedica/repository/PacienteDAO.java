/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Paciente;
/**
 *
 * @author Danilo
 */
public class PacienteDAO implements PacienteRepBridge{
    private ArrayListIterada<Paciente> dataBase;
    private static PacienteDAO instance;
    
    private PacienteDAO(){
        dataBase = new ArrayListIterada();
    }
    @Override
    public boolean inserir(Paciente item) {
        return dataBase.add(item);
    }
    public synchronized static PacienteDAO getInstance(){
        if(instance==null)
            instance = new PacienteDAO();
        return instance;
    } 

    @Override
    public boolean alterar(Paciente item) {
        int cont=0;
        
        for(Paciente data : dataBase){
            if(data.getCpf().equals(item.getCpf())){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Paciente item) {
        int cont=0;
        for(Paciente data : dataBase){
            if(data.getCpf().equals(item.getCpf())){
                dataBase.remove(cont);
                return true;
            }
            cont++;
        }
        return false;    
    }

    @Override
    public Iterador<Paciente> listar() {
        return dataBase;
    }

    @Override
    public Paciente selecionar(String cpf) {
        int cont = 0;
        
        for(Paciente data : dataBase){
            if(data.getCpf().equals(cpf)){
                return dataBase.get(cont);
            }
            cont++;
        }
        return null;
    }
    
}

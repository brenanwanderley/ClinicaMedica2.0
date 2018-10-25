/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.CpfInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Paciente extends Pessoa{
    private PlanoDeSaude planoDeSaude;
    private Endereco endereco;
    private Date dataNasc;
    private final String cpf;
    private int numeroVisitas;

    public Paciente(String cpf) throws PessoaException {
        
        super();
        if(!cpf.matches("^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}")){
            throw new CpfInvalidoException();
        }else{
            this.cpf = cpf;
        }
        endereco = new Endereco();
        planoDeSaude = new PlanoDeSaude();
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }
    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude){
        this.planoDeSaude=planoDeSaude;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    
    public String getDataNasc() {
        Calendar calendar = Calendar.getInstance(); 
        StringBuilder sb = new StringBuilder();
        calendar.setTime(this.dataNasc);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return df.format(calendar.getTime());
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }
    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void increaseNumeroVisitas() {
        this.numeroVisitas = numeroVisitas;
    }
    public boolean cadastroCompleto(){
        return dataNasc!=null && endereco.enderecoCompleto();
    }
    public boolean equals(Object paciente){
        Paciente objeto = (Paciente)paciente;
        return this.cpf.equals(objeto.cpf);
    }

}

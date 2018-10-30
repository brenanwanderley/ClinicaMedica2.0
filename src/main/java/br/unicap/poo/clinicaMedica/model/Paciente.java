/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.CpfInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author aluno
 */
@ApplicationScoped
public class Paciente extends Pessoa{
    private PlanoDeSaude planoDeSaude;
    private Endereco endereco;
    private Date dataNasc;
    private final String cpf;
    private int numeroVisitas;

    @JsonCreator
    public Paciente(@JsonProperty("nome") String nome,
                    @JsonProperty("telefone") String telefone, 
                    @JsonProperty("cpf") String cpf, 
                    @JsonProperty("planoDeSaude") PlanoDeSaude planoDeSaude, 
                    @JsonProperty("endereco") Endereco endereco,
                    @JsonProperty("dataNasc") String dataNasc) throws PessoaException{
        super(nome, telefone);
        if(!cpf.matches("^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}")){
            throw new CpfInvalidoException();
        }else{
            this.cpf = cpf;
        }
        this.endereco = endereco;
        this.planoDeSaude = planoDeSaude;
        setDataNasc(dataNasc);
    }
    public Paciente(String cpf, 
                    String nome,
                    String telefone) throws PessoaException {
        
        super(nome, telefone);
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
        calendar.setTime(this.dataNasc);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return df.format(calendar.getTime());
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setDataNasc(String dataNasc){
        DateProcessor dateProcessor = new DateProcessor(dataNasc);
        this.dataNasc = dateProcessor.getDate();
    }
    public String getCpf() {
        return cpf;
    }
    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void increaseNumeroVisitas() {
        this.numeroVisitas++;
    }
    public boolean cadastroCompleto(){
        return dataNasc!=null && endereco.enderecoCompleto();
    }
    public void setAll(Paciente paciente, SeguradoraPlano segPlanoRef){
        super.setAll(this);
        this.dataNasc=paciente.dataNasc;
        planoDeSaude.setAll(planoDeSaude, segPlanoRef);
        endereco.setAll(endereco);
    }

}

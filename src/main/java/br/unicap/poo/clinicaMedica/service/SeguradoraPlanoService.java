/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoRepBridge;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoRepEnum;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoRepFactory;
import java.io.IOException;
/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoService {
    private SeguradoraPlanoRepBridge seguradorasPlano;
    
    public SeguradoraPlanoService(){
        SeguradoraPlanoRepFactory instance = new SeguradoraPlanoConcreteRepFactory();
        seguradorasPlano = instance.getInstance();
    }
    public void inserirSeguradora(SeguradoraPlano item){
        seguradorasPlano.inserir(item);
    }
    public void alterarSeguradora(SeguradoraPlano item){
        seguradorasPlano.alterar(item);
    }
    public void removerSeguradora(SeguradoraPlano item){
        seguradorasPlano.remover(item);
    }
    public Iterador<SeguradoraPlano> listarSeguradoras(){
        Iterador<SeguradoraPlano> listaSeguradorasPlano = seguradorasPlano.listar();
                
        return listaSeguradorasPlano;
    }
    public SeguradoraPlano selecionar(int codigo){
        SeguradoraPlano selecao = seguradorasPlano.selecionar(codigo);

        
        return selecao;
    }
    public static void setConfig(SeguradoraPlanoRepEnum seguradoraPlanoEnum) throws IOException{
        SeguradoraPlanoRepFactory factory = new SeguradoraPlanoConcreteRepFactory();
        factory.setConfig(seguradoraPlanoEnum);
    }
}

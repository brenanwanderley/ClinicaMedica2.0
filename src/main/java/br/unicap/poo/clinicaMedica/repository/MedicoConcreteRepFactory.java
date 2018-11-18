
package br.unicap.poo.clinicaMedica.repository;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenan Wanderley
 */
public class MedicoConcreteRepFactory extends MedicoRepFactory{
    public MedicoConcreteRepFactory(){
        super();
    }
    @Override
    public MedicoRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        
        MedicoConfig config;
        try {
            config = new MedicoConfig();
        } catch (IOException ex) {
            Logger.getLogger(MedicoConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        MedicoRepEnum medicoEnum = config.getNum();
        
        switch(medicoEnum){
            case MEMORIA:
                return MedicoDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }
    }
    
    public void setConfig(MedicoRepEnum medicoEnum) throws IOException{
        MedicoConfig config = new MedicoConfig();
        config.setNum(medicoEnum);
        config.save();       
    }
}

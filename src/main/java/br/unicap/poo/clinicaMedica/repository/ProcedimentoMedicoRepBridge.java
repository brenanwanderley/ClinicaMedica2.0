/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ProcedimentoMedicoRepBridge {
    public boolean inserir(ProcedimentoMedico item);
    public boolean alterar(ProcedimentoMedico item);
    public boolean remover(ProcedimentoMedico item);
    public List<ProcedimentoMedico> listar();
    public ProcedimentoMedico selecionar(int codigo);
}

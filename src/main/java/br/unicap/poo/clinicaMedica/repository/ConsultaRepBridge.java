/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Consulta;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ConsultaRepBridge {
    public boolean inserir(Consulta item);
    public boolean alterar(Consulta item);
    public boolean remover(Consulta item);
    public List<Consulta> listar();
    public Consulta selecionar(int codigo);
}

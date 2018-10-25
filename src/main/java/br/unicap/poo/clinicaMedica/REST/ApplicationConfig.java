/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.REST;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Danilo
 */
@javax.ws.rs.ApplicationPath("app")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.unicap.poo.clinicaMedica.endPoint.ConsultaEndPoint.class);
        resources.add(br.unicap.poo.clinicaMedica.endPoint.EspecialidadeEndPoint.class);
        resources.add(br.unicap.poo.clinicaMedica.endPoint.PacienteEndPoint.class);
        resources.add(br.unicap.poo.clinicaMedica.endPoint.SeguradoraPlanoEndPoint.class);
        resources.add(br.unicap.poo.clinicaMedica.endPoint.TipoExameEndPoint.class);
        resources.add(br.unicap.poo.clinicaMedica.endPoint.TipoProcedimentoEndPoint.class);
    }
    
}

package org.pruebaevaluable.actividadevaluable.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que representa un usuario.
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Plataforma del usuario.
     */
    private String platform;

    /**
     * Indica si el usuario es administrador.
     */
    private Boolean is_admin;

    /**
     * Versión del usuario.
     */
    private Integer version;

    /**
     * Fecha y hora de creación del usuario.
     */
    private LocalDateTime created_at;

    @Override
    public String toString() {
        return "Email: "+email+"\n"+
                "Platform: "+platform+"\n"+
                "Administrador: "+is_admin+"\n"+
                "Version: "+version+"\n"+
                "Fecha de creación: "+created_at+"\n";
    }
}

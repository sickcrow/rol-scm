/*
 * @(#)JSONDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Representa un objeto Data Transfer Object para transferir datos.
 * <p>
 * Todos las clases que representen Data Transfer Object deben implementar esta interfaz.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface JSONDTO extends DTO {
}

/*
 * @(#)TiposOperacionHUBResult.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.TipoOperacionDTO;


/**
 * Representa el resultado de servicios HUB que retornan una colección de objetos TipoOperacionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class TiposOperacionHUBResult extends HUBResult<List<TipoOperacionDTO>> {

	private static final long serialVersionUID = 8298544078129416795L;
}

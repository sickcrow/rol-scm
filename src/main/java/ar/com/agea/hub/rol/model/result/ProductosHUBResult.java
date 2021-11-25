/*
 * @(#)ProductosHUBResult.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.ProductoDTO;


/**
 * Representa el resultado de servicios HUB que retornan una colección de objetos ProductoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/08/2013
 */
public class ProductosHUBResult extends HUBResult<List<ProductoDTO>> {

	private static final long serialVersionUID = 6336377643886613267L;
}

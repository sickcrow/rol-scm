/*
 * @(#)GWPService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;


/**
 * Representa una capa de abstración de los servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 23/10/2013
 */
public interface GWPService {

	/**
	 * Obtiene un objeto que representa la registración GWP.
	 * 
	 * @param dto Objeto usuario GWP a registrar.
	 * @return Objeto mapa de claves y valor string registrados.
	 * @throws ServiceException Cuando la salida a la llamada al servicio GWP devuelve errores.
	 */
	ROLResult realizar(GWPTransactionDTO dto) throws ServiceException;
}

/*
 * @(#)GWPServiceTest.java		1.0 14/08/2013
 */

package ar.com.agea.hub.rol.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.agea.hub.rol.common.FileName;
import ar.com.agea.hub.rol.common.GenericTestException;
import ar.com.agea.hub.rol.common.ServiceTest;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de acceso a los servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 14/08/2013
 */
public class GWPServiceTest extends ServiceTest {

	@Autowired
	private GWPService gwpService;

	/**
	 * Comprueba el envío y recepción de objetos al servicio registrar
	 * obteniendo valores con errores.
	 */
	@Test
	public void testRegistrarWithErrors() {
		String serviceName = "\"realizar\"";
		
		ROLResult output = null;
		
		GWPTransactionDTO input = getJSON(FileName.TEST_REALIZAR_WITH_ERRORS, GWPTransactionDTO.class);
		
		try {
			output = gwpService.realizar(input);
		} catch (Exception e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de GWP.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertTrue(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNull(serviceName + ": se ha devuelto un resultado no null.", output.getObject());
	}
}

/*
 * @(#)GWPCredentialsTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.credentials;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase GWPCredentials.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class GWPCredentialsTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo GWPCredentials.
	 */
	@Test
	public void testConstructor() {
		GWPCredentials dto = new GWPCredentials("CODIGO_APLICACION_CLIENTE", "LLAVE_APLICACION_CLIENTE");
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"GWPCredentials\""
				+ " utilizando el constructor por parámetros.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoAplicacionCliente y getCodigoAplicacionCliente de la clase GWPCredentials. 
	 */
	@Test
	public void testSetAndGetCodigoAplicacionClienteMethod() {
		GWPCredentials dto = new GWPCredentials("CODIGO_APLICACION_CLIENTE", "LLAVE_APLICACION_CLIENTE");
		String codigoAplicacionCliente = "CODIGO_APLICACION_CLIENTE";
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		
		String tmp = dto.getCodigoAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAplicacionCliente\" o \"getCodigoAplicacionCliente\" de la clase \"GWPCredentials\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAplicacionCliente\" de la clase \"GWPCredentials\""
				+ " no corresponde al valor enviado como argumento.", codigoAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setLlaveAplicacionCliente y getLlaveAplicacionCliente de la clase GWPCredentials. 
	 */
	@Test
	public void testSetAndGetLlaveAplicacionClienteMethod() {
		GWPCredentials dto = new GWPCredentials("CODIGO_APLICACION_CLIENTE", "LLAVE_APLICACION_CLIENTE");
		String llaveAplicacionCliente = "LLAVE_APLICACION_CLIENTE";
		
		dto.setLlaveAplicacionCliente(llaveAplicacionCliente);
		
		String tmp = dto.getLlaveAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setLlaveAplicacionCliente\" o \"getLlaveAplicacionCliente\" de la clase \"GWPCredentials\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getLlaveAplicacionCliente\" de la clase \"GWPCredentials\""
				+ " no corresponde al valor enviado como argumento.", llaveAplicacionCliente, tmp);
	}
}

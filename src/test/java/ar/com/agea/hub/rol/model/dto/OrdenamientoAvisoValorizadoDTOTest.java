/*
 * @(#)OrdenamientoAvisoValorizadoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase OrdenamientoAvisoValorizadoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenamientoAvisoValorizadoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo OrdenamientoAvisoValorizadoDTO.
	 */
	@Test
	public void testConstructor() {
		OrdenamientoAvisoValorizadoDTO dto = new OrdenamientoAvisoValorizadoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"OrdenamientoAvisoValorizadoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase OrdenamientoAvisoValorizadoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		OrdenamientoAvisoValorizadoDTO dto = new OrdenamientoAvisoValorizadoDTO();
		String nombre = "CODIGO";
		
		dto.setCodigo(nombre);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"OrdenamientoAvisoValorizadoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"OrdenamientoAvisoValorizadoDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValor y getValor de la clase OrdenamientoAvisoValorizadoDTO. 
	 */
	@Test
	public void testSetAndGetValorMethod() {
		OrdenamientoAvisoValorizadoDTO dto = new OrdenamientoAvisoValorizadoDTO();
		String valor = "VALOR";
		
		dto.setValor(valor);
		
		String tmp = dto.getValor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValor\" o \"getValor\" de la clase \"OrdenamientoAvisoValorizadoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValor\" de la clase \"OrdenamientoAvisoValorizadoDTO\""
				+ " no corresponde al valor enviado como argumento.", valor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoBusqueda y getCodigoBusqueda de la clase OrdenamientoAvisoValorizadoDTO. 
	 */
	@Test
	public void testSetAndCodigoBusquedaMethod() {
		OrdenamientoAvisoValorizadoDTO dto = new OrdenamientoAvisoValorizadoDTO();
		String codigoBusqueda = "CODIGO_BUSQUEDA";
		
		dto.setCodigoBusqueda(codigoBusqueda);
		
		String tmp = dto.getCodigoBusqueda();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoBusqueda\" o \"getCodigoBusqueda\" de la clase \"OrdenamientoAvisoValorizadoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoBusqueda\" de la clase \"OrdenamientoAvisoValorizadoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoBusqueda, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase OrdenamientoAvisoValorizadoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		OrdenamientoAvisoValorizadoDTO dto = new OrdenamientoAvisoValorizadoDTO();
		
		dto.setCodigo("CODIGO");
		dto.setValor("VALOR");
		dto.setCodigoBusqueda("CODIGO_BUSQUEDA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"OrdenamientoAvisoValorizadoDTO\".", tmp);
	}
}

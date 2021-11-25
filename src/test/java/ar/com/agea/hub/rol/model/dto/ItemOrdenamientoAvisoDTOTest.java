/*
 * @(#)ItemOrdenamientoAvisoDTOTest.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ItemOrdenamientoAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ItemOrdenamientoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ItemOrdenamientoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValor y getValor de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetValorMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		String valor = "VALOR";
		
		dto.setValor(valor);
		
		String tmp = dto.getValor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValor\" o \"getValor\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValor\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", valor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIngresoManual y getIngresoManual de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIngresoManualMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		Boolean ingresoManual = true;
		
		dto.setIngresoManual(ingresoManual);
		
		Boolean tmp = dto.getIngresoManual();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIngresoManual\" o \"getIngresoManual\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIngresoManual\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ingresoManual, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoBusqueda y getCodigoBusqueda de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoBusquedaMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		String codigoBusqueda = "CODIGO_BUSQUEDA";
		
		dto.setCodigoBusqueda(codigoBusqueda);
		
		String tmp = dto.getCodigoBusqueda();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoBusqueda\" o \"getCodigoBusqueda\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoBusqueda\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoBusqueda, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdOrdenamientoAviso y getIdOrdenamientoAviso de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdOrdenamientoAvisoMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		Long idOrdenamientoAviso = 300L;
		
		dto.setIdOrdenamientoAviso(idOrdenamientoAviso);
		
		Long tmp = dto.getIdOrdenamientoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdOrdenamientoAviso\" o \"getIdOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idOrdenamientoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdPadre y getIdPadre de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdPadreMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();
		Long idPadre = 300L;
		
		dto.setIdPadre(idPadre);
		
		Long tmp = dto.getIdPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdPadre\" o \"getIdPadre\" de la clase \"ItemOrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdPadre\" de la clase \"ItemOrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ItemOrdenamientoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemOrdenamientoAvisoDTO dto = new ItemOrdenamientoAvisoDTO();

		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setValor("VALOR");
		dto.setIngresoManual(true);
		dto.setCodigoBusqueda("CODIGO_BUSQUEDA");
		dto.setIdOrdenamientoAviso(300L);
		dto.setIdPadre(300L);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ItemOrdenamientoAvisoDTO\".", tmp);
	}
}

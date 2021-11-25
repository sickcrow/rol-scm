/*
 * @(#)ProductoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoDTO.Tipo;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ProductoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ProductoDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoDTO dto = new ProductoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ProductoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase ProductoDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		ProductoDTO dto = new ProductoDTO();
		Tipo tipo = Tipo.PAPEL;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"ProductoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"ProductoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase ProductoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ProductoDTO dto = new ProductoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"ProductoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"ProductoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase ProductoDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ProductoDTO dto = new ProductoDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"ProductoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"ProductoDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ProductoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoDTO dto = new ProductoDTO();
		
		dto.setTipo(Tipo.PAPEL);
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ProductoDTO\".", tmp);
	}
}

/*
 * @(#)NivelEstructuraDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO.Tipo;

/**
 * Representa JUnit Tests de inicializaci�n para la clase NivelEstructuraDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class NivelEstructuraDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo NivelEstructuraDTO.
	 */
	@Test
	public void testConstructor() {
		NivelEstructuraDTO dto = new NivelEstructuraDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"NivelEstructuraDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase NivelEstructuraDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		NivelEstructuraDTO dto = new NivelEstructuraDTO();
		Tipo tipo = Tipo.PAPEL;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"NivelEstructuraDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"NivelEstructuraDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase NivelEstructuraDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		NivelEstructuraDTO dto = new NivelEstructuraDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"NivelEstructuraDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"NivelEstructuraDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase NivelEstructuraDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		NivelEstructuraDTO dto = new NivelEstructuraDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"NivelEstructuraDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"NivelEstructuraDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase NivelEstructuraDTO. 
	 */
	@Test
	public void testToStringMethod() {
		NivelEstructuraDTO dto = new NivelEstructuraDTO();
		
		dto.setTipo(Tipo.PAPEL);
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"NivelEstructuraDTO\".", tmp);
	}
}

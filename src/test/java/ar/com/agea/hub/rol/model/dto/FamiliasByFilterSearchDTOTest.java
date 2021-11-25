/*
 * @(#)FamiliasByFilterSearchDTOTest.java		1.0 24/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase FamiliasByFilterSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/07/2014
 */
public class FamiliasByFilterSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo FamiliasByFilterSearchDTO.
	 */
	@Test
	public void testConstructor() {
		FamiliasByFilterSearchDTO dto = new FamiliasByFilterSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"FamiliasByFilterSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigosClase y getCodigosClase de la clase FamiliasByFilterSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigosClaseMethod() {
		FamiliasByFilterSearchDTO dto = new FamiliasByFilterSearchDTO();
		List<String> codigosClase = new ArrayList<String>();
		
		dto.setCodigosClase(codigosClase);
		
		List<String> tmp = dto.getCodigosClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigosClase\" o \"getCodigosClase\" de la clase \"FamiliasByFilterSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigosClase\" de la clase \"FamiliasByFilterSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigosClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase FamiliasByFilterSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		FamiliasByFilterSearchDTO dto = new FamiliasByFilterSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"FamiliasByFilterSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"FamiliasByFilterSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}

	/**
	 * Comprueba la ejecución de método toString de la clase FamiliasByFilterSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		FamiliasByFilterSearchDTO dto = new FamiliasByFilterSearchDTO();

		List<String> codigosClase = new ArrayList<String>();
		codigosClase.add("CODIGO_CLASE");
		codigosClase.add("ANOTHER_CODIGO_CLASE");
		codigosClase.add("UNKNOWN_CODIGO_CLASE");
		
		dto.setCodigosClase(codigosClase);
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"FamiliasByFilterSearchDTO\".", tmp);
	}
}

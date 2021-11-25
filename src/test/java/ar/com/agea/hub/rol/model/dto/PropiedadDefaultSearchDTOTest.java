/*
 * @(#)PropiedadDefaultSearchDTOTest.java		1.0 21/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PropiedadDefaultSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/08/2013
 */
public class PropiedadDefaultSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PropiedadDefaultSearchDTO.
	 */
	@Test
	public void testConstructor() {
		PropiedadDefaultSearchDTO dto = new PropiedadDefaultSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PropiedadDefaultSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigosPropiedadDefault y getCodigoNigetCodigosPropiedadDefaultvelEstructura de la clase PropiedadDefaultSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigosPropiedadDefaultMethod() {
		PropiedadDefaultSearchDTO dto = new PropiedadDefaultSearchDTO();
		List<String> codigosPropiedadDefault = new ArrayList<String>();
		
		dto.setCodigosPropiedadDefault(codigosPropiedadDefault);
		
		List<String> tmp = dto.getCodigosPropiedadDefault();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigosPropiedadDefault\" o \"getCodigosPropiedadDefault\" de la clase \"PropiedadDefaultSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigosPropiedadDefault\" de la clase \"PropiedadDefaultSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigosPropiedadDefault, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PropiedadDefaultSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PropiedadDefaultSearchDTO dto = new PropiedadDefaultSearchDTO();
		
		List<String> codigosPropiedadDefault = new ArrayList<String>();
		codigosPropiedadDefault.add("CODIGO_PROPIEDAD_DEFAULT");
		codigosPropiedadDefault.add("ANOTHER_CODIGO_PROPIEDAD_DEFAULT");
		codigosPropiedadDefault.add("UNKNOWN_CODIGO_PROPIEDAD_DEFAULT");
		
		dto.setCodigosPropiedadDefault(codigosPropiedadDefault);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PropiedadDefaultSearchDTO\".", tmp);
	}
}

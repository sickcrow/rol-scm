/*
 * @(#)AgrupadorAtributoAvisoDTOTest.java		1.0 18/02/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

public class AgrupadorAtributoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AgrupadorAtributoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AgrupadorAtributoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAtributoAviso y getAtributoAviso de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAtributoAvisoMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		AtributoAvisoDTO atributoAviso = new AtributoAvisoDTO();
		
		dto.setAtributoAviso(atributoAviso);
		
		AtributoAvisoDTO tmp = dto.getAtributoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAtributoAviso\" o \"getAtributoAviso\" de la clase \"AgrupadorAtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAtributoAviso\" de la clase \"AgrupadorAtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", atributoAviso, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setStep y getStep de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetStepMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		Long step = 300L;
		
		dto.setStep(step);
		
		Long tmp = dto.getStep();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setStep\" o \"getStep\" de la clase \"AgrupadorAtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getStep\" de la clase \"AgrupadorAtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", step, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		
		dto.setAtributoAviso(new AtributoAvisoDTO());
		dto.setStep(300L);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AgrupadorAtributoAvisoDTO\".", tmp);
	}
}

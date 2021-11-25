/*
 * @(#)AgrupadorAtributoAvisoDTOTest.java		1.0 18/02/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

public class AgrupadorAtributoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo AgrupadorAtributoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"AgrupadorAtributoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAtributoAviso y getAtributoAviso de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAtributoAvisoMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		AtributoAvisoDTO atributoAviso = new AtributoAvisoDTO();
		
		dto.setAtributoAviso(atributoAviso);
		
		AtributoAvisoDTO tmp = dto.getAtributoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAtributoAviso\" o \"getAtributoAviso\" de la clase \"AgrupadorAtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAtributoAviso\" de la clase \"AgrupadorAtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", atributoAviso, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setStep y getStep de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetStepMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		Long step = 300L;
		
		dto.setStep(step);
		
		Long tmp = dto.getStep();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setStep\" o \"getStep\" de la clase \"AgrupadorAtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getStep\" de la clase \"AgrupadorAtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", step, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase AgrupadorAtributoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorAtributoAvisoDTO dto = new AgrupadorAtributoAvisoDTO();
		
		dto.setAtributoAviso(new AtributoAvisoDTO());
		dto.setStep(300L);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"AgrupadorAtributoAvisoDTO\".", tmp);
	}
}

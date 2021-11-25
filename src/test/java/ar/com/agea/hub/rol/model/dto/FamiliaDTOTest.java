/*
 * @(#)FamiliaDTOTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase FamiliaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class FamiliaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo FamiliaDTO.
	 */
	@Test
	public void testConstructor() {
		FamiliaDTO dto = new FamiliaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"FamiliaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setClase y getClase de la clase FamiliaDTO. 
	 */
	@Test
	public void testSetAndGetClaseMethod() {
		FamiliaDTO dto = new FamiliaDTO();
		ClaseDTO clase = new ClaseDTO();
		
		dto.setClase(clase);
		
		ClaseDTO tmp = dto.getClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setClase\" o \"getClase\" de la clase \"FamiliaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getClase\" de la clase \"FamiliaDTO\""
				+ " no corresponde al valor enviado como argumento.", clase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setClases y getClases de la clase FamiliaDTO. 
	 */
	@Test
	public void testSetAndGetClasesMethod() {
		FamiliaDTO dto = new FamiliaDTO();
		List<ClaseDTO> clases = new ArrayList<ClaseDTO>();
		
		dto.setClases(clases);
		
		List<ClaseDTO> tmp = dto.getClases();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setClases\" o \"getClases\" de la clase \"FamiliaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getClases\" de la clase \"FamiliaDTO\""
				+ " no corresponde al valor enviado como argumento.", clases, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase FamiliaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		FamiliaDTO dto = new FamiliaDTO();
		
		List<ClaseDTO> clases = new ArrayList<ClaseDTO>();
		clases.add(new ClaseDTO());
		clases.add(new ClaseDTO());
		clases.add(new ClaseDTO());
		
		dto.setClase(new ClaseDTO());
		dto.setClases(clases);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"FamiliaDTO\".", tmp);
	}
}

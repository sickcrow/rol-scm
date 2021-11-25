/*
 * @(#)TrackCampanaDTOTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TrackCampanaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class TrackCampanaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TrackCampanaDTO.
	 */
	@Test
	public void testConstructor() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TrackCampanaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la creación de objeto de tipo TrackCampanaDTO por parámetros.
	 */
	@Test
	public void testConstructorWithParameters() {
		TrackCampanaDTO dto = new TrackCampanaDTO("FUENTE", "MEDIO", "CAMPANA");
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TrackCampanaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFuente y getFuente de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGetFuenteMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String fuente = "FUENTE";
		
		dto.setFuente(fuente);
		
		String tmp = dto.getFuente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFuente\" o \"getFuente\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFuente\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", fuente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMedio y getMedio de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGetMedioMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String medio = "MEDIO";
		
		dto.setMedio(medio);
		
		String tmp = dto.getMedio();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMedio\" o \"getMedio\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMedio\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", medio, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCampana y getCampana de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGeCampanaMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String campana = "CAMPANA";
		
		dto.setCampana(campana);
		
		String tmp = dto.getCampana();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCampana\" o \"getCampana\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCampana\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", campana, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		
		dto.setFuente("FUENTE");
		dto.setMedio("MEDIO");
		dto.setCampana("CAMPANA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TrackCampanaDTO\".", tmp);
	}
}

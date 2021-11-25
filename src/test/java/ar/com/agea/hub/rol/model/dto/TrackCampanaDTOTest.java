/*
 * @(#)TrackCampanaDTOTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TrackCampanaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class TrackCampanaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TrackCampanaDTO.
	 */
	@Test
	public void testConstructor() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TrackCampanaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la creaci�n de objeto de tipo TrackCampanaDTO por par�metros.
	 */
	@Test
	public void testConstructorWithParameters() {
		TrackCampanaDTO dto = new TrackCampanaDTO("FUENTE", "MEDIO", "CAMPANA");
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TrackCampanaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFuente y getFuente de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGetFuenteMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String fuente = "FUENTE";
		
		dto.setFuente(fuente);
		
		String tmp = dto.getFuente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFuente\" o \"getFuente\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFuente\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", fuente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMedio y getMedio de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGetMedioMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String medio = "MEDIO";
		
		dto.setMedio(medio);
		
		String tmp = dto.getMedio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMedio\" o \"getMedio\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMedio\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", medio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCampana y getCampana de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testSetAndGeCampanaMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		String campana = "CAMPANA";
		
		dto.setCampana(campana);
		
		String tmp = dto.getCampana();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCampana\" o \"getCampana\" de la clase \"TrackCampanaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCampana\" de la clase \"TrackCampanaDTO\""
				+ " no corresponde al valor enviado como argumento.", campana, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TrackCampanaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TrackCampanaDTO dto = new TrackCampanaDTO();
		
		dto.setFuente("FUENTE");
		dto.setMedio("MEDIO");
		dto.setCampana("CAMPANA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TrackCampanaDTO\".", tmp);
	}
}

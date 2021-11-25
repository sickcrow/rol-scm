/*
 * @(#)ConfiguracionOrdenamientoPantallaDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ConfiguracionOrdenamientoPantallaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ConfiguracionOrdenamientoPantallaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ConfiguracionOrdenamientoPantallaDTO.
	 */
	@Test
	public void testConstructor() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ConfiguracionOrdenamientoPantallaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase ConfiguracionOrdenamientoPantallaDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPosicion y getPosicion de la clase ConfiguracionOrdenamientoPantallaDTO. 
	 */
	@Test
	public void testSetAndGetPosicionMethod() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		Integer posicion = 300;
		
		dto.setPosicion(posicion);
		
		Integer tmp = dto.getPosicion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPosicion\" o \"getPosicion\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPosicion\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", posicion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ConfiguracionOrdenamientoPantallaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenamientosAviso y getOrdenamientosAviso de la clase ConfiguracionOrdenamientoPantallaDTO. 
	 */
	@Test
	public void testSetAndGetOrdenamientosAvisoMethod() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		List<OrdenamientoAvisoDTO> ordenamientosAviso = new ArrayList<OrdenamientoAvisoDTO>();
		
		dto.setOrdenamientosAviso(ordenamientosAviso);
		
		List<OrdenamientoAvisoDTO> tmp = dto.getOrdenamientosAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenamientosAviso\" o \"getOrdenamientosAviso\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenamientosAviso\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenamientosAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ConfiguracionOrdenamientoPantallaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ConfiguracionOrdenamientoPantallaDTO dto = new ConfiguracionOrdenamientoPantallaDTO();
		
		List<OrdenamientoAvisoDTO> ordenamientosAviso = new ArrayList<OrdenamientoAvisoDTO>();
		ordenamientosAviso.add(new OrdenamientoAvisoDTO());
		ordenamientosAviso.add(new OrdenamientoAvisoDTO());
		ordenamientosAviso.add(new OrdenamientoAvisoDTO());
		
		dto.setId(300L);
		dto.setPosicion(300);
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setOrdenamientosAviso(ordenamientosAviso);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ConfiguracionOrdenamientoPantallaDTO\".", tmp);
	}
}

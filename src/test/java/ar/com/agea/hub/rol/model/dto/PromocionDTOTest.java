/*
 * @(#)PromocionDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PromocionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class PromocionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PromocionDTO.
	 */
	@Test
	public void testConstructor() {
		PromocionDTO dto = new PromocionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PromocionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		PromocionDTO dto = new PromocionDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		PromocionDTO dto = new PromocionDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		PromocionDTO dto = new PromocionDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setObservacion y getObservacion de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetObservacionMethod() {
		PromocionDTO dto = new PromocionDTO();
		String observacion = "OBSERVACION";
		
		dto.setObservacion(observacion);
		
		String tmp = dto.getObservacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObservacion\" o \"getObservacion\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getObservacion\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", observacion, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCombo y getCombo de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetComboMethod() {
		PromocionDTO dto = new PromocionDTO();
		Boolean combo = true;
		
		dto.setCombo(combo);
		
		Boolean tmp = dto.getCombo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCombo\" o \"getCombo\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCombo\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", combo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setComboCerrado y getComboCerrado de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetComboCerradoMethod() {
		PromocionDTO dto = new PromocionDTO();
		Boolean comboCerrado = true;
		
		dto.setComboCerrado(comboCerrado);
		
		Boolean tmp = dto.getComboCerrado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setComboCerrado\" o \"getComboCerrado\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getComboCerrado\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", comboCerrado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setGratuita y getGratuita de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetGratuitaMethod() {
		PromocionDTO dto = new PromocionDTO();
		Boolean gratuita = true;
		
		dto.setGratuita(gratuita);
		
		Boolean tmp = dto.getGratuita();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setGratuita\" o \"getGratuita\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getGratuita\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", gratuita, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setSeleccion y getSeleccion de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetSeleccionMethod() {
		PromocionDTO dto = new PromocionDTO();
		Boolean seleccion = true;
		
		dto.setSeleccion(seleccion);
		
		Boolean tmp = dto.getSeleccion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setSeleccion\" o \"getSeleccion\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getSeleccion\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", seleccion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValidacionPromocion y getValidacionPromocion de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetValidacionPromocionMethod() {
		PromocionDTO dto = new PromocionDTO();
		List<ValidacionPromocionDTO> validacionPromocion = new ArrayList<ValidacionPromocionDTO>();
		
		dto.setValidacionPromocion(validacionPromocion);
		
		List<ValidacionPromocionDTO> tmp = dto.getValidacionPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValidacionPromocion\" o \"getValidacionPromocion\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValidacionPromocion\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", validacionPromocion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setRepiteSalida y getRepiteSalida de la clase PromocionDTO. 
	 */
	@Test
	public void testSetAndGetRepiteSalidaMethod() {
		PromocionDTO dto = new PromocionDTO();
		Boolean repiteSalida = true;
		
		dto.setRepiteSalida(repiteSalida);
		
		Boolean tmp = dto.getRepiteSalida();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setRepiteSalida\" o \"getRepiteSalida\" de la clase \"PromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getRepiteSalida\" de la clase \"PromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", repiteSalida, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PromocionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PromocionDTO dto = new PromocionDTO();

		List<ValidacionPromocionDTO> validcionesPromocion = new ArrayList<ValidacionPromocionDTO>();
		validcionesPromocion.add(new ValidacionPromocionDTO());
		validcionesPromocion.add(new ValidacionPromocionDTO());
		validcionesPromocion.add(new ValidacionPromocionDTO());
		
		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		dto.setObservacion("OBSERVACION");
		dto.setCombo(true);
		dto.setComboCerrado(true);
		dto.setGratuita(true);
		dto.setSeleccion(true);
		dto.setValidacionPromocion(validcionesPromocion);
		dto.setRepiteSalida(true);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PromocionDTO\".", tmp);
	}
}

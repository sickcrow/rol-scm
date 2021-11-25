/*
 * @(#)ConceptoVendibleDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ConceptoVendibleDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ConceptoVendibleDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ConceptoVendibleDTO.
	 */
	@Test
	public void testConstructor() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ConceptoVendibleDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setId y getId de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setId\" o \"getId\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getId\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaTarifa y getFechaTarifa de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetFechaTarifaMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Date fechaTarifa = null;
		
		dto.setFechaTarifa(fechaTarifa);
		
		Date tmp = dto.getFechaTarifa();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaTarifa\" o \"getFechaTarifa\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaTarifa\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTarifa, tmp);
		
		fechaTarifa = new Date();
		
		dto.setFechaTarifa(fechaTarifa);
		
		tmp = dto.getFechaTarifa();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaTarifa\" o \"getFechaTarifa\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaTarifa\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTarifa, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPrefacturado y getPrefacturado de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetPrefacturadoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Boolean prefacturado = true;
		
		dto.setPrefacturado(prefacturado);
		
		Boolean tmp = dto.getPrefacturado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPrefacturado\" o \"getPrefacturado\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPrefacturado\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", prefacturado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTipoMoneda y getTipoMoneda de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetTipoMonedaMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		TipoMonedaDTO tipoMoneda = new TipoMonedaDTO();
		
		dto.setTipoMoneda(tipoMoneda);
		
		TipoMonedaDTO tmp = dto.getTipoMoneda();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipoMoneda\" o \"getTipoMoneda\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipoMoneda\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoMoneda, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPorcentajeIVA y getPorcentajeIVA de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetPorcentajeIVAMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double porcentajeIVA = 300.0;
		
		dto.setPorcentajeIVA(porcentajeIVA);
		
		Double tmp = dto.getPorcentajeIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPorcentajeIVA\" o \"getPorcentajeIVA\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPorcentajeIVA\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", porcentajeIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoSinIVA y getMontoSinIVA de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoSinIVAMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoSinIVA = 300.0;
		
		dto.setMontoSinIVA(montoSinIVA);
		
		Double tmp = dto.getMontoSinIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoSinIVA\" o \"getMontoSinIVA\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoSinIVA\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoSinIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoSinIVASinPromo y getMontoSinIVASinPromo de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoSinIVASinPromoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoIVASinPromo = 300.0;
		
		dto.setMontoSinIVASinPromo(montoIVASinPromo);
		
		Double tmp = dto.getMontoSinIVASinPromo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoSinIVASinPromo\" o \"getMontoSinIVASinPromo\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoSinIVASinPromo\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoIVASinPromo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoIVA y getMontoIVA de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoIVAMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoIVA = 300.0;
		
		dto.setMontoIVA(montoIVA);
		
		Double tmp = dto.getMontoIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoIVA\" o \"getMontoIVA\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoIVA\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoIVASinPromo y getMontoIVASinPromo de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoIVASinPromoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoIVASinPromo = 300.0;
		
		dto.setMontoIVASinPromo(montoIVASinPromo);
		
		Double tmp = dto.getMontoIVASinPromo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoIVASinPromo\" o \"getMontoIVASinPromo\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoIVASinPromo\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoIVASinPromo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoPercepcion y getMontoPercepcion de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoPercepcionMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoPercepcion = 300.0;
		
		dto.setMontoPercepcion(montoPercepcion);
		
		Double tmp = dto.getMontoPercepcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoPercepcion\" o \"getMontoPercepcion\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoPercepcion\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoPercepcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoPercepcionSinPromo y getMontoPercepcionSinPromo de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoPercepcionSinPromoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoPercepcionSinPromo = 300.0;
		
		dto.setMontoPercepcionSinPromo(montoPercepcionSinPromo);
		
		Double tmp = dto.getMontoPercepcionSinPromo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoPercepcionSinPromo\" o \"getMontoPercepcionSinPromo\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoPercepcionSinPromo\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoPercepcionSinPromo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoTotal y getMontoTotal de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoTotalMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoTotal = 300.0;
		
		dto.setMontoTotal(montoTotal);
		
		Double tmp = dto.getMontoTotal();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoTotal\" o \"getMontoTotal\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoTotal\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoTotal, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoTotalSinPromo y getMontoTotalSinPromo de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMontoTotalSinPromoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		Double montoTotalSinPromo = 300.0;
		
		dto.setMontoTotalSinPromo(montoTotalSinPromo);
		
		Double tmp = dto.getMontoTotalSinPromo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoTotalSinPromo\" o \"getMontoTotalSinPromo\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoTotalSinPromo\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", montoTotalSinPromo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEstado y getEstado de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		String estado = "ESTADO";
		
		dto.setEstado(estado);
		
		String tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEstado\" o \"getEstado\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEstado\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMotivoEstado y getMotivoEstado de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetMotivoEstadoMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		String motivoEstado = "MOTIVO_ESTADO";
		
		dto.setMotivoEstado(motivoEstado);
		
		String tmp = dto.getMotivoEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMotivoEstado\" o \"getMotivoEstado\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMotivoEstado\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoEstado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAcciones y getAcciones de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetAccionesMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		List<AccionSecuenciaDTO> acciones = new ArrayList<AccionSecuenciaDTO>();
		
		dto.setAcciones(acciones);
		
		List<AccionSecuenciaDTO> tmp = dto.getAcciones();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAcciones\" o \"getAcciones\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAcciones\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", acciones, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAccionesPosibles y getAccionesPosibles de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetAccionesPosiblesMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		List<String> accionesPosibles = new ArrayList<String>();
		
		dto.setAccionesPosibles(accionesPosibles);
		
		List<String> tmp = dto.getAccionesPosibles();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAccionesPosibles\" o \"getAccionesPosibles\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAccionesPosibles\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", accionesPosibles, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPromocion y getPromocion de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetPromocionMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		PromocionDTO promocion = new PromocionDTO();
		
		dto.setPromocion(promocion);
		
		PromocionDTO tmp = dto.getPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPromocion\" o \"getPromocion\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPromocion\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", promocion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setItemsConceptoVendible y getItemsConceptoVendible de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetItemsConceptoVendibleMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		List<ItemConceptoVendibleDTO> itemsConceptoVendible = new ArrayList<ItemConceptoVendibleDTO>();
		
		dto.setItemsConceptoVendible(itemsConceptoVendible);
		
		List<ItemConceptoVendibleDTO> tmp = dto.getItemsConceptoVendible();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setItemsConceptoVendible\" o \"getItemsConceptoVendible\" de la clase \"ConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getItemsConceptoVendible\" de la clase \"ConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", itemsConceptoVendible, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ConceptoVendibleDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ConceptoVendibleDTO dto = new ConceptoVendibleDTO();
		
		List<AccionSecuenciaDTO> accionesSecuencia = new ArrayList<AccionSecuenciaDTO>();
		accionesSecuencia.add(new AccionSecuenciaDTO());
		accionesSecuencia.add(new AccionSecuenciaDTO());
		accionesSecuencia.add(new AccionSecuenciaDTO());
		
		List<String> accionesPosible = new ArrayList<String>();
		accionesPosible.add("ACCION_POSIBLE");
		accionesPosible.add("ANOTHER_ACCION_POSIBLE");
		accionesPosible.add("UNKNOWN_ACCION_POSIBLE");
		
		List<ItemConceptoVendibleDTO> itemsConceptoVendible = new ArrayList<ItemConceptoVendibleDTO>();
		itemsConceptoVendible.add(new ItemConceptoVendibleDTO());
		itemsConceptoVendible.add(new ItemConceptoVendibleDTO());
		itemsConceptoVendible.add(new ItemConceptoVendibleDTO());
		
		dto.setId(300L);
		dto.setDescripcion("DESCRIPCION");
		dto.setFechaTarifa(new Date());
		dto.setPrefacturado(true);
		dto.setTipoMoneda(new TipoMonedaDTO());
		dto.setPorcentajeIVA(300.0);
		dto.setMontoSinIVA(300.0);
		dto.setMontoSinIVASinPromo(300.0);
		dto.setMontoIVA(300.0);
		dto.setMontoIVASinPromo(300.0);
		dto.setMontoPercepcion(300.0);
		dto.setMontoPercepcionSinPromo(300.0);
		dto.setMontoTotal(300.0);
		dto.setMontoTotalSinPromo(300.0);
		dto.setEstado("ESTADO");
		dto.setMotivoEstado("MOTIVO_ESTADO");
		dto.setAcciones(accionesSecuencia);
		dto.setAccionesPosibles(accionesPosible);
		dto.setPromocion(new PromocionDTO());
		dto.setItemsConceptoVendible(itemsConceptoVendible);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ConceptoVendibleDTO\".", tmp);
	}
}

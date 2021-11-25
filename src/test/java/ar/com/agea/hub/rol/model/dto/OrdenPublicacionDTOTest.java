/*
 * @(#)OrdenPublicacionDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase OrdenPublicacionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenPublicacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo OrdenPublicacionDTO.
	 */
	@Test
	public void testConstructor() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"OrdenPublicacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setId y getId de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setId\" o \"getId\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getId\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setUuidGenerarOrden y getUuidGenerarOrden de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetUuidGenerarOrdenMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		String uuidGenerarOrden = "UUID_GENERAR_ORDEN";
		
		dto.setUuidGenerarOrden(uuidGenerarOrden);
		
		String tmp = dto.getUuidGenerarOrden();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUuidGenerarOrden\" o \"getUuidGenerarOrden\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUuidGenerarOrden\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", uuidGenerarOrden, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaAlta y getFechaAlta de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetFechaAltaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Date fechaAlta = null;
		
		dto.setFechaAlta(fechaAlta);
		
		Date tmp = dto.getFechaAlta();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaAlta\" o \"getFechaAlta\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaAlta\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaAlta, tmp);
		
		fechaAlta = new Date();
		
		dto.setFechaAlta(fechaAlta);
		
		tmp = dto.getFechaAlta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaAlta\" o \"getFechaAlta\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaAlta\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaAlta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPresupuestada y getPresupuestada de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetPresupuestadaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Boolean presupuestada = true;
		
		dto.setPresupuestada(presupuestada);
		
		Boolean tmp = dto.getPresupuestada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPresupuestada\" o \"getPresupuestada\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPresupuestada\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", presupuestada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setIncompleta y getIncompleta de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetIncompletaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Boolean incompleta = true;
		
		dto.setIncompleta(incompleta);
		
		Boolean tmp = dto.getIncompleta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIncompleta\" o \"getIncompleta\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIncompleta\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", incompleta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setLeida y getLeida de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetLeidaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Boolean leida = true;
		
		dto.setLeida(leida);
		
		Boolean tmp = dto.getLeida();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setLeida\" o \"getLeida\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getLeida\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", leida, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProcesada y getProcesada de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetProcesadaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Boolean procesada = true;
		
		dto.setProcesada(procesada);
		
		Boolean tmp = dto.getProcesada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProcesada\" o \"getProcesada\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProcesada\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", procesada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setExterna y getExterna de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetExternaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		Boolean externa = true;
		
		dto.setExterna(externa);
		
		Boolean tmp = dto.getExterna();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setExterna\" o \"getExterna\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProcesada\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", externa, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTipoDocumento y getTipoDocumento de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetTipoDocumentoMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		TipoDocumentoDTO tipoDocumento = new TipoDocumentoDTO();
		
		dto.setTipoDocumento(tipoDocumento);
		
		TipoDocumentoDTO tmp = dto.getTipoDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipoDocumento\" o \"getTipoDocumento\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipoDocumento\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDomicilio y getDomicilio de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetDomicilioMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		DomicilioDTO domicilio = new DomicilioDTO();
		
		dto.setDomicilio(domicilio);
		
		DomicilioDTO tmp = dto.getDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDomicilio\" o \"getDomicilio\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDomicilio\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", domicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMedioDePago y getCodigoMedioDePago de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioDePagoMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		String codigoMedioDePago = "CODIGO_MEDIO_DE_PAGO";
		
		dto.setCodigoMedioDePago(codigoMedioDePago);
		
		String tmp = dto.getCodigoMedioDePago();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMedioDePago\" o \"getCodigoMedioDePago\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMedioDePago\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioDePago, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoTarjeta y getCodigoTipoTarjeta de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoTarjetaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		String codigoTipoTarjeta = "CODIGO_TIPO_TARJETA";
		
		dto.setCodigoTipoTarjeta(codigoTipoTarjeta);
		
		String tmp = dto.getCodigoTipoTarjeta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoTarjeta\" o \"getCodigoTipoTarjeta\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoTarjeta\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoTarjeta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTipoIVA y getTipoIVA de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetTipoIVAMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		TipoIVADTO tipoIVA = new TipoIVADTO();
		
		dto.setTipoIVA(tipoIVA);
		
		TipoIVADTO tmp = dto.getTipoIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipoIVA\" o \"getTipoIVA\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipoIVA\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setConceptosVendibles y getConceptosVendibles de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetConceptosVendiblesMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		List<ConceptoVendibleDTO> conceptosVendibles = new ArrayList<ConceptoVendibleDTO>();
		
		dto.setConceptosVendibles(conceptosVendibles);
		
		List<ConceptoVendibleDTO> tmp = dto.getConceptosVendibles();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setConceptosVendibles\" o \"getConceptosVendibles\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getConceptosVendibles\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", conceptosVendibles, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCapturador y getCapturador de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetCapturadorMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		CapturadorDTO capturador = new CapturadorDTO();
		
		dto.setCapturador(capturador);
		
		CapturadorDTO tmp = dto.getCapturador();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCapturador\" o \"getCapturador\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCapturador\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", capturador, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setUsuarioExterno y getUsuarioExterno de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetUsuarioExternoMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		UsuarioExternoDTO usuarioExterno = new UsuarioExternoDTO();
		
		dto.setUsuarioExterno(usuarioExterno);
		
		UsuarioExternoDTO tmp = dto.getUsuarioExterno();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUsuarioExterno\" o \"getUsuarioExterno\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUsuarioExterno\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", usuarioExterno, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTransaccionActual y getTransaccionActual de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetTransaccionActualMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		GWPTransaccionDTO transaccionActual = new GWPTransaccionDTO();
		
		dto.setTransaccionActual(transaccionActual);
		
		GWPTransaccionDTO tmp = dto.getTransaccionActual();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTransaccionActual\" o \"getTransaccionActual\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTransaccionActual\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", transaccionActual, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTransacciones y getTransacciones de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetTransaccionesMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		List<GWPTransaccionDTO> transacciones = new ArrayList<GWPTransaccionDTO>();
		
		dto.setTransacciones(transacciones);
		
		List<GWPTransaccionDTO> tmp = dto.getTransacciones();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTransacciones\" o \"getTransacciones\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTransacciones\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", transacciones, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTrackCampana y getTrackCampana de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testSetAndGetTrackCampanaMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		TrackCampanaDTO trackCampana = new TrackCampanaDTO();
		
		dto.setTrackCampana(trackCampana);
		
		TrackCampanaDTO tmp = dto.getTrackCampana();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTrackCampana\" o \"getTrackCampana\" de la clase \"OrdenPublicacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTrackCampana\" de la clase \"OrdenPublicacionDTO\""
				+ " no corresponde al valor enviado como argumento.", trackCampana, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase OrdenPublicacionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		OrdenPublicacionDTO dto = new OrdenPublicacionDTO();
		
		List<ConceptoVendibleDTO> conceptosVendible = new ArrayList<ConceptoVendibleDTO>();
		conceptosVendible.add(new ConceptoVendibleDTO());
		conceptosVendible.add(new ConceptoVendibleDTO());
		conceptosVendible.add(new ConceptoVendibleDTO());
		
		List<GWPTransaccionDTO> gwpTransacciones = new ArrayList<GWPTransaccionDTO>();
		gwpTransacciones.add(new GWPTransaccionDTO());
		gwpTransacciones.add(new GWPTransaccionDTO());
		gwpTransacciones.add(new GWPTransaccionDTO());
		
		dto.setId(300L);
		dto.setUuidGenerarOrden("UUID_GENERAR_ORDEN");
		dto.setFechaAlta(new Date());
		dto.setPresupuestada(true);
		dto.setIncompleta(true);
		dto.setLeida(true);
		dto.setProcesada(true);
		dto.setExterna(true);
		dto.setTipoDocumento(new TipoDocumentoDTO());
		dto.setDomicilio(new DomicilioDTO());
		dto.setCodigoMedioDePago("CODIGO_MEDIO_DE_PAGO");
		dto.setCodigoTipoTarjeta("CODIGO_TIPO_TARJETA");
		dto.setTipoIVA(new TipoIVADTO());
		dto.setConceptosVendibles(conceptosVendible);
		dto.setCapturador(new CapturadorDTO());
		dto.setUsuarioExterno(new UsuarioExternoDTO());
		dto.setTransaccionActual(new GWPTransaccionDTO());
		dto.setTransacciones(gwpTransacciones);
		dto.setTrackCampana(new TrackCampanaDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"OrdenPublicacionDTO\".", tmp);
	}
}

/*
 * @(#)GWPTransactionDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase GWPTransactionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class GWPTransactionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DomicilioDTO.
	 */
	@Test
	public void testConstructor() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"GWPTransactionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAplicacionCliente y getCodigoAplicacionCliente de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAplicacionClienteMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String codigoAplicacionCliente = "CODIGO_APLICACION_CLIENTE";
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		
		String tmp = dto.getCodigoAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAplicacionCliente\" o \"getCodigoAplicacionCliente\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAplicacionCliente\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setLlaveAplicacionCliente y getLlaveAplicacionCliente de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetLlaveAplicacionClienteMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String llaveAplicacionCliente = "LLAVE_APLICACION_CLIENTE";
		
		dto.setLlaveAplicacionCliente(llaveAplicacionCliente);
		
		String tmp = dto.getLlaveAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setLlaveAplicacionCliente\" o \"getLlaveAplicacionCliente\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getLlaveAplicacionCliente\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", llaveAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdTransaccionCliente y getIdTransaccionCliente de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionClienteMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String idTransaccionCliente = "ID_TRANSACCION_CLIENTE";
		
		dto.setIdTransaccionCliente(idTransaccionCliente);
		
		String tmp = dto.getIdTransaccionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdTransaccionCliente\" o \"getIdTransaccionCliente\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdTransaccionCliente\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombreItem y getNombreItem de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetNombreItemMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String nombreItem = "NOMBRE_ITEM";
		
		dto.setNombreItem(nombreItem);
		
		String tmp = dto.getNombreItem();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombreItem\" o \"getNombreItem\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombreItem\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreItem, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setApellidos y getApellidos de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetApellidosMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String apellidos = "APELLIDOS";
		
		dto.setApellidos(apellidos);
		
		String tmp = dto.getApellidos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setApellidos\" o \"getApellidos\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getApellidos\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", apellidos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombres y getNombres de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetNombresMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String nombres = "NOMBRES";
		
		dto.setNombres(nombres);
		
		String tmp = dto.getNombres();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombres\" o \"getNombres\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombres\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombres, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMail y getMail de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetMailMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String mail = "MAIL";
		
		dto.setMail(mail);
		
		String tmp = dto.getMail();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMail\" o \"getMail\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMail\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", mail, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTelefono y getTelefono de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetTelefonoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String telefono = "TELEFONO";
		
		dto.setTelefono(telefono);
		
		String tmp = dto.getTelefono();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTelefono\" o \"getTelefono\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTelefono\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", telefono, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipoTransaccion y getTipoTransaccion de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetTipoTransaccionMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String tipoTransaccion = "TIPO_TRANSACCION";
		
		dto.setTipoTransaccion(tipoTransaccion);
		
		String tmp = dto.getTipoTransaccion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipoTransaccion\" o \"getTipoTransaccion\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipoTransaccion\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoTransaccion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumeroCliente y getNumeroCliente de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetNumeroClienteMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		Integer numeroCliente = 300;
		
		dto.setNumeroCliente(numeroCliente);
		
		Integer tmp = dto.getNumeroCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumeroCliente\" o \"getNumeroCliente\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumeroCliente\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumeroFactura y getNumeroFactura de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetNumeroFacturaMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String numeroFactura = "NUMERO_FACTURA";
		
		dto.setNumeroFactura(numeroFactura);
		
		String tmp = dto.getNumeroFactura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumeroFactura\" o \"getNumeroFactura\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumeroFactura\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroFactura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaVencimiento y getFechaVencimiento de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetFechaVencimientoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		Date fechaVencimiento = null;
		
		dto.setFechaVencimiento(fechaVencimiento);
		
		Date tmp = dto.getFechaVencimiento();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaVencimiento\" o \"getFechaVencimiento\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVencimiento\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVencimiento, tmp);
		
		fechaVencimiento = new Date();
		
		dto.setFechaVencimiento(fechaVencimiento);
		
		tmp = dto.getFechaVencimiento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaVencimiento\" o \"getFechaVencimiento\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVencimiento\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVencimiento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMetodoPago y getCodigoMetodoPago de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMetodoPagoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String codigoMetodoPago = "CODIGO_METODO_PAGO";
		
		dto.setCodigoMetodoPago(codigoMetodoPago);
		
		String tmp = dto.getCodigoMetodoPago();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMetodoPago\" o \"getCodigoMetodoPago\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMetodoPago\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMetodoPago, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMedioPago y getCodigoMedioPago de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String codigoMedioPago = "CODIGO_MEDIO_PAGO";
		
		dto.setCodigoMedioPago(codigoMedioPago);
		
		String tmp = dto.getCodigoMedioPago();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMedioPago\" o \"getCodigoMedioPago\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMedioPago\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPago, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCantidadCuotas y getCantidadCuotas de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetCantidadCuotasMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		Integer cantidadCuotas = 300;
		
		dto.setCantidadCuotas(cantidadCuotas);
		
		Integer tmp = dto.getCantidadCuotas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCantidadCuotas\" o \"getCantidadCuotas\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCantidadCuotas\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadCuotas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMoneda y getCodigoMoneda de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMonedaMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String codigoMoneda = "CODIGO_MONEDA";
		
		dto.setCodigoMoneda(codigoMoneda);
		
		String tmp = dto.getCodigoMoneda();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMoneda\" o \"getCodigoMoneda\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMoneda\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMoneda, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMonto y getMonto de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetMontoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		Double monto = 300.0;
		
		dto.setMonto(monto);
		
		Double tmp = dto.getMonto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMonto\" o \"getMonto\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMonto\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", monto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setUrlImagen y getUrlImagen de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetUrlImagenMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String urlImagen = "URL_IMAGEN";
		
		dto.setUrlImagen(urlImagen);
		
		String tmp = dto.getUrlImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUrlImagen\" o \"getUrlImagen\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUrlImagen\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", urlImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setUrlExito y getUrlExito de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetUrlExitoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String urlExito = "URL_EXITO";
		
		dto.setUrlExito(urlExito);
		
		String tmp = dto.getUrlExito();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUrlExito\" o \"getUrlExito\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUrlExito\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", urlExito, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setUrlFracaso y getUrlFracaso de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testSetAndGetUrlFracasoMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		String urlFracaso = "URL_FRACASO";
		
		dto.setUrlFracaso(urlFracaso);
		
		String tmp = dto.getUrlFracaso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUrlFracaso\" o \"getUrlFracaso\" de la clase \"GWPTransactionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUrlFracaso\" de la clase \"GWPTransactionDTO\""
				+ " no corresponde al valor enviado como argumento.", urlFracaso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase GWPTransactionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		GWPTransactionDTO dto = new GWPTransactionDTO();

		dto.setCodigoAplicacionCliente("CODIGO_APLICACION_CLIENTE");
		dto.setLlaveAplicacionCliente("LLAVE_APLICACION_CLIENTE");
		dto.setIdTransaccionCliente("ID_TRANSACCION_CLIENTE");
		dto.setNombreItem("NOMBRE_ITEM");
		dto.setApellidos("APELLIDOS");
		dto.setNombres("NOMBRES");
		dto.setMail("MAIL");
		dto.setTelefono("TELEFONO");
		dto.setTipoTransaccion("TIPO_TRANSACCION");
		dto.setNumeroCliente(300);
		dto.setNumeroFactura("NUMERO_FACTURA");
		dto.setFechaVencimiento(new Date());
		dto.setCodigoMetodoPago("CODIGO_METODO_PAGO");
		dto.setCodigoMedioPago("CODIGO_MEDIO_PAGO");
		dto.setCantidadCuotas(300);
		dto.setCodigoMoneda("CODIGO_MONEDA");
		dto.setMonto(300.0);
		dto.setUrlImagen("URL_IMAGEN");
		dto.setUrlExito("URL_EXITO");
		dto.setUrlFracaso("URL_FRACASO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"GWPTransactionDTO\".", tmp);
	}
}

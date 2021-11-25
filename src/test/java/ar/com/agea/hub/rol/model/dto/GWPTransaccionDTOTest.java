/*
 * @(#)GWPTransaccionDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase GWPTransaccionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class GWPTransaccionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo GWPTransaccionDTO.
	 */
	@Test
	public void testConstructor() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"GWPTransaccionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAplicacionCliente y getCodigoAplicacionCliente de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAplicacionClienteMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoAplicacionCliente = "CODIGO_APLICACION_CLIENTE";
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		
		String tmp = dto.getCodigoAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAplicacionCliente\" o \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdTransaccionCliente y getIdTransaccionCliente de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionClienteMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String idTransaccionCliente = "ID_TRANSACCION_CLIENTE";
		
		dto.setIdTransaccionCliente(idTransaccionCliente);
		
		String tmp = dto.getIdTransaccionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdTransaccionCliente\" o \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombreItem y getNombreItem de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNombreItemMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String nombreItem = "NOMBRE_ITEM";
		
		dto.setNombreItem(nombreItem);
		
		String tmp = dto.getNombreItem();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombreItem\" o \"getNombreItem\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombreItem\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreItem, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaImputado y getFechaImputado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetFechaImputadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Date fechaImputado = null;
		
		dto.setFechaImputado(fechaImputado);
		
		Date tmp = dto.getFechaImputado();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaImputado\" o \"getFechaImputado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaImputado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaImputado, tmp);
		
		fechaImputado = new Date();
		
		dto.setFechaImputado(fechaImputado);
		
		tmp = dto.getFechaImputado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaImputado\" o \"getFechaImputado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaImputado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaImputado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaTransaccion y getFechaTransaccion de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetFechaTransaccionMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Date fechaTransaccion = null;
		
		dto.setFechaTransaccion(fechaTransaccion);
		
		Date tmp = dto.getFechaTransaccion();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaTransaccion\" o \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTransaccion, tmp);
		
		fechaTransaccion = new Date();
		
		dto.setFechaTransaccion(fechaTransaccion);
		
		tmp = dto.getFechaTransaccion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaTransaccion\" o \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTransaccion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEstado y getEstado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String estado = "ESTADO";
		
		dto.setEstado(estado);
		
		String tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEstado\" o \"getEstado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEstado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMetodoPago y getCodigoMetodoPago de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMetodoPagoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMetodoPago = "CODIGO_METODO_PAGO";
		
		dto.setCodigoMetodoPago(codigoMetodoPago);
		
		String tmp = dto.getCodigoMetodoPago();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMetodoPago\" o \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMetodoPago, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMedioPago y getCodigoMedioPago de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMedioPago = "CODIGO_MEDIO_PAGO";
		
		dto.setCodigoMedioPago(codigoMedioPago);
		
		String tmp = dto.getCodigoMedioPago();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMedioPago\" o \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPago, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumeroTarjeta y getNumeroTarjeta de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNumeroTarjetaMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String numeroTarjeta = "NUMERO_TARJETA";
		
		dto.setNumeroTarjeta(numeroTarjeta);
		
		String tmp = dto.getNumeroTarjeta();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumeroTarjeta\" o \"getNumeroTarjeta\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumeroTarjeta\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroTarjeta, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMoneda y getCodigoMoneda de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMonedaMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMoneda = "CODIGO_MONEDA";
		
		dto.setCodigoMoneda(codigoMoneda);
		
		String tmp = dto.getCodigoMoneda();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMoneda\" o \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMoneda, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMonto y getMonto de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMontoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Double monto = 300.0;
		
		dto.setMonto(monto);
		
		Double tmp = dto.getMonto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMonto\" o \"getMonto\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMonto\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", monto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMontoPagado y getMontoPagado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMontoPagadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Double montoPagado = 300.0;
		
		dto.setMontoPagado(montoPagado);
		
		Double tmp = dto.getMontoPagado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMontoPagado\" o \"getMontoPagado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMontoPagado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoPagado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdTransaccionProveedor y getIdTransaccionProveedor de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionProveedorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String idTransaccionProveedor = "ID_TRANSACCION_PROVEEDOR";
		
		dto.setIdTransaccionProveedor(idTransaccionProveedor);
		
		String tmp = dto.getIdTransaccionProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdTransaccionProveedor\" o \"getIdTransaccionProveedor\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdTransaccionProveedor\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProveedor y getCodigoProveedor de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProveedorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoProveedor = "CODIGO_PROVEEDOR";
		
		dto.setCodigoProveedor(codigoProveedor);
		
		String tmp = dto.getCodigoProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProveedor\" o \"getCodigoProveedor\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProveedor\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPosibleFraude y getPosibleFraude de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetPosibleFraudeMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Boolean posibleFraude = true;
		
		dto.setPosibleFraude(posibleFraude);
		
		Boolean tmp = dto.getPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPosibleFraude\" o \"getPosibleFraude\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPosibleFraude\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", posibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMotivoPosibleFraude y getMotivoPosibleFraude de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMotivoPosibleFraudeMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String motivoPosibleFraude = "MOTIVO_POSIBLE_FRAUDE";
		
		dto.setMotivoPosibleFraude(motivoPosibleFraude);
		
		String tmp = dto.getMotivoPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMotivoPosibleFraude\" o \"getMotivoPosibleFraude\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMotivoPosibleFraude\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoPosibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEmail y getEmail de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEmail\" o \"getEmail\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEmail\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setApellidos y getApellidos de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetApellidosMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String apellidos = "APELLIDOS";
		
		dto.setApellidos(apellidos);
		
		String tmp = dto.getApellidos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setApellidos\" o \"getApellidos\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getApellidos\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", apellidos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombres y getNombres de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNombresMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String nombres = "NOMBRES";
		
		dto.setNombres(nombres);
		
		String tmp = dto.getNombres();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombres\" o \"getNombres\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombres\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombres, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTelefono y getTelefono de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetTelefonoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String telefono = "TELEFONO";
		
		dto.setTelefono(telefono);
		
		String tmp = dto.getTelefono();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTelefono\" o \"getTelefono\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTelefono\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", telefono, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcionError y getDescripcionError de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionErrorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String descripcionError = "DESCRIPCION_ERROR";
		
		dto.setDescripcionError(descripcionError);
		
		String tmp = dto.getDescripcionError();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcionError\" o \"getDescripcionError\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcionError\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcionError, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		
		dto.setCodigoAplicacionCliente("CODIGO_APLICACION_CLIENTE");
		dto.setIdTransaccionCliente("ID_TRANSACCION_CLIENTE");
		dto.setNombreItem("NOMBRE_ITEM");
		dto.setFechaImputado(new Date());
		dto.setFechaTransaccion(new Date());
		dto.setEstado("ESTADO");
		dto.setCodigoMetodoPago("CODIGO_METODO_PAGO");
		dto.setCodigoMedioPago("CODIGO_MEDIO_PAGO");
		dto.setNumeroTarjeta("NUMERO_TARJETA");
		dto.setCodigoMoneda("CODIGO_MONEDA");
		dto.setMonto(300.0);
		dto.setMontoPagado(300.0);
		dto.setIdTransaccionProveedor("ID_TRANSACCION_PROVEEDOR");
		dto.setCodigoProveedor("CODIGO_PROVEEDOR");
		dto.setPosibleFraude(true);
		dto.setMotivoPosibleFraude("MOTIVO_POSIBLE_FRAUDE");
		dto.setEmail("EMAIL");
		dto.setApellidos("APELLIDOS");
		dto.setNombres("NOMBRES");
		dto.setTelefono("TELEFONO");
		dto.setDescripcionError("DESCRIPCION_ERROR");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"GWPTransaccionDTO\".", tmp);
	}
}

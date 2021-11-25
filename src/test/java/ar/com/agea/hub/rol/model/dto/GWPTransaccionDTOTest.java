/*
 * @(#)GWPTransaccionDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase GWPTransaccionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class GWPTransaccionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo GWPTransaccionDTO.
	 */
	@Test
	public void testConstructor() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"GWPTransaccionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoAplicacionCliente y getCodigoAplicacionCliente de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAplicacionClienteMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoAplicacionCliente = "CODIGO_APLICACION_CLIENTE";
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		
		String tmp = dto.getCodigoAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAplicacionCliente\" o \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setIdTransaccionCliente y getIdTransaccionCliente de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionClienteMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String idTransaccionCliente = "ID_TRANSACCION_CLIENTE";
		
		dto.setIdTransaccionCliente(idTransaccionCliente);
		
		String tmp = dto.getIdTransaccionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdTransaccionCliente\" o \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombreItem y getNombreItem de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNombreItemMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String nombreItem = "NOMBRE_ITEM";
		
		dto.setNombreItem(nombreItem);
		
		String tmp = dto.getNombreItem();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombreItem\" o \"getNombreItem\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombreItem\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreItem, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaImputado y getFechaImputado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetFechaImputadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Date fechaImputado = null;
		
		dto.setFechaImputado(fechaImputado);
		
		Date tmp = dto.getFechaImputado();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaImputado\" o \"getFechaImputado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaImputado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaImputado, tmp);
		
		fechaImputado = new Date();
		
		dto.setFechaImputado(fechaImputado);
		
		tmp = dto.getFechaImputado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaImputado\" o \"getFechaImputado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaImputado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaImputado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaTransaccion y getFechaTransaccion de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetFechaTransaccionMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Date fechaTransaccion = null;
		
		dto.setFechaTransaccion(fechaTransaccion);
		
		Date tmp = dto.getFechaTransaccion();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaTransaccion\" o \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTransaccion, tmp);
		
		fechaTransaccion = new Date();
		
		dto.setFechaTransaccion(fechaTransaccion);
		
		tmp = dto.getFechaTransaccion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaTransaccion\" o \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaTransaccion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEstado y getEstado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String estado = "ESTADO";
		
		dto.setEstado(estado);
		
		String tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEstado\" o \"getEstado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEstado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMetodoPago y getCodigoMetodoPago de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMetodoPagoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMetodoPago = "CODIGO_METODO_PAGO";
		
		dto.setCodigoMetodoPago(codigoMetodoPago);
		
		String tmp = dto.getCodigoMetodoPago();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMetodoPago\" o \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMetodoPago, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMedioPago y getCodigoMedioPago de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMedioPago = "CODIGO_MEDIO_PAGO";
		
		dto.setCodigoMedioPago(codigoMedioPago);
		
		String tmp = dto.getCodigoMedioPago();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMedioPago\" o \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPago, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumeroTarjeta y getNumeroTarjeta de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNumeroTarjetaMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String numeroTarjeta = "NUMERO_TARJETA";
		
		dto.setNumeroTarjeta(numeroTarjeta);
		
		String tmp = dto.getNumeroTarjeta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumeroTarjeta\" o \"getNumeroTarjeta\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumeroTarjeta\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroTarjeta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMoneda y getCodigoMoneda de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMonedaMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoMoneda = "CODIGO_MONEDA";
		
		dto.setCodigoMoneda(codigoMoneda);
		
		String tmp = dto.getCodigoMoneda();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMoneda\" o \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMoneda, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMonto y getMonto de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMontoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Double monto = 300.0;
		
		dto.setMonto(monto);
		
		Double tmp = dto.getMonto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMonto\" o \"getMonto\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMonto\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", monto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoPagado y getMontoPagado de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMontoPagadoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Double montoPagado = 300.0;
		
		dto.setMontoPagado(montoPagado);
		
		Double tmp = dto.getMontoPagado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoPagado\" o \"getMontoPagado\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoPagado\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoPagado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setIdTransaccionProveedor y getIdTransaccionProveedor de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionProveedorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String idTransaccionProveedor = "ID_TRANSACCION_PROVEEDOR";
		
		dto.setIdTransaccionProveedor(idTransaccionProveedor);
		
		String tmp = dto.getIdTransaccionProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdTransaccionProveedor\" o \"getIdTransaccionProveedor\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdTransaccionProveedor\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProveedor y getCodigoProveedor de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProveedorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String codigoProveedor = "CODIGO_PROVEEDOR";
		
		dto.setCodigoProveedor(codigoProveedor);
		
		String tmp = dto.getCodigoProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProveedor\" o \"getCodigoProveedor\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProveedor\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPosibleFraude y getPosibleFraude de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetPosibleFraudeMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		Boolean posibleFraude = true;
		
		dto.setPosibleFraude(posibleFraude);
		
		Boolean tmp = dto.getPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPosibleFraude\" o \"getPosibleFraude\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPosibleFraude\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", posibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMotivoPosibleFraude y getMotivoPosibleFraude de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetMotivoPosibleFraudeMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String motivoPosibleFraude = "MOTIVO_POSIBLE_FRAUDE";
		
		dto.setMotivoPosibleFraude(motivoPosibleFraude);
		
		String tmp = dto.getMotivoPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMotivoPosibleFraude\" o \"getMotivoPosibleFraude\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMotivoPosibleFraude\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoPosibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEmail y getEmail de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEmail\" o \"getEmail\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEmail\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setApellidos y getApellidos de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetApellidosMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String apellidos = "APELLIDOS";
		
		dto.setApellidos(apellidos);
		
		String tmp = dto.getApellidos();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setApellidos\" o \"getApellidos\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getApellidos\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", apellidos, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombres y getNombres de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetNombresMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String nombres = "NOMBRES";
		
		dto.setNombres(nombres);
		
		String tmp = dto.getNombres();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombres\" o \"getNombres\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombres\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombres, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTelefono y getTelefono de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetTelefonoMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String telefono = "TELEFONO";
		
		dto.setTelefono(telefono);
		
		String tmp = dto.getTelefono();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTelefono\" o \"getTelefono\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTelefono\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", telefono, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcionError y getDescripcionError de la clase GWPTransaccionDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionErrorMethod() {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		String descripcionError = "DESCRIPCION_ERROR";
		
		dto.setDescripcionError(descripcionError);
		
		String tmp = dto.getDescripcionError();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcionError\" o \"getDescripcionError\" de la clase \"GWPTransaccionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcionError\" de la clase \"GWPTransaccionDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcionError, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase GWPTransaccionDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"GWPTransaccionDTO\".", tmp);
	}
}

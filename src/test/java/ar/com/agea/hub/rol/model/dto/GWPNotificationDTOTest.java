/*
 * @(#)GWPNotificationDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase GWPNotificationDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class GWPNotificationDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo GWPNotificationDTO.
	 */
	@Test
	public void testConstructor() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"GWPNotificationDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoAplicacionCliente y getCodigoAplicacionCliente de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAplicacionClienteMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String codigoAplicacionCliente = "CODIGO_APLICACION_CLIENTE";
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		
		String tmp = dto.getCodigoAplicacionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAplicacionCliente\" o \"getCodigoAplicacionCliente\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAplicacionCliente\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAplicacionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setIdTransaccionCliente y getIdTransaccionCliente de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionClienteMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String idTransaccionCliente = "ID_TRANSACCION_CLIENTE";
		
		dto.setIdTransaccionCliente(idTransaccionCliente);
		
		String tmp = dto.getIdTransaccionCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdTransaccionCliente\" o \"getIdTransaccionCliente\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdTransaccionCliente\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombreItem y getNombreItem de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetNombreItemMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String nombreItem = "NOMBRE_ITEM";
		
		dto.setNombreItem(nombreItem);
		
		String tmp = dto.getNombreItem();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombreItem\" o \"getNombreItem\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombreItem\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreItem, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFecha y getFecha de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetFechaMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		Date fecha = null;
		
		dto.setFecha(fecha);
		
		Date tmp = dto.getFecha();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFecha\" o \"getFecha\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFecha\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", fecha, tmp);
		
		fecha = new Date();
		
		dto.setFecha(fecha);
		
		tmp = dto.getFecha();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFecha\" o \"getFecha\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFecha\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", fecha, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEstado y getEstado de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String estado = "ESTADO";
		
		dto.setEstado(estado);
		
		String tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEstado\" o \"getEstado\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEstado\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMetodoPago y getCodigoMetodoPago de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMetodoPagoMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String codigoMetodoPago = "CODIGO_METODO_PAGO";
		
		dto.setCodigoMetodoPago(codigoMetodoPago);
		
		String tmp = dto.getCodigoMetodoPago();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMetodoPago\" o \"getCodigoMetodoPago\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMetodoPago\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMetodoPago, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMedioPago y getMedioPago de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetMedioPagoMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String medioPago = "MEDIO_PAGO";
		
		dto.setMedioPago(medioPago);
		
		String tmp = dto.getMedioPago();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMedioPago\" o \"getMedioPago\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMedioPago\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", medioPago, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumeroTarjeta y getNumeroTarjeta de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetNumeroTarjetaMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String numeroTarjeta = "NUMERO_TARJETA";
		
		dto.setNumeroTarjeta(numeroTarjeta);
		
		String tmp = dto.getNumeroTarjeta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumeroTarjeta\" o \"getNumeroTarjeta\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumeroTarjeta\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroTarjeta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMoneda y getCodigoMoneda de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMonedaMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String codigoMoneda = "CODIGO_MONEDA";
		
		dto.setCodigoMoneda(codigoMoneda);
		
		String tmp = dto.getCodigoMoneda();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMoneda\" o \"getCodigoMoneda\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMoneda\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMoneda, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMonto y getMonto de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetMontoMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		Double monto = 300.0;
		
		dto.setMonto(monto);
		
		Double tmp = dto.getMonto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMonto\" o \"getMonto\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMonto\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", monto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoPagado y getMontoPagado de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetMontoPagadoMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		Double montoPagado = 300.0;
		
		dto.setMontoPagado(montoPagado);
		
		Double tmp = dto.getMontoPagado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoPagado\" o \"getMontoPagado\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoPagado\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", montoPagado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setIdTransaccionProveedor y getIdTransaccionProveedor de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetIdTransaccionProveedorMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String idTransaccionProveedor = "ID_TRANSACCION_PROVEEDOR";
		
		dto.setIdTransaccionProveedor(idTransaccionProveedor);
		
		String tmp = dto.getIdTransaccionProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdTransaccionProveedor\" o \"getIdTransaccionProveedor\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdTransaccionProveedor\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", idTransaccionProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProveedor y getCodigoProveedor de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProveedorMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String codigoProveedor = "CODIGO_PROVEEDOR";
		
		dto.setCodigoProveedor(codigoProveedor);
		
		String tmp = dto.getCodigoProveedor();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProveedor\" o \"getCodigoProveedor\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProveedor\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProveedor, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPosibleFraude y getPosibleFraude de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetPosibleFraudeMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		Boolean posibleFraude = true;
		
		dto.setPosibleFraude(posibleFraude);
		
		Boolean tmp = dto.getPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPosibleFraude\" o \"getPosibleFraude\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPosibleFraude\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", posibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMotivoPosibleFraude y getMotivoPosibleFraude de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testSetAndGetMotivoPosibleFraudeMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		String motivoPosibleFraude = "MOTIVO_POSIBLE_FRAUDE";
		
		dto.setMotivoPosibleFraude(motivoPosibleFraude);
		
		String tmp = dto.getMotivoPosibleFraude();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMotivoPosibleFraude\" o \"getMotivoPosibleFraude\" de la clase \"GWPNotificationDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMotivoPosibleFraude\" de la clase \"GWPNotificationDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoPosibleFraude, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase GWPNotificationDTO. 
	 */
	@Test
	public void testToStringMethod() {
		GWPNotificationDTO dto = new GWPNotificationDTO();
		
		dto.setCodigoAplicacionCliente("CODIGO_APLICACION_CLIENTE");
		dto.setIdTransaccionCliente("ID_TRANSACCION_CLIENTE");
		dto.setNombreItem("NOMBRE_ITEM");
		dto.setFecha(new Date());
		dto.setEstado("ESTADO");
		dto.setCodigoMetodoPago("CODIGO_METODO_PAGO");
		dto.setMedioPago("MEDIO_PAGO");
		dto.setNumeroTarjeta("NUMERO_TARJETA");
		dto.setCodigoMoneda("CODIGO_MONEDA");
		dto.setMonto(300.0);
		dto.setMontoPagado(300.0);
		dto.setIdTransaccionProveedor("ID_TRANSACCION_PROVEEDOR");
		dto.setCodigoProveedor("CODIGO_PROVEEDOR");
		dto.setPosibleFraude(true);
		dto.setMotivoPosibleFraude("MOTIVO_POSIBLE_FRAUDE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"GWPNotificationDTO\".", tmp);
	}
}

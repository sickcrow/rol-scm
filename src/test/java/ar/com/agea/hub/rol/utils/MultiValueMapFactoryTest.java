/*
 * @(#)MultiValueMapFactoryTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.MultiValueMap;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO;

/**
 * Representa JUnit Tests de inicialización para la clase MultiValueMapFactory.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class MultiValueMapFactoryTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de método createAgrupadorProductoComercialNivel de la clase MultiValueMapFactory. 
	 */
	@Test
	public void testCreateMultiValueMapForPASEUsuarioDTOMethod() {
		MultiValueMapKey[] keys = new MultiValueMapKey[] {MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN, MultiValueMapKey.UID,
				MultiValueMapKey.ID_USUARIO, MultiValueMapKey.APELLIDO, MultiValueMapKey.NOMBRE, MultiValueMapKey.GENERO, 
				MultiValueMapKey.FECHA_NACIMIENTO, MultiValueMapKey.EMAIL, MultiValueMapKey.PALABRA_CLAVE};
		
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		
		dto.setCodigoSitio("ROL-CODE");
		dto.setToken("300-000");
		dto.setUid("300");
		dto.setApellido("apellido");
		dto.setNombre("nombre");
		dto.setGenero("M");
		dto.setFechaNacimiento("10/06/1960");
		dto.setEmail("apellidonombre@email.com");
		dto.setPalabraClave("usuario");

		MultiValueMap<String, String> output = MultiValueMapFactory.createMultiValueMap(keys, dto);
		
		Assert.assertNotNull("Ha fallado la llamada al método \"createMultiValueMap\" para PASEUsuarioDTO de la clase \"MultiValueMapFactory\".",
				output);
		
		for (MultiValueMapKey key : keys) {
			Object value = output.getFirst(key.getName());
			
			Assert.assertNotNull("El valor retornado por la clave \"" + key + "\" de la clase \"MultiValueMapFactory\" es nulo.",
					value);
		}
	}
	
	public void testCreateMultiValueMapForGWPTransactionDTOMethod() {
		MultiValueMapKey[] keys = new MultiValueMapKey[] {MultiValueMapKey.CODIGO_APLICACION_CLIENTE,
				MultiValueMapKey.LLAVE_APLICACION_CLIENTE, MultiValueMapKey.CODIGO_METODO_PAGO, 
				MultiValueMapKey.CODIGO_MEDIO_PAGO, MultiValueMapKey.MONTO, MultiValueMapKey.NOMBRE_ITEM, 
				MultiValueMapKey.CODIGO_MONEDA, MultiValueMapKey.TIPO_TRANSACCION, MultiValueMapKey.ID_TRANSACCION_CLIENTE, 
				MultiValueMapKey.FECHA_VENCIMIENTO, MultiValueMapKey.CANTIDAD_CUOTAS, MultiValueMapKey.NUMERO_CLIENTE, 
				MultiValueMapKey.NUMERO_FACTURA, MultiValueMapKey.MAIL, MultiValueMapKey.APELLIDOS, MultiValueMapKey.NOMBRES, 
				MultiValueMapKey.TELEFONO, MultiValueMapKey.URL_IMAGEN, MultiValueMapKey.URL_EXITO, MultiValueMapKey.URL_FRACASO};
		
		GWPTransactionDTO dto = new GWPTransactionDTO();
		
		dto.setCodigoAplicacionCliente("ROL-300");
		dto.setLlaveAplicacionCliente("300-000");
		dto.setCodigoMetodoPago("TARJETA");
		dto.setCodigoMedioPago("VISA");
		dto.setMonto(300.0);
		dto.setNombreItem("Clasificados Clarín - Receptoría On line");
		dto.setCodigoMoneda("PESO");
		dto.setTipoTransaccion("TIPO");
		dto.setIdTransaccionCliente("ROL_3000");
		dto.setFechaVencimiento(new Date());
		dto.setCantidadCuotas(3);
		dto.setNumeroCliente(3);
		dto.setNumeroFactura("300-000");
		dto.setMail("apellidonombre@email.com");
		dto.setApellidos("apellidos");
		dto.setNombres("nombres");
		dto.setTelefono("3000-0000");
		dto.setUrlImagen("http://url.com");
		dto.setUrlExito("http://url.com");
		dto.setUrlFracaso("http://url.com");
		
		MultiValueMap<String, String> output = MultiValueMapFactory.createMultiValueMap(keys, dto);
		
		Assert.assertNotNull("Ha fallado la llamada al método \"createMultiValueMap\" para  GWPTransactionDTO de la clase \"MultiValueMapFactory\".",
				output);
		
		for (MultiValueMapKey key : keys) {
			Object value = output.getFirst(key.getName());
			
			Assert.assertNotNull("El valor retornado por la clave \"" + key + "\" de la clase \"MultiValueMapFactory\" es nulo.",
					value);
		}
	}
}

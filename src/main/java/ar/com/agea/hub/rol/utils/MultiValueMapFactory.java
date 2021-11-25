/*
 * @(#)MultiValueMapFactory.java		1.0 10/10/2013
 */

package ar.com.agea.hub.rol.utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO;

/**
 * Representa un objeto Factory para crear objetos de tipo Data Transfer Object
 * de clases específicas a partir de otros objetos que representan sus parámetros.
 *  
 * @author		Eduardo Barrera
 * @version		1.0 10/10/2013
 */
public final class MultiValueMapFactory {
	
	private static final String LANGUAGE_ES = "es";
	private static final String COUNTRY_AR = "AR";
	
	private static Locale locale;
	
	private static NumberFormat numberFormatter;
	private static DateFormat dateFormatter;
	
	static {
		locale = new Locale(LANGUAGE_ES, COUNTRY_AR);
		
		numberFormatter = NumberFormat.getInstance(locale);
		numberFormatter.setGroupingUsed(false);
		
		dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
	}
	
	private MultiValueMapFactory() {} 

	/**
	 * Crea un objeto MultiValueMap a partir de un conjunto de datos
	 * que representan sus parámetros.
	 * 
	 * @param keys Objetos claves que indica qué datos se deben obtener.
	 * @param dto Objeto usuario PASE del cual se obtienen los datos.
	 * @return Objeto MultiValueMap creado.
	 */
	public static MultiValueMap<String, String> createMultiValueMap(MultiValueMapKey[] keys, PASEUsuarioDTO dto) {
		MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();

		Map<MultiValueMapKey, String> data = new HashMap<MultiValueMapKey, String>();
		
		data.put(MultiValueMapKey.CODIGO_SITIO, dto.getCodigoSitio());
		data.put(MultiValueMapKey.TOKEN, dto.getToken());
		data.put(MultiValueMapKey.UID, String.valueOf(dto.getUid()));
		data.put(MultiValueMapKey.ID_USUARIO, String.valueOf(dto.getUid()));
		data.put(MultiValueMapKey.APELLIDO, dto.getApellido());
		data.put(MultiValueMapKey.NOMBRE, dto.getNombre());
		data.put(MultiValueMapKey.GENERO, dto.getGenero());
		data.put(MultiValueMapKey.FECHA_NACIMIENTO, dto.getFechaNacimiento());
		data.put(MultiValueMapKey.EMAIL, dto.getEmail());
		data.put(MultiValueMapKey.PALABRA_CLAVE, dto.getPalabraClave());
		
		for (MultiValueMapKey key : keys) {
			if (data.containsKey(key)) {
				result.add(key.getName(), data.get(key));
			}
		}
		
		return result;
	}
	
	/**
	 * Crea un objeto MultiValueMap a partir de un conjunto de datos
	 * que representan sus parámetros.
	 * 
	 * @param keys Objetos claves que indica qué datos se deben obtener.
	 * @param dto Objeto usuario PASE del cual se obtienen los datos.
	 * @return Objeto MultiValueMap creado.
	 */
	public static MultiValueMap<String, String> createMultiValueMap(MultiValueMapKey[] keys, GWPTransactionDTO dto) {
		MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();

		Map<MultiValueMapKey, String> data = new HashMap<MultiValueMapKey, String>();

		data.put(MultiValueMapKey.CODIGO_APLICACION_CLIENTE, dto.getCodigoAplicacionCliente());
		data.put(MultiValueMapKey.LLAVE_APLICACION_CLIENTE, dto.getLlaveAplicacionCliente());
		data.put(MultiValueMapKey.CODIGO_METODO_PAGO, dto.getCodigoMetodoPago());
		data.put(MultiValueMapKey.CODIGO_MEDIO_PAGO, dto.getCodigoMedioPago());
		data.put(MultiValueMapKey.MONTO, (dto.getMonto() != null ? numberFormatter.format(dto.getMonto()) : null));
		data.put(MultiValueMapKey.NOMBRE_ITEM, dto.getNombreItem());
		data.put(MultiValueMapKey.CODIGO_MONEDA, dto.getCodigoMoneda());
		data.put(MultiValueMapKey.TIPO_TRANSACCION, dto.getTipoTransaccion());
		data.put(MultiValueMapKey.ID_TRANSACCION_CLIENTE, dto.getIdTransaccionCliente());
		data.put(MultiValueMapKey.FECHA_VENCIMIENTO, (dto.getFechaVencimiento() != null ? dateFormatter.format(dto.getFechaVencimiento()) : null));
		data.put(MultiValueMapKey.CANTIDAD_CUOTAS, String.valueOf(dto.getCantidadCuotas()));
		data.put(MultiValueMapKey.NUMERO_CLIENTE, String.valueOf(dto.getNumeroCliente()));
		data.put(MultiValueMapKey.NUMERO_FACTURA, dto.getNumeroFactura());
		data.put(MultiValueMapKey.MAIL, dto.getMail());
		data.put(MultiValueMapKey.APELLIDOS, dto.getApellidos());
		data.put(MultiValueMapKey.NOMBRES, dto.getNombres());
		data.put(MultiValueMapKey.TELEFONO, dto.getTelefono());
		data.put(MultiValueMapKey.URL_IMAGEN, dto.getUrlImagen());
		data.put(MultiValueMapKey.URL_EXITO, dto.getUrlExito());
		data.put(MultiValueMapKey.URL_FRACASO, dto.getUrlFracaso());
		
		for (MultiValueMapKey key : keys) {
			if (data.containsKey(key)) {
				result.add(key.getName(), data.get(key));
			}
		}
		
		return result;
	}
}
	

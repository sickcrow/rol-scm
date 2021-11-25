/*
 * @(#)DefaultGWPService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import ar.com.agea.hub.rol.credentials.GWPCredentials;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.GWPService;
import ar.com.agea.hub.rol.service.Service;
import ar.com.agea.hub.rol.utils.DataTypeUtil;
import ar.com.agea.hub.rol.utils.MultiValueMapFactory;
import ar.com.agea.hub.rol.utils.MultiValueMapKey;
import ar.com.agea.hub.rol.utils.URLServiceName;

/**
 * Provee una implementación de la interfaz GWPService.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 23/10/2013
 */
@Component
public class DefaultGWPService extends Service implements GWPService {

	@Autowired
	private GWPCredentials gwpCredentials;
	
	@Override
	public ROLResult realizar(GWPTransactionDTO dto) throws ServiceException {
		getLogger().info("--- Realizando llamado al GWP de transaccion cliente: "+dto.getIdTransaccionCliente()+" ---");

		addGWPCredentials(dto);
		
		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(new MultiValueMapKey[]
				{MultiValueMapKey.CODIGO_APLICACION_CLIENTE, MultiValueMapKey.LLAVE_APLICACION_CLIENTE,
				MultiValueMapKey.CODIGO_METODO_PAGO, MultiValueMapKey.CODIGO_MEDIO_PAGO,
				MultiValueMapKey.MONTO, MultiValueMapKey.NOMBRE_ITEM, MultiValueMapKey.ID_TRANSACCION_CLIENTE,
				MultiValueMapKey.CANTIDAD_CUOTAS, MultiValueMapKey.MAIL, MultiValueMapKey.APELLIDOS,
				MultiValueMapKey.NOMBRES}, dto);
		
		MultiValueMap<String, String> map = MultiValueMapFactory.createMultiValueMap(values, dto);
		
		String tmp = null;
		
		/*
		 * Esto es un tratamiento especial por los resultados que devuelve GWP.
		 * 
		 * GWP no tiene un objeto de retorno como el resto de los servicios con lo cual sus retornos
		 * se tratan como objeto string.
		 * 
		 * GWP siempre devuelve un objeto string que puede ser un error o un contenido html.
		 */
		try {
			tmp = getFacade().callService(URLServiceName.GWP_REALIZAR, map, String.class, null);
		} catch (Exception e) {
			tmp = e.getMessage();
		}

		ROLResult rolResult = handleResult(tmp);
			
		getLogger().info("--- Retorno llamado del GWP de transaccion cliente: "+dto.getIdTransaccionCliente()+" ---");

		return rolResult;
	}
	
	private GWPTransactionDTO addGWPCredentials(GWPTransactionDTO dto) {
		dto.setCodigoAplicacionCliente(gwpCredentials.getCodigoAplicacionCliente());
		dto.setLlaveAplicacionCliente(gwpCredentials.getLlaveAplicacionCliente());
		
		return dto;
	}
	
	private MultiValueMapKey[] filterMultiValueMapKeyByEmpty(MultiValueMapKey[] keys, GWPTransactionDTO dto) {
		Set<MultiValueMapKey> result = new HashSet<MultiValueMapKey>();
		
		Map<MultiValueMapKey, String> stringData = new HashMap<MultiValueMapKey, String>();
		
		stringData.put(MultiValueMapKey.CODIGO_APLICACION_CLIENTE, dto.getCodigoAplicacionCliente());
		stringData.put(MultiValueMapKey.LLAVE_APLICACION_CLIENTE, dto.getLlaveAplicacionCliente());
		stringData.put(MultiValueMapKey.CODIGO_METODO_PAGO, dto.getCodigoMetodoPago());
		stringData.put(MultiValueMapKey.CODIGO_MEDIO_PAGO, dto.getCodigoMedioPago());
		stringData.put(MultiValueMapKey.NOMBRE_ITEM, dto.getNombreItem());
		stringData.put(MultiValueMapKey.CODIGO_MONEDA, dto.getCodigoMoneda());
		stringData.put(MultiValueMapKey.TIPO_TRANSACCION, dto.getTipoTransaccion());
		stringData.put(MultiValueMapKey.ID_TRANSACCION_CLIENTE, dto.getIdTransaccionCliente());
		stringData.put(MultiValueMapKey.NUMERO_FACTURA, dto.getNumeroFactura());
		stringData.put(MultiValueMapKey.MAIL, dto.getMail());
		stringData.put(MultiValueMapKey.APELLIDOS, dto.getApellidos());
		stringData.put(MultiValueMapKey.NOMBRES, dto.getNombres());
		stringData.put(MultiValueMapKey.TELEFONO, dto.getTelefono());
		stringData.put(MultiValueMapKey.URL_IMAGEN, dto.getUrlImagen());
		stringData.put(MultiValueMapKey.URL_EXITO, dto.getUrlExito());
		stringData.put(MultiValueMapKey.URL_FRACASO, dto.getUrlFracaso());

		Map<MultiValueMapKey, Double> doubleData = new HashMap<MultiValueMapKey, Double>();
		
		doubleData.put(MultiValueMapKey.MONTO, dto.getMonto());
		
		Map<MultiValueMapKey, Integer> integerData = new HashMap<MultiValueMapKey, Integer>();
		
		integerData.put(MultiValueMapKey.CANTIDAD_CUOTAS, dto.getCantidadCuotas());
		integerData.put(MultiValueMapKey.NUMERO_CLIENTE, dto.getNumeroCliente());
		
		Map<MultiValueMapKey, Date> dateData = new HashMap<MultiValueMapKey, Date>();
		
		dateData.put(MultiValueMapKey.FECHA_VENCIMIENTO, dto.getFechaVencimiento());
		
		for (MultiValueMapKey key : keys) {
			if (!DataTypeUtil.isEmpty(stringData.get(key)) || !DataTypeUtil.isEmpty(doubleData.get(key))
					|| !DataTypeUtil.isEmpty(integerData.get(key)) || !DataTypeUtil.isEmpty(dateData.get(key))) {
				result.add(key);
			}
		}
		
		return (MultiValueMapKey[]) result.toArray(new MultiValueMapKey[] {});
	}
}

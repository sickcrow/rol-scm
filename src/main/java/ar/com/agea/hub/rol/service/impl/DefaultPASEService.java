/*
 * @(#)DefaultPASEService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service.impl;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.service.Service;

/**
 * Provee una implementación de la interfaz PASEService.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 23/10/2013
 */
@Component
public class DefaultPASEService extends Service {
	
//	private static Set<DTOFieldName> fieldsToObfuscate;
//
//	static {
//		fieldsToObfuscate = new HashSet<DTOFieldName>();
//		
//		fieldsToObfuscate.add(DTOFieldName.PALABRA_CLAVE);
//	}
//	
//	
//	@Override
//	public ROLResult registrar(PASEUsuarioDTO dto) throws ServiceException {
//		getLogger().info("Registrando usuario...");
//
//		MultiValueMap<String, String> map = createMultiValueMapForRegistrar(dto);
//		
//		PASEResult tmp = getFacade().callService(URLServiceName.PASE_REGISTRAR, map, PASEResult.class, fieldsToObfuscate);
//		
//		ROLResult rolResult = handleResult(tmp);
//			
//		getLogger().info("Usuario registrado.");
//
//		return rolResult;
//	}
//	
//	private MultiValueMap<String, String> createMultiValueMapForRegistrar(PASEUsuarioDTO dto) {
//		
//		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(new MultiValueMapKey[]
//				{MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN,
//				MultiValueMapKey.APELLIDO, MultiValueMapKey.NOMBRE, MultiValueMapKey.GENERO, 
//				MultiValueMapKey.FECHA_NACIMIENTO, MultiValueMapKey.EMAIL,
//				MultiValueMapKey.PALABRA_CLAVE}, dto);
//		
//		return MultiValueMapFactory.createMultiValueMap(values, dto);
//	}
//	
//	@Override
//	public ROLResult modificar(PASEUsuarioDTO dto) throws ServiceException {
//		getLogger().info("Modificando usuario...");
//
//		MultiValueMap<String, String> map = createMultiValueMapForModificar(dto);
//
//		PASEResult tmp = getFacade().callService(URLServiceName.PASE_MODIFICAR, map, PASEResult.class, fieldsToObfuscate);
//		
//		ROLResult rolResult = handleResult(tmp);
//			
//		getLogger().info("Usuario modificado.");
//
//		return rolResult;
//	}
//	
//	private MultiValueMap<String, String> createMultiValueMapForModificar(PASEUsuarioDTO dto) {
//
//		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(new MultiValueMapKey[]
//				{MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN, MultiValueMapKey.UID,
//				MultiValueMapKey.APELLIDO, MultiValueMapKey.NOMBRE, MultiValueMapKey.GENERO,
//				MultiValueMapKey.FECHA_NACIMIENTO, MultiValueMapKey.PALABRA_CLAVE}, dto);
//		
//		return MultiValueMapFactory.createMultiValueMap(values, dto);
//	}
//	
//	@Override
//	public ROLResult autenticar(PASEUsuarioDTO dto) throws ServiceException {
//		getLogger().info("Autenticando usuario por email...");
//
//		MultiValueMap<String, String> map = createMultiValueMapForAutenticar(dto);
//
//		PASEResult tmp = getFacade().callService(URLServiceName.PASE_AUTENTICAR, map, PASEResult.class, fieldsToObfuscate);
//		
//		ROLResult rolResult = handleResult(tmp);
//		
//		getLogger().info("Usuario por email autenticado.");
//		
//		return rolResult;
//	}
//	
//	private MultiValueMap<String, String> createMultiValueMapForAutenticar(PASEUsuarioDTO dto) {
//		
//		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(new MultiValueMapKey[]
//				{MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN, MultiValueMapKey.EMAIL,
//				MultiValueMapKey.PALABRA_CLAVE}, dto);
//		
//		return MultiValueMapFactory.createMultiValueMap(values, dto);
//	}
//	
//	@Override
//	public ROLResult obtener(PASEUsuarioDTO dto) throws ServiceException {
//		getLogger().info("Obteniendo usuario...");
//
//		MultiValueMap<String, String> map = createMultiValueMapForObtener(dto);
//
//		PASEResult tmp = getFacade().callService(URLServiceName.PASE_OBTENER, map, PASEResult.class, fieldsToObfuscate);
//		
//		ROLResult rolResult = handleResult(tmp);
//		
//		getLogger().info("Usuario obtenido.");
//
//		return rolResult;
//	}
//
//	private MultiValueMap<String, String> createMultiValueMapForObtener(PASEUsuarioDTO dto) {
//		
//		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(
//				new MultiValueMapKey[] {MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN,
//				MultiValueMapKey.ID_USUARIO, MultiValueMapKey.EMAIL}, dto);
//		
//		return MultiValueMapFactory.createMultiValueMap(values, dto);
//	}
//	
//	@Override
//	public ROLResult recuperarPassword(PASEUsuarioDTO dto) throws ServiceException {
//		getLogger().info("Recuperando password de usuario...");
//
//		MultiValueMap<String, String> map = createMultiValueMapForRecuperarPassword(dto);
//
//		PASEResult tmp = getFacade().callService(URLServiceName.PASE_RECUPERAR_PASSWORD, map, PASEResult.class, fieldsToObfuscate);
//		
//		ROLResult rolResult = handleResult(tmp);
//		
//		getLogger().info("Password de usuario recuperada.");
//		
//		return rolResult;
//	}
//
//	private MultiValueMap<String, String> createMultiValueMapForRecuperarPassword(PASEUsuarioDTO dto) {
//		
//		MultiValueMapKey[] values = filterMultiValueMapKeyByEmpty(
//				new MultiValueMapKey[] {MultiValueMapKey.CODIGO_SITIO, MultiValueMapKey.TOKEN,
//				MultiValueMapKey.EMAIL}, dto);
//		
//		return MultiValueMapFactory.createMultiValueMap(values, dto);
//	}
//	
//
//	
//	private MultiValueMapKey[] filterMultiValueMapKeyByEmpty(MultiValueMapKey[] keys, PASEUsuarioDTO dto) {
//		Set<MultiValueMapKey> result = new HashSet<MultiValueMapKey>();
//		
//		Map<MultiValueMapKey, String> stringData = new HashMap<MultiValueMapKey, String>();
//		
//		stringData.put(MultiValueMapKey.CODIGO_SITIO, dto.getCodigoSitio());
//		stringData.put(MultiValueMapKey.TOKEN, dto.getToken());
//		stringData.put(MultiValueMapKey.APELLIDO, dto.getApellido());
//		stringData.put(MultiValueMapKey.NOMBRE, dto.getNombre());
//		stringData.put(MultiValueMapKey.GENERO, dto.getGenero());
//		stringData.put(MultiValueMapKey.FECHA_NACIMIENTO, dto.getFechaNacimiento());
//		stringData.put(MultiValueMapKey.EMAIL, dto.getEmail());
//		stringData.put(MultiValueMapKey.PALABRA_CLAVE, dto.getPalabraClave());
//		
//		Map<MultiValueMapKey, Long> longData = new HashMap<MultiValueMapKey, Long>();
//		
//		//comento por deprecado con auth0
////		longData.put(MultiValueMapKey.UID, dto.getUid());
////		longData.put(MultiValueMapKey.ID_USUARIO, dto.getUid());
//		
//		for (MultiValueMapKey key : keys) {
//			if (!DataTypeUtil.isEmpty(stringData.get(key)) || !DataTypeUtil.isEmpty(longData.get(key))) {
//				result.add(key);
//			}
//		}
//		
//		return (MultiValueMapKey[]) result.toArray(new MultiValueMapKey[] {});
//	}
}

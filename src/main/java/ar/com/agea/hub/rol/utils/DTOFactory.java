/*
 * @(#)DTOFactory.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.agea.hub.rol.model.dto.AccionSecuenciaDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoComercialNivelDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesDTO;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO;
import ar.com.agea.hub.rol.model.dto.ClaseSearchDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransaccionDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO.Tipo;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoValorizadoDTO;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO;
import ar.com.agea.hub.rol.model.dto.PrimitiveDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.model.dto.ProductoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.UpdateEstadoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioCompuestoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioExternoDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.dto.ValidateVigenciaDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionSearchDTO;

/**
 * Representa un objeto Factory para crear objetos de tipo Data Transfer Object
 * de clases espec�ficas a partir de otros objetos que representan sus par�metros.
 *  
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public final class DTOFactory {
	
	private DTOFactory() {}

	/**
	 * Crea un objeto AccionSecuenciaDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param numero Objeto n�mero.
	 * @param accion Objeto acci�n.
	 * @return Objeto AccionSecuenciaDTO creado.
	 */
	public static AccionSecuenciaDTO createAccionSecuencia(Long numero, String accion) {
		AccionSecuenciaDTO dto = new AccionSecuenciaDTO();
		
		dto.setNumero(numero);
		dto.setAccion(accion);
	
		return dto;
	}
	
	/**
	 * Crea un objeto AgrupadorProductoComercialNivelDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param productoComercial Objeto producto comercial.
	 * @param nivelEstructura Objeto nivel estructura.
	 * @return Objeto AgrupadorProductoComercialNivelDTO creado.
	 */
	public static AgrupadorProductoComercialNivelDTO createAgrupadorProductoComercialNivel(ProductoComercialDTO productoComercial,
			NivelEstructuraDTO nivelEstructura) {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		
		dto.setProductoComercial(productoComercial);
		dto.setNivelEstructura(nivelEstructura);
	
		return dto;
	}
	
	/**
	 * Crea un objeto AgrupadorProductoZonasNivelesDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param producto Objeto producto.
	 * @param zonasComercializacion Objetos zonas comercializaci�n.
	 * @param agrupadoresProductoComercialNivel Objetos agrupadores producto comercial nivel.
	 * @return Objeto AgrupadorProductoZonasNivelesDTO creado.
	 */
	public static AgrupadorProductoZonasNivelesDTO createAgrupadorProductoZonasNiveles(ProductoDTO producto,
			List<ZonaComercializacionDTO> zonasComercializacion, List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel) {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
	
		dto.setProducto(producto);
		dto.setZonasComercializacion(zonasComercializacion);
		dto.setAgrupadoresProductoComercialNivel(agrupadoresProductoComercialNivel);
	
		return dto;
	}
	
	/**
	 * Crea un objeto CalendarioSearchDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param nivelEstructura Objeto nivel estructura.
	 * @param fechaVigencia Objeto fecha vigencia.
	 * @param controlarHorarioCierre Objeto controlar horario cierre.
	 * @param zonasComercializacion Objetos zonas comercializaci�n.
	 * @param idItemPromocion Objeto id �tem promoci�n.
	 * @param codigoCanalEntrada Objeto c�digo canal entrada.
	 * @return Objeto CalendarioSearchDTO creado.
	 */
	public static CalendarioSearchDTO createCalendarioSearch(String nivelEstructura, Date fechaVigencia, Boolean controlarHorarioCierre,
			List<ZonaComercializacionDTO> zonasComercializacion, Long idItemPromocion, String codigoCanalEntrada) {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
	
		dto.setNivelEstructura(nivelEstructura);
		dto.setFechaVigencia(fechaVigencia);
		dto.setControlarHorarioCierre(controlarHorarioCierre);
		
		List<String> codigosZonaComercializacion = new ArrayList<String>(); 
		
		for (ZonaComercializacionDTO zonaComercializacion : zonasComercializacion) {
			codigosZonaComercializacion.add(zonaComercializacion.getCodigo());
		}
		
		dto.setZonasComercializacion(codigosZonaComercializacion);
		dto.setIdItemPromocion(idItemPromocion);
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
	
		return dto;
	}
	
	/**
	 * Crea un objeto CapturadorCRUDDTO a partir de un conjunto de datos que representan sus par�metros.
	 *  
	 * @param apellido Objeto apellido.
	 * @param nombre Objeto nombre.
	 * @param codigoTipoDocumento Objeto c�digo tipo documento.
	 * @param numeroDocumento Objeto n�mero documento.
	 * @param email Objeto email.
	 * @param codigoCliente Objeto c�digo cliente. 
	 * @param codigoAnunciante Objeto c�digo anunciante.
	 * @param codigoTipoAnunciante Objeto c�digo tipo anunciante.
	 * @param codigoCanalEntrada Objeto c�digo canal entrada.
	 * @param codigoTipoIVA Objeto c�digo tipo IVA.
	 * @param codigoMedioPagoPrincipal Objeto c�digo medio pago principal.
	 * @param codigoPASE Objeto c�digo PASE.
	 * @param sexo Objeto sexo.
	 * @param fechaNacimiento Objeto fechaNacimiento.
	 * @return Objeto CapturadorCRUDDTO creado.
	 */
	public static CapturadorCRUDDTO createCapturadorCRUD(String apellido, String nombre, String codigoTipoDocumento, Long numeroDocumento,
			String email, String codigoCliente, Long codigoAnunciante, String codigoTipoAnunciante, String codigoPerfilAnunciante, String codigoCanalEntrada,
			String codigoTipoIVA, String codigoMedioPagoPrincipal, String usuarioExternoCodigo, String sexo, String fechaNacimiento) {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
	
		dto.setApellido(apellido);
		dto.setNombre(nombre);
		dto.setCodigoTipoDocumento(codigoTipoDocumento);
		dto.setNumeroDocumento(numeroDocumento);
		dto.setEmail(email);
		dto.setCodigoCliente(codigoCliente);
		dto.setCodigoAnunciante(codigoAnunciante);
		dto.setCodigoTipoAnunciante(codigoTipoAnunciante);
		dto.setCodigoPerfilAnunciante(codigoPerfilAnunciante);
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		dto.setCodigoTipoIVA(codigoTipoIVA);
		dto.setCodigoMedioPagoPrincipal(codigoMedioPagoPrincipal);
		dto.setUsuarioExternoCodigo(usuarioExternoCodigo);
		dto.setSexo(sexo);
		dto.setFechaNacimiento(fechaNacimiento);
	
		return dto;
	}
	

	/**
	 * Crea un objeto ClaseSerachDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoCanalEntrada
	 * @param codigoClase
	 * @param fechaVigencia
	 * @return Objeto ClaseSearchDTO creado
	 */
	public static ClaseSearchDTO createClaseSearchDTO(String codigoCanalEntrada, String codigoClase, Date fechaVigencia) {
		ClaseSearchDTO dto = new ClaseSearchDTO();
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		dto.setCodigoClase(codigoClase);
		dto.setFechaVigencia(fechaVigencia);
		
		return dto;
	}
	
	/**
	 * Crea un objeto GWPTransaccionDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoAplicacionCliente Objeto c�digo aplicaci�n cliente.
	 * @param idTransaccionCliente Objeto id transacci�n cliente.
	 * @param nombreItem Objeto nombre �tem.
	 * @param fechaInputado Objeto fecha inputado.
	 * @param fechaTransaccion Objeto fecha transacci�n.
	 * @param estado Objeto estado.
	 * @param codigoMetodoPago Objeto c�digo m�todo pago.
	 * @param codigoMedioPago Objeto c�digo medio pago.
	 * @param numeroTarjeta Objeto n�mero tarjeta.
	 * @param codigoMoneda Objeto c�digo moneda.
	 * @param monto Objeto monto.
	 * @param montoPagado Objeto monto pagado.
	 * @param idTransaccionProveedor Objeto id transacci�n proveedor.
	 * @param codigoProveedor Objeto c�digo proveedor.
	 * @param posibleFraude Objeto posible fraude.
	 * @param motivoPosibleFraude Objeto motivo posible fraude.
	 * @param email Objeto email.
	 * @param apellidos Objeto apellidos.
	 * @param nombres Objeto nombres.
	 * @param telefono Objeto tel�fono.
	 * @param descripcionError Objeto descripci�n error.
	 * @return Objeto GWPTransaccionDTO creado.
	 */
	public static GWPTransaccionDTO createGWPTransaccion(String codigoAplicacionCliente, String idTransaccionCliente,
			String nombreItem, Date fechaInputado, Date fechaTransaccion, String estado, String codigoMetodoPago,
			String codigoMedioPago, String numeroTarjeta, String codigoMoneda, Double monto, Double montoPagado,
			String idTransaccionProveedor, String codigoProveedor, Boolean posibleFraude, String motivoPosibleFraude,
			String email, String apellidos, String nombres, String telefono, String descripcionError) {
		GWPTransaccionDTO dto = new GWPTransaccionDTO();
		
		dto.setCodigoAplicacionCliente(codigoAplicacionCliente);
		dto.setIdTransaccionCliente(idTransaccionCliente);
		dto.setNombreItem(nombreItem);
		dto.setFechaImputado(fechaInputado);
		dto.setFechaTransaccion(fechaTransaccion);
		dto.setEstado(estado);
		dto.setCodigoMetodoPago(codigoMetodoPago);
		dto.setCodigoMedioPago(codigoMedioPago);
		dto.setNumeroTarjeta(numeroTarjeta);
		dto.setCodigoMoneda(codigoMoneda);
		dto.setMonto(monto);
		dto.setMontoPagado(montoPagado);
		dto.setIdTransaccionProveedor(idTransaccionProveedor);
		dto.setCodigoProveedor(codigoProveedor);
		dto.setPosibleFraude(posibleFraude);
		dto.setMotivoPosibleFraude(motivoPosibleFraude);
		dto.setEmail(email);
		dto.setApellidos(apellidos);
		dto.setNombres(nombres);
		dto.setTelefono(telefono);
		dto.setDescripcionError(descripcionError);
		
		return dto;
	}
	
	/**
	 * Crea un objeto GWPTransactionDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoMetodoPago Objeto c�digo m�todo pago.
	 * @param codigoMedioPago Objeto c�digo medio pago.
	 * @param monto Objeto monto.
	 * @param nombreItem Objeto nombre �tem. 
	 * @param idTransaccionCliente Objeto id transacci�n cliente. 
	 * @param mail Objeto mail. 
	 * @param apellidos Objeto apellidos. 
	 * @param nombres Objeto nombres. 
	 * @return Objeto GWPTransactionDTO creado.
	 */
	public static GWPTransactionDTO createGWPTransaction(String codigoMetodoPago, String codigoMedioPago, Double monto,
			String nombreItem, String idTransaccionCliente, String mail, String apellidos, String nombres) {
		GWPTransactionDTO dto = new GWPTransactionDTO();
		
		dto.setCodigoMetodoPago(codigoMetodoPago);
		dto.setCodigoMedioPago(codigoMedioPago);
		dto.setMonto(monto);
		dto.setNombreItem(nombreItem);
		dto.setIdTransaccionCliente(idTransaccionCliente);
		dto.setMail(mail);
		dto.setApellidos(apellidos);
		dto.setNombres(nombres);
		
		return dto;
	}
	
	/**
	 * Crea un objeto ImagenDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param contenido Objeto contenido.
	 * @return Objeto ImagenDTO creado.
	 */
	public static ImagenDTO createImagen(String contenido) {
		ImagenDTO dto = new ImagenDTO();

		dto.setTipo(Tipo.IMAGEN);
		dto.setContenido(contenido);
		
		return dto;
	}
	
	/**
	 * Crea un objeto JustificacionDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoProducto Objeto c�digo producto.
	 * @param codigoProductoComercial Objeto c�digo producto comercial. 
	 * @param codigoNivelEstructura Objeto c�digo nivel estructura.
	 * @param codigoTemplateDetallado Objeto c�digo template detallado.
	 * @param ordenamientos Objetos ordenamientos aviso valorizado.
	 * @param textoLibre Objeto texto libre.
	 * @return Objeto JustificacionDTO creado.
	 */
	public static JustificacionDTO createJustificacion(String codigoProducto,
			String codigoProductoComercial, String codigoNivelEstructura, String codigoTemplateDetallado,
			List<OrdenamientoAvisoValorizadoDTO> ordenamientos, String textoLibre, String nombreImagen, String nombreLibreriaImagen, ImagenDTO material) {
		JustificacionDTO dto = new JustificacionDTO();

		dto.setCodigoProducto(codigoProducto);
		dto.setCodigoProductoComercial(codigoProductoComercial);
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		dto.setCodigoTemplateDetallado(codigoTemplateDetallado);
		dto.setOrdenamientos(ordenamientos);
		dto.setTextoLibre(textoLibre);
		dto.setNombreImagen(nombreImagen);
		dto.setNombreLibreriaImagen(nombreLibreriaImagen);
		dto.setMaterial(material);
		
		return dto;
	}
	
	/**
	 * Crea un objeto NivelEstructuraSearchDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoCanalEntrada Objeto c�digo canal entrada. 
	 * @param codigoClase Objeto c�digo clase.
	 * @param codigoProducto Objeto c�digo Producto.
	 * @param codigoTipoOperacion Objeto c�digo tipo operaci�n.
	 * @param fechaVigencia Objeto fecha vigencia.
	 * @return Objeto NivelEstructuraSearchDTO creado.
	 */
	public static NivelEstructuraSearchDTO createNivelEstructuraSearch(String codigoCanalEntrada,
			String codigoClase, String codigoProducto, String codigoTipoOperacion, Date fechaVigencia) {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		dto.setCodigoClase(codigoClase);
		dto.setCodigoProducto(codigoProducto);
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		dto.setFechaVigencia(fechaVigencia);
		
		return dto;
	}
	
	/**
	 * Crea un objeto PASEUsuarioDTO a partir de un conjunto de datos que representan sus par�metros.
	 *  
	 * @param uid Objeto uid.
	 * @param apellido Objeto apellido.
	 * @param nombre Objeto nombre.
	 * @param genero Objeto g�nero. 
	 * @param fechaNacimiento Objeto fecha nacimiento. 
	 * @param email Objeto email.
	 * @param palabraClave Objeto palabra clave.
	 * @return Objeto CapturadorCRUDDTO creado.
	 */
	public static PASEUsuarioDTO createPASEUsuario(String uid, String apellido, String nombre, String genero,
			String fechaNacimiento, String email, String palabraClave) {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();

		dto.setUid(uid);
		dto.setApellido(apellido);
		dto.setNombre(nombre);
		dto.setGenero(genero);
		dto.setFechaNacimiento(fechaNacimiento);
		dto.setEmail(email);
		dto.setPalabraClave(palabraClave);
	
		return dto;
	}
	
	/**
	 * Crea un objeto PrimitiveDTO a partir de una pareja de dato que representa su par�metro-valor.
	 * 
	 * @param nombreCampo Objeto nombre campo.
	 * @param primitivo Objeto primitivo.
	 * @return Objeto PrimitiveDTO creado.
	 */
	public static <T extends Object> PrimitiveDTO<T> createPrimitiveDTO(String nombreCampo, T primitivo){
		PrimitiveDTO<T> dto = new PrimitiveDTO<T>(nombreCampo, primitivo);
		
		return dto;
	}
	
	/**
	 * Crea un objeto ProductoComercialDefaultDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoTipoAviso Objeto c�digo tipo aviso.
	 * @param codigoCanalEntrada Objeto c�digo canal entrada.
	 * @param codigoTipoOperacion Objeto c�digo tipo operaci�n.
	 * @param codigoNivelEstructura Objeto c�digo nivel estructura.
	 * @return Objeto ProductoComercialDefaultDTO creado.
	 */
	public static ProductoComercialDefaultDTO createProductoComercialDefault(String codigoAgrupamientoProductoTecnico,
			String codigoCanalEntrada, String codigoTipoOperacion, String codigoNivelEstructura) {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		return dto;
	}
	
	/**
	 * Crea un objeto ProductoSearchDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoCanalEntrada Objeto c�digo canal entrada. 
	 * @param codigoClase Objeto c�digo clase.
	 * @param codigoTipoOperacion Objeto c�digo tipo operaci�n.
	 * @param fechaVigencia Objeto fecha vigencia.
	 * @return Objeto ProductoSearchDTO creado.
	 */
	public static ProductoSearchDTO createProductoSearch(String codigoCanalEntrada,
			String codigoClase, String codigoTipoOperacion, Date fechaVigencia) {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		dto.setCodigoClase(codigoClase);
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		dto.setFechaVigencia(fechaVigencia);
		
		return dto;
	}
	
	/**
	 * Crea un objeto PropiedadDefaultSearchDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigosPropiedadDefault Objeto c�digos propiedad default.
	 * @return Objeto PropiedadDefaultSearchDTO creado.
	 */
	public static PropiedadDefaultSearchDTO createPropiedadDefaultSearch(List<String> codigosPropiedadDefault) {
		PropiedadDefaultSearchDTO dto = new PropiedadDefaultSearchDTO();
		
		dto.setCodigosPropiedadDefault(codigosPropiedadDefault);
		
		return dto;
	}
	
	/**
	 * Crea un objeto UpdateEstadoAvisoDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param idAviso Objeto id aviso.
	 * @param accion Objeto acci�n.
	 * @param motivoRechazo Objeto motivo rechazo.
	 * @param observacion Objeto observaci�n.
	 * @return Objeto UpdateEstadoAvisoDTO creado.
	 */
	public static UpdateEstadoAvisoDTO createUpdateEstadoAviso(Long idAviso, String accion, String motivoRechazo, String observacion) {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		
		dto.setIdAviso(idAviso);
		dto.setAccion(accion);
		dto.setMotivoRechazo(motivoRechazo);
		dto.setObservacion(observacion);
		
		return dto;
	}
	
	/**
	 * Crea un objeto UsuarioCompuestoDTO a partir de un conjunto de datos que representan sus par�metros.
	 *  
	 * @param paseCookie Objeto PASE cookie.
	 * @param paseUsuario Objeto PASE usuario.
	 * @param capturador Objeto capturador.
	 * @return Objeto UsuarioCompuestoDTO creado.
	 */
	public static UsuarioCompuestoDTO createUsuarioCompuesto(PASEUsuarioDTO paseUsuario, CapturadorDTO capturador) {
		UsuarioCompuestoDTO dto = new UsuarioCompuestoDTO();
	
		dto.setPASEUsuario(paseUsuario);
		dto.setCapturador(capturador);
	
		return dto;
	}
	
	/**
	 * Crea un objeto UsuarioExternoDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigo Objecto c�digo.
	 * @param codigoSistema Objeto c�digo sistema.
	 * @return Objeto UsuarioExternoDTO creado.
	 */
	public static UsuarioExternoDTO createUsuarioExterno(String codigo, String codigoSistema) {
		UsuarioExternoDTO dto = new UsuarioExternoDTO();
		
		dto.setCodigo(codigo);
		dto.setCodigoSistema(codigoSistema);
		
		return dto;
	}
	
	/**
	 * Crea un objeto ValidarPromocionesDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param ordenPublicacion Objeto orden publicaci�n.
	 * @param promocionesAplicables Objetos promociones.
	 * @return Objeto ValidarPromocionesDTO creado.
	 */
	public static ValidarPromocionesDTO createValidarPromociones(OrdenPublicacionDTO ordenPublicacion, List<PromocionDTO> promocionesAplicables) {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		
		dto.setOrdenPublicacion(ordenPublicacion);
		dto.setPromocionesAplicables(promocionesAplicables);

		return dto;
	}
	
	/**
	 * Crea un objeto ValidacionVigenciaDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoNivelEstructura
	 * @param codigoProducto
	 * @param codigoProductoComercial
	 * @return Objeto ValidacionVigenciaDTO creado
	 */
	public static ValidateVigenciaDTO createValidateVigencia(String codigoProductoComercial, String codigoNivelEstructura, String codigoProducto) {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		dto.setCodigoProducto(codigoProducto);
		
		return dto;
	}
	
	/**	
	 * Crea un objeto ZonaComercializacionSearchDTO a partir de un conjunto de datos que representan sus par�metros.
	 * 
	 * @param codigoProducto Objeto c�digo Producto.
	 * @param fechaVigencia Objeto fecha vigencia.
	 * @return Objeto ZonaComercializacionSearchDTO creado.
	 */
	public static ZonaComercializacionSearchDTO createZonaComercializacionSearch(String codigoProducto,
			Date fechaVigencia) {
		ZonaComercializacionSearchDTO dto = new ZonaComercializacionSearchDTO();
		
		dto.setCodigoProducto(codigoProducto);
		dto.setFechaVigencia(fechaVigencia);

		return dto;
	}
}

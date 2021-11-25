package ar.com.agea.hub.rol.utils;

/**
 * Identifica la clave de datos MultiValueMap.
 * 
 * @author      Eduardo Barrera
 * @version		1.0 10/10/2013
 */
public enum MultiValueMapKey {

	// Usados por sistema GWP.
	CODIGO_APLICACION_CLIENTE("codigoAplicacionCliente"),
	LLAVE_APLICACION_CLIENTE("llaveAplicacionCliente"),
	CODIGO_METODO_PAGO("codigoMetodoPago"),
	CODIGO_MEDIO_PAGO("codigoMedioPago"),
	MONTO("monto"),
	NOMBRE_ITEM("nombreItem"),
	CODIGO_MONEDA("codigoMoneda"),
	TIPO_TRANSACCION("tipoTransaccion"),
	ID_TRANSACCION_CLIENTE("idTransaccionCliente"),
	FECHA_VENCIMIENTO("fechaVencimiento"),
	CANTIDAD_CUOTAS("cantidadCuotas"),
	NUMERO_CLIENTE("numeroCliente"),
	NUMERO_FACTURA("numeroFactura"),
	MAIL("mail"), // Una lástima que no se llame mail, pero debe llamarse así GWP puede utilizar su valor.
	APELLIDOS("apellidos"),
	NOMBRES("nombres"),
	TELEFONO("telefono"),
	URL_IMAGEN("urlImagen"),
	URL_EXITO("urlExito"),
	URL_FRACASO("urlFracaso"),
	
	// Usados por sistema PASE.
	CODIGO_SITIO("codigoSitio"),
	TOKEN("token"),
	UID("uid"),
	ID_USUARIO("idUsuario"),
	APELLIDO("apellido"),
	NOMBRE("nombre"),
	GENERO("genero"),
	FECHA_NACIMIENTO("fechaNacimiento"),
	EMAIL("email"), // Usado por PASE.
	PALABRA_CLAVE("palabraClave");

	private String name;
		
	private MultiValueMapKey(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre de la clave representado por su nombre.
	 * 
	 * @return Clave relacionada.
	 */
	public String getName() {
		return name;
	}
}

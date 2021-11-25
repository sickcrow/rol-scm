/**
 * author: jlichowski
 * version: 1.0.0
 * require: handlebars.js | data-utils.js
 * description: Clase placeholder para Templates y Helpers de componentes UI.
 * additional: Copia descarada del crear-aviso-templates.js
 */
DecoratorTemplates = {};

/*********************************************************
 * Templates
 *********************************************************/
/**
 * idPopUp   : Para identificarlo y utilizarlo luego
 * titulo    : Titulo del popup
 * mensaje   : Cuerpo del popup
 * txtBoton1 : Que contendra el boton 1 (Cancelar, No)
 * txtBoton2 : Que contendra el boton 2 (Guardar, Aceptar, Si, etc)
 */
DecoratorTemplates.modalPopUpWindow = [
    "<div id='{{idPopUp}}' class='modal fade {{classTipoMensaje}}' data-toggle='modal' >",
    	"<div class='modal-dialog'>",
	    	"<div class='modal-header'>",
	    		"<a class='close' data-dismiss='modal' title='Cerrar'>&nbsp;</a>",
	    		"<h3 id='titVentana'>{{titulo}}</h3>",
	    	"</div>",
		    "<div class='modal-body'>",
		    	"<p>{{mensaje}}</p>",
		    "</div>",
		    "<div class='modal-footer'>",
		    	"<div class='btn {{classBoton1}}' onClick='{{funcionBoton1}}'>{{txtBoton1}}</div>",
		    	"<div class='btn btn-primary {{classBoton2}}' onclick='{{funcionBoton2}}'>{{txtBoton2}}</div>",
		    "</div>",
	    "</div>",
    "</div>"
].join("\n");

/**
 * idPopUp   : Para identificarlo y utilizarlo luego
 * titulo    : Titulo del popup
 * mensaje   : Cuerpo del popup
 * txtBoton1 : Que contendra el boton 1 (Cancelar, No)
 * txtBoton2 : Que contendra el boton 2 (Guardar, Aceptar, Si, etc)
 */
DecoratorTemplates.modalPopUpWindowSinCerrar = [
    "<div id='{{idPopUp}}' class='modal fade {{classTipoMensaje}}' data-toggle='modal' >",
    	"<div class='modal-dialog'>",
	    	"<div class='modal-header'>",
	    		"<h3 id='titVentana'>{{titulo}}</h3>",
	    	"</div>",
		    "<div class='modal-body'>",
		    	"<p>{{mensaje}}</p>",
		    "</div>",
		    "<div class='modal-footer'>",
		    	"<div class='btn btn-primary {{classBoton1}}' onclick='{{funcionBoton1}}'>{{txtBoton1}}</div>",
		    	"<div class='btn btn-primary {{classBoton2}}' onclick='{{funcionBoton2}}'>{{txtBoton2}}</div>",
		    "</div>",
	    "</div>",
    "</div>"
].join("\n");

DecoratorTemplates.selectorTarjetas = [
 	"<ul>",
 		"<li id='liTarjetas'><h3>tarjeta de Cr&eacute;dito</h3>",
 			"<ul class='subListaTarjetas'>",
 			 "{{#each tarjetasPago}}",
 			 	"<li><input type='radio' name='tipoTarjeta' id='{{codigoGATEWAY}}' value={{descripcion}} ><label class='' for={{codigoGATEWAY}} title={{descripcion}}><span class='imgTarjeta'><img src='..{{rutaImagenTC}}' alt='{{descripcion}}' title='{{descripcion}}'></span>{{descripcion}}</label></li>",
 			 "{{/each}}",
 			"</ul>",
 		"</li>",
 		"<li class='hidden'><input class='css-radio' type='radio' name='tipoPagoCheck' id='pagoConPagoFacil'><label class='css-label-radio' for='pagoConPagoFacil'>Pago F&aacute;cil / RapiPago</label></li>",
 	"</ul>"
].join("\n");

DecoratorTemplates.textoTerminosYCondiciones = [
	"<p>Por medio del presente se describen los t&eacute;rminos y condiciones generales de uso y contrataci&oacute;n (en adelante, los \"T&eacute;rminos y Condiciones de Uso\"), del servicio de publicaci&oacute;n denominado ROL -Receptoria On Line- (en adelante, el Servicio), mediante el cual se ofrece la publicidad de avisos en papel del suplemento \"Clasificados\" del diario Clar&iacute;n, en los rubros autos, inmuebles y empleos (en adelante, los Avisos), a trav&eacute;s de sitios Web <a href='http://www.clasificados.clarin.com'>www.clasificados.clarin.com</a> o <a href='http://receptoriaonline.clarin.com'>receptoriaonline.clarin.com</a> (en adelante, el Sitio), de  titularidad de ARTE GR&Aacute;FICO EDITORIAL ARGENTINO S. A. (en adelante, AGEA), CUIT 30500124152, con domicilio legal en la calle Piedras 1743 de la Ciudad Aut&oacute;noma de Buenos Aires. En consecuencia, los interesados en utilizar este Servicio deber&aacute;n registrarse previamente en el Sitio y cumplir con las presentes condiciones.</p>",
	"<h4>a) Introducci&oacute;n:</h4>",
	"<ol>",
		"<li>Toda persona que este interesada en utilizar el Servicio para publicar los Avisos clasificados a trav&eacute;s del Sitio (en adelante, el Usuario), deber&aacute; previamente registrarse conforme a las condicione aqu&iacute; previstas, y aceptar sin condicionamientos, todos y cada uno de los presentes T&eacute;rminos y Condiciones de Uso, como as&iacute; tambi&eacute;n sus modificaciones, documentos complementarios, etc. y se obliga a cumplirlos sin objeci&oacute;n alguna. En consecuencia, si el Usuario no est&aacute; de acuerdo con alguno de los T&eacute;rminos y Condiciones de Uso, no deber&aacute; utilizar el Servicio ni el Sitio para la publicaci&oacute;n de los Avisos. Se deja expresamente aclarado que los presentes T&eacute;rminos y Condiciones de Uso tienen car&aacute;cter obligatorio y vinculante.</li>",
		"<li>AGEA se reserva el derecho, a su sola discreci&oacute;n, de modificar, alterar o de otra manera actualizar, estos T&eacute;rminos y Condiciones de Uso en cualquier momento. Las modificaciones entrar&aacute;n en vigencia desde el momento que se indique y/o en su defecto, se entender&aacute; que su aplicaci&oacute;n es inmediata. Por lo que usando el Usuario este Sitio, despu&eacute;s de dichas modificaciones, acepta estar sujeto a dichos cambios, alteraciones y/o actualizaciones, de los T&eacute;rminos y Condiciones de Uso, sin derecho el Usuario a efectuar reclamo alguno con relaci&oacute;n a ello.</li>",
		"<li>Se deja aclarado que ciertos contenidos accedidos a trav&eacute;s del Sitio pueden estar alcanzados por normas espec&iacute;ficas que reglamenten y complementen a los presentes T&eacute;rminos y Condiciones de Uso, raz&oacute;n por la cual se recomienda al Usuario tomar conocimiento espec&iacute;fico de ellas.</li>",
		"<li>AGEA se reserva el derecho a denegar o retirar el acceso al Sitio y/o a prestar el  Servicio, sin necesidad de preaviso alguno, a aquellos Usuarios que incumplan los presentes T&eacute;rminos y Condiciones de Uso, sin obligaci&oacute;n de AGEA de abonar suma alguna, por ninguna &iacute;ndole ni concepto, en virtud y/o con causa en lo anterior. </li>",
	"</ol>",
	"<h4>b) Condiciones de acceso y registraci&oacute;n al Sitio</h4>",
	"<ol>",
		"<li>Para tener acceso y contratar el Servicio, el Usuario deber&aacute; obligatoriamente inscribirse y registrase en el Sitio, conforme se establece en la presente cl&aacute;usula.</li>",
		"<li>A tales efectos, el Usuario deber&aacute; hacer click en la opción \"Ingresar\", luego en \"Registrate\", indicando una direcci&oacute;n de correo electr&oacute;nico y una contrase&ntilde;a. Tambi&eacute;n deber&aacute; completar el Formulario de Registraci&oacute;n con su informaci&oacute;n personal. Dichos datos tendr&aacute;n car&aacute;cter de declaraci&oacute;n jurada.</li>",
		"<li>El Usuario se compromete a seleccionar, usar y conservar su contrase&ntilde;a de forma diligente, y a mantener la misma en secreto y en protecci&oacute;n, respecto de terceros.</li>",
		"<li>Una vez registrado, el Usuario recibir&aacute; un e-mail del Sitio, de a fin de confirmar la Cuenta y Activar su acceso al mismo, de acuerdo a las indicaciones que se establecer&aacute;n en el  cuerpo de dicho e-mail.</li>",
		"<li>El Usuario podr&aacute; modificar cuando lo desee sus datos de registraci&oacute;n, a excepci&oacute;n del e-mail, clickeando sobre el link de su nombre.</li>",
		"<li>El Usuario podr&aacute; en todo momento acceder al listado de Avisos publicados a trav&eacute;s de la solapa �Mis Avisos�, dispuesta en el Sitio.</li>",
	"</ol>",
	"<h4>c) Carga y generaci&oacute;n de los Avisos</h4>",
	"<ol>",
		"<li>Todo Usuario deber&aacute; generar un Aviso ingresando a la p&aacute;gina principal del Sitio y a la bandeja \"Mis avisos\", y posteriormente cumpliendo los siguientes cinco (5) pasos: a) Se deber&aacute; seleccionar la familia (automotores, empleos, inmuebles), el tipo de bien (ejemplo: auto, camioneta) y la operaci&oacute;n (ejemplo: venta) en la cual desea publicar su aviso; b) Se deber&aacute; seleccionar el medio y el rubro en el cual desea publicar su aviso; c) Se deber&aacute; seleccionar la fecha de publicaci&oacute;n de su aviso; d) De acuerdo a la familia seleccionada, deber&aacute; ingresar informaci&oacute;n adicional (ejemplo: para la familia automotores, se ingresar&aacute; marca y modelo), ingresando el texto del aviso; e) Cotizar el aviso, y acto seguido, el Sitio mostrar&aacute; todos los datos ingresados por el Usuario para la generaci&oacute;n del Aviso, por lo que se le solicitar&aacute; su confirmaci&oacute;n, para luego conectarse directamente con \"Decidir\" para efectuar el pago mediante los medios habilitados.",
		"<li>Se deja expresamente aclarado que el Servicio del Sitio es con cargo, y que la  tarifa de los Avisos, estar&aacute;n condicionadas conforme la cantidad de l&iacute;neas y el d&iacute;a de publicaci&oacute;n. Sin perjuicio de ello, antes del ingreso del Aviso los Usuarios podr&aacute;n calcular la tarifa/precio del mismo, a trav&eacute;s de la opci&oacute;n �previsualizar y cotizar aviso�, a fin de tomar conocimiento del tarifario publicado por AGEA, el cual estar&aacute; sujeto a cambios.</li>",
		"<li>El precio de los Servicios podr&aacute;n ser cancelados a trav&eacute;s de las siguientes tarjetas de cr&eacute;dito: (a) Visa, (b) Masterdcard, (c) American Express, y (d) Tarjeta Naranja. Una vez realizado el pago con cualquiera de las tarjetas de cr&eacute;dito habilitadas, \"Decidir\" enviar&aacute; al Usuario un e-mail a la direcci&oacute;n de correo electr&oacute;nica, denunciada por aquel, informando la operaci&oacute;n realizada a trav&eacute;s de su cuenta en el Sitio. Asimismo, el Usuario podr&aacute; consultar el estado de su pago desde la bandeja \"Mis Avisos\" del Sitio. Finalmente, la factura del pago ser&aacute; enviada al Usuario por e-mail a la direcci&oacute;n de e-mail determinada por el Usuario.</li>",
		"<li>Los Avisos deber&aacute;n ser ingresados al Sitio por los Usuarios antes del horario de cierre de la fecha de publicaci&oacute;n del suplemento Clasificados correspondiente, el cual puede tener cambios a criterio de AGEA.</li>",
	"</ol>",
	"<h4>d) Uso del Servicio</h4>",
	"<ol>",
		"<li>El Usuario se comprometen a utilizar el Sitio y el Servicio de conformidad con la ley, la moral, el orden p&uacute;blico, los presentes T&eacute;rminos y Condiciones de Uso, en su caso, le sean de aplicaci&oacute;n, y bajo su exclusivo riesgo y responsabilidad. Asimismo, se compromete hacer un uso adecuado del Servicio del Sitio y a no emplearlos para realizar actividades il&iacute;citas o constitutivas de delito, que atenten contra los derechos de terceros y/o que infrinjan la regulaci&oacute;n sobre propiedad intelectual e industrial, o cualesquiera otras normas del ordenamiento jur&iacute;dico aplicable.</li>",
		"<li>Asimismo, de corresponder, el Usuario tendr&aacute; a su cargo el dise&ntilde;o, compaginaci&oacute;n, edici&oacute;n y producci&oacute;n de los Avisos, de forma tal que deber&aacute; entregar los mismos confeccionados y listos para su publicaci&oacute;n en el suplemento correspondiente.</li>",
		"<li>En particular, los Usuarios se comprometen a no trasmitir, introducir, difundir y poner a disposici&oacute;n de terceros, cualquier tipo de material e informaci&oacute;n (datos contenidos, mensajes, dibujos, archivos de sonido e imagen, fotograf&iacute;as, software, etc.) que sean contrarios a la ley, la moral, el orden p&uacute;blico, los presentes T&eacute;rminos y Condiciones de Uso y, en su caso, a las Condiciones Particulares que le sean de aplicaci&oacute;n.</li>",
		"<li>A t&iacute;tulo enunciativo, y en ning&uacute;n caso limitativo o excluyente, los Usuarios se comprometen a:",
			"<ul>",
				"<li>No ingresar o difundir contenidos o propaganda de car&aacute;cter racista, xen&oacute;fobo, pornogr&aacute;fico, de apolog&iacute;a del terrorismo o que atenten contra los derechos humanos.</li>",
				"<li>No ingresar o difundir en la red programas de datos (virus y software nocivo) susceptibles de provocar da&ntilde;os en los sistemas inform&aacute;ticos del proveedor de acceso, sus proveedores o terceros usuarios de la red Internet.</li>",
				"<li>No ingresar, difundir, transmitir o poner a disposici&oacute;n de terceros cualquier tipo de informaci&oacute;n, elemento o contenido que constituya publicidad il&iacute;cita o desleal.</li>",
				"<li>No transmitir publicidad no solicitada o no autorizada, material publicitario, \"correo basura\", \"cartas en cadena\", \"estructuras piramidales\", o cualquier otra forma de solicitaci&oacute;n, excepto en aquellas &aacute;reas (tales como espacios comerciales) que hayan sido exclusivamente concebidas para ello.</li>",
				"<li>No ingresar o difundir cualquier informaci&oacute;n y contenidos falsos, ambiguos, extempor&aacute;neos o inexactos de forma que induzca a error a los receptores de la informaci&oacute;n.</li>",
				"<li>No suplantar a otros Usuarios utilizando sus claves de registro a los distintos Servicios del Sitio.</li>",
				"<li>No introducir o difundir contenidos que sean contrarios al honor, a la intimidad personal y familiar o a la propia imagen de las personas.</li>",
				"<li>No ingresar, difundir, transmitir o poner a disposici&oacute;n de terceros cualquier tipo de informaci&oacute;n, elemento o contenido que suponga una violaci&oacute;n de los derechos de propiedad intelectual e industrial, patentes, marcas o copyright que correspondan a los titulares del Sitio o a terceros.</li>",
				"<li>No ingresar, difundir, transmitir o poner a disposici&oacute;n de terceros cualquier tipo de informaci&oacute;n, elemento o contenido que suponga una violaci&oacute;n del secreto de las comunicaciones y la legislaci&oacute;n de datos de car&aacute;cter personal.</li>",
				"<li>Usar cualquier mecanismo, software o rutina para impedir o intentar impedir el adecuado funcionamiento de este Sitio o cualquier actividad que se est&aacute; realizando en este Sitio. </li>",
				"<li>No realizar cualquier acci&oacute;n que imponga una carga desproporcionada o desmesurada sobre la infraestructura de este Sitio.</li>",
				"<li>No revelar o compartir su contrase&ntilde;a con terceras personas o usar su contrase&ntilde;a para cualquier prop&oacute;sito no autorizado.</li>",
				"<li>No intentar descifrar, descompilar u obtener el c&oacute;digo fuente de cualquier programa de software que comprenda o constituya una parte de este Sitio.</li>",
			"</ul></li>",
	"</ol>",
	"<h4>e) Publicaci&oacute;n de los Avisos</h4>",
	"<ol>",
		"<li>La publicaci&oacute;n de los Avisos en el suplemento Clasificados del diario Clar&iacute;n estar&aacute; siempre supeditada y condicionada a la disponibilidad del espacio correspondiente. En consecuencia, el pedido de publicaci&oacute;n y carga del Aviso por parte del Usuario, no implica la publicaci&oacute;n del Aviso. Lo anterior por cuanto la publicaci&oacute;n de todo Aviso est&aacute; sujeta a disponibilidad de espacio, ubicaci&oacute;n y a las eventuales modificaciones de &uacute;ltimo momento que pueda sufrir la diagramaci&oacute;n de los Avisos del diario sobre el cierre de cada edici&oacute;n, a exclusivo criterio de AGEA y sin que ello otorgue derecho a reclamo o indemnizaci&oacute;n alguna. </li>",
		"<li>Consecuentemente, la no publicaci&oacute;n de Avisos por las razones estipuladas en los presentes T&eacute;rminos y Condiciones y/o sus normas complementarias, no genera responsabilidad alguna para AGEA ni tampoco derecho a reclamo alguno por parte de los Usuarios, para lo cual se reprogramar&aacute; con el Usuario la nueva fecha de publicaci&oacute;n. </li>",
		"<li>AGEA no asume responsabilidad alguna con relaci&oacute;n a los Avisos y su contenido, siendo los mismos exclusiva responsabilidad de los Usuarios.</li>",
		"<li>En el caso de dudas o reclamos sobre los Avisos, los Usuarios deber&aacute;n contactarse con el Centro de Atenci&oacute;n al Cliente (CEAC) de AGEA al email <a href='mailto:ceac@agea.com.ar'>ceac@agea.com.ar</a>. A tales efectos, el CEAC solicitar&aacute; a los Usuarios los datos con los cuales se registro el Usuario al ROL, tales como nombre y apellido, y tipo y n&uacute;mero de documento.</li>",
	"</ol>",
	"<h4>f) Responsabilidad por el contenido de los Avisos</h4>",
	"<ol>",
		"<li>Los Usuarios ser&aacute;n &uacute;nico y exclusivo responsable del contenido de los Avisos y mantendr&aacute; libre e indemne al Sito y/o AGEA, por todo expediente administrativo y/o judicial que se inicie con motivo de los mismos. AGEA solo revisar&aacute; la calidad t&eacute;cnica de los Avisos, de forma tal que AGEA queda expresamente facultada para desestimar los que considere inadecuados para la publicaci&oacute;n en el suplemento \"Clasificados\" del Diario Clar&iacute;n, los que deber&aacute;n ser reemplazados por los Usuarios dentro de las 24 horas de comunicado su rechazo.</li>",
		"<li>Al registrarse y/o navegar el Sitio, el Usuario brinda informaci&oacute;n personal, prestando su consentimiento para que la misma sea almacenada directamente en la base de datos de AGEA, encontr&aacute;ndose protegida electr&oacute;nicamente, utilizando los mecanismos de seguridad inform&aacute;tica de protecci&oacute;n de la informaci&oacute;n m&aacute;s completos y eficaces para mantenerla en total confidencialidad, conforme a la Ley N&deg; 25.326 de H&aacute;beas Data, no obstante lo cual, los Usuarios pueden acceder a esta informaci&oacute;n y solicitar su eliminaci&oacute;n o modificaci&oacute;n en la direcci&oacute;n Nacional de Protecci&oacute;n de Datos Personales sita en Sarmiento 1118 piso 5to de la Ciudad Aut&oacute;noma de Buenos Aires Tel. 4383-8510/12/13/15; <a href='http://www.jus.gov.ar/datospersonales'>www.jus.gov.ar/datospersonales</a> - <a href='mailto:infodnpdpa@jus.gov.ar'>infodnpdpa@jus.gov.ar</a>, la referida Direcci&oacute;n es el &oacute;rgano de control de la Ley N&deg; 25.326.</li>",
		"<li>Los Usuarios son responsables por el buen uso del Sitio y/o del Servicio, comprometi&eacute;ndose expresamente a evitar cualquier tipo de acci&oacute;n que pueda da&ntilde;ar a sistemas, equipos o servicios accesibles, directa o indirectamente a trav&eacute;s de Internet, incluyendo la congesti&oacute;n intencional de enlaces o sistemas y de acuerdo a las presentes condiciones.</li>",
		"<li>Se deja expresamente aclarado que el Sitio y/o la contrataci&oacute;n de los Servicios solo podr&aacute; ser utilizado &uacute;nica y exclusivamente por personas mayores de 18 a&ntilde;os, debiendo abstenerse de utilizarlo las personas que no sean mayores de dicha edad. </li>",
		"<li>Toda la informaci&oacute;n publicada y/u ofrecida por los Avisos en el suplemento �Clasificados� del Diario Clar&iacute;n es proporcionada por el Usuario, siendo responsabilidad exclusiva de los mismos dicha informaci&oacute;n como as&iacute; tambi&eacute;n lo referente a su comercializaci&oacute;n. AGEA no es responsable por la publicaci&oacute;n, veracidad y exactitud de la informaci&oacute;n que en los Avisos publicados en el suplemento de �Clasificados� del Diario Clar&iacute;n se provea, ni de los cambios que sobre los mismos pudieran acontecer.</li>",
		"<li>Los Usuarios son responsables por el buen uso del Servicio, comprometi&eacute;ndose expresamente a evitar cualquier tipo de acci&oacute;n, que pueda da&ntilde;ar a sistemas, equipos o servicios accesibles directos o indirectamente a trav&eacute;s de Internet, incluyendo la congesti&oacute;n intencional de enlaces o sistemas y de acuerdo a las presentes condiciones.</li>",
		"<li>Los Usuarios asumen plena responsabilidad frente al Sitio y a terceros por da&ntilde;os y perjuicios que se produjeran como consecuencia del accionar propio, de sus dependientes o de terceros y los que resulten de la inobservancia de las leyes o reglamentaciones de otros hechos il&iacute;citos o del mal uso que se haga del servicio, debiendo los Usuarios indemnizar y mantener indemne al Sitio ante cualquier reclamo de pago que pudiera corresponder.</li>",
		"<li> AGEA tendr&aacute; el derecho de ampliar o mejorar el Servicio en el Sitio prestado sin necesidad de comunicaci&oacute;n previa, as&iacute; como de alterar los medios o rutas utilizados para la prestaci&oacute;n del Servicio.</li>",
		"<li>La falta de ejercicio temporario por parte de AGEA de los derechos que los presentes les confiere, no implicar&aacute;n una renuncia a los mismos, los cuales podr&aacute;n ser ejercidos en todo momento.</li>",
		"<li>AGEA no ser&aacute; responsable de la satisfacer ni cumplir con las necesidades y requerimientos del Usuario, limit&aacute;ndose solo a otorgar un espacio para la publicaci&oacute;n de un Aviso.</li>",
		"<li>AGEA no ser&aacute; responsable por los da&ntilde;os, alteraci&oacute;n de informaci&oacute;n o interferencias al sistema o a las redes, producto del accionar de terceros.</li>",
		"<li>AGEA no ser&aacute; responsable por el resultado del Servicio en tanto las instalaciones necesarias para su buen funcionamiento dependan de terceros. Esto incluye, pero no limita a, errores de encaminamiento, p&eacute;rdida de informaci&oacute;n o datos, interrupciones del Servicio no planificadas que no sean atribuibles al Sitio.</li>",
		"<li>AGEA no ser&aacute; responsable de la calidad, exactitud, fiabilidad, correcci&oacute;n y utilidad de los datos, programas e informaci&oacute;n de cualquier tipo que se transmitan por sus redes.</li>",
		"<li>AGEA no ser&aacute; responsable por el mal uso de las facilidades y Servicio prestado, debidos a cortes de energ&iacute;a o interrupciones programadas o cualquier otra falla que no se atribuible a culpa grave o dolo del Sitio.</li>",
		"<li>AGEA no ser&aacute; responsable por los da&ntilde;os y perjuicios causados, incluyendo caso fortuito y fuerza mayor, que se produjeran a los equipos, instalaciones o personal de los Usuarios. </li>",
		"<li>Los productos, bienes, autom&oacute;viles y/o Servicios ofrecidos y/o publicados en los Avisos no se encuentran garantizados por el Sitio ni por AGEA, asumiendo quienes los publican y/o proveen toda la responsabilidad respecto a la calidad, los vicios redhibitorios, evicci&oacute;n y/o cualquier p&eacute;rdida o da&ntilde;o que pudiera sufrirse con relaci&oacute;n a las contrataciones formalizadas sobre los mismos por los Usuarios.</li>",
	"</ol>",
	"<h4>g) Declaraciones:</h4>",
	"<ol>",
		"<li>Los Usuarios expresamente comprenden, aceptan y est&aacute;n de acuerdo en que:",
			"<ul>",
				"<li>El Sitio puede contener errores;</li>",
				"<li>AGEA no ser&aacute;n responsables por ning&uacute;n da&ntilde;o o perjuicio, directo o indirecto, incluyendo, sin ning&uacute;n tipo de limitaci&oacute;n, da&ntilde;os producidos por la p&eacute;rdida y/o deterioro de informaci&oacute;n y/o por el uso del Sitio;</li>",
				"<li>La utilizaci&oacute;n del Sitio y de Internet en general implica la asunci&oacute;n de riesgos de potenciales da&ntilde;os al software y al hardware del Usuario. Por tal motivo, el equipo terminal desde el cual los Usuarios acceden al Sitio estar&aacute; en condiciones de resultar atacado y da&ntilde;ado por la acci&oacute;n de hackers quienes podr&iacute;an incluso acceder a la informaci&oacute;n contenida en el equipo terminal de los Usuarios, extraerla, sustraerla y/o da&ntilde;arla. Los Usuario renuncian a efectuar reclamos por estos motivos.</li>",
				"<li>El intercambio de informaci&oacute;n a trav&eacute;s de Internet tiene el riesgo de que tal informaci&oacute;n pueda ser captada por un tercero. El Sitio no se hace responsable de las consecuencias que pudiera acarrear a los Usuarios en tal hip&oacute;tesis. </li>",
				"<li>El Sitio no guarda obligaci&oacute;n alguna de conservar informaci&oacute;n que hayan hecho disponible los Usuario, ni que le haya sido enviada por &eacute;stos.</li>",
			"</ul></li>",
	"</ol>",
	"<h4>h) Derecho de de autor, propiedad intelectual e industrial y registro de marcas:</h4>",
	"<ol>",
		"<li>El Sitio es de propiedad &uacute;nica, exclusiva y excluyente de ARTE GR&Aacute;FICO EDITORIAL ARGENTINO  S. A. (en adelante, \"AGEA\"), ubicada en Piedras 1743, Capital Federal, Ciudad Aut&oacute;noma de Buenos Aires, Rep&uacute;blica Argentina. Todo el material en este Sitio, incluyendo, pero sin limitaci&oacute;n a, im&aacute;genes, ilustraciones, clips de audio, y clips de video, se encuentra protegido por derechos de autor, los cuales son propiedad de, y controlados por AGEA,  u otras partes que han licenciado su material a AGEA.</li>",
		"<li>El material de este Sitio no puede ser copiado, reproducido, republicado, cargado, exhibido, transmitido, o distribuido en forma alguna. El modificar los materiales o utilizar los materiales para cualquier prop&oacute;sito representa una violaci&oacute;n de los derechos de autor y otros derechos de propiedad.</li>",
	"</ol>",
	"<h4>i) Ley aplicable y tribunal competente:</h4>",
	"<ol>",
		"<li>Los presentes T&eacute;rminos y Condiciones de Uso y las normas que lo complementan se regir&aacute;n por las leyes de la Rep&uacute;blica Argentina, siendo competentes para cualquier controversia que pudiere llegar a suscitarse, los Tribunales Nacionales en lo Comercial, con asiento en la Capital Federal, sin reservas. </li>",
		"<li>La utilizaci&oacute;n del Sitio est&aacute; expresamente prohibida en toda jurisdicci&oacute;n en donde no puedan ser aplicadas las condiciones establecidas en los presentes T&eacute;rminos y Condiciones de Uso.</li>",
		"<li>Toda notificaci&oacute;n u otra comunicaci&oacute;n que deba efectuarse bajo estos T&eacute;rminos y Condiciones de Uso, deber&aacute; realizarse por escrito: (i) al Usuario: a la cuenta mail por &eacute;l ingresada o por carta documento dirigida al domicilio declarado en su ficha de alta y registraci&oacute;n; (ii) a AGEA: a la cuenta de correo electr&oacute;nico &oacute; a Piedras 1743, Capital Federal, Ciudad Aut&oacute;noma de Buenos Aires (1139).<br>Las personas que utilicen el Sitio <a href='http://www.clasificados.clarin.com'>www.clasificados.clarin.com</a> o <a href='http://receptoriaonline.clarin.com'>receptoriaonline.clarin.com</a>, por su sola utilizaci&oacute;n aceptar&aacute;n de pleno derecho todas y cada una de las disposiciones previstas en los presentes T&eacute;rminos y Condiciones de Uso, sin reservas.</li>",
	"</ol>",
].join("\n");


DecoratorTemplates.textoProteccionDatos = [
	"<p>Al registrarse en alguno de los sitios de Dominio de ARTE GRAFICO EDITORIAL ARGENTINO S.A. (en adelante AGEA), EL USUARIO deber&aacute; brinda informaci&oacute;n personal, prestando su consentimiento para que la misma sea almacenada directamente en una BASE DE DATOS, encontr&aacute;ndose protegida electr&oacute;nicamente, utilizando los mecanismos de seguridad inform&aacute;tica de protecci&oacute;n de la informaci&oacute;n m&aacute;s completos y eficaces para mantenerla en total confidencialidad, conforme a la Ley N&deg; 25.326 de H&aacute;beas Data, no obstante lo cual, el Usuario puede acceder a esta informaci&oacute;n y solicitar su eliminaci&oacute;n. (<a href='http://www.jus.gob.ar/media/33481/ley_25326.pdf' target='_blank'>http://www.jus.gob.ar/media/33481/ley_25326.pdf</a>), siendo la Direcci&oacute;n Nacional de Protecci&oacute;n de Datos Personales, del Ministerio de Justicia, Seguridad y Derechos Humanos, el &oacute;rgano de control de la citada norma legal (<a href='http://www.jus.gov.ar/datospersonales/' target='_blank'>http://www.jus.gov.ar/datospersonales/</a>).</p>" ,
	"<p>AGEA se reserva el derecho a modificar la presente pol&iacute;tica para adaptarla a novedades legislativas o jurisprudenciales as&iacute; como a pr&aacute;cticas de la industria. En dichos supuestos, anunciar&aacute; en esta p&aacute;gina los cambios introducidos con razonable antelaci&oacute;n a su puesta en pr&aacute;ctica.</p>" ,
	"<p>Mediante el presente, toda persona que se registra en un sitio de Internet de dominio de AGEA (en adelante USUARIO) y vuelque informaci&oacute;n respecto de su nombre, domicilio, documento nacional de identidad, identificaci&oacute;n tributaria, tel&eacute;fono, direcci&aacute;n de correo electr&oacute;nico y/o datos vinculados a productos financieros (DATOS PERSONALES), presta su consentimiento para que dicha informaci&oacute;n sea almacenada directamente en una BASE DE DATOS de propiedad de AGEA.</p>",
	"<p>El Usuario garantiza que los Datos Personales facilitados a AGEA son veraces y se hace responsable de comunicar a &eacute;sta cualquier modificaci&oacute;n en los mismos.</p>",
	"<p>Se deja expresamente aclarado que ciertos Servicios prestados por &eacute;ste sitio u otros sitios vinculados pueden contener Condiciones Particulares con previsiones espec&iacute;ficas en materia de protecci&oacute;n de Datos Personales.</p>",
	"<p>Los Datos Personales ser&aacute;n incorporados a una base de datos que es de titularidad de AGEA (la \"Base\").</p>",
	"<p>EL USUARIO presta su consentimiento para que AGEA realice operaciones y procedimientos sistem&aacute;ticos, electr&oacute;nicos o no, que permitan la recolecci&oacute;n, conservaci&oacute;n, ordenaci&oacute;n, almacenamiento, modificaci&oacute;n, evaluaci&oacute;n, bloqueo y en general, el procesamiento de sus DATOS PERSONALES (en adelante TRATAMIENTO DE DATOS PERSONALES).</p>",
	"<p>AGEA podr&aacute; contratar a terceros para el tratamiento de Datos Personales.</p>",
	"<p>La finalidad de la recogida y tratamiento de los Datos Personales es la que se detalla a continuaci&oacute;n:</p>",
	"<p>Para habilitar su participaci&oacute;n en promociones, premios o concursos en l&iacute;nea.</p>",
	"<p>Para el desarrollo de nuevos productos y servicios que satisfagan las necesidades del Usuario.</p>",
	"<p>Para contactarse, v&iacute;a mail o telef&oacute;nicamente, con el Usuario a fin de relevar opiniones sobre el servicio y para informar sobre productos y servicios de cualquiera de los sitios editoriales o productos de AGEA.</p>",
	"<p>AGEA ha adoptado los niveles de seguridad de protecci&oacute;n de los Datos Personales legalmente requeridos, y ha instalado todos los medios y medidas t&eacute;cnicas a su alcance para evitar la p&eacute;rdida, mal uso, alteraci&oacute;n, acceso no autorizado y robo de los Datos Personales facilitados a AGEA. Ello no obstante, el Usuario debe ser consciente de que las medidas de seguridad en Internet no son inexpugnables. Por tal motivo, debe tener presente que siempre que divulguen voluntariamente informaci&oacute;n personal online, &eacute;sta puede ser recogida y utilizada por otros. Por lo tanto, si bien ponemos nuestro mayor esfuerzo por proteger su informaci&oacute;n personal, AGEA no ser&aacute; responsable por la difusi&oacute;n de los datos personales de nuestros visitantes efectuada por fuentes ajenas a &eacute;sta ni ser&aacute; responsable por los da&ntilde;os y perjuicios que la misma genere.</p>",
	"<p>El Usuario tiene reconocidos los derechos de acceso, cancelaci&oacute;n, rectificaci&oacute;n y oposici&oacute;n, as&iacute; como tienen reconocido el derecho a ser informados de los permisos de acceso realizados contact&aacute;ndose con AGEA a trav&eacute;s del correo electr&oacute;nico <a href='mailto:datospersonales@agea.com.ar'>datospersonales@agea.com.ar</a></p>",
	"<p>El Usuario puede modificar sus Datos Personales en cualquier momento, accediendo directamente a su P&aacute;gina Personal dentro del Sitio, en tanto, se encuentre activo el Sitio, los Suscriptores podr&aacute;n, vali&eacute;ndose del Nombre de Usuario que generen y la Contrase&ntilde;a, dar de alta, modificar y/o dar de baja los datos personales que hubieran ingresado en la Base.</p>",
	"<p>Las estructuras de la Base no requiere ni permite el ingreso de datos \"sensibles\" en los t&eacute;rminos del art&iacute;culo 7&deg; y concordantes de la Ley 25.326 de Protecci&oacute;n de Datos Personales y su Reglamentaci&oacute;n.</p>"
].join("\n");
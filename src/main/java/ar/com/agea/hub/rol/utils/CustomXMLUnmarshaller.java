/*
 * @(#)CustomXMLUnmarshaller.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Representa un objeto Unmarshaller para obtener una representación XML de un determinado dato.
 * 
 * @author		Juan Martín Lichowski
 * @author		Eduardo Barrera
 * @version		1.0 30/10/2013
 */
public class CustomXMLUnmarshaller {

	private static final String LOGGER_NAME = "rol";
	
	private final Logger logger;
	
	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;
	
	/**
	 * Instancia un objeto de tipo CustomXMLUnmarshaller.
	 */
	public CustomXMLUnmarshaller() {
		logger = Logger.getLogger(LOGGER_NAME);
	}
	
	/**
	 * Crea una representación XML a partir de un request.
	 * 
	 * @param request Objeto request a representar en XML.
	 * @return Representación XML creado.
	 */
	public Object unmarshal(HttpServletRequest request) {
		Object result = null;
		
		try {
            ServletInputStream is = request.getInputStream();
            Writer writer = new StringWriter();
            char[] buffer = new char[request.getContentLength()];
            
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, request.getCharacterEncoding()));
                int n;

                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            
            result = jaxb2Marshaller.unmarshal(new StreamSource(new StringReader(writer.toString())));
        } catch (IOException exception) {
			logger.error("Ha fallado el método unMarshall del objeto CustomXMLUnmarshaller", exception);
        }
		
		return result;
	}
}

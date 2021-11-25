/*
 * @(#)ROLErrorTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ROLError.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class ROLErrorTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ROLError.
	 */
	@Test
	public void testConstructor() {
		ROLError error = new ROLError();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLError\""
				+ " utilizando el constructor por defecto.", error);
	}

	/**
	 * Comprueba la ejecución de métodos setErrorType y getErrorType de la clase ROLError. 
	 */
	@Test
	public void testSetAndGetErrorTypeMethod() {
		ROLError error = new ROLError();
		
		error.setErrorType(ROLErrorType.REDIRECTION);
		
		ROLErrorType errorType = error.getErrorType();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrorType\" o \"getErrorType\" de la clase \"ROLError\".",
				errorType);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFieldName y getFieldName de la clase ROLError. 
	 */
	@Test
	public void testSetAndGetFieldNameMethod() {
		ROLError error = new ROLError();
		
		error.setFieldName(ROLFieldName.EMAIL);
		
		ROLFieldName fieldName = error.getFieldName();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFieldName\" o \"getFieldName\" de la clase \"ROLError\".",
				fieldName);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMessageCode y getMessageCode de la clase ROLError. 
	 */
	@Test
	public void testSetAndGetMessageCodeMethod() {
		ROLError error = new ROLError();
		
		error.setMessageCode(ROLMessageCode.CODE_000000);
		
		ROLMessageCode messageCode = error.getMessageCode();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMessageCode\" o \"getMessageCode\" de la clase \"ROLError\".",
				messageCode);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMessage y getMessage de la clase ROLError. 
	 */
	@Test
	public void testSetAndGetMessageMethod() {
		ROLError error = new ROLError();
		
		error.setMessage("MESSAGE");
		
		String message = error.getMessage();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMessage\" o \"getMessage\" de la clase \"ROLError\".",
				message);
	}

	/**
	 * Comprueba la ejecución de método hashCode de la clase ROLError. 
	 */
	@Test
	public void testHashCodeMethod() {
		Set<ROLError> errors = new HashSet<ROLError>();
		
		ROLError error = new ROLError();
		errors.add(error);

		error = new ROLError();
		error.setErrorType(ROLErrorType.REDIRECTION);
		error.setFieldName(ROLFieldName.EMAIL);
		error.setMessageCode(ROLMessageCode.CODE_000000);
		error.setMessage("MESSAGE");
		errors.add(error);
		
		Iterator<ROLError> iterator = errors.iterator();
		
		ROLError first = iterator.next();
		ROLError second = iterator.next();
		
		boolean isEqual = first.equals(second);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
	}
	
	/**
	 * Comprueba la ejecución de método equals de la clase ROLError. 
	 */
	@Test
	public void testEqualsMethod() {
		ROLError error = new ROLError();

		boolean isEqual = error.equals(error);
		
		Assert.assertTrue("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		isEqual = error.equals(null);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		isEqual = error.equals("Un objeto diferente.");
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		ROLError otherError = new ROLError();
		
		otherError.setErrorType(ROLErrorType.REDIRECTION);
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		otherError.setErrorType(null);
		otherError.setFieldName(ROLFieldName.EMAIL);
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		otherError.setFieldName(null);
		otherError.setMessageCode(ROLMessageCode.CODE_000000);
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		otherError.setMessageCode(null);
		otherError.setMessage("OTHER MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		error.setMessage("MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
		
		otherError.setMessage("MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertTrue("Ha fallado la llamada al método \"equals\" de la clase \"ROLError\".",
				isEqual);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ROLError. 
	 */
	@Test
	public void testToStringMethod() {
		ROLError error = new ROLError();
		
		error.setMessage("MESSAGE");
		
		String message = error.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ROLError\".",
				message);
	}
}

/*
 * @(#)ImagenComparatorTest.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Representa JUnit Tests de comparaci�n de im�genes.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public class ImagenComparatorTest {

	@Autowired
	private ImagenComparator imagenComparator;
	
	@Test
	public void testSomething() {}
	
//	/**
//	 * Comprueba el env�o y recepci�n de objetos al servicio compareImagenes
//	 * obteniendo valores con errores.
//	 */
//	@Test
//	public void testGetCompareImagenesWithErrors() {
//		List<Integer> output = null;
//		
//		try {
//			output = imagenComparator.compareImagenes(ImagenDTO dtoFirst, ImagenDTO dtoSecond);
//		} catch (ServiceException e) {
//			throw new GenericTestException("Se produjo un error al acceder al comparador ImagenComparator.", e);
//		}
//		
//		Assert.assertNotNull("El servicio getCaracteresInvalidosJustificacion no ha devuelto ning�n valor.", output);
//		Assert.assertFalse("La lista de caracteres inv�lidos es vac�a.", output.isEmpty());
//	}
//	
//	/**
//	 * Comprueba el env�o y recepci�n de objetos al servicio compareImagenes
//	 * obteniendo valores sin errores.
//	 */
//	@Test
//	public void testGetCompareImagenesWithoutErrors() {
//		List<Integer> output = null;
//		
//		try {
//			output = imagenComparator.compareImagenes(ImagenDTO dtoFirst, ImagenDTO dtoSecond);
//		} catch (ServiceException e) {
//			throw new GenericTestException("Se produjo un error al acceder al comparador ImagenComparator.", e);
//		}
//		
//		Assert.assertNotNull("El servicio getCaracteresInvalidosJustificacion no ha devuelto ning�n valor.", output);
//		Assert.assertFalse("La lista de caracteres inv�lidos es vac�a.", output.isEmpty());
//	}
	
}

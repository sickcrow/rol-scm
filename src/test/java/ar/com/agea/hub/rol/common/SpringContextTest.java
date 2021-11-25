/*
 * @(#)SpringContextTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Brinda una intefaz unificada a todos los JUnit Tests para el acceso
 * a los beans definidos en Spring Framework.
 * <p>
 * Todos los JUnit Tests deben extender de esta clase para heredar y
 * utilizar sus prestaciones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
@ContextConfiguration("classpath:application-context.xml")
public abstract class SpringContextTest extends AbstractJUnit4SpringContextTests {

	private static final String JSON_EXTENSION = ".json";
	
	private Map<FileName, String> fileContents;

	/**
	 * Inicializa todos los recursos necesarios para acceder a los servicios
	 * HUB.
	 */
	@Before
    public void setUp() {
		fileContents = getContents(getAbsoluteFileNamesFromRelativePaths(new String[] {"src/test/resources/json/"}));
    }

	/**
	 * Obtiene el contenido de un archivo representado por FileName. 
	 * 
	 * @param fileName Objeto FileName asociado a un objeto contenido.
	 * @return Objeto contenido asociado a un objeto FileName.
	 */
	public String getFileContent(FileName fileName) {
		return fileContents.get(fileName);
	}
	
	/*
	 * Obtiene todos los contenidos de los archivos representados por el
	 * parámetro "fileNames". Estos contenidos son devueltos de la forma
	 * clave-valor donde clave es el nombre del archivo y valor es su contenido.
	 */
	private Map<FileName, String> getContents(Set<String> fileNames) {
		Map<FileName, String> contents = new HashMap<FileName, String>();
		StringBuilder content = new StringBuilder();
		String line = null;
		
		for (String fileName : fileNames) {
			try {
				File file = new File(fileName);
				
				if (file.exists() && file.isFile()) {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
					while ((line = reader.readLine()) != null) {
						content.append(line);
					}
	
					FileName key = FileName.getByReference(file.getName());
					
					if (key == null) {
						reader.close();
						throw new GenericTestException("No existe el nombre de archivo \"" + file.getName() + "\" en las constantes de nombres de archivos.");
					}
					
					contents.put(key, content.toString());
	
					content.delete(0, content.length());
					
					reader.close();
				}
			} catch (IOException e) {
				throw new GenericTestException("Se produjo un error al leer archivos.", e);
			}
		}
		
		return contents;
	}
	
	/*
	 * Obtiene todos los nombres absolutos de archivos que se encuentren en
	 * las rutas representadas por el parámetro "paths". Sólo aquellos archivos
	 * que contengan la extensión .json serán tenidos en cuenta.
	 */
	private Set<String> getAbsoluteFileNamesFromRelativePaths(String[] paths) {
		Set<String> absoluteFileNames = new HashSet<String>();
		
		for (String path : paths) {
			if (path != null) {
				File directory = new File(path);
				
				if (directory.exists() && directory.isDirectory()) {
					for (File file : directory.listFiles()) {
						String fileName = file.getName();
						
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(JSON_EXTENSION)) {
							absoluteFileNames.add(file.getAbsolutePath());
						}
					}
				}
			}
		}
		
		return absoluteFileNames;
	}
}

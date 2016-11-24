package ubu.lsi.dms.test.agenda.persistencia;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Clase que extiende de TestSuite para asegurar la ejecución en orden correcto
 * para JUnit 3.8
 * 
 * @author root
 * 
 */
public class AlphabeticMethodSorterTestSuite extends TestSuite {

	public AlphabeticMethodSorterTestSuite(Class<?> clazz) {
		final Method[] methods = clazz.getMethods();
		final List<String> names = new ArrayList<String>();
		for (Method method : methods) {
			final String methodName = method.getName();
			if (methodName.startsWith("test")) {
				names.add(methodName);
			}
		}

		Collections.sort(names);

		try {
			final Constructor<?> constructor = clazz
					.getConstructor(new Class<?>[] { String.class });
			final Object[] initargs = new Object[1];
			for (String name : names) {
				initargs[0] = name;
				final Test test = (Test) constructor.newInstance(initargs);
				addTest(test);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

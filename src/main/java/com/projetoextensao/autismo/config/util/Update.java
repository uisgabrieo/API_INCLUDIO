package com.projetoextensao.autismo.config.util;

import java.lang.reflect.Method;

public class Update {
	
	public static void updateDate(Object obj, Object update) {
		Class<?> classObj = obj.getClass();
		
		try {
			for(Method getter : classObj.getMethods()) {
				if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
					Object value = getter.invoke(update);
					if(value != null) {
						String setterName = getter.getName().replaceFirst("get", "set");
						try {
							Method setter = classObj.getMethod(setterName, getter.getReturnType());
							setter.invoke(obj, value);
						} catch (NoSuchMethodException  e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

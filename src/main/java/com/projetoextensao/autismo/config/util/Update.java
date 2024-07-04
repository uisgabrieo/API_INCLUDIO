package com.projetoextensao.autismo.config.util;

import java.lang.reflect.Method;

public class Update {

//    public static void updateIfNotNull(Object original, Object updated) {
//        Class<?> clazz = original.getClass();
//        
//        try {
//            for (Method getter : clazz.getMethods()) {
//                if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
//                    Object value = getter.invoke(updated);
//                    if (value != null) {
//                        String setterName = getter.getName().replaceFirst("get", "set");
//                        try {
//                            Method setter = clazz.getMethod(setterName, getter.getReturnType());
//                            setter.invoke(original, value);
//                        } catch (NoSuchMethodException e) {
//                        	e.getMessage();
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

	public static void updateDate(Object obj, Object update) {
		Class<?> classObj = obj.getClass();

		try {
			for (Method getter : classObj.getMethods()) {
				if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
					System.out.println("Invocando getter: " + getter);
					Object value = getter.invoke(update);
					if (value != null) {
						String setterName = getter.getName().replaceFirst("get", "set");
						try {
							Method setter = classObj.getMethod(setterName, getter.getReturnType());
							System.out.println("Invocando setter: " + setterName + " com valor: " + value);

							// Check if the value is an object and not a primitive type or String
							if (!getter.getReturnType().isPrimitive() && !getter.getReturnType().equals(String.class)) {
								System.out.println("Valor é um objeto. Atualizando recursivamente.");
								Object nestedObj = getter.invoke(obj);
								if (nestedObj == null) {
									nestedObj = getter.getReturnType().getDeclaredConstructor().newInstance();
									setter.invoke(obj, nestedObj);
								}
								updateDate(nestedObj, value);
							} else {
								setter.invoke(obj, value);
							}
						} catch (NoSuchMethodException e) {
							System.out.println("Setter não encontrado: " + setterName);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
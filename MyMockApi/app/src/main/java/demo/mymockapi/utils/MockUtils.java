package demo.mymockapi.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockUtils {

	/***
	 * 初始化指定泛型类型的集合的并设置属性值，默认长度为10
	 * @param clType 要创建集合的泛型类型
	 * @param <T>
     * @return
     */
	public static <T> List<T> mockList(Class<T> clType) {
		List<T> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(mockObj(clType));
		}
		return list;
	}

	/***
	 * 初始化制定类型对象的并设置属性值
	 * 
	 * @param clType mock对象的类型
	 * @return 带有初始化属性值的mock对象
	 */
	public static <T> T mockObj(Class<T> clType) {
		T targetObj = mock(clType);
		Random random = new Random();

		Field[] fields = targetObj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				String fieldName = field.getName();
				Class<?> fieldType = field.getType();
				Type fieldGenericTyp = field.getGenericType();
				String fieldTypeName = fieldType.toString();
				Object fieldValue = field.get(targetObj);

				if (fieldType == Integer.class || fieldType == int.class) {
					field.set(targetObj, random.nextInt());
				} else if (fieldType == Float.class || fieldType == float.class) {
					field.set(targetObj, random.nextFloat());
				} else if (fieldType == Double.class
						|| fieldType == double.class) {
					field.set(targetObj, random.nextDouble());
				} else if (fieldType == String.class && fieldValue == null) {
					// 字符串
					field.set(targetObj, fieldName + " test data");
				} else if (fieldType == List.class && fieldValue == null) {
					System.err.println("fieldTypeName" + "List集合："
							+ fieldTypeName + "--" + field.getGenericType());

					Type[] types = getParadigmType(field);
					if (types != null && types.length > 0) {
						Class<?> cl = (Class<?>) types[0];
						System.err.println("fieldTypeName" + cl.toString());

						List list = new ArrayList();
						for (int i = 0; i < 5; i++) {
							list.add(mockObj(cl));
						}
						field.set(targetObj, list);
					}
				} else if (fieldTypeName != null && fieldValue == null
						&& fieldTypeName.startsWith("class")) {
					System.out.println("fieldTypeName" + "自定义类："
							+ fieldTypeName);
					// 设置一个自定类
					field.set(targetObj, mockObj(fieldType));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return targetObj;
	}

	/***
	 * 根据类型创建一个属性值为空的对象，
	 * 
	 * @param type
	 * @return
	 */
	private static <T> T mock(Class<T> type) {
		try {
			Constructor[] contructors = type.getConstructors();
			T resObj = type.newInstance();
			System.out.println(resObj.toString());
			return resObj;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/***
	 * 获取指定类的泛型
	 * @param t
	 * @param <T>
     * @return
     */
	public static <T> Class<T> getClassType(T t)
	{
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) t.getClass().getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			return clazz;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



	private static Class<?> getClassType(Type[] types) {
		if (types != null && types.length > 0) {
			Class<?> cl = (Class<?>) types[0];
			return cl;
		}
		return null;
	}

	/***
	 * 根据属性获取泛型类型
	 * 
	 * @param f
	 * @return
	 */
	private static Type[] getParadigmType(Field f) {
		// 获得Field实例f的泛型类型
		Type gType = f.getGenericType();
		// 如果gType类型是ParameterizedType的对象
		if (gType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) gType;
			// 获取原始类型
			Type rType = pType.getRawType();
			System.out.println("原始类型是：" + rType);
			// 取得泛型类型参数
			Type[] tArgs = pType.getActualTypeArguments();
			System.out.println("泛型类型是：");
			for (int i = 0; i < tArgs.length; i++) {
				System.out.println("第" + i + "个泛型类型是：" + tArgs[i]);
			}
			return tArgs;
		} else {
			System.out.println("获取泛型类型出错！");
		}
		return null;
	}
}
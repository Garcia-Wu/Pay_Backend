package com.jx.projects.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelUtils {

	
	/** 
	 * 读取所有数据并返回对应实体类集合
	 * 	in ：读取excel表格的输入流
	 * 	headerMap ：表头信息对应实体类属性的集合
	 * 	class1 ： 对应实体类
	 *  */
//	public static List<Object> readAll(InputStream in, Map<String, String> headerMap, Class<?> class1) throws Exception {
//		// 传入excel输入流
//		POIFSFileSystem fs = new POIFSFileSystem(in);
//		// 获得workbook
//		HSSFWorkbook wb = new HSSFWorkbook(fs);
//		// 获得要解析的表单
//		HSSFSheet sheet = wb.getSheetAt(0);
//		// 获取表头的数据
//		HSSFRow headerRow = sheet.getRow(0);
//		// 表头的数据装进列数组里
//		Cell[] headerCell = new Cell[headerRow.getPhysicalNumberOfCells()];
//		for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
//			headerCell[i] = headerRow.getCell(i);
//		}
//		List<Object> list = new ArrayList<>();
//		// 遍历sheet getRows()为获得总行数 (表头没有,且去掉最后一行合计的)
//		for (int i = 1; i < sheet.getLastRowNum(); i++) {
//			// 获得每一行的数据
//			HSSFRow row = sheet.getRow(i);
//			// 装进列数组
//			Cell[] cell = new Cell[row.getPhysicalNumberOfCells()];
//			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
//				cell[j] = row.getCell(j);
//			}
//			Object obj = class1.newInstance();
//			for (int j = 0; j < headerCell.length; j++) {
//				// 获得每一列的数据
//				for (String header : headerMap.keySet()) {
//					// 如果当前列的表头与集合里面的key相同,则找到对应的set方法进行赋值
//					if( headerCell[j].getStringCellValue().trim().equals(header)){
//						// 获取set方法
//						Method setMethod = getSetMethod(headerMap.get(header),class1);
//						invokeMethod(setMethod, obj, cell[j].getStringCellValue().trim());
//					}
//				}
//			}
//			// 读取完一行,添加至集合
//			list.add(obj);
//		}
//		for (Object object : list) {
//			System.out.println(object);
//		}
//		wb.close();
//		return list;
//	}
	
	/** 
	 * 读取所有数据并返回对应实体类集合
	 * 	in ：读取excel表格的输入流
	 * 	headerMap ：表头信息对应实体类属性的集合
	 * 	class1 ： 对应实体类
	 *  */
	public static <T> List<T> readAll(InputStream in, Map<String, String> headerMap, Class<T> class1) throws Exception {
		// 获得workbook
		Workbook wb = Workbook.getWorkbook(in);
		// 获得要解析的表单
		Sheet sheet = wb.getSheet(0);
		// 获取表头的数据
		Cell[] headerCell = sheet.getRow(0);
		List<T> list = new ArrayList<>();
		// 遍历sheet getRows()为获得总行数 (表头没有,且去掉最后一行合计的)
		for (int i = 1; i < sheet.getRows() - 1; i++) {
			// 获得每一行的数据
			Cell[] cell = sheet.getRow(i);
			T obj = class1.newInstance();
			for (int j = 0; j < headerCell.length; j++) {
				// 获得每一列的数据
				for (String header : headerMap.keySet()) {
					// 如果当前列的表头与集合里面的key相同,则找到对应的set方法进行赋值
					if( headerCell[j].getContents().trim().equals(header)){
						// 获取set方法
						Method setMethod = getSetMethod(headerMap.get(header),class1);
						invokeMethod(setMethod, obj, cell[j].getContents());
					}
				}
			}
			// 读取完一行,添加至集合
			list.add(obj);
		}
		for (Object object : list) {
			System.out.println(object);
		}
		wb.close();
		return list;
	}

	/** 判断参数类型，代入执行方法 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NumberFormatException */
	private static void invokeMethod(Method setMethod, Object obj, String contents) throws Exception {
		// 返回第一个参数的类型(set方法只有一个参数)
		Type paramType = setMethod.getParameterTypes()[0];
		// 如果不为空，进行赋值
		if(contents != null && !contents.equals("")){
			// 去除 "%"
			contents = contents.replaceAll("%", "");
			// 判断类型进行赋值
			if(double.class.equals(paramType) || Double.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Double.valueOf(contents));
			}else if(int.class.equals(paramType) || Integer.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Integer.valueOf(contents));
			}else if(String.class.equals(paramType)){
				setMethod.invoke(obj, contents);
			}else if(Date.class.equals(paramType)){
				contents = "20" + contents;
				// 使用常量类定义的时间格式
				setMethod.invoke(obj, PayConstants.sdf.parse(contents));
			}else if(byte.class.equals(paramType) || Byte.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Byte.valueOf(contents));
			}else if(short.class.equals(paramType) || Short.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Short.valueOf(contents));
			}else if(long.class.equals(paramType) || Long.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Long.valueOf(contents));
			}else if(float.class.equals(paramType) || Float.class.equals(paramType)){
				// 数据类型去除逗号
				contents = contents.replaceAll(",", "");
				setMethod.invoke(obj, Float.valueOf(contents));
			}else if(boolean.class.equals(paramType) || Boolean.class.equals(paramType)){
				setMethod.invoke(obj, Boolean.valueOf(contents));
			}else if(char.class.equals(paramType) || Character.class.equals(paramType)){
				// String转为char时,只截取第一个字符
				setMethod.invoke(obj, Character.valueOf(contents.toCharArray()[0]));
			}else{
				throw new PayException("类型转换异常！类型为："+paramType);
			}
		}
		
	}

	/** 获取set方法 */
	private static Method getSetMethod(String field, Class<?> class1) {
		// 获取set方法名
		String methodName = "set" + field.substring(0, 1).toUpperCase() + field.substring(1); 
		Method[] methods = class1.getDeclaredMethods();
		// 遍历所有方法，找到方法并返回
		for (Method method : methods) {
			if(method.getName().equals(methodName)){
				return method;
			}
		}
		throw new PayException("没有找到对应的set方法："+field+"|  -->class1");
	}

	// 获得实体类定义属性个数
	public static int getLength(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		// 去掉uid、日期、所属
		return fields.length - 3;
	}

}

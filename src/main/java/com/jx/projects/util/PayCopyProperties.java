package com.jx.projects.util;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * @author  JX.Wu
 * @date  2018年1月31日
 */
public class PayCopyProperties {
	
	/**
	 * 若source对象有相应属性且不为空, 则赋给target
	 */
	public static void CopyProperties(Object source, Object target){
		try {
			Assert.notNull(source, "Source must not be null");
	        Assert.notNull(target, "Target must not be null");
	        Class<?> sourceClass = source.getClass();
	        Class<?> targetClass = target.getClass();
	        Field[] sourceFields = sourceClass.getDeclaredFields();
	        Field[] targetFields = targetClass.getDeclaredFields();
	        for (Field sourceField : sourceFields) {
				for (Field targetField : targetFields) {
					sourceField.setAccessible(true);
					if(sourceField.get(source) != null){
						if(sourceField.getName().equals(targetField.getName()) && StringUtils.isNotEmpty(sourceField.get(source).toString())){
							targetField.setAccessible(true);
							targetField.set(target, sourceField.get(source));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

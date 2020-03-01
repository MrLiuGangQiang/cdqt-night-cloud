package org.cdqt.night.core.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化资源文件操作类
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class Prompt {
	/**
	 * 默认资源文件路径 默认值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private final static String FILEPATH = "i18n.prompt";

	/**
	 * 构造器私有化
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private Prompt() {
	}

	/**
	 * 获取无占位符的属性值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param key 键值
	 * @return 属性值
	 */
	public static String bundle(String key) {
		return ResourceBundle.getBundle(FILEPATH, Locale.getDefault()).getString(key);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param key       键值
	 * @param arguments 参数（数组或不定参数）
	 * @return 替换占位符后的属性值
	 */
	public static String bundle(String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(FILEPATH, Locale.getDefault()).getString(key), arguments);
	}

	/**
	 * 获取无占位符的属性值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path 文件路径
	 * @param key  键值
	 * @return 属性值
	 */
	public static String bundle(String path, String key) {
		return ResourceBundle.getBundle(path, Locale.getDefault()).getString(key);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path      文件路径
	 * @param key       键值
	 * @param arguments 参数（数组或不定参数）
	 * @return 替换占位符后的属性值
	 */
	public static String bundle(String path, String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(path, Locale.getDefault()).getString(key), arguments);
	}
}

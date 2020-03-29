package org.cdqt.night.core.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化资源文件操作类
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public abstract class Prompt {
	/**
	 * 默认资源文件路径 默认值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private final static String FILEPATH = "i18n.prompt";

	private Locale locale;

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

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
	 * @return {@link String}
	 */
	@Deprecated
	public static String bundle(String key) {
		return ResourceBundle.getBundle(FILEPATH, Locale.getDefault()).getString(key);
	}

	/**
	 * 获取无占位符的属性值
	 *
	 * @author LiuGangQiang Create in 2020/03/30
	 * @param key    键值
	 * @param locale 语言环境
	 * @return {@link String}
	 */
	public static String bundle(String key, Locale locale) {
		return ResourceBundle.getBundle(FILEPATH, locale).getString(key);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param key       键值
	 * @param arguments 参数（数组或不定参数）
	 * @return {@link String}
	 */
	@Deprecated
	public static String bundle(String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(FILEPATH, Locale.getDefault()).getString(key), arguments);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param key       键值
	 * @param locale    语言环境
	 * @param arguments 参数（数组或不定参数）
	 * @return {@link String}
	 */
	public static String bundle(String key, Locale locale, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(FILEPATH, locale).getString(key), arguments);
	}

	/**
	 * 获取无占位符的属性值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path 文件路径
	 * @param key  键值
	 * @return {@link String}
	 */
	@Deprecated
	public static String bundle(String path, String key) {
		return ResourceBundle.getBundle(path, Locale.getDefault()).getString(key);
	}

	/**
	 * 获取无占位符的属性值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path   文件路径
	 * @param locale 语言环境
	 * @param key    键值
	 * @return {@link String}
	 */
	public static String bundle(String path, String key, Locale locale) {
		return ResourceBundle.getBundle(path, locale).getString(key);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path      文件路径
	 * @param key       键值
	 * @param arguments 参数（数组或不定参数）
	 * @return {@link String}
	 */
	@Deprecated
	public static String bundle(String path, String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(path, Locale.getDefault()).getString(key), arguments);
	}

	/**
	 * 获取有占位符的属性值并赋值
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param path      文件路径
	 * @param key       键值
	 * @param locale    语言环境
	 * @param arguments 参数（数组或不定参数）
	 * @return {@link String}
	 */
	public static String bundle(String path, String key, Locale locale, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(path, locale).getString(key), arguments);
	}
}

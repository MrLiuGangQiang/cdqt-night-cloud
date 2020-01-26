package org.cdqt.module.mongo.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Prompt
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
public class Prompt {
	private static String filePath = "i18n.prompt";

	/**
	 * bundle
	 *
	 * @author LiuGangQiang Create in 2020/01/24
	 * @param key
	 * @return {@link String}
	 */
	public static String bundle(String key) {
		return ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key);
	}

	/**
	 * bundle
	 *
	 * @author LiuGangQiang Create in 2020/01/24
	 * @param key
	 * @param arguments
	 * @return {@link String}
	 */
	public static String bundle(String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key), arguments);
	}
}

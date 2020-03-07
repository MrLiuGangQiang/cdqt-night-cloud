package org.cdqt.night.reverse.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 逆向注释工具类
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class CommentGenerator extends DefaultCommentGenerator {

	/**
	 * 属性
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private Properties properties;

	public CommentGenerator() {
		properties = new Properties();
	}

	@Override
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
	}

	/**
	 * @see org.mybatis.generator.internal.DefaultCommentGenerator#addModelClassComment(org.mybatis.generator.api.dom.java.TopLevelClass,
	 *      org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String author = properties.getProperty("author");
		String dateFormat = properties.getProperty("dateFormat", "yyyy/MM/dd");
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		// 获取表注释
		String remarks = introspectedTable.getRemarks();
		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * " + remarks);
		topLevelClass.addJavaDocLine(" *");
		topLevelClass.addJavaDocLine(" * @author " + author + " Create in " + dateFormatter.format(new Date()));
		topLevelClass.addJavaDocLine(" */");
	}

	/**
	 * @see org.mybatis.generator.internal.DefaultCommentGenerator#addFieldComment(org.mybatis.generator.api.dom.java.Field,
	 *      org.mybatis.generator.api.IntrospectedTable,
	 *      org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		String author = properties.getProperty("author");
		String dateFormat = properties.getProperty("dateFormat", "yyyy/MM/dd");
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		// 获取列注释
		String remarks = introspectedColumn.getRemarks();
		field.addJavaDocLine("/**");
		field.addJavaDocLine(" * " + remarks);
		field.addJavaDocLine(" * ");
		field.addJavaDocLine(" * @author " + author + " Create in " + dateFormatter.format(new Date()));
		field.addJavaDocLine(" */");
	}

	/**
	 * @see org.mybatis.generator.internal.DefaultCommentGenerator#addGetterComment(org.mybatis.generator.api.dom.java.Method,
	 *      org.mybatis.generator.api.IntrospectedTable,
	 *      org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * @return the " + introspectedColumn.getJavaProperty());
		method.addJavaDocLine(" */");
	}

	/**
	 * @see org.mybatis.generator.internal.DefaultCommentGenerator#addSetterComment(org.mybatis.generator.api.dom.java.Method,
	 *      org.mybatis.generator.api.IntrospectedTable,
	 *      org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * @param " + introspectedColumn.getJavaProperty() + " the " + introspectedColumn.getJavaProperty() + " to set");
		method.addJavaDocLine(" */");
	}

	/**
	 * @see org.mybatis.generator.internal.DefaultCommentGenerator#addComment(org.mybatis.generator.api.dom.xml.XmlElement)
	 */
	@Override
	public void addComment(XmlElement xmlElement) {
	}
}
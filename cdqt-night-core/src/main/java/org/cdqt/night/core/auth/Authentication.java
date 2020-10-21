package org.cdqt.night.core.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限认证注解
 *
 * @author LiuGangQiang Create in 2020/02/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authentication {

	/**
	 * 权限控制级别 默认值为 {@link Level#OPERATION}
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return 权限级别 参考 {@link Level}
	 */
	Level level() default Level.OPERATION;

	/**
	 * 权限描述值 默认值为 "" <br>
	 * 建议命名规则 <font style="color:yellow;">[级别]</font> <font style="color:orange;">[:模块(服务模块简称)]</font> <font style="color:yellow;">[:对象(针对何种对象)]</font>
	 * <font style="color:orange;">[:操作(一般使用方法名)]</font><br>
	 * 每块内容有多个单词用"-"隔开<br>
	 * 例如:<br>
	 * role:user:user:manager 用户管理角色<br>
	 * prms:user:user:select 用户查询权限<br>
	 * oper:user:user:insert 用户新增操作<br>
	 * 
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return 权限值(字符串)
	 */
	String value() default "";

	/**
	 * 是否忽略校验 默认值为 <code>false</code>
	 * 
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return 是否忽略校验
	 */
	boolean ignore() default false;

	/**
	 * 是否只做登录验证 默认值为 <code>false</code>
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return 是否只做登录验证 默认不是
	 */
	boolean authc() default false;
}

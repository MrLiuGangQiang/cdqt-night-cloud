package org.cdqt.night.core.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Authentication 权限认证注解
 *
 * @author LiuGangQiang Create in 2020/01/20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authentication {

	/**
	 * 权限控制级别 默认值为{@link Level#OPERATION}
	 * 
	 * @author LiuGangQiang Create in 2020/01/20
	 * @return 权限级别 参考{@link Level}
	 */
	Level level() default Level.OPERATION;

	/**
	 * 权限描述值 默认值为 "" <br>
	 * 建议命名规则 <font style="color:red;">[级别]</font>
	 * <font style="color:green;">[:模块(服务模块简称)]</font>
	 * <font style="color:red;">[:对象(针对何种对象)]</font>
	 * <font style="color:green;">[:操作(一般使用方法名)]</font><br>
	 * 每块内容有多个单词用"-"隔开<br>
	 * 例如:<br>
	 * role:user:user:manager 用户管理角色<br>
	 * prms:user:user:select 用户查询权限<br>
	 * oper:user:user:insert 用户新增操作<br>
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @return 权限值
	 */
	String value() default "";

	/**
	 * 是否忽略校验 默认不忽略
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @return 是否忽略校验
	 */
	boolean ignore() default false;

	/**
	 * 是否只做登录验证 默认不是
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @return 是否只做登录验证
	 */
	boolean authc() default false;
}

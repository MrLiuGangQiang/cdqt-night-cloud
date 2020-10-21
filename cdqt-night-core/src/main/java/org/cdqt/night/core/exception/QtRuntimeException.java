package org.cdqt.night.core.exception;

/**
 * 自定义异常
 *
 * @author LiuGangQiang Create in 2020/10/21
 */
public class QtRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * 参数
	 *
	 * @author LiuGangQiang Create in 2020/06/24
	 */
	private Object[] args;

	/**
	 * QtRuntimeException
	 *
	 * @author LiuGangQiang Create in 2020/10/21
	 * @param message 异常消息
	 * @param args    不定参数
	 */
	public QtRuntimeException(String message, Object... args) {
		super(message);
		this.args = args;
	}

	/**
	 * QtRuntimeException
	 *
	 * @author LiuGangQiang Create in 2020/10/21
	 * @param message 异常消息
	 */
	public QtRuntimeException(String message) {
		super(message);
	}

	/**
	 * QtRuntimeException
	 *
	 * @author LiuGangQiang Create in 2020/10/21
	 */
	public QtRuntimeException() {
		super();
	}

	/**
	 * @return the args
	 */
	public Object[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

}

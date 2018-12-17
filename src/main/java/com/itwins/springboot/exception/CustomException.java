package com.itwins.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 * @author itwins
 *spring 对于 RuntimeException 异常才会进行事务回滚。
 */
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 8204338781985655956L;

	private String code;
	
	private String msg;

}

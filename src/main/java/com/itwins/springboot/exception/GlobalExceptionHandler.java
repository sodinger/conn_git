package com.itwins.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局统一的异常处理类
 * @author Administrator
 *利用@ControllerAdvice和@ExceptionHandler定义一个统一异常处理类
@ControllerAdvice：控制器增强，使@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法。
@ExceptionHandler：异常处理器，此注解的作用是当出现其定义的异常时进行处理的方法
 */
//补充：如果全部异常处理返回json，那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，
//这样在方法上就可以不需要添加 @ResponseBody。
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }
    
    /**
     * 拦截捕捉自定义异常 CustomException.class
     * @param ex
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(value = CustomException.class)
//    public Map<String, Object> myErrorHandler(CustomException ex) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", ex.getCode());
//        map.put("msg", ex.getMsg());
//        return map;
//    }

	
	// 正常开发过程中，可创建一个统一相应实体，如GlobalResp.
	//如果不需要返回json数据，而要渲染某个页面模板返回给浏览器，那么MyControllerAdvice中可以这么实现：
//    @ExceptionHandler(value = CustomException.class)
//    public ModelAndView myErrorHandler2(CustomException ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("code", ex.getCode());
//        modelAndView.addObject("msg", ex.getMsg());
//        return modelAndView;
//    }
}

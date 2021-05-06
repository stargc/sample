package com.gc.demo.infrastructure.exception;

import com.gc.demo.infrastructure.model.BaseResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 定制异常处理逻辑
 */
@ControllerAdvice
@RestController
public class EhlExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(EhlExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public BaseResponse<String> handleException(HttpServletRequest requset, Exception e) {
		logger.error(ExceptionUtils.getStackTrace(e));
		BaseResponse<String> message = new BaseResponse<>();
		message.setStatus(BaseResponse.Code.ERROR);
		message.setMessage(e.getMessage());
		return message;
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public BaseResponse handleBindException(HttpServletRequest request, BindException e) {
		BaseResponse<String> message = new BaseResponse<>();
		message.setStatus(BaseResponse.Code.ERROR);
		message.setMessage(getErrorMsg(e.getBindingResult()));
		logger.error(String.format("请求接口%s报错[%s]",request.getRequestURI(),getErrorMsg(e.getBindingResult())));
		return message;
	}
	/***
	 * 处理传参为 @RequestBody且 Validator验证参数错误时 抛出的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public BaseResponse handleParmValidationException(HttpServletRequest request, MethodArgumentNotValidException e) {
		BaseResponse<String> message = new BaseResponse<>();
		message.setStatus(BaseResponse.Code.ERROR);
		message.setMessage(getErrorMsg(e.getBindingResult()));
		logger.error(String.format("请求接口%s报错[%s]",request.getRequestURI(),getErrorMsg(e.getBindingResult())));
		return message;
	}

	@ExceptionHandler(LogicErrorException.class)
	@ResponseBody
	public BaseResponse handleValParmException(HttpServletRequest request, LogicErrorException e) {
		BaseResponse<String> message = new BaseResponse<>();
		message.setStatus(BaseResponse.Code.ERROR);
		message.setMessage(e.getMessage());
		logger.error(String.format("请求接口%s报错[%s]",request.getRequestURI(),e.getMessage()));
		return message;
	}

	@ExceptionHandler(ThirdPatryException.class)
	@ResponseBody
	public BaseResponse handleThirdPatryException(HttpServletRequest request, ThirdPatryException e) {
		BaseResponse<String> message = new BaseResponse<>();
		message.setStatus(BaseResponse.Code.ERROR);
		message.setMessage(e.getMessage());
		logger.error(String.format("请求接口%s报错[%s]",request.getRequestURI(),e.getMessage()));
		return message;
	}

	private String getErrorMsg(BindingResult result){
		StringBuilder errorMsg = new StringBuilder("请求参数异常：");
		for (ObjectError error : result.getAllErrors()) {
			errorMsg.append(error.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return errorMsg.toString();
	}


}
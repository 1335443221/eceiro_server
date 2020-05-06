package com.timber.eceiro.common.Interceptor;
import javax.servlet.http.HttpServletRequest;

import com.timber.eceiro.common.utils.Result;
import com.timber.eceiro.common.utils.CodeMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
 
    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("", e);
        if(e instanceof org.springframework.web.servlet .NoHandlerFoundException) {
        	return Result.error(CodeMsg.MISSING_PATH,0);
        }else if(e instanceof MyException){
        	return e;
        }else{
            return Result.error(CodeMsg.SERVER_ERROR,0);
        }
         
    }
}

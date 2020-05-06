package com.timber.eceiro.common.Interceptor;

import com.timber.eceiro.common.utils.CodeMsg;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String error(){
        throw new MyException(CodeMsg.MISSING_PATH,0);
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}

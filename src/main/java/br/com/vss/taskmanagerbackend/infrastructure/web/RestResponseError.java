package br.com.vss.taskmanagerbackend.infrastructure.web;


import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class RestResponseError {
    private String error;
    private RestResponseError(){

    }
    public String getError(){
        return error;
    }

    public static RestResponseError fromValidationError(Errors errors){
        RestResponseError resp = new RestResponseError();
        StringBuilder sb = new StringBuilder();
        for (ObjectError error: errors.getAllErrors()){
            sb.append(error.getDefaultMessage()).append(". ");
        }
        resp.error = sb.toString();
        return resp;
    }
}

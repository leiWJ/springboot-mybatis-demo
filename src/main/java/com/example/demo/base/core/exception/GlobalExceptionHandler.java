package com.example.demo.base.core.exception;


import com.example.demo.base.Result;
import com.example.demo.base.core.constants.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.*;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author wen
 * @Description:
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常处理，比如：404,500
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        Result result = new Result();

        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            result.setCode(ResultEnum.NOT_FOUND.getCode());
            result.setMessage(ResultEnum.NOT_FOUND.getMsg());
        } else if (e instanceof NullPointerException) {
            result.setCode(ResultEnum.NullPointerException.getCode());
            result.setMessage(ResultEnum.NullPointerException.getMsg());
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            result.setCode(ResultEnum.ArrayIndexOutOfBoundsException.getCode());
            result.setMessage(ResultEnum.ArrayIndexOutOfBoundsException.getMsg());
        } else if (e instanceof SQLException) {
            result.setCode(ResultEnum.SQLException.getCode());
            result.setMessage(ResultEnum.SQLException.getMsg());
        } else if (e instanceof org.springframework.jdbc.UncategorizedSQLException) {
            result.setCode(ResultEnum.SQLException.getCode());
            result.setMessage("编码异常，请检查后重试！");
        } else if (e instanceof IOException) {
            result.setCode(ResultEnum.IOException.getCode());
            result.setMessage(ResultEnum.IOException.getMsg());
        } else if (e instanceof FileNotFoundException) {
            result.setCode(ResultEnum.FileNotFoundException.getCode());
            result.setMessage(ResultEnum.FileNotFoundException.getMsg());
        } else if (e instanceof ClassCastException) {
            result.setCode(ResultEnum.ClassCastException.getCode());
            result.setMessage(ResultEnum.ClassCastException.getMsg());
        } else if (e instanceof EOFException) {
            result.setCode(ResultEnum.EOFException.getCode());
            result.setMessage(ResultEnum.EOFException.getMsg());
        } else if (e instanceof NumberFormatException) {
            result.setCode(ResultEnum.NumberFormatException.getCode());
            result.setMessage(ResultEnum.NumberFormatException.getMsg());
        } else if (e instanceof NoSuchMethodException) {
            result.setCode(ResultEnum.NoSuchMethodException.getCode());
            result.setMessage(ResultEnum.NoSuchMethodException.getMsg());
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            result.setCode(ResultEnum.MethodArgumentTypeMismatchException.getCode());
            result.setMessage(ResultEnum.MethodArgumentTypeMismatchException.getMsg());
        } else if (e instanceof MultipartException) {
            result.setCode(ResultEnum.MultipartException.getCode());
            result.setMessage(ResultEnum.MultipartException.getMsg());
        } else if (e instanceof org.springframework.dao.DuplicateKeyException) {
            result.setCode(ResultEnum.DUPLICATE_ERROR.getCode());
            result.setMessage(ResultEnum.DUPLICATE_ERROR.getMsg());
        } else if (e instanceof org.springframework.dao.DataIntegrityViolationException) {
            result.setCode(ResultEnum.SQLException.getCode());
            result.setMessage(ResultEnum.SQLException.getMsg());
        } else if (e instanceof org.springframework.jdbc.BadSqlGrammarException) {
            result.setCode(ResultEnum.SQLException.getCode());
            result.setMessage(ResultEnum.SQLException.getMsg());
        } else if (e instanceof BindException) {
            result.setCode(ResultEnum.ERROR.getCode());
            result.setMessage(((BindException) e).getBindingResult().toString());
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            StringBuilder errorMsg = new StringBuilder();
            for (ConstraintViolation<?> violation : constraintViolations) {
                errorMsg.append(violation.getMessage()).append(",");
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            result.setCode(ResultEnum.ERROR.getCode());
            result.setMessage(errorMsg.toString());
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult1 = ((MethodArgumentNotValidException) e).getBindingResult();
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : bindingResult1.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage()).append(",");
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            result.setCode(ResultEnum.ERROR.getCode());
            result.setMessage(errorMsg.toString());
        } else if (e instanceof BusinessException) {
            BusinessException permissionsException = (BusinessException) e;
            result.setCode(permissionsException.getErrorCode());
            result.setMessage(permissionsException.getMessage());
        } else {
            result.setCode(ResultEnum.ERROR.getCode());
            result.setMessage(e.getMessage());
        }
        log.error("[errorMsg]:" + getStackTraceInfo(e));
        /*
        * e.toString()：  获得异常种类和错误信息
        * e.getMessage():获得错误信息
        * e.printStackTrace()：在控制台打印出异常种类，错误信息和出错位置等
        * */
        return result;
    }

    /**
     * 获取e.printStackTrace() 的具体信息，赋值给String 变量，并返回
     *
     * @param e Exception
     * @return e.printStackTrace() 中 的信息
     */
    public static String getStackTraceInfo(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);//将出错的栈信息输出到printWriter中
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (Exception ex) {
            return "获取e.printStackTrace()异常！";
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
    }

}

package com.mapersive.insuranceservice.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mapersive.insuranceservice.dtos.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerMapping;

/**
 *
 * @author ECHAFAI Nassreddine
 *
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Autowired
    private HttpServletRequest request;


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionDTO maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        ControllerExceptionHandler.LOG.error("unxpected error has happend ", e.getCause());
        ExceptionDTO exceptionDTO = this.initExceptionDTO(e, "Max Size Exceeded (20MB)", 400, "Bad Request");
        return exceptionDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDTO exception(Exception exception) {
        ControllerExceptionHandler.LOG.error("unxpected error has happend ", exception);
        ExceptionDTO exceptionDTO = this.initExceptionDTO(exception, "Internal Error", 500, "Internal Server error");
        return exceptionDTO;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @ExceptionHandler(FileNotSupportedException.class)
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    public ExceptionDTO authenticationException(FileNotSupportedException exception) {
        ControllerExceptionHandler.LOG.error("unxpected error has happend ", exception);
        ExceptionDTO exceptionDTO = this.initExceptionDTO(exception, exception.getMessage(), 403, "Forbidden");
        return exceptionDTO;
    }
    private ExceptionDTO initExceptionDTO(Exception e, String message, int status, String error) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(LocalDateTime.now().toString());
        exceptionDTO.setStatus(status);
        exceptionDTO.setError(error);
        String path = (String) this.request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        exceptionDTO.setPath(path);
        exceptionDTO.setMessage(message);

        return exceptionDTO;
    }
}
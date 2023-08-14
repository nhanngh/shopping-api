package com.demo.openfeign.controller;

import com.demo.openfeign.exception.BadRequestException;
import com.demo.openfeign.exception.CustomException;
import com.demo.openfeign.exception.NotFoundException;
import com.demo.openfeign.model.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionHandlers {
  private static final String ERROR_MESSAGE = "An error happened: ";

  @ExceptionHandler({NotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorResponse handleConflict(CustomException exception) {
    log.error(ERROR_MESSAGE, exception);
    return buildErrorResponse(exception);
  }

  @ExceptionHandler({BadRequestException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ErrorResponse handleBadRequest(CustomException exception) {
    log.error(ERROR_MESSAGE, exception);
    return buildErrorResponse(exception);
  }

  private ErrorResponse buildErrorResponse(CustomException exception) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(exception.getErrorCode().getCode());
    errorResponse.setMessage(exception.getMessage());
    return errorResponse;
  }
}


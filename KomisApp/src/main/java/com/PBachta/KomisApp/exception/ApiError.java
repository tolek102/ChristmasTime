package com.PBachta.KomisApp.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {

  private String statusCode;
  private HttpStatus status;
  private String message;
  private List<String> errors;


  public ApiError() {
    super();
  }

  public ApiError(final String statusCode, final HttpStatus status,
                  final String message, final List<String> errors) {
    super();
    this.statusCode = statusCode;
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public ApiError(final String statusCode, final HttpStatus status,
                  final String message, final String error) {
    super();
    this.statusCode = statusCode;
    this.status = status;
    this.message = message;
    errors = Arrays.asList(error);
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(final HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(final List<String> errors) {
    this.errors = errors;
  }

  public void setError(final String error) {
    errors = Arrays.asList(error);
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

}

package com.example.demo.model;

public class ErrorResponse {

  private String message;
  private String detailMessage;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetailMessage() {
    return detailMessage;
  }

  public void setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
  }

  public ErrorResponse(String message, String detailMessage) {
    super();
    this.message = message;
    this.detailMessage = detailMessage;
  }
}

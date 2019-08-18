package com.sombrainc.ffmpeg.enumeration;

public enum Status {
  SUCCESS("Operation %s was completed successfully"), FAILED("Operation %s was failed with status: %s");

  private String message;

  Status(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}

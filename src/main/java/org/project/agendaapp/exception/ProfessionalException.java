package org.project.agendaapp.exception;

import lombok.Getter;
import org.project.agendaapp.Enum.ErrorCode;

@Getter
public class ProfessionalException extends RuntimeException {
  private final ErrorCode errorCode;

  public ProfessionalException(String message) {
    super(message);
    this.errorCode = null;
  }

  public ProfessionalException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ProfessionalException(ErrorCode errorCode, String details) {
    super(errorCode.getMessage() + " : " + details);
    this.errorCode = errorCode;
  }
}

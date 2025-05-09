package org.project.agendaapp.exception;

import lombok.Getter;
import org.project.agendaapp.Enum.ErrorCode;

@Getter
public class TechnicalException extends RuntimeException {

        private final ErrorCode errorCode;

        public TechnicalException(String message){
            super(message);
            this.errorCode=null;
        }

        public TechnicalException(ErrorCode errorCode) {
            super(errorCode.getMessage());
            this.errorCode = errorCode;
        }

        public TechnicalException(ErrorCode errorCode, String details) {
            super(errorCode.getMessage()+":"+ details);
            this.errorCode = errorCode;
        }
}

package com.ndhuy.user.exceptions;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.annotation.Resource;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    private MessageSource messageSource;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleCustomRuntimeException(BadRequestException ex, Locale locale) {
        // Lấy thông điệp lỗi từ MessageSource
        String errorMessage = messageSource.getMessage("error." + ex.getErrorCode(), ex.getAr(), locale);

        // Trả về thông tin lỗi
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getErrorCode(), errorMessage));
    }

    // Lớp nội bộ cho cấu trúc phản hồi lỗi
    public static class ErrorResponse {
        private final String errorCode;
        private final String errorMessage;

        public ErrorResponse(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}

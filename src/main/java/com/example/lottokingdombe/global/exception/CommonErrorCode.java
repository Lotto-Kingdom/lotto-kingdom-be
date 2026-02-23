package com.example.lottokingdombe.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    INVALID_PARAMETER("C001", "Invalid parameter", 400),
    RESOURCE_NOT_FOUND("C002", "Resource not found", 404),
    INTERNAL_SERVER_ERROR("C003", "Internal server error", 500),
    UNAUTHORIZED("C004", "Unauthorized", 401),
    FORBIDDEN("C005", "Forbidden", 403),
    METHOD_NOT_ALLOWED("C006", "Method not allowed", 405),
    CONFLICT("C007", "Conflict", 409);

    private final String code;
    private final String message;
    private final int status;
}
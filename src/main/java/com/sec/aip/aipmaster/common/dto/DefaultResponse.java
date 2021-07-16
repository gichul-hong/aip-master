package com.sec.aip.aipmaster.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DefaultResponse<T> { 

    private AipResponseStatus status;
    private int responseCode;
    private String responseMessage;
    private T data;

    public DefaultResponse(final AipResponseStatus status, final String responseMessage) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> DefaultResponse<T> of(final AipResponseStatus status, final String responseMessage) {
        return of(status, responseMessage, null);
    }

    public static<T> DefaultResponse<T> of(final AipResponseStatus status, final String responseMessage, final T t) {
        return DefaultResponse.<T>builder()
                .data(t)
                .responseCode(status.getStatusCode())
                .responseMessage(status.getCode())
                .build();
    }
}
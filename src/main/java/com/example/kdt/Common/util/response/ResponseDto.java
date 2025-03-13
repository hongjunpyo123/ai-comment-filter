package com.example.kdt.Common.util.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto<T> {
    private HttpStatus status;
    private String message;
    private T danger_level, clean_up_message;

    public static <T> ResponseDto<T> response(HttpStatus status, String message, T data, T data2) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setStatus(status);
        responseDto.setMessage(message);
        responseDto.setDanger_level(data);
        responseDto.setClean_up_message(data2);
        return responseDto;
    }

}
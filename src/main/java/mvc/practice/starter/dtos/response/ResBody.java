package mvc.practice.starter.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2021/06/01
 * Copyright (C) 2021, Centum Factorial all rights reserved.
 */

@Getter
@Setter
public class ResBody {
    private Integer status;
    private String  code;
    private String  message;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime timestampKST;

    public ResBody(HttpStatus httpStatus, String message) {
        this.status = httpStatus.value();
        this.code = httpStatus.getReasonPhrase();
        this.message = message;
        this.timestampKST = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }
}

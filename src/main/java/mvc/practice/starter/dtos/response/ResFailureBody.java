package mvc.practice.starter.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2021/06/01
 * Copyright (C) 2021, Centum Factorial all rights reserved.
 */

@Getter
@Setter
@ToString
public class ResFailureBody extends ResBody {
    private String error;

    public ResFailureBody(HttpStatus httpStatus, String error, String message) {
        super(httpStatus, message);
        this.error = error;
    }
}

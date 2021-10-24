package mvc.practice.starter.exceptions;

import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Getter
public class BadRequestException extends RuntimeException {
    private ErrCode errCode;

    public BadRequestException(ErrCode errCode) {
        this.errCode = errCode;
    }
}

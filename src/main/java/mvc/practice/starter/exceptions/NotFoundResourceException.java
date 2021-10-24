package mvc.practice.starter.exceptions;

import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Getter
public class NotFoundResourceException extends RuntimeException {
    private ErrCode errCode;

    public NotFoundResourceException() {
        this.errCode = ErrCode.NOT_FOUND_RESOURCE;
    }
}

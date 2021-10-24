package mvc.practice.starter.exceptions;

import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Getter
public enum ErrCode {
    UN_KNOWN("E_0001"),
    NOT_FOUND_RESOURCE("E_0002");

    private final String code;

    ErrCode(String code) {
        this.code = code;
    }
}

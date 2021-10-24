package mvc.practice.starter.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mvc.practice.starter.dtos.response.ResFailureBody;
import mvc.practice.starter.exceptions.BadRequestException;
import mvc.practice.starter.exceptions.ErrCode;
import mvc.practice.starter.exceptions.NotFoundResourceException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    private final MessageSource messageSource;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResFailureBody handleException(HttpServletRequest request,
                                          final Exception e) {
        log.error(e.getMessage());

        Locale locale = new Locale(request.getParameter("locale"));
        ErrCode errCode = ErrCode.UN_KNOWN;
        String code = getMessage(errCode.getCode(), null, locale);
        String message = getMessage(errCode.getCode() + ".message", null, locale);
        return new ResFailureBody(HttpStatus.INTERNAL_SERVER_ERROR, code, message);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResFailureBody handleBadRequestException(HttpServletRequest request,
                                                    final BadRequestException e) {
        log.error(e.getMessage());

        Locale locale = new Locale(request.getParameter("locale"));
        ErrCode errCode = e.getErrCode();
        String code = getMessage(errCode.getCode(), null, locale);
        String message = getMessage(errCode.getCode() + ".message", null, locale);
        return new ResFailureBody(HttpStatus.BAD_REQUEST, code, message);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResFailureBody handleNotFoundException(HttpServletRequest request,
                                                  final NotFoundResourceException e) {
        log.error(e.getMessage());

        Locale locale = new Locale(request.getParameter("locale"));
        ErrCode errCode = e.getErrCode();
        String code = getMessage(errCode.getCode(), null, locale);
        String message = getMessage(errCode.getCode() + ".message", null, locale);
        return new ResFailureBody(HttpStatus.NOT_FOUND, code, message);
    }

    private String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }
}

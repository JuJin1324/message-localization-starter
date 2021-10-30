package mvc.practice.starter.controllers;

import mvc.practice.starter.controllers.api.UserApiController;
import mvc.practice.starter.exceptions.ErrCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Locale;
import java.util.TimeZone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@ImportAutoConfiguration
@ActiveProfiles("test")
@SpringBootTest
class UserApiControllerTest {
    private static final Long   NOT_FOUND_USER_KEY = 99999999L;
    private static final String LANG_KO            = "ko";
    private static final String LANG_EN            = "en";

    private        MockMvc mockMvc;
    private static String  notFoundResourceMessageKorean;
    private static String  notFoundResourceCodeKorean;
    private static String  notFoundResourceMessageEnglish;
    private static String  notFoundResourceCodeEnglish;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ExceptionController exceptionController;

    @BeforeEach
    void setUp(@Autowired UserApiController userApiController) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        mockMvc = MockMvcBuilders.standaloneSetup(userApiController)
                .setControllerAdvice(exceptionController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 한글 깨짐 처리
                .alwaysDo(print())
                .build();

        notFoundResourceMessageKorean = messageSource.getMessage(
                ErrCode.NOT_FOUND_RESOURCE.name() + ".message",
                null,
                Locale.KOREAN);
        notFoundResourceCodeKorean = messageSource.getMessage(
                ErrCode.NOT_FOUND_RESOURCE.name() + ".code",
                null,
                Locale.KOREAN);
        notFoundResourceMessageEnglish = messageSource.getMessage(
                ErrCode.NOT_FOUND_RESOURCE.name() + ".message",
                null,
                Locale.ENGLISH);
        notFoundResourceCodeEnglish = messageSource.getMessage(
                ErrCode.NOT_FOUND_RESOURCE.name() + ".code",
                null,
                Locale.ENGLISH);
    }

    @Test
    @DisplayName("[회원 단건 조회] 존재하지 않는 유저 처리 - 디폴트")
    void getSingleUser_whenExceptionOccurred_Default() throws Exception {
        reqGetSingleUser_notFound(NOT_FOUND_USER_KEY, null);
    }

    @Test
    @DisplayName("[회원 단건 조회] 존재하지 않는 유저 처리 - 한글")
    void getSingleUser_whenExceptionOccurred_KOREAN() throws Exception {
        reqGetSingleUser_notFound(NOT_FOUND_USER_KEY, LANG_KO);
    }

    @Test
    @DisplayName("[회원 단건 조회] 존재하지 않는 유저 처리 - 영어")
    void getSingleUser_whenExceptionOccurred_ENGLISH() throws Exception {
        reqGetSingleUser_notFound(NOT_FOUND_USER_KEY, LANG_EN);
    }

    private void reqGetSingleUser_notFound(Long userKey, String lang) throws Exception {
        String url = "/api/users/" + userKey;
        if (lang != null) {
            url += "?locale=" + lang;
        }
        mockMvc.perform(get(url))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(String.valueOf(HttpStatus.NOT_FOUND.value())))
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(
                        lang == null || lang.equals(LANG_KO) ? notFoundResourceMessageKorean : notFoundResourceMessageEnglish
                ))
                .andExpect(jsonPath("$.error").value(
                        lang == null || lang.equals(LANG_KO) ? notFoundResourceCodeKorean : notFoundResourceCodeEnglish
                ));
    }
}

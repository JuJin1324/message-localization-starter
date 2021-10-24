package mvc.practice.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class MessageLocalizationStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageLocalizationStarterApplication.class, args);
    }

}

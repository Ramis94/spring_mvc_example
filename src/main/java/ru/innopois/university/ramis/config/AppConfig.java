package ru.innopois.university.ramis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by innopolis on 03.11.16.
 */
@Configuration
@ComponentScan("ru.innopois.university.ramis")
@EnableWebMvc
@Import({SecurityConfig.class})
public class AppConfig {
}

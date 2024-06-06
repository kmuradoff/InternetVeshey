package ru.unn.internetveshey.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "carsharing.common")
public class CommonProperties {
    private String jwtSigningKey;
}
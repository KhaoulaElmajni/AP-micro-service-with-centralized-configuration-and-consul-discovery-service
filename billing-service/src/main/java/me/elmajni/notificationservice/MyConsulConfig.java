package me.elmajni.notificationservice;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class MyConsulConfig {
    private long accesTokenTimeOut;
    private long refreshTokenTimeOut;
}

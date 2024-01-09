package ie.atu.menums;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "ie.atu.menums")
public class FeignClientConfig {
}
package xxx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

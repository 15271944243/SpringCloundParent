package xxx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
public class Application {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

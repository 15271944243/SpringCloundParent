package xxx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
public class Application {
    // @LoadBalanced 就表示整合了ribbon
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

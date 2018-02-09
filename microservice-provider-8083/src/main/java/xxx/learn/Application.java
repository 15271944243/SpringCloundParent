package xxx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

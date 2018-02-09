package xxx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import ribbon.config.RibbonClientConfig;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
// 与下面的@LoadBalanced不同,这种方式就是自定义配置ribbon
/*@RibbonClients(value = {
        @RibbonClient(name = "microservice-provider",configuration = RibbonClientConfig.class)
})*/
@RibbonClient(name = "microservice-provider",configuration = RibbonClientConfig.class)
// 注意:@RibbonClient里面的配置类(就是RibbonClientConfig.class)是不能被Spring-boot启动程序扫描到的
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

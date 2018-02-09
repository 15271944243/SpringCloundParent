package xxx.fegin.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration1 {
    // 配置了这个,使用http访问时,就要使用feign的注解,如果不配置,用SpringMVC的注解就行了
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

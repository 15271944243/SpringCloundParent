package xxx.learn.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import xxx.fegin.config.Configuration1;
import xxx.learn.model.User;

// 注意:@FeignClient里面的配置类(Configuration1.class)是不能被Spring-boot启动程序扫描到的
@FeignClient(name = "microservice-provider",configuration = Configuration1.class)
public interface ConsumerFeignClient {

    @RequestLine("GET /user/{id}")
    public User findById(@Param("id") Integer id);

}

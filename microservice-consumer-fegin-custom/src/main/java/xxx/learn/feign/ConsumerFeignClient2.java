package xxx.learn.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xxx.fegin.config.Configuration2;

// 注意:@FeignClient里面的配置类(Configuration1.class)是不能被Spring-boot启动程序扫描到的
@FeignClient(name = "xxxxx",url = "http://localhost:8761/", configuration = Configuration2.class)
public interface ConsumerFeignClient2 {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}

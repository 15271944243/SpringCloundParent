package xxx.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxx.learn.feign.ConsumerFeignClient;
import xxx.learn.feign.ConsumerFeignClient2;
import xxx.learn.model.User;

@RestController
@RequestMapping("/consumerFeign")
public class ConsumerFeignController {

    @Autowired
    private ConsumerFeignClient consumerFeignClient;

    @Autowired
    private ConsumerFeignClient2 consumerFeignClient2;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id){
        return consumerFeignClient.findById(id);
    }

    @GetMapping("/eureka/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        return this.consumerFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}

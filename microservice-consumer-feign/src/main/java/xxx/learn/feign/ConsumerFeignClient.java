package xxx.learn.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xxx.learn.model.User;

@FeignClient("microservice-provider")
public interface ConsumerFeignClient {

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user);
}

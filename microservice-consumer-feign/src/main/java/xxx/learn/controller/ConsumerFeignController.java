package xxx.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxx.learn.feign.ConsumerFeignClient;
import xxx.learn.model.User;

@RestController
@RequestMapping("/consumerFeign")
public class ConsumerFeignController {

    @Autowired
    private ConsumerFeignClient consumerFeignClient;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id){
        return consumerFeignClient.findById(id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return consumerFeignClient.postUser(user);
    }
}

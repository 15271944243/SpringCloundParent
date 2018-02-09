package xxx.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xxx.learn.model.User;

@RestController
@RequestMapping("/consumerRibbon")
public class ConsumerRibbonController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id){
        // 这里把ip和端口换成spring.application.name
        return this.restTemplate.getForObject("http://microservice-provider/user/"+id,User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-two");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

        return "1";
    }
}

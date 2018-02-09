package xxx.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xxx.learn.model.User;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.findByIdUrl}")
    private String findByIdUrl;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id){
        return this.restTemplate.getForObject(this.findByIdUrl+id,User.class);
    }
}

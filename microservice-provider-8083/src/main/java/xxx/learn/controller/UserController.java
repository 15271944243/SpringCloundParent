package xxx.learn.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import xxx.learn.model.User;
import xxx.learn.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation(value = "获取全部用户对象列表",notes = "获取全部用户对象列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> findUserList(){
        return userService.findUserList();
    }

    @ApiOperation(value = "根据User的id来获取用户详细信息",notes = "根据User的id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "java.lang.Integer",paramType = "path")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @ApiOperation(value = "新增用户信息",notes = "新增用户信息")
    /*@ApiImplicitParams({
            @ApiImplicitParam(required = true,dataType = "xxx.learn.model.User")
    })*/
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user){
        return user;
    }

    @RequestMapping(value = "/eureka-instance",method = RequestMethod.GET)
    public String serviceUrl(){
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER",false);
        return instanceInfo.getHomePageUrl();
    }

    @RequestMapping(value = "/instance-info",method = RequestMethod.GET)
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}

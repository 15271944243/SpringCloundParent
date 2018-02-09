package xxx.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xxx.learn.dao.UserMapper;
import xxx.learn.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findUserList(){
        return userMapper.findUserList();
    }

    public User findUserById(Integer id){
        return userMapper.findUserById(id);
    }
}

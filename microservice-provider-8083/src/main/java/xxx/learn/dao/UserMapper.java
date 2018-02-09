package xxx.learn.dao;

import org.apache.ibatis.annotations.Mapper;
import xxx.learn.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> findUserList();

    public User findUserById(Integer id);
}

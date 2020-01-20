package name.xu.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import name.xu.entity.User;
import name.xu.mapper.UserMapper;
import name.xu.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsersWithoutAnnotation(String name) {
        return userMapper.getUsersWithoutAnnotation(name, "name");
    }

    @Override
    public List<User> getUsersWithAnnotation(String name) {
        return userMapper.getUsersWithoutAnnotation(name, "name");
    }

    @Override
    public List<User> getUsersWithMap(String name) {
        return userMapper.getGetUsersWithMap(name, "name");
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
    @Override
    public int insertUsers(List<User> users) {
        return userMapper.insertUsers(users);
    }

    /**
     * 插入多个,每个独立,一个失败不影响其他的
     */
    @Override
    public int insertUsersEachIndividual(List<User> users) {
        int i = 0;
        for (User user : users) {
            try {
                i += insertByNewTransaction(user);
            } catch (Exception e) {
                log.error("插入出错: {}", e.getMessage());
            }
        }
        return i;
    }

    /**
     * 在for循环中调用这个方法,通过
     * Propagation.REQUIRES_NEW 来创建一个新的事务,独立提交,独立回滚
     * 如果调用者当前有事务，就将事务挂起，重新开启事务。
     * 这样调用这个方法后，这个方法单独开启事务，每次执行完，单独提交，遇到异常单独回滚，外部方法收到抛出的异常并不处理就好，这样内外事务互不影响。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int insertByNewTransaction(User user) {
        return userMapper.insert(user);
    }
}

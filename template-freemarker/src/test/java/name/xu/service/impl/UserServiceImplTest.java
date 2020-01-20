package name.xu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import name.xu.Application;
import name.xu.entity.User;
import name.xu.service.UserService;

import java.util.List;

/**
 * @author Created by HuoXu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    // 回滚数据(spring3 里面用@Rollback(true))
    @Transactional
    public void getUsersWithAnnotation() {
        User user = new User();
        final String name = "zhangsan";
        user.setName(name);
        Assert.assertEquals(1, userService.insert(user));
        List<User> users = userService.getUsersWithAnnotation("zhang");
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(name, users.get(0).getName());
    }
}

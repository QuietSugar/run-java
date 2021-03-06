package name.xu.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import name.xu.Application;

import java.io.IOException;

/**
 * @author Created by HuoXu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class TemplateFtlMapperTest {
    @Autowired
    private DataModelMapper dataModelMapper;
    @Autowired
    private TemplateFtlMapper templateFtlMapper;

    /**
     * 插入模板和数据
     */
    @Test
    //@Ignore
    public void init() throws IOException {

    }
}

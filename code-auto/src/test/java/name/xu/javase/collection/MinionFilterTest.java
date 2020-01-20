package name.xu.javase.collection;

import org.junit.BeforeClass;
import org.junit.Test;
import name.xu.pojo.common.SimplestJavaData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Created by HuoXu
 */
public class MinionFilterTest {

    static ArrayList<SimplestJavaData> simplestJavaDatas;

    @BeforeClass
    public static void init() {
        Random random = new Random();
        simplestJavaDatas = new ArrayList<SimplestJavaData>() {
            {
                for (int i = 0; i < 20; i++) {
                    //随机
                    //int randomNumber = random.nextInt(10);
                    add(new SimplestJavaData(i, "name" + i));
                }
            }
        };
        Collections.shuffle(simplestJavaDatas);
    }

    @Test
    public void filter() {
        MinionFilter.filter(simplestJavaDatas);
    }
}

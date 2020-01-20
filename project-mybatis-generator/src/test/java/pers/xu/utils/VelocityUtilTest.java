package pers.xu.utils;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Created by HuoXu
 */
public class VelocityUtilTest {

    @Test
    public void gen2File() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("modelName","modelName");
        map.put("packageName","packageName");

        FileWriter out = new FileWriter("a.java");

        VelocityUtil.gen2File("template/Java.vm", map, out);

    }
}

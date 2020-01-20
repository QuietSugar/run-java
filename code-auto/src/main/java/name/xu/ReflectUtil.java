package name.xu;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 反射获取类的信息
 *
 * @author Created by HuoXu
 */
public class ReflectUtil {
    private static final Logger log = LoggerFactory.getLogger(ReflectUtil.class);

    /**
     * 生成一个JavaBean对象get部分代码，
     * 获取一个对象的全部属性
     * 打印信息，用于写代码
     *
     * 类别（type）：
     * 1 : String name = user.getName();
     * 2 :
     *
     * @param myClass 数据来源的类名
     * @param type    类别
     * @throws Exception 异常
     */
    public static void printJavaBeanGetCode(Class<?> myClass, int type) throws Exception {
        Method[] methods = myClass.getMethods();
        for (Method method : methods) {
            // 得到方法的名称
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                //获取get
                String getFunction = StringUtils.uncapitalize(myClass.getSimpleName()) + "." + methodName + "();";
                if (type == 1) {
                    // 得到方法的返回值类型的类类型
                    String returnType = method.getReturnType().getSimpleName();

                    String msg = returnType + " " + StringUtils.uncapitalize(methodName.replace("get", ""));
                    msg += " = " + getFunction;
                    log.debug(msg);
                } else if (type == 2) {
                    log.debug(getFunction);
                } else {
                    log.debug("未知类别....");
                }
            }
        }
    }

    /**
     * 生成一个JavaBean对象set部分代码，给一个对象全部属性赋值
     * 打印信息，用于写代码
     * 如果想实现自动赋值的功能，而不是生成代码，请使用BeanUtils.populate
     *
     * @param myClass  将要被赋值的类名
     * @param pojoName 数据来源对象名
     * @throws Exception
     */
    public static void printJavaBeanSetCode(Class<?> myClass, String pojoName) throws Exception {
        Method[] methods = myClass.getMethods();
        for (Method method : methods) {
            // 得到方法的名称
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                String msg = "";
                msg += StringUtils.uncapitalize(myClass.getSimpleName()) + "." + methodName + "(" + pojoName + ".get" + methodName.replace("set", "") + "());";
                log.debug(msg);
            }
        }
    }
}

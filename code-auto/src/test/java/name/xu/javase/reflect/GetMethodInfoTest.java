package name.xu.javase.reflect;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class GetMethodInfoTest {
    private static final Logger LOG = LoggerFactory.getLogger(GetMethodInfoTest.class);

    private static Class<?> stringUtilsClass;
    private static Class<?> userClass;

    static {
        String utilClassName = "org.apache.commons.lang3.StringUtils";
        String userClassName = "name.xu.model.User";
        try {
            userClass = Class.forName(userClassName);
            stringUtilsClass = Class.forName(utilClassName);
        } catch (ClassNotFoundException e) {
            LOG.error("加载类失败：", e);
        }
    }


    @Test
    public void main() throws Exception {
        ReflectUtil.printJavaBeanSetCode(userClass, "str");
        ReflectUtil.printJavaBeanGetCode(userClass, 2);
    }

    /**
     * 针对工具类的测试
     * 可以显示一些方法之类的
     *
     * @throws Exception 异常
     */
    @Test
    public void getAllMethodInfoByReflectTest1() throws Exception {
        //获取包括父类方法在内的所有方法
        ReflectUtil.getAllMethodInfoByReflect(stringUtilsClass);
        //获取本类自己的方法，不包括父类
        ReflectUtil.getMethodInfoByReflect(stringUtilsClass);
        //静态方法
        ReflectUtil.methodInfo(stringUtilsClass, null);
        //打印字段
        ReflectUtil.printFields(stringUtilsClass);
    }

    /**
     * 针对工具类的测试
     * 可以显示一些方法之类的
     *
     * @throws Exception 异常
     */
    @Test
    public void getAllMethodInfoByReflectTest() throws Exception {

        //静态方法
        ReflectUtil.methodInfo(Class.forName("org.apache.commons.lang3.StringUtils"), false);

    }
    //// 得到全部的参数类型
    //Class<?>[] parameterTypes = method.getParameterTypes();
    //
    ////Arrays.stream(parameterTypes).forEach(Class::getSimpleName);
    //String reduce = Arrays.stream(parameterTypes).map(i -> i.getSimpleName()).reduce(",", String::concat);
    //
    //
    //        log.debug("{} ({})",method.getName(),reduce);
    //
    ////System.out.print("(");
    ////for (int x = 0; x < param.length; x++) {// 循环输出每一方法的参数的类型
    ////    System.out.print(param[x].getSimpleName());
    ////    if (x < param.length - 1) {
    ////        System.out.print(",");
    ////    }
    ////}

    @Test
    public void aaaaa() throws Exception {
        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
                .reduce(new ArrayList<Integer>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

                                acc.add(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("BiFunction");
                                return acc;
                            }
                        }, new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                                System.out.println("BinaryOperator");
                                acc.addAll(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("--------");
                                return acc;
                            }
                        });
        System.out.println("accResult_: " + accResult_);

    }
}

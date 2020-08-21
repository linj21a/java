package Junit;

import Polymorphism.Cat;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试动物类cat，使用到了Junit工具。
 *
 * 我们以往的测试：
 * 通过新建一个类，创建main方法，创建对应的测试对象，一个一个方法的测试。要添加注释等。
 * 麻烦极了。
 *
 * 常见的测试Junit工具
 * 测试分类
 * 1、白盒测试——代码逻辑看得见。给输入，看输出是否符合预期的功能设计。
 * 2、黑盒测试——代码逻辑看不见。给输入，看输出输出是否符合预期的功能设计。
 *
 * junit工具是白盒测试。一般要求白盒测试。技术含量点。
 *
 * 要求的规范：
 * 1、命名规范，专属的测试包xxxx.xxx.xx.test，
 * 2、类名：要测试的类名+Test
 * 3、方法名：test+要测试带方法
 *
 * 一些测试技巧
 * 1、方法不要有参数和返回值。我们是测试而不应该添加这些东西。
 * 2、使用断言来比较预期的输出和真实的 输出
 * 3、一般不要在测试方法里面进行输出操作
 * 4、一些资源申请和关闭的操作。如果重复的话，可以创建init()和close()方法。使用的Junit注解——@before，@after
 * 该注解声明的方法一定会在对应的测试方法执行前后进行。
 *
 *
 *我们一般只看窗口是全绿色还是红色。红色代表测试失败有bug，绿色则通过。
 *
 * 工具Junit4
 *
 */

public class CatTest {
    public void init(){
        System.out.println("资源申请");
    }
    public void close(){
        System.out.println("资源关闭");
    }
    @Test
    public void testSayHello(){
        System.out.println("开始测试。。。");
        Cat cat = new Cat("狗子",3,"吃饭");
        //使用断言类来测试，参数：预期的输出，真实的输出
        Assert.assertEquals("吃饭",cat.getHobby());
        //cat.sayHello();

    }
}

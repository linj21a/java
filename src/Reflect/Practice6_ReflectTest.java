package Reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * 模拟电脑主机的程序扩展过程
 * 添加声卡、显卡、鼠标等插件过程。
 *
 * 电脑对外提供一个接口——Pic统一插件的方法——
 * 1、open
 * 2、close
 * 则只要插件都实现该接口，同时利用了反射创建对象实例的常用方法
 * 配置文件加Class.forName(String str);
 * 再通过构造器的方法创建实例。new Instance();
 *
 */

public class Practice6_ReflectTest {
    public static void main(String[]args) throws IOException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Practice6_MainBoard mainBoard = new Practice6_MainBoard();
        mainBoard.run();

        //添加插件。
        //1、早期做法：mainBoard.usePIC(new SoundCard());//添加声卡功能。
        //每次添加一个功能 ，都需要新创建一个实例对象，修改一次代码。


        //2、现在的做法
        File config = new File("MainBoard.properties");//当前目录
        boolean res = config.exists();
        while(!res){//文件不存在就创建。
            res = config.createNewFile();//配置文件不存在则创建
        }
        FileInputStream fileInputStream = new FileInputStream(config);//配置文件

        //使用键值对的形式来保存配置信息，加载配置信息
        Properties properties = new Properties();

        //将配置文件加载到该键值对集合里边
        properties.load(fileInputStream);

        //遍历配置文件，添加扩展功能。
        for(int x=0;x<properties.size();x++){
            String s = properties.getProperty("Property"+(x+1));//获取配置文件中添加的插件的包名加类名。
            //System.out.println(s);Property1=Reflect.Practice6_SoundCard注意，键值对文件里边没有双引号。
            Class<?>clazz = Class.forName(s);
            Constructor<?> constructor = clazz.getConstructor();//由于clazz.newInstance()方法过时了。我们这里默认反射获取其无参构造器。
            Practice6_PIC_Interface pic = (Practice6_PIC_Interface) constructor.newInstance();

            //使用扩展功能。
            mainBoard.usePIC(pic);
        }


    }
}

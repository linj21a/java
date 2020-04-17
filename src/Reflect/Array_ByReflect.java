package Reflect;


import java.lang.reflect.Array;

import static java.lang.reflect.Array.newInstance;//静态导入

/**
 * 使用反射机制动态创建数组并访问数组
 * java.lang.reflect包提供了一个Array类，使用Array类可以动态地创建和访问数组。
 * static newInstance(Class<?> componentType, int length)方法可创建数组。
 *  componentType用以指定数组的元素类型，length用以指定数组长度。该方法返回一个Object，可考虑使用强制转换。
 *
 * static native xxx getXxx(Object array, int index)方法可获取数组某一元素。
 *  array用以指定数组，index用以指定元素下标。xxx表示int和short等基本类型，若是引用类型的数组，则应去掉xxx。
 *
 * static native void setXxx(Object array, int index, xxx val)方法可为数组某一元素赋值。
 *  array用以指定数组，index用以指定要赋值的元素的下标，val为要赋的值。该方法同样返回一个Object，可考虑使用强制转换。
 *
 *
 *  Array类支持多维数组
 *
 * static Object newInstance(Class<?> componentType, int... dimensions)
 *
 * 备注：使用反射创建对象，效率较低
 *
 */

public class Array_ByReflect {
    public static void main(String[]args){
        String []array = (String[])newInstance(String.class,2);

        //set数组元素
        Array.set(array,0,"ABC");
        Array.set(array,1,"CBA");

        //get数组元素
        for(int i=0;i<array.length;i++){
            String str = (String)Array.get(array,i);//返回的是Object对象
            System.out.println(str);
        }

        //演示多维数组，数组的shape（4，5，4）三维
        Object thirdArr = Array.newInstance(int.class, 4, 5, 4);
        Object firstArr = Array.get(thirdArr, 3);//第一维度
        Array.set(firstArr, 2, new int[] {5, 6});//可以一次设置元素的值

        Object secArr = Array.get(firstArr, 4);//第二维度
        Array.set(secArr, 1, 2);
        Array.set(secArr, 3, 9);
        int[][][] strArr = (int[][][]) thirdArr;
        System.out.println(strArr[3][2][0]);
        System.out.println(strArr[3][2][1]);
        System.out.println(strArr[3][4][1]);
        System.out.println(strArr[3][4][3]);




    }
}
//1、什么是ArrayList
//ArrayList就是传说中的动态数组

//Array如果不是反射里边的Array，是不能动态分配空间的。
package java基础;

public class StringBufferLearn {
    public static void main(String[]args){
        //这样是错误的，没有这样的构造方法
        // StringBuffer str = "hello java, I like coding!";
        StringBuffer str = new StringBuffer("hello java, I like coding!");//这是可变字符串

        //替换hello
        str.replace(0,5,"java");
        System.out.println(str);
        str.reverse();//反向输出字符串
        System.out.println(str);

        //追加
        str.append(2);//可以是int，char，float,string，抽象类等。
        System.out.println(str);
        char [] chs = "python,l like too！".toCharArray();//可以对字面量使用toCharArray
        str.append(chs,8,6);//从chs的索引8开始加长度为6的字串上去。
        System.out.println(str);

        //替换使用setCharAt
        str.setCharAt(0,'#');//一次只能一个字符替换
        System.out.println(str);
        //删除使用delete或者deleteCharAt
        str.delete(0,8);
        System.out.println(str);
        str.deleteCharAt(6);
        System.out.println(str);

        //获取长度
        System.out.println(str.length());




    }
}

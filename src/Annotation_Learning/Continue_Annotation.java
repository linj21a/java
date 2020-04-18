package Annotation_Learning;

@interface Continue_Tags{//定义Continue_Tags注解

    Continue_Tag[] value();//定义为Continue_Tag注解的数组
}

@interface Continue_Tag{
    String con();//注解的常量
}
public class Continue_Annotation {
    @Continue_Tags({@Continue_Tag(con="hhh"),@Continue_Tag(con="jjj")})
    public void sayHell0(){
        System.out.println("展示多重注解的java7的写法，其实就相当于定义了两个注解，第一个注解其成员为一注解数组，第二个为该注解数组类型的注解");
    }
    @Continue_Tag(con="jj")
    public static void main(String[]args){
        new Continue_Annotation().sayHell0();
    }
}

package Lambda表达式;
//使用该注解保证标识该接口为函数式接口。
@FunctionalInterface
public interface Caculation {
    int caculationInt(int x, int y);//这是默认的抽象方法，如果不加声明
}


package Lambda表达式;


/**
 * 匿名内部类的弊端和好处：
 * 1、使用一个子类，省略了一个类的定义。
 * 2、写法复杂。
 *
 * Lambda表达式的好处：
 * 1、简化书写。
 * 2、更加关注于结果。
 *
 * Lambda的格式，以及满足Lambda表达式简化的条件：
 *
 * 标准格式：
 * 1、一些参数
 * 2、一个括号
 * 3、语句块
 *
 * 如()->{}
 *
 *
 */

public class Lambda02_BasicFormat {
    public static void main(String[] args) {
        new Lambda02_BasicFormat().canCook("我做的大米饭喔", new Lambda02_Cook() {
            @Override
            public void makeRice(String mess) {
                System.out.println(mess);
            }
        });

        new Lambda02_BasicFormat().canCook("我会做大米饭2",(String mess)-> System.out.println(mess));
        //IDEA还提示了简化：
        new Lambda02_BasicFormat().canCook("我会做大米饭3", System.out::println);

    }
    public void canCook(String mess,Lambda02_Cook cook){//有一个方法，其参数是包含一个函数式接口
        cook.makeRice(mess);
    }
}

package Stream流AndMethodFerence;

import classandobject.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Stream09_Reduce {
    public static void main(String[] args) {
        List<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("李四",30));
        personArrayList.add(new Person("王五",20));
        personArrayList.add(new Person("张三",40));
        personArrayList.add(new Person("田七",50));

        //第一种情况，reduce只有一个输入参数
         personArrayList.stream().reduce((new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person, Person person2) {
                return person.getAge()>person2.getAge()?person:person2;//返回年纪最大的person
            }
        })).ifPresent((p)-> System.out.println(p));


        //第二种情况，reduce有两个输入参数，用于构造一个新的流中元素，
        Person newPerson1 = personArrayList.stream().reduce(new Person("二蛋", 100), new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person, Person person2) {
                return person.getAge()>person2.getAge()?person:person2;//返回年纪最大的person,构建的person100大于田七50
            }
        });
        System.out.println(newPerson1.toString());
        Person newPerson2 = personArrayList.stream().reduce(new Person("二蛋", 10), new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person, Person person2) {
                return person.getAge()>person2.getAge()?person:person2;//返回年纪最大的person,构建的person100大于田七50
            }
        });
        System.out.println(newPerson2.toString());

        //第三种情况,三个参数，第一个参数指定返回类型，而第二种情况直接指定了person不能改变的。，
        // 第二个参数是累加器。其泛型参数的第一个看reduce要返回的类型，第二个则是流中数据的类型。
        //第三个参数则是BinaryOperator，其泛型参数都是返回值类型。
       Integer ageSum = personArrayList.stream().reduce(0,(sum,p2)->sum+=p2.getAge(),(sum1,sum2)->sum1+sum2);
        System.out.println(ageSum);
        Integer ageSum1 = personArrayList.parallelStream().reduce(0,(sum,p2)->sum+=p2.getAge(),(sum1,sum2)->sum1+sum2);
        System.out.println(ageSum1);

    }
}

package Stream流AndMethodFerence;

import classandobject.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect 是一个非常有用的终端操作，它可以将流中的元素转变成另外一个不同的对象，
 * 例如一个List，Set或Map。collect 接受入参为Collector（收集器），
 * 它由四个不同的操作组成：供应器（supplier）、累加器（accumulator）、组合器（combiner）和终止器（finisher）。
 *
 */

public class Stream07_Collect {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("李四",30));
        personList.add(new Person("王五",20));
        personList.add(new Person("张三",40));
        personList.add(new Person("田七",50));

        Stream<Person> stream = personList.stream();
        //先对集合的person进行过滤掉30以下的人
        List<Person> newPersonList = stream.filter((p)->p.getAge()>30).collect(Collectors.toList());
        System.out.println(newPersonList);

        Map<Integer, List<Person>> personsByAge = personList
                .stream()
                .collect(Collectors.groupingBy(Person::getAge)); // 以年龄为 key,进行分组

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        Double averageAge = personList
                .stream()
                .collect(Collectors.averagingInt(Person::getAge)); // 聚合出平均年龄

        System.out.println(averageAge);     // 35.0

    }
}

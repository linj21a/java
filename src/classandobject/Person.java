package classandobject;

import java.io.Serializable;

public class Person  implements Comparable<Person>, Serializable {//比较、序列化
    private static final long serialVersionUID = 123456788L;
    private String name;
    private  int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if(o == null)
            throw new NullPointerException("传入类型为空！");
        int temp = this.age- o.age;
        return temp==0?this.name.compareTo(o.name):temp;
    }
    @Override
    public boolean equals(Object o){
        System.out.println("重复元素"+this.name+"的hash值相同时比较内容调用equals方法");
        if(!(o instanceof Person))
            throw new ClassCastException("类型错误！");
        Person p = (Person)o;
        int temp = this.age-p.getAge();
        return temp == 0 && this.name.equals(p.getName());
    }
    @Override
    public int hashCode(){
        System.out.println("我的hashCode方式是调用name.hashCode"+this.name+"!!!");
        return this.name.hashCode();
    }
    public void show(){
        System.out.println("show方法,姓名："+name+"年龄:"+age);
    }
    public void say(String s){
        System.out.println(name+"说："+s);
    }



}

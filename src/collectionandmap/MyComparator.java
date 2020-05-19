package collectionandmap;

import classandobject.Person;

import java.util.Comparator;

public class MyComparator<T extends Person> implements Comparator<T> {//只能比较person
    @Override
    public int compare(T o1, T o2) {
        int temp = o1.getAge()-o2.getAge();
        return temp==0?o1.getName().compareTo(o2.getName()):temp;
    }
}

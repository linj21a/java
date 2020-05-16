package ComparatorClass;

import java.util.Comparator;

public class ComparatorDemo implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof String) || !(o2 instanceof String))
            throw new ClassCastException("不满足类型约束，类型错误");
        String s1 = (String)o1;
        String s2 = (String)o2;
        int temp = s1.length()-s2.length();

        return temp==0?s1.compareTo(s2):temp;
    }
}

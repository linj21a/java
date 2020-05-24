package CollectionDemoandArrays;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 展示如何将一个非同步集合转化为同步集合
 * 比如我们现在要存储的元素必须是重复的，查询快的
 * 使用了ArrayList，同时我们需要使用到多线程，那就需要同步
 *
 * 原理——给每个方法加上同一个锁，封装一个类来实现该集合类，引用其原来的方法，只不过加了锁而已
 * 这样我们就得到一个同步的集合类了。
 * 但是为了体现封装性和便捷使用，我们将其封装为一个工具类，对外提供接口即可。
 * 此时同步类变为一个内部类，创建一个api，用来转化的调用
 *
 * ——Collections工具类就是应用这个原理来实现的
 *      相关API——synchronizedSet(Set<T> s) ，synchronizedMap(Map<K,V> m)
 *      synchronizedCollection(Collection<T> c) synchronizedList(List<T> list)
 */
class MyToolClass{
    public static <T> TosynchronizedCollection<T> toSynchronizedList(List<T> list){
        if(list==null){
            throw new NullPointerException("传入的参数为null");
        }
        return new TosynchronizedCollection<T>(list);

    }
    //将下面的封装类定义为内部私有的类。
}

public class TosynchronizedCollection<T> implements List<T> {
    private List<T> list;
    private static final Object lock = new Object();
    public TosynchronizedCollection(List<T> l){
        this.list = l;
    }

    @Override
    public int size() {
        synchronized (lock){
            return list.size();
        }

    }

    @Override
    public boolean isEmpty() {
        synchronized (lock){
            return list.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (lock){
            return list.contains(o);
        }
    }

    @Override
    public Iterator<T> iterator() {
        synchronized (lock){
            return list.iterator();
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (lock){
            return list.toArray();
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        synchronized (lock){

            return list.toArray(a);
        }
    }

    @Override
    public boolean add(T t) {
        synchronized (lock){

            return list.add(t);
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

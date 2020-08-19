package dataStruct;
/**
 * 单链表实现同义哈希值的存储
 *
 * @param <T> 泛型参数
 */
public class MySingleLinkedList<T> {
    Node<T> head;

    {
        head = new Node<>(null, null, null);
    }

    public boolean insertDifferent(T value) {
        Node<T> p = head;
        while (p.next != null) {
            p = p.next;
            //System.out.println(p.data);
            if (p.data.equals(value))
                return false;
        }
        //p。next==null
        p.next = new Node<>(p, value, null);
        return true;
    }

    public T remove(T key) {

        Node<T> p = head;
        Node<T> temp;
        while (p.next != null) {
            p = p.next;
            if (p.data.equals(key)) {
                temp = p.next;
                p.prev.next = temp;
                if (temp != null)
                    temp.prev = p.prev;
                T e = p.data;
                p = null;//提示GC进行回收
                return e;
            }

        }
        return null;
    }

    /**
     * 单链表的结点
     *
     * @param <T> 泛型参数
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }
}


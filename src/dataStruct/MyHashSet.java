package dataStruct;

/**
 * 构造链地址法的散列表——HashSet
 * @param <T> 泛型参数
 */

public class MyHashSet<T>   {
    private SinglyList<T>[]Table;//散列表，采用单链表数组——实现同义词单链表对象数组
    private int count = 0;//元素个数
    private static final float LOAD_FACTOR = 0.75f;//装填因子

    /**
     * 创建指定容量的散列表（hashSet)
     * @param length 传入的哈希表的长度
     */
    public MyHashSet(int length){
        if(length<10)
            length = 10;
        this.Table = new SinglyList[length];//数组实现的单链表
        for(int i=0;i<length;i++){
            this.Table[i] = new SinglyList<T>();//创建空的单链表
        }

    }

    /**
     * 创建一个容量为16的hashSet
     */
    public MyHashSet(){
        this(16);//调用有参构造器，散列表的容量为16
    }

    /**
     * 构造器——将传入的对象数组变为散列表（hashSet）
     * @param values 对象数组
     */
    public MyHashSet(T[]values){
        this(values.length*4/3);
        //构造散列表，将values数组元素变为构造元素
        for (T value : values) {
            this.add(value);
        }
    }
    /**
     * 计算对应的key的对应散列表中的坐标，——使用除留取余法
     * @param x 要计算hashcode的对象x
     * @return 返回一个哈希值
     */
    private int hash(T x){
        int key = Math.abs(x.hashCode());
        //System.out.println(key+" "+key%(this.Table.length)+" "+this.Table.length);
        return key%(this.Table.length);
    }

    /**
     * 添加方法，参数为添加的元素
     * @param value 泛型参数、要插入的对象
     * @return 返回的是布尔型，是否插入成功
     */
    public boolean add(T value) {
       // System.out.println("开始插入");
        if(this.count>=this.Table.length*LOAD_FACTOR){//散列表如果满了就2倍扩充
            SinglyList<T>[]temp = this.Table;
            this.Table = new SinglyList[this.Table.length*2];
            for(int i=0;i<this.Table.length;i++){
                this.Table[i]=new SinglyList<T>();
            }
            this.count=0;
            for (SinglyList<T> tSinglyList : temp) {
                for (Node<T> p = tSinglyList.head.next; p != null; p = p.next) {
                    this.add(p.data);
                }
            }
        }
        boolean insert = this.Table[this.hash(value)].insertDifferent(value);
        if(insert){
            this.count++;
        }
       System.out.println("开始插入"+value.toString()+insert+"长度"+this.count+" "+(this.Table.length*LOAD_FACTOR));

        return insert;
    }

    /**
     * 删除哈希表中对映的key
     * @param key 要删除的对象
     * @return 返回删除的对象
     */
    public T remove(T key){
        T x = this.Table[this.hash(key)].remove(key);
        if(x!=null)
            this.count--;
        return x;
    }

    /**
     * 判断哈希表是否为空
     * @return 判断结果
     */
    public boolean isEmpty(){
        if(this.count==0)
            return true;
        return false;
    }

    /**
     * 返回哈希表的大小
     * @return size大小
     */
    public int size(){ return this.count; }

    /**
     * 添加一组数据
     * @param values 参数是数据数组
     */
    public void addAll(T[]values){}

    /**
     * 对象转化为字符串
     * @return 返回转化的字符串
     */
    @Override
    public String toString(){return (this.hashCode()+"——散列表的哈希值转化为string");}

    /**
     * 清空哈希表
     */
    public void clear(){
        for (SinglyList<T> tSinglyList : Table) {
            tSinglyList.head.next = null;
        }
    }
    public void show(){
        for (SinglyList<T> tSinglyList : this.Table) {
            if (tSinglyList.head.next != null) {
                Node<T> p = tSinglyList.head.next;
                while (p != null) {
                    System.out.println(p.data.toString());
                    p = p.next;
                }
            }
        }

    }
    public boolean get(int index){
        if(this.Table[index].head.next==null){
            return false ;
        }
        else{
            System.out.print(index+": ");
            Node<T> p= this.Table[index].head.next;
            while(p!=null){
                System.out.print(p.data.toString()+"->");
                p=p.next;
            }
            System.out.println();
            return true;
        }

    }

    /**
     * 单链表实现同义哈希值的存储
     * @param <T> 泛型参数
     */
    private  class SinglyList<T>{
         MyHashSet.Node<T> head;

        {
            head = new Node<>(null, null, null);
        }

        public boolean insertDifferent(T value){
            MyHashSet.Node<T> p=head;
            while(p.next!=null){
                p = p.next;
                //System.out.println(p.data);
                if(p.data.equals(value))
                    return false ;
            }
            //p。next==null
            p.next = new Node<>(p,value,null);
            return true;
        }
        public T remove(T key){

            MyHashSet.Node<T> p=head;
            MyHashSet.Node<T> temp;
            while(p.next!=null){
                p = p.next;
                if(p.data.equals(key)){
                    temp = p.next;
                    p.prev.next = temp;
                    if(temp!=null)
                        temp.prev = p.prev;
                    T e = p.data;
                    return e;
                }

            }
            return null;
        }


    }

    /**
     * 单链表的结点
     * @param <T> 泛型参数
     */
    private static class Node<T>{
        T data;
        MyHashSet.Node<T> next;
        MyHashSet.Node<T> prev;

        Node(MyHashSet.Node<T> prev, T element, MyHashSet.Node<T> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }

}

package dataStruct;

import java.util.Scanner;

/**
 * 邻接表\无向图、有向图、带权图实现
 */
public class GraphAdjList {
    private static final int MAXSIZE = 100;//默认最大顶点个数为100
    private int numVertexes;//顶点个数
    private int numEdges;//边数
    public boolean flag;//标记是否为无向图,java类里边默认初始化为true

    public VertexNode[] adjList;

    /**
     * 构造器
     * @param numVertexes 顶点个数
     * @param numEdges 边数
     */
    public GraphAdjList(int numVertexes,int numEdges,boolean flag) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        this.flag = flag;
        adjList = new VertexNode[MAXSIZE];//为了后面的插入
    }
    public void CreateALGraph(){
       // System.out.println("请输入顶点个数和边数：");
        Scanner input = new Scanner(System.in);
        String info = "无向图";
        if(!flag)
            info = "有向图";
        System.out.println("创建"+info+"，顶点个数："+this.numVertexes+"边数："+this.numEdges);
       // this.numVertexes = input.nextInt();
       // this.numVertexes = input.nextInt();
        System.out.println("开始输入顶点信息：");
        for(int i=0;i<this.numVertexes;i++){
            int data = input.nextInt();
            this.adjList[i] = new VertexNode(data,null);
        }
        System.out.println("开始输入边（vi，vj）的顶点序号和边上的权值w：");
        for(int k=0;k<this.numEdges;k++){
            int i=input.nextInt();
            int j=input.nextInt();//1 3 2,1 2 4
            int weight = input.nextInt();

            EdgeNode e = new EdgeNode(j, weight);
            e.next = this.adjList[i].firstEdge;//头插法,e节点指向原来头结点指向的地址
            this.adjList[i].firstEdge = e;//链接！

            if(flag){//如果是无向图
                e = new EdgeNode(i,weight);
                e.next = this.adjList[j].firstEdge;
                this.adjList[j].firstEdge = e;
            }

        }
        System.out.println("创建完成！");
    }
    public void displayALGraph(){
        for(int i=0;i<this.numVertexes;i++){
            if(adjList[i].firstEdge!=null){
                EdgeNode e = adjList[i].firstEdge;
                while(e!=null){
                    System.out.print("顶点："+this.adjList[i].data+"邻接顶点：");//打印顶点信息
                    System.out.println(e.adjvex+"权值："+e.weight);//打印该顶点其邻接顶点信息
                    e = e.next;
                }
            }
        }
    }
    static class VertexNode{//顶点结构
        int data;//顶点信息
        EdgeNode firstEdge;//边表头指针
        public VertexNode(int data,EdgeNode firstEdge){
            this.data = data;
            this.firstEdge = firstEdge;
        }
    }
    static class EdgeNode{//边表
        public int adjvex;//邻接顶点的下标
        public int weight;//权重
        public EdgeNode next;//链域，指向下一个邻接顶点
        public EdgeNode(int adjvex,int weight){
            this.adjvex = adjvex;
            this.weight = weight;
        }
    }
    public static void main(String[]args){
        GraphAdjList myGraph = new GraphAdjList(5,6,false);//创建5顶点6边的有向图
        myGraph.CreateALGraph();
        myGraph.displayALGraph();
    }
}

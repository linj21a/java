package dataStruct;

import java.util.Scanner;

/**
 * 分治法实现残缺棋盘的覆盖
 */
public class ChessBoard {
    public int tile =1;
    public int[][] board=new int[100][100];//棋盘

    /**
     *
     * @param tr  开始填充的位置 行下标
     * @param tc 开始填充的位置 列下标
     * @param dr 残缺格子的位置 行下标
     * @param dc 残缺格子的位置 列下标
     * @param size 棋盘的规模数，2^size
     */
    public void chessBoard(int tr,int tc,int dr,int dc,int size){
            if(size == 1)//问题规模如果是1，不需要填充
                return;
            int t = tile++;//三格板的编号
            int s = size / 2;//分割棋盘，如8*8——4*4——2*2
            //覆盖左上角棋盘
            if(dr < tr + s && dc < tc + s)
            {//残缺方格在左上角
                chessBoard(tr, tc, dr, dc, s);
            }
            else
            {//此部分无残缺方格，将右下角方格当成残缺方格
                board[tr + s - 1][tc + s - 1] = t;
                chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
            }

            //覆盖右上角棋盘
            if (dr < tr + s && dc >= tc + s)
            {//残缺方格在右上角
                chessBoard(tr, tc + s, dr, dc, s);
            }
            else
            {//此部分无残缺方格，将左下角方格当成残缺方格
                board[tr + s -1][tc + s] = t;
                chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
            }

            //覆盖左下角棋盘
            if (dr >= tr + s && dc < tc + s)
            {//残缺方格在左下角
                chessBoard(tr + s, tc, dr, dc, s);
            }
            else
            {//此部分无残缺方格，将右上角方格当成残缺方格
                board[tr + s][tc + s - 1] = t;
                chessBoard(tr + s, tc, tr + s, tc + s -1, s);
            }

            //覆盖右下角棋盘
            if (dr >= tr + s && dc >= tc + s)
            {//残缺方格在右下角
                chessBoard(tr + s, tc + s, dr, dc, s);
            }
            else
            {//此部分无残缺方格，将左上角方格当成残缺方格
                board[tr + s][tc + s] = t;
                chessBoard(tr + s, tc + s, tr +s, tc + s, s);
            }
    }
    public  void displayBoard(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.printf("%-4d",board[i][j]);//类似于C语言的printf函数。
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int tr = sc.nextInt();
        int tc = sc.nextInt();
        int dr = sc.nextInt();
        int dc = sc.nextInt();

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.chessBoard(tr,tc,dr,dc,size);
        chessBoard.displayBoard(size);
    }
}

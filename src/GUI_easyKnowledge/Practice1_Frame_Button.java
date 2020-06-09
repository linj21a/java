package GUI_easyKnowledge;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Practice1_Frame_Button {
    public static void main(String[]args) {
        Frame frame = new Frame("第二个窗口");
        //设置大小
        frame.setSize(500, 500);
        //出现的位置
        frame.setLocation(300, 300);
        //设置背景颜色
        frame.setBackground(Color.MAGENTA);//粉红
        //设置可见
        frame.setVisible(true);

        //设置布局
        frame.setLayout(new FlowLayout());//使用流式布局。

        //不设置关闭窗口的监听，是无法关闭的。但是最小化和最大化却可以。。。
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("现在关闭窗口。");
                //super.windowClosed(e);//这个函数体是空。
                System.exit(0);//退出虚拟机
            }
        });

        //添加按钮Button、也是一个类，有自己的一些方法。如监听器。
        Button but = new Button("exit");//默认是String label参数，实际内部会被封装为标签。所有的东西都被封装为组件。

        //可以设置按钮的大小
        //but.setSize(40,40);
        but.addActionListener(e -> System.out.println("通过退出按钮退出！"));
        //因为ActionListener只有一个抽象方法，所以是函数式接口。用lambda表达式。函数体语句又只有一句。

        //将该按钮添加到窗口。
        frame.add(but);

    }
}

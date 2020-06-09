package GUI_easyKnowledge;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 使用文本框文TextField
 * TextArea文本区域
 * 配合Frame与Button进行鼠标监听。
 * 或者键盘监听。
 */

public class Practice2_TestField_Frame_Button/* extends Frame*/ {
    private Frame frame;
    private TextField tf;

    public Practice2_TestField_Frame_Button() {
        init();//初始化一些配置信息。
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public TextField getTf() {
        return tf;
    }

    public void setTf(TextField tf) {
        this.tf = tf;
    }

    private void init() {
        frame = new Frame("演示文本框及按钮");
        frame.setLayout(new FlowLayout());
        //初始化出现的位置和窗口的大小
        frame.setBounds(300,300,500,400);
        frame.setVisible(true);
        //添加文本框。、
        tf = new TextField(10);//初始化列数。
        frame.add(tf);
        tf.setText("默认文本");
        Button button = new Button("enter");
        button.addActionListener(e -> System.out.println("文本框按钮！"));
        frame.add(button);
        //使得关闭按钮生效
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

    }
    public static void main(String[]args){
        Practice2_TestField_Frame_Button test = new Practice2_TestField_Frame_Button();
        System.out.println(test);

        //也就是说，在一些基本功能封装好了，我们不用写了。我们只需要关注我们需要丰富的功能身上即可。
    }

}

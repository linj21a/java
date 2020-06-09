package GUI_easyKnowledge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 鼠标监听。
 * public interface MouseListener
 * extends EventListener用于在组件上接收“有趣”鼠标事件（按下，释放，单击，输入和退出）的侦听器界面。
 * （要跟踪鼠标移动和鼠标拖动，请使用MouseMotionListener ）
 * 对处理鼠标事件感兴趣的类要么实现此接口（及其包含的所有方法），要么扩展抽象MouseAdapter类（仅覆盖感兴趣的方法）。
 *
 * 然后，使用组件的addMouseListener方法向组件注册从该类创建的侦听器对象。 按下鼠标，释放单击（按下并释放）时会生成鼠标事件。
 * 当鼠标光标进入或离开组件时，也会生成鼠标事件。 发生鼠标事件时，将调用侦听器对象中的相关方法，并将MouseEvent传递给它。
 *
 * 从以下版本开始：
 * 1.1
 *
 * 方法：
 * void mouseClicked​(MouseEvent e) 在组件上单击（按下并释放）鼠标按钮时调用。
 * void mouseEntered​(MouseEvent e) 鼠标进入组件时调用。
 * void mouseExited​(MouseEvent e) 鼠标退出组件时调用。
 * void mousePressed​(MouseEvent e) 在组件上按下鼠标按钮时调用。
 * void mouseReleased​(MouseEvent e) 在组件上释放鼠标按钮时调用。
 */
public class Practice2_MouseListener {
    public static void main(String[]ars){
        Frame frame = new JFrame("鼠标监控");
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        frame.setBounds(200,300,500,400);
        frame.setBackground(Color.blue);
        TextArea textArea = new TextArea();
        textArea.setBackground(Color.CYAN);
        textArea.setText("鼠标监控演示");
        frame.add(textArea);

        Button button = new Button("Demo");
        //添加鼠标监控器。
        button.addMouseListener(new MouseAdapter() {
            private int count=0;//记录点下来的次数。
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("鼠标拖动");
            }
            @Override
            public void mouseClicked(MouseEvent e){
               /* count++;
                System.out.println("鼠标点击！次数为"+count+"....");
                textArea.setText("点击"+count);*/
               //实际上e里边就封装了次数。
                count = e.getClickCount();//获取点击次数。
               // e.getPoint()//还能获取点击点的位置。等。
                if(count==2){
                    textArea.setText("双击！"+count);
                }//演示双击。
            }
            @Override
            public void mouseExited(MouseEvent e){
                System.out.println("鼠标退出了按钮的范围！");
                textArea.setText("鼠标退出了按钮的范围");
            }
            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println("鼠标进入了按钮的范围！");
                textArea.setText("鼠标进入了按钮的范围");
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.out.println("鼠标按下去了！");
                textArea.setText("鼠标按下去了！");
            }
            @Override
            public void mouseReleased(MouseEvent e){
                System.out.println("鼠标放开了！");
                textArea.setText("鼠标放开了！");
            }

        });
        //添加按钮
        frame.add(button);

        frame.setVisible(true);
    }

}

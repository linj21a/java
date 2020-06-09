package GUI_easyKnowledge;

import java.awt.*;
import java.awt.event.*;

/**
 * 学习如何对文本框进行键盘监控。
 * ——TextField.addKeyListener(new KeyAdapter(){
 * //@Override
 * public void KeyPressed(KeyEvent e){}
 * })
 *
 * 监听键盘
 * KeyEvent的继承体系
 * java.lang.Object
 * java.util.EventObject
 * java.awt.AWTEvent
 * java.awt.event.ComponentEvent
 * java.awt.event.InputEvent
 * java.awt.event.KeyEvent
 * 指示组件中发生击键的事件。
 * 当按下，释放或键入键时，该组件对象（例如文本字段）会生成此低级事件。
 * 该事件将传递给每个KeyListener或KeyAdapter对象，该对象使用组件的addKeyListener方法进行注册以接收此类事件。
 * （ KeyAdapter对象实现了KeyListener接口。）每个此类侦听器对象在事件发生时获取此KeyEvent 。
 *
 * 它将所有的键盘值都封装为了字面值。
 * public int getKeyLocation()
 * 返回发起此键事件的键的位置。 某些键在键盘上出现不止一次，例如左右移位键。 此外，某些键出现在数字小键盘上。
 * 这提供了区分这些键的方法。
 * 结果
 * 按下或释放的键的位置。 对于KEY_TYPED事件，始终返回KEY_LOCATION_UNKNOWN 。
 */

public class Practice3_TextField_Input {
    public static void main(String[]args){
        Frame frame = new Frame("键盘监听！");
        frame.setLayout(new FlowLayout());
        frame.setBounds(300,200,500,400);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        TextField tf = new TextField(30);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //监听键盘按下的类型。
                //只接受字母输入。其他不允许输入。
                int code = e.getKeyCode();
                if(!(code>=KeyEvent.VK_A&&code<=KeyEvent.VK_Z)){
                    System.out.println("你输入的是"+(char)code+"不是字母不能进来");
                    e.consume();//使用此事件，以便由发起该事件的源不以默认的方式处理。
                }//这里不分大小写

                //下面开始监控输入ctrl和enter才有效
               /* if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER){
                    System.out.println("ctrl+enter按下");
                }*/


            }
        });

        Button button = new Button("enter");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标按下");
            }
        });

        //button.addKeyListener(,,,);
        frame.add(tf);
        frame.add(button);

    }
}

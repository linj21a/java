package GUI_easyKnowledge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * 做一个小项目：实现文本框、按钮和文本区的布局画面
 * 然后在文本框中输入对应的目录，能够在文本区显示出目录下的内容。
 * <p>
 * 既可以点击按钮进行显示。也可以在文本框中按enter直接显示。
 * <p>
 * 然后在此基础上，添加菜单栏目。
 */

public class Practice4_ShowDirProgram1 {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private JFrame jFrame;
    private JButton button;
    private JTextArea jTextArea;
    private JTextField jTextField;

    public Practice4_ShowDirProgram1() {
        InitGui();//初始化界面
    }

    public static void main(String[] ars) {
        Practice4_ShowDirProgram1 practice4_showDirProgram1 = new Practice4_ShowDirProgram1();
        System.out.println(practice4_showDirProgram1);
    }

    private void InitGui() {
        //第一步，创建窗体
        jFrame = new JFrame("目录显示");
        jFrame.setLayout(new BorderLayout(2,1));
        jFrame.setBounds(200, 200, 500, 400);
        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        jFrame.setBackground(Color.LIGHT_GRAY);

        //第二步，创建相应的组件
        jTextField = new JTextField(20);
        jTextField.setSize(200, 20);
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showDir();
                }
            }
        });
        //1、jFrame.add(jTextField);
        //第一块画布
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));//上面是流式布局。
        jPanel2.setVisible(true);
        jPanel2.add(jTextField);

        //按钮
        button = new JButton("转到");
        button.setSize(30, 20);
        button.setBackground(Color.MAGENTA);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showDir();
            }
        });
        jPanel2.add(button);
        //文本区域
        jTextArea = new JTextArea();
        jTextArea.setBackground(Color.WHITE);
        jTextArea.setSize(400, 150);
        //第二块画布
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setVisible(true);
        jPanel1.add(jTextArea);

        //1、jFrame.add(button);
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayout(2,1));
        jPanel3.add(jPanel2);
        jPanel3.add(jPanel1);
        jFrame.add(jPanel3);
    }

    private void showDir() {
        String dir = jTextField.getText();
        File src_dir = new File(dir);
        showDir2(src_dir, jTextArea);
    }

    private void showDir2(File src, JTextArea j) {
        if (src.exists() && src.isDirectory()) {
            String[] dirs = src.list();
            if (dirs != null) {
                j.setText("");
                for (String s : dirs) {
                    j.append(s + LINE_SEPARATOR);
                }
            }
        }else{
            Dialog dialog = new JDialog(jFrame);
            dialog.setBounds(400,250,100,100);
            dialog.setVisible(true);
            dialog.setTitle("警告！");
            String text = "文件空或者不存在！";
            Label label = new Label();
            //label.setText("文件或者目录不存在！");//中文会乱码。。怎么办？
           // label.setFont(new Font("MS Song", Font.PLAIN, 9));//只能使用字体为MS song
            label.setText(text);
            label.setVisible(true);
            dialog.add(label);

        }
    }


}

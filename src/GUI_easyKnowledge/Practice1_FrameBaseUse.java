package GUI_easyKnowledge;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame
 * public class Frame
 * extends Window
 * implements MenuContainerFrame是一个带标题和边框的顶级窗口。
 * 框架的大小包括为边框指定的任何区域。 可以使用getInsets方法获得边界区域的尺寸，但是，由于这些尺寸与平台相关，
 * 因此在通过调用pack或show使框架可显示之前，无法获得有效的插入值。 由于边框区域包含在框架的整体尺寸中，
 * 边框有效地遮挡了框架的一部分，约束了可用于渲染的区域和/或将子组件显示到具有左上角位置(insets.left, insets.top) ，
 * 以及尺寸为width - (insets.left + insets.right) by height - (insets.top + insets.bottom) 。
 * 框架的默认布局是BorderLayout 。
 *
 * 帧可以具有其天然装饰品（即Frame和Titlebar ）断开与setUndecorated 。 这只能在框架不是displayable时完成 。
 * 在多屏幕环境中，你可以创建一个Frame通过构建不同的屏幕设备上Frame与Frame(GraphicsConfiguration)
 * 或Frame(String title, GraphicsConfiguration) 。 GraphicsConfiguration对象是目标屏幕设备的GraphicsConfiguration对象之一。
 *
 * 在桌面区域可以跨越多个物理屏幕设备的虚拟设备多屏幕环境中，所有配置的边界都相对于虚拟坐标系统。
 * 虚拟坐标系的原点位于主物理屏幕的左上角。 根据虚拟设备中主屏幕的位置，可以使用负坐标，如下图所示。
 *
 * 在这样的环境中，调用setLocation ，必须将虚拟坐标传递给此方法。 同样，调用getLocationOnScreen在Frame返回虚拟设备坐标。
 * 拨打getBounds一个方法GraphicsConfiguration找到它的起源在虚拟坐标系统相同。
 *
 * 以下代码将Frame的位置设置为（10,10）相对于相应GraphicsConfiguration的物理屏幕的GraphicsConfiguration 。
 * 如果不考虑GraphicsConfiguration的边界，则Frame位置将相对于虚拟坐标系设置为（10,10）并显示在主物理屏幕上，
 * 这可能与物理屏幕的物理屏幕不同。指定GraphicsConfiguration 。
 *
 *   Frame f = new Frame(GraphicsConfiguration gc);
 *       Rectangle bounds = gc.getBounds();
 *       f.setLocation(10 + bounds.x, 10 + bounds.y); 帧能够生成以下类型的WindowEvent ：
 *
 * WINDOW_OPENED
 * WINDOW_CLOSING ：
 * 如果程序在处理此事件时未显式隐藏或处置窗口，则取消窗口关闭操作。
 * WINDOW_CLOSED
 * WINDOW_ICONIFIED
 * WINDOW_ACTIVATED
 * WINDOW_DEACTIVATED
 * WINDOW_GAINED_FOCUS
 * WINDOW_LOST_FOCUS
 * WINDOW_STATE_CHANGED
 * 从以下版本开始：
 * 1.0
 */

public class Practice1_FrameBaseUse {
    public static void main(String[]args){
        Frame frame = new Frame("我的第一个窗口");
        //设置大小
        frame.setSize(500,500);
        //出现的位置
        frame.setLocation(300,300);
        //设置背景颜色
        frame.setBackground(Color.RED);//红色背景。
        //设置可见
        frame.setVisible(true);
        //设置布局管理器。frame默认是borderLayout，即边缘布局。要

        //不设置关闭窗口的监听，是无法关闭的。但是最小化和最大化却可以。。。
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("现在关闭窗口。");
              //super.windowClosed(e);//这个函数体是空。
                System.exit(0);//退出虚拟机
            }
        });
    }
}

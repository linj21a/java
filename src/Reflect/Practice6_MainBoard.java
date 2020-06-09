package Reflect;


/**
 * 主板
 */
public class Practice6_MainBoard {
    public Practice6_MainBoard() {}
    public void run(){
        System.out.println("Main Computer starts!");
    }
    public void usePIC(Practice6_PIC_Interface Pic){
        if(Pic!=null){
            Pic.open();//扩展功能开启
            Pic.close();//扩展功能关闭
        }else{//运行时异常一般不需要在函数处声明
            throw new RuntimeException("扩展功能失败，PIC is null！");
        }
    }

}

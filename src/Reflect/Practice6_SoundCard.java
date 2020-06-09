package Reflect;

/**
 * 声卡
 */

public class Practice6_SoundCard implements Practice6_PIC_Interface{
    @Override
    public void open() {
        System.out.println("SoundCard start！");
    }

    @Override
    public void close() {
        System.out.println("SoundCard .....close！");
    }
}

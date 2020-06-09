package Reflect;
/**
 * 对外提供的接口
 * 只要添加的插件实现该接口。那么只要修改配置文件同时添加类字节码文件到相应的目录
 * 就能扩展主板的功能。
 */

public interface Practice6_PIC_Interface {
    void open();
    void close();//默认抽象静态方法。
}

package Annotation_Learning;


//   @SuppressWarnings注解，

/**
 * Java 中的 @SuppressWarnings 注解指示被该注解修饰的程序元素
 * （以及该程序元素中的所有子元素）取消显示指定的编译器警告，
 * 且会一直作用于该程序元素的所有子元素。
 * 例如，使用 @SuppressWarnings 修饰某个类取消显示某个编译器警告，
 * 同时又修饰该类里的某个方法取消显示另一个编译器警告，那么该方法将会同时取消显示这两个编译器警告。
 *
 * @SuppressWarnings 注解主要用在取消一些编译器产生的警告对代码左侧行列的遮挡
 * <p>
 * 通常情况下，如果程序中使用没有泛型限制的集合将会引起编译器警告，为了避免这种编译器警告，可以使用 @SuppressWarnings 注解消除这些警告。
 * <p>
 * 注解的使用有以下三种：
 * 抑制单类型的警告：@SuppressWarnings("unchecked")
 * 抑制多类型的警告：@SuppressWarnings("unchecked","rawtypes")
 * 抑制所有类型的警告：@SuppressWarnings("unchecked")
 */


public class SuppressWarnings_Test {


    @Deprecated(since = "9", forRemoval = true)
    public String toString1() {
        System.out.println("这是过时的方法");
        return "被@SuppressWarnings注解抑制了。";
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        SuppressWarnings_Test test = new SuppressWarnings_Test();
        System.out.println(test.toString1());
    }
}

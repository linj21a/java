package classandobject;

class Base {
    public String toString() {
        return "override toString in Base";
    }

    public void foo() {
        System.out.println("foo method in Base");
    }
}

class Derived1 extends Base {
    public void foo() {
        System.out.println("foo method in Derived1");
    }
}

class Derived2 extends Base {
    public void foo() {
        System.out.println("foo method in Derived2");
    }
}

// possible consumer code
public class Demo_NeiCun {
    public static void main(String[] args) {
        Base ref = new Base();
        Base ref1 = new Derived1();
        Base ref2 = new Derived2();

        System.out.println(ref.equals(ref1));   // false, equals() method inherits from Object
        System.out.println(ref1.toString());    // "override toString in Base"
        System.out.println(ref2.toString());     // "override toString in Base"
        ref1.foo();         // "foo method in Derived1"
        ref2.foo();         // "foo method in Derived2"
    }
}

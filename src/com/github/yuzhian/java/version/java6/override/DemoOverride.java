package com.github.yuzhian.java.version.java6.override;

interface I {
    default void hi() {
        System.out.println("I: hi");
    }
}

abstract class AbsC {
    void hello() {
        System.out.println("AbsC: hello");
    }
}

class C extends AbsC implements I {

    @Override
    public void hi() {
        System.out.println("C: hi");
    }

    @Override
    void hello() {
        System.out.println("C: hello");
    }
}


/**
 * @author yuzhian
 */
public class DemoOverride {
    public static void main(String[] args) {
        new I() {
        }.hi();

        new AbsC() {
        }.hello();

        C c = new C();
        c.hello();
        c.hi();
    }
}
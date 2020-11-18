package com.github.yuzhian.java.version.java5.autoboxing;

/**
 * 自动拆装箱, 语法糖, 编译后通过 valueOf() 实现装箱, xxxValue() 实现拆箱.
 *
 * @author yuzhian
 */
public class DemoAutoboxing {
    public static void main(String[] args) {
        // autoboxing
        Byte _b = 127;
        Short _s = 32_767;
        Integer _i = 2_147_483_647;
        Long _l = 223_372_036_854_775_807L;
        Float _f = 1.2f;
        Double _d = 1.2d;
        Character _c = 'z';
        Boolean _bl = false;
        // unboxing
        byte b = _b;
        short s = _s;
        int i = _i;
        long l = _l;
        float f = _f;
        double d = _d;
        char c = _c;
        boolean bl = _bl;
    }
}

// public class DemoAutoboxing {
//     public static void main(String[] args) {
//         Byte _b = Byte.valueOf(127);
//         Short _s = Short.valueOf(32767);
//         Integer _i = Integer.valueOf(2147483647);
//         Long _l = Long.valueOf(223372036854775807L);
//         Float _f = Float.valueOf(1.2F);
//         Double _d = Double.valueOf(1.2D);
//         Character _c = Character.valueOf('z');
//         Boolean _bl = Boolean.valueOf(false);
//         byte b = _b.byteValue();
//         short s = _s.shortValue();
//         int i = _i.intValue();
//         long l = _l.longValue();
//         float f = _f.floatValue();
//         double d = _d.doubleValue();
//         char c = _c.charValue();
//         boolean bl = _bl.booleanValue();
//     }
// }

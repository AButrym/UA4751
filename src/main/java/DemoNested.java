public class DemoNested {
    private static int RATE = 12;

    static class A {
        static class C {
            private static int DAYS = 7;
            void foo() {
                System.out.println(RATE);
            }
        }
    }
    static class C {
        void foo() {
            System.out.println(A.C.DAYS);
        }
    }
}

class Main2 {
    static void main() {
        var o1 = new DemoNested.A();
        var o2 = new I.B();
        var o3 = new DemoNested.A.C();
        System.out.println(o3.getClass().getName());
        System.out.println(o3.getClass().getCanonicalName());
        System.out.println(o3.getClass().getSimpleName());
        class Local {}
        var o4 = new Local();

        var o5 = new I() {}; // Anonymous class

        class Anonymous implements I {} // Local class
        var o6 = new Anonymous();
        var o7 = new Anonymous();
    }

}

interface I {
    /*static*/ class B {}
}



public class Main {
    static void main() {
        Child child = new Child();
        child.describe();
    }
}


interface Granny {
    default void describe() {
        System.out.println("Granny");
    }
}

interface Mammy extends Granny {
    @Override
    default void describe() {
        System.out.println("Mammy");
    }
}

interface Daddy extends Granny {
    @Override
    default void describe() {
        Granny.super.describe();
    }
}

class Child implements Mammy, Daddy {
    @Override
    public void describe() {
        Daddy.super.describe();
        Mammy.super.describe();
    }
}

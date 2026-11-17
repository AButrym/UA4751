import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public sealed interface Result permits Success, Failure {
    default Result map(UnaryOperator<Object> op) {
        return switch (this) {
            case Success(Object value) -> new Success(op.apply(value));
            case Failure _ -> this;
        };
    }

    default Result ifSuccess(Consumer<Object> con) {
        if (this instanceof Success s) {
            con.accept(s.value());
        }
        return this;
    }

    default Result ifFailure(Consumer<Throwable> con) {
        if (this instanceof Failure f) {
            con.accept(f.exception());
        }
        return this;
    }
}

record Success(Object value) implements Result {
}

record Failure(Throwable exception) implements Result {
}

class Main1 {
    static void main() {
        process()
                .map(v -> v + " World")
                .ifSuccess(System.out::println)
                .ifFailure(e -> System.err.println(e.getMessage()));
    }

    static Result process() {
        if (new Random().nextBoolean()) {
            return new Success("Hello");
        } else {
            return new Failure(new IllegalArgumentException("Failed"));
        }
    }
}
package kyh.lectures.lecture12;

public interface LambdaInterfaces {
    @FunctionalInterface
    interface MyLambda {
        int func(int x, int y);
    }
}

package example1asynchronous;

import io.vertx.core.Handler;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Example1 {

    public static void main(String[] args) {
        add(5, 5, h -> System.out.println("result is: " + h));
    }

    /**
     * Asynchronous, everything happens in the same thread.
     */
    private static void add(int i, int j, Handler<Integer> handler) {
        int result = i + j;
        handler.handle(result);
    }

}

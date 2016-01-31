package example2eventbus;

import example2eventbus.verticles.Consumer;
import example2eventbus.verticles.Producer;
import io.vertx.core.Vertx;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Example2 {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Consumer("1"));
        vertx.deployVerticle(new Consumer("2"));
        vertx.deployVerticle(new Producer());

    }




}

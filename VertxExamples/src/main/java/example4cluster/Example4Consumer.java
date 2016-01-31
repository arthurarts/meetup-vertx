package example4cluster;

import example4cluster.verticles.Consumer;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Example4Consumer {

    public static void main(String[] args) {

        Vertx.clusteredVertx(new VertxOptions(), vertxAsyncResult -> {
            Vertx vertx = vertxAsyncResult.result();
            vertx.deployVerticle(new Consumer("Consumer 1"));
        });

    }

}

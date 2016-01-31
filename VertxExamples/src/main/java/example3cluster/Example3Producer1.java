package example3cluster;

import example3cluster.verticles.Producer;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Example3Producer1 {

    public static void main(String[] args) {

        Vertx.clusteredVertx(new VertxOptions(), vertxAsyncResult -> {
            Vertx vertx = vertxAsyncResult.result();
            vertx.deployVerticle(new Producer("Producer 1"));
        });

    }

}

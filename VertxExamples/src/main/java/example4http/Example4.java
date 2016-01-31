package example4http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * Created by Cesar Koot on 31-1-2016.
 */
public class Example4 extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Example4());
    }

    public void start() {
        vertx.createHttpServer().requestHandler(req ->
            req.response().end("It works!")
        ).listen(8080);
    }
}

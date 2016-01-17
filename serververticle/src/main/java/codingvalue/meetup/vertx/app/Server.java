package codingvalue.meetup.vertx.app;

import io.vertx.core.Vertx;
import codingvalue.meetup.vertx.verticles.HttpServerVerticle;

/**
 * Created by Cesar Koot on 17-1-2016.
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new HttpServerVerticle());
    }

}

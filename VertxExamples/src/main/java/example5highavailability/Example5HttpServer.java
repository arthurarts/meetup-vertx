package example5highavailability;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerResponse;

import java.lang.management.ManagementFactory;

/**
 * Created by Cesar Koot on 31-1-2016.
 */
public class Example5HttpServer extends AbstractVerticle {

    public static void main(String[] args) {

        // Was: Vertx.vertx().deployVerticle();

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertxAsyncResult ->
            vertxAsyncResult.result().deployVerticle(new Example5HttpServer(), new DeploymentOptions().setHa(true))
        );
    }

    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            System.out.println("Incoming request");
            HttpServerResponse response = req.response();
            String processName = ManagementFactory.getRuntimeMXBean().getName();
            response.end("Request served from " + processName);
        }).listen(8080);
    }
}

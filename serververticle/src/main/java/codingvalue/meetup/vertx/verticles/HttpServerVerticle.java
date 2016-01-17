package codingvalue.meetup.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

/**
 * Created by Cesar Koot on 17-1-2016.
 */
public class HttpServerVerticle extends AbstractVerticle {

    private HttpServer httpServer = null;

    @Override
    public void start() throws Exception {
        httpServer = vertx.createHttpServer();

        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {
                System.out.println("Incoming request!");

                HttpServerResponse response = request.response();
                response.setStatusCode(200);
                response.headers()
                        .add("Content-Length", String.valueOf(57))
                        .add("Content-Type", "text/html")
                ;
                response.write("I'm alive!");
                response.end();
            }
        });

        httpServer.listen(9999);
    }
}

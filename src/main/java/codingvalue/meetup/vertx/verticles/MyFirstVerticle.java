package codingvalue.meetup.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;

/**
 * @author Arthur Arts
 */

public class MyFirstVerticle extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        HttpClient httpClient = vertx.createHttpClient();

        for (int i = 0; i < 100; i++) {

            httpClient.getNow(9999, "192.168.178.16", "/", new Handler<HttpClientResponse>() {
                @Override
                public void handle(HttpClientResponse httpClientResponse) {
                    System.out.println("Response received");
                }
            });
        }

    }

}

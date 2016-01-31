package example4cluster.verticles;

import io.vertx.core.AbstractVerticle;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Producer extends AbstractVerticle {

    private String name;
    public Producer(String name) {
        this.name = name;
    }

    public void start() {
        vertx.setPeriodic(1000, aLong ->
                vertx.eventBus().publish("example3.eventbus", name + " is kind of awesome!"));
    }

}

package example2eventbus.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Producer extends AbstractVerticle {

    public void start() {

        EventBus eventBus = vertx.eventBus();
        eventBus.publish("example2.eventbus", "publish");
        eventBus.send("example2.eventbus", "send");

    }
}

package example2eventbus.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Producer extends AbstractVerticle {

    public void start() {

        EventBus eventBus = vertx.eventBus();
        eventBus.publish("example2.eventbus", new JsonObject().put("test","publish"));
        eventBus.send("example2.eventbus", new JsonObject().put("test","send"));

    }
}

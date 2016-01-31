package example2eventbus.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Consumer extends AbstractVerticle {

    private String name;
    public Consumer(String name) {
        this.name = name;
    }

    /**
     * This is a verticle. Its start() method will be called when deployed. The vertx instance is ready to be used
     * in this class.
     */
    public void start() {

        EventBus eventBus = vertx.eventBus();
        MessageConsumer<JsonObject> consumer = eventBus.consumer("example2.eventbus");
        consumer.handler(message -> System.out.println("Consumer " + name + " Received json: " + message.body()));

        /**
         * A Handler can also be passed to the consumer so you can reduce the above code to:
         * eventBus.consumer("myEventBus", message -> System.out.println("Received json: " + message.body()));
         */

    }

}

package example4cluster.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

/**
 * Created by Cesar Koot on 30-1-2016.
 */
public class Consumer extends AbstractVerticle {

    private String name;
    public Consumer(String name) {
        this.name = name;
    }

    public void start() {

        EventBus eventBus = vertx.eventBus();
        MessageConsumer<String> consumer = eventBus.consumer("example3.eventbus");
        consumer.handler(message -> System.out.println(message.body()));

    }

}

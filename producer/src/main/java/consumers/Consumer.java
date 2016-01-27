package consumers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Cesar Koot on 26-1-2016.
 */
@Slf4j
public class Consumer extends AbstractVerticle {

    private String consumerName;
    private String eventBus;

    public Consumer(String consumerName, String eventBus) {
        this.consumerName = consumerName;
        this.eventBus = eventBus;
    }

    @Override
    public void start(Future<Void> startFuture) {
        //Start listening on this address (just a string).
        vertx.eventBus().consumer(eventBus, message -> {
            log.info(consumerName + " received 1 message.body() : "
                    + message.body());
        });
    }

}

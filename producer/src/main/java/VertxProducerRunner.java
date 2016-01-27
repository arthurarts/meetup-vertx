import consumers.Consumer;
import io.vertx.core.AsyncResult;
import io.vertx.core.AsyncResultHandler;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import producers.StringProducer;

/**
 *
 *
 * Created by Cesar Koot on 26-1-2016.
 */
@Slf4j
public class VertxProducerRunner {

    public static void main(String[] args) throws InterruptedException {

        //Define a vertx event bus.
        String eventBus = "vertxmeetup";

        //Create the Vertx instance.
        Vertx vertx = Vertx.vertx();

        //Two listeners on our eventbus.
        vertx.deployVerticle(new Consumer("First consumer", eventBus));
        vertx.deployVerticle(new Consumer("Second consumer", eventBus));

        //Check it against http://dictionary-api.cambridge.org/api/resources#java

        for (int i = 0; i < 10; i++) {

            //Let a producer fire a message.
            StringProducer stringProducer = new StringProducer(eventBus);

            vertx.deployVerticle(stringProducer, new AsyncResultHandler<String>() {

                    //If deployment succeeded then undeploy it again.
                    @Override
                    public void handle(AsyncResult<String> stringAsyncResult) {
                        if (stringAsyncResult.succeeded()) {
                            String deploymentId = stringAsyncResult.result();
                            vertx.undeploy(deploymentId);
                            log.info(deploymentId); //doesn't work?
                        } else {
                            log.error("deployment not succeeded"); //doesn't work?
                        }
                    }

            });

        }

        log.info("---> finished!");
    }

}

package producers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.util.Random;

/**
 * Created by Cesar Koot on 26-1-2016.
 */
public class StringProducer extends AbstractVerticle {

    private String eventBus;

    public StringProducer(String eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().send(eventBus, createNewWord());
    }

    private String createNewWord() {
        Random random = new Random();
        char[] word = new char[random.nextInt(8)+3]; // Words of length 3 to 10.
        for(int j = 0; j < word.length; j++)
        {
            word[j] = (char)('a' + random.nextInt(26));
        }
        return new String(word);
    }


}

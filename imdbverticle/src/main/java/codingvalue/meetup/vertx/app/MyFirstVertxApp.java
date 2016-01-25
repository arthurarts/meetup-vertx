package codingvalue.meetup.vertx.app;

import codingvalue.meetup.vertx.verticles.MyFirstVerticle;
import io.vertx.core.Vertx;

/**
 * The Vertx instance by itself doesn't do much except all the thread management, creating an event bus etc.
 * which are all communication and infrastructure tasks.
 * In order to get the application to do something useful,
 * you need to deploy one or more verticles (component) inside the Vertx instance.
 */
public class MyFirstVertxApp {

    public static void main(String[] args) {

        /* The Vertx instance creates a number of threads internally to handle the exchange of messages between verticles.
         * These threads are not daemon threads, so they prevent the JVM from shutting down,
         * even if the main thread creating the Vertx instance terminates. */
        Vertx vertx = Vertx.vertx();

        /** Once you have created a verticle you need to deploy it to the Vertx instance.
         *  You deploy a verticle using one of the deployVerticle() methods on the Vertx instance.*/
        vertx.deployVerticle(new MyFirstVerticle());


    }

}

package org.jade;

import jade.core.Agent;

public class App extends Agent {

    @Override
    protected void setup() {
        System.out.println("Main-Container Id: " + getAID().getName());
    }

}
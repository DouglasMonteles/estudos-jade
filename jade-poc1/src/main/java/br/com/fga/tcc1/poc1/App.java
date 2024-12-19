package br.com.fga.tcc1.poc1;

import jade.core.Agent;

import java.io.Serial;

public class App extends Agent {

    @Serial
    private static final long serialVersionUID = -3926629846981685094L;

    @Override
    protected void setup() {
        System.out.println("Main-Container Id: " + getAID().getName());
    }

}
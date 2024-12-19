package org.jade.agents.behaviour;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MeuComportamento extends Behaviour {

    int i = 0;

    public MeuComportamento(Agent agent) {
        super(agent);
    }

    @Override
    public void action() {
        System.out.println("* Olá mundo! Meu nome é " + myAgent.getLocalName());
        System.out.println("i = " + i);
        i = i + 1;
    }

    @Override
    public boolean done() {
        // Caso este método retorne TRUE o comportamento será finalizado
        return i > 3;
    }

}

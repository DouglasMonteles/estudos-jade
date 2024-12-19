package org.jade.agents;

import jade.core.Agent;
import org.jade.agents.behaviour.MeuComportamento;

public class MeuAgente extends Agent {

    @Override
    protected void setup() {
        System.out.println("Olá, eu sou um agente.");
        System.out.println("Estou disparando o comportamento...");

        addBehaviour(new MeuComportamento(this));
    }
}

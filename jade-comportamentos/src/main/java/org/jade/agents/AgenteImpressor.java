package org.jade.agents;

import jade.core.Agent;
import org.jade.agents.behaviour.ImprimeFrase;

public class AgenteImpressor extends Agent {

    @Override
    protected void setup() {
        Object[] args = getArguments();

        if (args != null && args.length > 0) {
            System.out.println("Olá! Eu sou um agente impressor!");
            System.out.println("# Vou executar meu comportamento");

            Long valor = Long.parseLong((String) args[0]);
            addBehaviour(new ImprimeFrase(this, valor));
        } else {
            System.out.println("Você não passou os argumentos!");
        }
    }
}

package org.jade.agents.behaviour;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class ImprimeFrase extends Behaviour {

    private Long delay;

    private long tempoInicial = System.currentTimeMillis();

    private int numExecucao = 1;

    public ImprimeFrase(Agent agent, Long delay) {
        super(agent);
        this.delay = delay;
    }


    @Override
    public void action() {
        // Aguarda a finalização do action() para bloquear a execução
        block(delay);
        System.out.println("# Tempo " + (System.currentTimeMillis() - tempoInicial)
            + ": Meu nome é " + myAgent.getLocalName());

        numExecucao = numExecucao + 1;
    }

    @Override
    public boolean done() {
        return numExecucao > 10;
    }

    @Override
    public int onEnd() {
        System.out.println(myAgent.getLocalName() + ": Meu comportamento foi finalizado! Até mais...");
        return 0;
    }
}

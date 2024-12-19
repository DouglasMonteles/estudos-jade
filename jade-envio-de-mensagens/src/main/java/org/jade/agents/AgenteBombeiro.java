package org.jade.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.Serial;

public class AgenteBombeiro extends Agent {

    @Serial
    private static final long serialVersionUID = -2985123899726599150L;

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    String content = msg.getContent();

                    if (content.equalsIgnoreCase("Fogo")) {
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent("Recebi seu aviso! Obrigado por auxiliar meu serviço");
                        myAgent.send(reply);

                        System.out.println("O agente " + msg.getSender().getName()
                            + " avisou de um incêncio");

                        System.out.println("Vou ativar os procedimentos de combate ao incêndio");
                    }
                } else {
                    // interrompe esse comportamento até que chegue uma nova mensagem
                    block();
                }
            }
        });
    }
}

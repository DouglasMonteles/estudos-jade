package org.jade.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.Serial;

public class AgenteAlarmado extends Agent {

    @Serial
    private static final long serialVersionUID = 8579651735480411512L;

    @Override
    protected void setup() {
        addBehaviour(new OneShotBehaviour(this) {
            @Serial
            private static final long serialVersionUID = 1517862529142005698L;

            @Override
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);

                msg.setOntology("Emergência");
                msg.setLanguage("Português");
                msg.addReceiver(new AID("Bombeiro", AID.ISLOCALNAME));
                msg.setContent("Fogo");

                myAgent.send(msg);
            }
        });

        addBehaviour(new CyclicBehaviour() {
            @Serial
            private static final long serialVersionUID = -5281094867588217510L;

            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    String content = msg.getContent();
                    System.out.println("--> " + msg.getSender().getName()
                            + ": " + content);
                } else {
                    // Com o block() bloqueamos o comportamento até que uma nova
                    // mensagem chegue ao agente e assim evitamos consumir ciclos
                    // da CPU.
                    block();
                }
            }
        });
    }

}

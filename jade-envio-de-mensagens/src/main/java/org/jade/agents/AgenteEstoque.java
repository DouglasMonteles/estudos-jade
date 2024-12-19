package org.jade.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import org.jade.models.Musicos;

import java.io.IOException;
import java.io.Serial;

public class AgenteEstoque extends Agent {
    @Serial
    private static final long serialVersionUID = -4687381299017897907L;

    private Musicos[] musicos = new Musicos[5];

    @Override
    protected void setup() {

        musicos[0] = new Musicos("Cláudia Leite", 30, "Babado Novo");
        musicos[1] = new Musicos("Paula Toller" , 45 , "Kid Abelha");
        musicos[2] = new Musicos("Rogério Flausino" , 37 , "Jota Quest");
        musicos[3] = new Musicos("Laura Pausini" , 33 , null);
        musicos[4] = new Musicos("Bono Vox" , 47 , "U2");

        addBehaviour(new SimpleBehaviour() {
            @Serial
            private static final long serialVersionUID = -1275046739627241181L;

            private int count = 0;

            @Override
            public void action() {
                try {
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);

                    msg.addReceiver(new AID("Contador", AID.ISLOCALNAME));
                    msg.setContentObject(musicos[count]);

                    myAgent.send(msg);
                    count++;
                } catch (IOException e) {
                    System.out.println("Erro no envio da mensagem: " + e.getMessage());
                }
            }

            @Override
            public boolean done() {
                if (count > 4) {
                    count = 0;
                    myAgent.doDelete();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("Todas as informações foram enviadas");
    }
}

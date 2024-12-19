package org.jade.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.jade.models.Musicos;

import java.io.Serial;

public class AgenteContador extends Agent {
    @Serial
    private static final long serialVersionUID = 8216248987980590788L;

    @Override
    protected void setup() {
        System.out.println("Agente contador inicializado.\n" +
                "Aguardando informações...");

        addBehaviour(new CyclicBehaviour(this) {
            @Serial
            private static final long serialVersionUID = -4873354547109083417L;

            private Musicos[] musicos = new Musicos[5];

            private int count = 0;

            @Override
            public void action() {
                ACLMessage msg = receive();

                if (count >= 5) {
                    count = 0;
                }

                if (msg != null) {
                    try {
                        musicos[count] = (Musicos) msg.getContentObject();
                        musicos[count].imprimir();
                        count++;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index maior que o tamanho do vetor. " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro no recebimento da mensagem: " + e.getMessage());
                        count = 0;
                    }
                }
            }
        });
    }
}

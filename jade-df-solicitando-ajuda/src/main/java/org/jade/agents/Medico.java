package org.jade.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.io.Serial;

public class Medico extends Agent {

    @Serial
    private static final long serialVersionUID = -5643350535092069063L;

    @Override
    protected void setup() {
        ServiceDescription sd = new ServiceDescription();
        sd.setType("salva vidas");
        sd.setName(this.getLocalName());

        registrarServico(sd);
        receberMensagens("doente", "Vou salvar o doente");
    }

    protected void registrarServico(ServiceDescription sd) {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }

    protected void receberMensagens(final String mensagem, final String resposta) {
        addBehaviour(new CyclicBehaviour() {
            @Serial
            private static final long serialVersionUID = -6798726141889684953L;

            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    if (msg.getContent().equalsIgnoreCase(mensagem)) {
                        ACLMessage reply = msg.createReply();
                        reply.setContent(resposta);
                        myAgent.send(reply);
                    }
                } else {
                    block();
                }
            }
        });
    }
}

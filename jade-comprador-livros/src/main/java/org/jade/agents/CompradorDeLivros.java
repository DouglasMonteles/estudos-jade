/*
* Livro: Manual Complementar do Projeto de Pesquisa: Sistemas Multiagentes na Construção de um Middleware para Suporte a Ambientes Computacionais
* Código 2.3: CompradorDeLivros.java
* Passando informações a um agente
* */

package org.jade.agents;

import jade.core.Agent;

import java.util.Arrays;

public class CompradorDeLivros extends Agent {

    private String livrosComprar;

    @Override
    protected void setup() {
        // Imprime mensagem de Bem-Vindo
        System.out.println("Olá, eu sou o agente comprador " + getLocalName()
                + " e estou pronto para comprar!");

        Object[] args = getArguments();

        // Finaliza o agente (if earlier)
        if (args == null || args.length == 0) {
            System.out.println("[" + getAID().getLocalName() + "] - Não há livros para serem comprados!");

            // invoca a execução do metodo TakeDown()
            doDelete();
            return;
        }

        livrosComprar = (String) args[0];
        System.out.println("[" + getAID().getLocalName() + "] - Pretendo comprar o livro: " + livrosComprar);
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente comprador " + getAID().getName() + " foi finalizado!");
    }
}

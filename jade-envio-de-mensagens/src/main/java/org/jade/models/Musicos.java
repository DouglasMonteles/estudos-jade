package org.jade.models;

import java.io.Serial;
import java.io.Serializable;

public class Musicos  implements Serializable {

    @Serial
    private static final long serialVersionUID = 7278374746816246748L;

    private String nome;

    private Integer idade;

    private String banda;

    public Musicos() {
    }

    public Musicos(String nome, Integer idade, String banda) {
        this.nome = nome;
        this.idade = idade;
        this.banda = banda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public void imprimir() {
        System.out.println("-----------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Banda: " + banda);
        System.out.println("-----------------------");
    }

    @Override
    public String toString() {
        return "Musicos{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", banda='" + banda + '\'' +
                '}';
    }
}

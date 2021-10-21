package br.com.minhaempresa.domain;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {

    private static long serialVersionUID = 1L;

    public Cliente(){
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id;

    @Column(name="nome_cliente", length=150, unique=true)
    private String nome;
    private String sobrenome;

    public Cliente(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            System.out.println("Nome do cliente inválido");
        } else {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }

    public int getIdentificador() {
        return id;
    }

    public void setIdentificador(String identificador) {
        this.id = id;
    }
}

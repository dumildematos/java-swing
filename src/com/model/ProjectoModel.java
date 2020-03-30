/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

/**
 *
 * @author dumildematos
 */
public class ProjectoModel {
    
    private int idprojecto;
    private String nome;
    private int dificuldade;
    private int inovacao;
    private int nota_final;
    private int aluno_idaluno;

    public int getIdprojecto() {
        return idprojecto;
    }

    public void setIdprojecto(int idprojecto) {
        this.idprojecto = idprojecto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getInovacao() {
        return inovacao;
    }

    public void setInovacao(int inovacao) {
        this.inovacao = inovacao;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    public int getAluno_idaluno() {
        return aluno_idaluno;
    }

    public void setAluno_idaluno(int aluno_idaluno) {
        this.aluno_idaluno = aluno_idaluno;
    }
    
    
    
}

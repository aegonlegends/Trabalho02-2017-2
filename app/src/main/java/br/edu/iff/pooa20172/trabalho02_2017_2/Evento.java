package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

public class Evento {
    private String nome, local, promotor, patrocinio;
    private int dia, mes, ano, capacidade;
    private float valorIngresso;

    public Evento(String nome, String local, int dia, int mes, int ano) {
        this.nome = nome;
        this.local = local;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
        public Evento(String nome, String local, int dia, int mes, int ano, int capacidade, String promotor, String patrocinio, float valorIngresso) {
        this.nome = nome;
        this.local = local;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.capacidade = capacidade;
        this.promotor = promotor;
        this.patrocinio = patrocinio;
        this.valorIngresso = valorIngresso;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("local", local);
        bundle.putString("promotor", promotor);
        bundle.putString("patrocinio", patrocinio);

        bundle.putInt("dia", dia);
        bundle.putInt("mes", mes);
        bundle.putInt("ano", ano);
        bundle.putInt("capacidade", capacidade);

        bundle.putFloat("valorIngresso", valorIngresso);

        return bundle;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getPromotor() {
        return promotor;
    }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }

    public String getPatrocinio() {
        return patrocinio;
    }

    public void setPatrocinio(String patrocinio) {
        this.patrocinio = patrocinio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(float valorIngresso) {
        this.valorIngresso = valorIngresso;
    }


}

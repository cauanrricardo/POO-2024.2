package application;

import java.util.*;

class Pessoa{
    private String nome;
    private double mass;
    private Planeta p;
  
    Pessoa(String nome, double mass, Planeta p){
      this.nome = nome;
      this.mass = mass;
      this.p = p;
    }
  
    public double massaEquivalente(Planeta otherPlanet){
      System.out.printf("A forca gravitacional no planeta %s é %.2f\n", otherPlanet, otherPlanet.forcaGravitacional());
     return otherPlanet.pesoSuperficie(mass);
    }
  
    public String toString(){
      return "nome: " + nome + " mass: " + String.format("%.2f", mass) + " planeta: " + p;
    }
  
  }
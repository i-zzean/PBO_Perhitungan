package com.example.demo;

import jakarta.persistence.*;


@Entity
@Table(name = "perhitungan")
public class Perhitungan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoperasi")
    private Long idOperasi;

    @Column(name = "bilangan1")
    private float bilangan1;

    @Column(name = "bilangan2")
    private float bilangan2;

    @Column(name = "operator")
    private char operator;


    public Long getIdOperasi(){
        return idOperasi;
    }

    public void setIdOperasi(Long idOperasi){
        this.idOperasi = idOperasi;
    }

    public float getBilangan1() {
        return bilangan1;
    }
    
    public void setBilangan1(float bilangan1) {
        this.bilangan1 = bilangan1;
    }
    
    
    public float getBilangan2() {
        return bilangan2;
    }

    public void setBilangan2(float bilangan2) {
        this.bilangan2 = bilangan2;
    }
    
    public void setOperator(char operator){
        this.operator = operator;
    }
    
    public char getOperator(){
        return operator;
    }

    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author laboratorio
 */
public class ContaCorrente {
    private double saldo;
    private int chequeEspecial;
    private double valorTransferencia;
   
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(int chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
    
    
    
    public void depositar(double valor) throws Exception{
        if(valor<=0){
            throw new Exception("Não podemos depositar um valor negativo ou zero!");
        }
        else{
            saldo+=valor;
            System.out.println("Valor depositado: "+saldo);
        }
    
    }
    
    public void sacar(double valor) throws Exception{
        if(valor<=0){
            throw new Exception ("Nao podemos sacar um valor negativo ou zero! Valor:"+valor);
        }
        else if(valor>(saldo+chequeEspecial)){
            throw new Exception ("Operacao negada! O cliente não tem saldo suficiente! Saldo atual:"+(saldo + chequeEspecial));
        }
        else{
            saldo-=valor;
            System.out.println("Valor sacado: "+valor);
        }
    }
    
    public void transferir(ContaCorrente conta, double valor) throws Exception {
        if(valor<=0){
            throw new Exception ("Nao podemos sacar um valor negativo ou zero! Valor:"+valor);
        }
        else if(valor>(saldo+chequeEspecial)){
            throw new Exception ("Operacao negada! O cliente não tem saldo suficiente para transferir! Saldo atual:"+(saldo + chequeEspecial));
        }
        else{
            this.saldo-=valor;
            conta.depositar(valor);
        }
        
    }
    
}

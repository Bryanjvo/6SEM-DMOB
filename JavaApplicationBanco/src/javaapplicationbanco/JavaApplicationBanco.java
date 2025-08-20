/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplicationbanco;

import com.ContaCorrente;

/**
 *
 * @author laboratorio
 */
public class JavaApplicationBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();
        conta1.depositar(3000);
        conta1.sacar(10);
        System.out.println("Valor disponivel: "+conta1.getSaldo());
        conta2.depositar(500);
        conta2.sacar(5);
        System.out.println("Valor disponivel: "+conta2.getSaldo());
        //fazer metodo para transferir 500 da conta 1 para a conta 2
        conta1.transferir(conta2, 500);
        System.out.println("Valor disponivel: "+conta1.getSaldo());
        System.out.println("Valor disponivel: "+conta2.getSaldo());
        
        
        
    }
    
}

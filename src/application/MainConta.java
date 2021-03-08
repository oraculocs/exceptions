package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class MainConta {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da Conta:");
		
		System.out.print("Numero:");
		Integer num = sc.nextInt();
		
		System.out.print("Titular:");
		String titular = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Saldo Inicial:");
		Double saldo = sc.nextDouble();
		
		System.out.print("Limite Retirada: ");
		Double limiteRetirada = sc.nextDouble();
		
		
		Conta conta = new Conta(num, titular, saldo, limiteRetirada);
		
		System.out.println();
		System.out.print("Insira o Valor para sacar:");
		Double quantia = sc.nextDouble();
		
		
		try {
			conta.retirada(quantia);
			System.out.println("Novo Saldo: " + String.format("%.2f", conta.getSaldo()));
		} catch (DomainException e) {
			System.out.println("Erro de retirada: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		sc.close();
		
		

	}

}

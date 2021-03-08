package model.entities;

import model.exceptions.DomainException;

public class Conta {
	
	private Integer numeroConta;
	private String titular;
	private Double saldo;
	private Double limiteRetirada;
	
	public Conta() {
	}
	
	public Conta(Integer numeroConta, String titular, Double saldo, Double limiteRetirada) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteRetirada = limiteRetirada;
	}
	
	
	
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteRetirada() {
		return limiteRetirada;
	}

	public void deposito(Double quantia) {
		saldo += quantia;
	}
	
	public void retirada(Double quantia) throws DomainException {
		if(quantia > limiteRetirada) {
			throw new DomainException("O valor excede o limite de saque!");
			
		}
		if(quantia > saldo) {
			throw new DomainException("Não há saldo suficiente!");
		}
			saldo -= quantia;
	}
	

}

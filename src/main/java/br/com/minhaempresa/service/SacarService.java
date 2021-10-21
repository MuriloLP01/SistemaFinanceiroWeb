package br.com.minhaempresa.service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;
import br.com.minhaempresa.exception.SaldoInsuficienteException;

public class SacarService {
    public double sacar(String nome, String sobrenome, double saque) throws SaldoInsuficienteException {
        Cliente cliente = new Cliente(nome, sobrenome);
        Conta conta = new ContaCorrente(cliente);
        conta.sacar(saque);
        return conta.consultarSaldo();
    }
}

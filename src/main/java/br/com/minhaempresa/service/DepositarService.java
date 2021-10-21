package br.com.minhaempresa.service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;

public class DepositarService {
    public double depositar(String nome, String sobrenome, double deposito) {
        Cliente cliente = new Cliente(nome, sobrenome);
        Conta conta = new ContaCorrente(cliente);

        conta.depositar(deposito);
        return conta.consultarSaldo();
    }
}

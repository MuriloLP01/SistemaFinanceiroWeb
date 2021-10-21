package br.com.minhaempresa.service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;
import br.com.minhaempresa.exception.SaldoInsuficienteException;

public class TransferirService {
    public double transferir(String nomeOrigem, String sobrenomeOrigem, String nomeDestino, String sobrenomeDestino, double transferido) throws SaldoInsuficienteException {
        Cliente clienteOrigem = new Cliente(nomeOrigem, sobrenomeOrigem);
        Conta contaOrigem = new ContaCorrente(clienteOrigem);

        Cliente clienteDestino = new Cliente(nomeDestino, sobrenomeDestino);
        Conta contaDestino = new ContaCorrente(clienteDestino);

        contaOrigem.transferir(transferido, contaDestino);
        return contaOrigem.consultarSaldo();
    }
}

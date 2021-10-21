package br.com.minhaempresa.controller;

import br.com.minhaempresa.exception.SaldoInsuficienteException;
import br.com.minhaempresa.service.DepositarService;
import br.com.minhaempresa.service.TransferirService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= "/transferir")
public class TransferirController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeOrigem = req.getParameter("nomeOrigem");
        String sobrenomeOrigem = req.getParameter("sobrenomeOrigem");

        String nomeDestino = req.getParameter("nomeDestino");
        String sobrenomeDestino = req.getParameter("sobrenomeDestino");

        double transferido = Double.valueOf(req.getParameter("transferido"));

        TransferirService transferirService = new TransferirService();
        double novoSaldo = 0;

        try {
            novoSaldo = transferirService.transferir(nomeOrigem, sobrenomeOrigem, nomeDestino, sobrenomeDestino, transferido);
        } catch (SaldoInsuficienteException e) {
            resp.getWriter().println(e.getMessage());
        }

        resp.getWriter().println("Foi transferido R$ " + transferido + " para a conta de " + nomeDestino + " " + sobrenomeDestino + " da conta de " + nomeOrigem + " " + sobrenomeOrigem);
        resp.getWriter().println("Saldo atual de " + nomeOrigem + " " + sobrenomeOrigem + " é R$ " + novoSaldo);

    }
}

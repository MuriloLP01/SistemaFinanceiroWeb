package br.com.minhaempresa.controller;

import br.com.minhaempresa.service.DepositarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/depositar")
public class DepositarController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        double deposito = Double.valueOf(req.getParameter("deposito"));

        DepositarService depositarService = new DepositarService();
        double novoSaldo = depositarService.depositar(nome, sobrenome, deposito);

        resp.getWriter().println("Foi depositado R$ " + deposito + " na conta de " + nome + " " + sobrenome );
        resp.getWriter().println("Saldo atual da conta de " + nome + " " + sobrenome + " é R$ " + novoSaldo);
    }
}

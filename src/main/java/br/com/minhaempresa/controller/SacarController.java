package br.com.minhaempresa.controller;

import br.com.minhaempresa.exception.SaldoInsuficienteException;
import br.com.minhaempresa.service.DepositarService;
import br.com.minhaempresa.service.SacarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sacar")
public class SacarController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        double saque = Double.valueOf(req.getParameter("saque"));

        SacarService sacarService = new SacarService();
        double novoSaldo = 100.0;

        try {
            novoSaldo = sacarService.sacar(nome, sobrenome, saque);
            resp.getWriter().println("Saldo atual da conta de " + nome + " " + sobrenome + " é R$ " + novoSaldo);
        } catch (SaldoInsuficienteException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}

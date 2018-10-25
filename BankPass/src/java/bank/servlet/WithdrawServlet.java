/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.servlet;

import bank.model.Account;
import bank.model.History;
import bank.model.jpa.controller.AccountJpaController;
import bank.model.jpa.controller.HistoryJpaController;
import bank.model.jpa.controller.exceptions.NonexistentEntityException;
import bank.model.jpa.controller.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Admin
 */
public class WithdrawServlet extends HttpServlet {

    @PersistenceUnit(unitName = "BankPassPU")
    EntityManagerFactory emf;

    @Resource
    UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String withdrawS = request.getParameter("withdraw");
        if (withdrawS != null && withdrawS.trim().length() > 0) {
            int withdraw = Integer.parseInt(withdrawS);
            Account accountObj = (Account) session.getAttribute("account");
            if (accountObj.getBalance() >= 0 && withdraw >= 0) {
                AccountJpaController accountJpaCtrl = new AccountJpaController(utx, emf);
                HistoryJpaController historyJpaCtrl = new HistoryJpaController(utx, emf);

                int sum = accountObj.getBalance() - withdraw;
                accountObj.setBalance(sum);
                int hId = historyJpaCtrl.getHistoryCount() + 1;

                History historyObj = new History(hId, "Withdraw", withdraw, new Date(), accountObj.getBalance(), accountObj);

                try {
                    historyJpaCtrl.create(historyObj);
                } catch (Exception ex) {
                    Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                List<History> historyList = historyJpaCtrl.findHistoryEntities();
                List<History> historyAccount = new ArrayList<>();

                for (History history : historyList) {
                    if (history.getAccountid().getAccountid() == accountObj.getAccountid()) {
                        historyAccount.add(history);
                    }
                }

                accountObj.setHistoryList(historyAccount);

                try {
                    accountJpaCtrl.edit(accountObj);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("status", "Deposit Complete!");
                getServletContext().getRequestDispatcher("/MyAccount.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/WithdrawPageServlet").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

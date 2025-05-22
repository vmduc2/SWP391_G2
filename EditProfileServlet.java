
package controller;

import dal.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import model.Customer;
import model.User;

/**
 *
 * @author PC
 */
public class EditProfileServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int customerID = 1; 
        UserDao dao = new UserDao();
        Customer customer = dao.getInfoCustomersByID(customerID);
        User user = dao.getInfoByID(customerID);
        LocalDateTime ldt = customer.getRegistrationDate();
        Date regDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        request.setAttribute("registrationDate", regDate);
        request.setAttribute("customer", customer);
        request.setAttribute("user", user);
        String mode = request.getParameter("mode");
        request.setAttribute("editMode", mode != null && mode.equals("edit"));
        request.getRequestDispatcher("/ViewOfCustomer/ProfilePaging.jsp").forward(request, response);
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
        int customerID = 1;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String username = request.getParameter("username");
        UserDao dao = new UserDao();
        dao.changeInfoCustomersByID(customerID, name, address, contact);
        dao.changeInfoByID(customerID, username, email);

        Customer customer = dao.getInfoCustomersByID(customerID);
        User user = dao.getInfoByID(customerID);
        request.setAttribute("customer", customer);
        request.setAttribute("user", user);
        request.setAttribute("editMode", false);
        request.getRequestDispatcher("/ViewOfCustomer/ProfilePaging.jsp").forward(request, response);
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

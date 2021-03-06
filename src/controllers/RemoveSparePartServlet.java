package controllers;

import models.SparePart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rawlooa on 7/17/2017.
 */
@WebServlet(name = "RemoveSparePartServlet", urlPatterns = {"/remove-spare-part"})
public class RemoveSparePartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean success = new SparePart().removeSparePart(
                request.getParameter("name"),
                request.getParameter("model")
        );
        if (success) {
            request.setAttribute("message",
                    "<p style='color : green;'> Spare part removed successfully!</p>"
            );
        } else {
            request.setAttribute("message",
                    "<p style='color : red;'> Spare part not present!</p>"
            );
        }
        request.getRequestDispatcher("remove_spare_part.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package crud;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = null;
        for (Product p : ProductsServlet.products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }

        if (product == null) {
            out.println("<h3 style='color:red'>Product not found!</h3>");
            out.println("<a href='products'>Back</a>");
        } else {
            out.println("<h2>Edit Product</h2>");
            out.println("<form method='post' action='update'>"
                    + "ID: <input name='id' value='" + product.getId() + "' readonly><br>"
                    + "Name: <input name='name' value='" + product.getName() + "' required><br>"
                    + "Price: <input name='price' value='" + product.getPrice() + "' required><br>"
                    + "<input type='submit' value='Update Product'>"
                    + "</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        for (Product p : ProductsServlet.products) {
            if (p.getId() == id) {
                p.setName(name);
                p.setPrice(price);
                break;
            }
        }

        out.println("<h3 style='color:green'>Product updated successfully!</h3>");
        out.println("<a href='products'>Back to Product List</a>");
    }
}

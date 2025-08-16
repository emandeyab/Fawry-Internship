package crud;

import crud.ProductsServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        boolean exist = ProductsServlet.products.stream()
                .anyMatch(p -> p.getId() == id);

        if(exist){
            ProductsServlet.products.removeIf(product -> product.getId() == id);
            out.write("<h3 style='color:green;'>Product deleted successfully!</h3>");
        }
        else {
            out.write("<h3>Product not found.</h3>");
        }
        out.println("<button> <a href='products'>Back to Product List</a> </button>");
    }
}

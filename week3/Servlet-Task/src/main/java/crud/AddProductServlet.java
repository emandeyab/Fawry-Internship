package crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Add Product</h2>");
        out.println("<form method='post' action='add'>"
                + "ID: <input name='id' required><br>"
                + "Name: <input name='name' required><br>"
                + "Price: <input name='price' required><br>"
                + "<input type='submit' value='Save'>"
                + "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        boolean exist = ProductsServlet.products.stream()
                .anyMatch(p -> p.getId() == id);

        if(exist){
            out.write("<h3 style='color:red;'>Error: Product ID already exists!</h3>");
        }
        else {
            ProductsServlet.products.add(new Product(id, name, price));
            out.write("<h3 style='color:green;'>Product added successfully!</h3>");
        }
        out.println("<button> <a href='products'>Back to Product List</a> </button>");
    }
}

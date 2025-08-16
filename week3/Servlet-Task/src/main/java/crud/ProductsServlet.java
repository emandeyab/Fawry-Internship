package crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    public static List<Product> products = new ArrayList<>();

    public List<Product> getProducts(){
        return products;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Phone", 800));
        products.add(new Product(3, "Headphones", 120));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Product List</h2>");
        out.write("<ul>");
        for (Product product : products){
            out.write("<b> <li> " + product.getId() + " - " + product.getName() + " - " + product.getPrice()
                    + "  <button> <a href='update?id=" + product.getId() + "'>Update</a> </button>"
                    + "  <button> <a href='delete?id=" + product.getId() + "'>Delete</a> </button>"
                    + "</b> </li>");
        }
        out.println("</ul>");

        out.write("<button> <a href='add'> Add new product </a> </button>");
    }
}

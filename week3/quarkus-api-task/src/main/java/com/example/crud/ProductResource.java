package com.example.crud;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Phone", 800));
        products.add(new Product(3, "Headphones", 120));
    }

    @GET
    @Path("")
    public List<Product> getProducts() {
        return products;
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return Response.ok(p).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Product not found").build();
    }

    @POST
    public Response addProduct(Product newProduct) {
        for (Product p : products) {
            if (p.getId() == newProduct.getId()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Product with this ID already exists").build();
            }
        }
        products.add(newProduct);
        return Response.status(Response.Status.CREATED).entity(newProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (removed) {
            return Response.ok("Product deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, Product updatedProduct) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                return Response.ok(p).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Product not found").build();
    }
}
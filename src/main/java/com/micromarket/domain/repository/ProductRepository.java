package com.micromarket.domain.repository;

import com.micromarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  List<Product> getAll();

  List<Product> getProductByIdCategory(int idCategory);

  List<Product> getScarseProducts(int quantity);

  Optional<Product> getProductById(int idProduct);

  Product createProduct(Product product);

  void deleteProduct(int idProduct);
}

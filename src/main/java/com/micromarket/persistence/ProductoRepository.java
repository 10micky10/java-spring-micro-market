package com.micromarket.persistence;

import com.micromarket.domain.Product;
import com.micromarket.domain.repository.ProductRepository;
import com.micromarket.persistence.crud.ProductoCrudRepository;
import com.micromarket.persistence.entity.Producto;
import com.micromarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCrudRepository productoCrudRepository;
  private ProductMapper mapper;

  @Override
  public List<Product> getAll(){
    List<Producto> listaProductos = (List<Producto>) productoCrudRepository.findAll();
    return mapper.toProducts(listaProductos);
  }

  @Override
  public List<Product> getProductByIdCategory(int idCategory) {
    List<Producto> listaProductosByIdCategory = productoCrudRepository.findByIdCategoria(idCategory);
    return mapper.toProducts(listaProductosByIdCategory);
  }

  @Override
  public List<Product> getScarseProducts(int quantity) {
    List<Producto> listaProductosEscasos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    return mapper.toProducts(listaProductosEscasos);
  }

  @Override
  public Optional<Product> getProductById(int idProduct) {
    return productoCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
  }

  @Override
  public Product createProduct(Product product) {
    return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
  }

  @Override
  public void deleteProduct(int idProduct) {
    productoCrudRepository.deleteById(idProduct);
  }
}

package com.micromarket.persistence.crud;

import com.micromarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

  List<Producto> findByIdCategoria(int idCategoria);

  List<Producto> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}

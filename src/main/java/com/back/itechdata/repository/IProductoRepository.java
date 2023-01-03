package com.back.itechdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.itechdata.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}

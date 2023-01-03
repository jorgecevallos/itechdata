package com.back.itechdata.service;

import java.util.List;
import java.util.Optional;

import com.back.itechdata.model.Orden;
import com.back.itechdata.model.Usuario;

public interface IOrdenService {
	List<Orden> findAll();
	Optional<Orden> findById(Integer id);
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario (Usuario usuario);
}

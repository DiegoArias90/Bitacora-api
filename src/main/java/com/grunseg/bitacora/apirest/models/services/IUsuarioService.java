package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import com.grunseg.bitacora.apirest.models.entity.Role;
import com.grunseg.bitacora.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Usuario findById(Long id);

	public Usuario save(Usuario usuario);

	public void delete(Long id);

	public Usuario findByUsername(String username);

	/* LISTA ROLES */
	public List<Role> findAllRoles();

}

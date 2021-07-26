package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grunseg.bitacora.apirest.models.entity.Role;
import com.grunseg.bitacora.apirest.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
	//public Usuario findByUsernameAndEstado(String username, Boolean estado);

	@Query("from Role")
	public List<Role> findAllRoles();

}

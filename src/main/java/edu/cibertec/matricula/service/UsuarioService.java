package edu.cibertec.matricula.service;

import edu.cibertec.matricula.dao.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    public UsuarioEntity validarLogin(UsuarioEntity usuario);

    public List<UsuarioEntity> getListaUsuarios();
    public void insertarUsuario(UsuarioEntity usuario);
}

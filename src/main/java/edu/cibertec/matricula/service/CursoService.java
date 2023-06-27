package edu.cibertec.matricula.service;

import edu.cibertec.matricula.dao.entity.CursoEntity;

import java.util.List;

public interface CursoService {
    List<CursoEntity> listarTodos();

    void insertar(CursoEntity ce);

    void eliminar(int codigo);
    CursoEntity getUsuario(int codigo);

    void actualizar(CursoEntity ce);
}
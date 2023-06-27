package edu.cibertec.matricula.dao.repository;

import edu.cibertec.matricula.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);
}

package edu.cibertec.matricula.service.impl;

import edu.cibertec.matricula.dao.entity.UsuarioEntity;
import edu.cibertec.matricula.dao.repository.UsuarioRepository;
import edu.cibertec.matricula.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity validarLogin(UsuarioEntity usuario) {
        UsuarioEntity rpta = usuarioRepository
                .findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());

        return rpta;
    }

    @Override
    public List<UsuarioEntity> getListaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

}

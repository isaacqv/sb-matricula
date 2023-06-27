package edu.cibertec.matricula.service.impl;

import edu.cibertec.matricula.dao.entity.CursoEntity;
import edu.cibertec.matricula.dao.repository.CursoRepository;
import edu.cibertec.matricula.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<CursoEntity> listarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public void insertar(CursoEntity ce) {
        cursoRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        cursoRepository.deleteById(codigo);
    }

    public CursoEntity getUsuario(int codigo){
        CursoEntity rpta = null;
        Optional<CursoEntity> busqueda = cursoRepository.findById(codigo);
        if (busqueda.isPresent()){
            rpta = busqueda.get();
        }
        return rpta;
    }

    @Override
    public void actualizar(CursoEntity ce) {cursoRepository.save(ce);
    }

}

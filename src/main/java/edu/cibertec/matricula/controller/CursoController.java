package edu.cibertec.matricula.controller;

import edu.cibertec.matricula.dao.entity.CursoEntity;
import edu.cibertec.matricula.service.CursoService;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CursoController {

    //Logger logger = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoListar")
    public ModelAndView cursoMostrar() {
        ModelAndView mv = new ModelAndView("curso", "lista", cursoService.listarTodos());
        mv.addObject("cursoBean", new CursoEntity());
        return mv;
    }

    @RequestMapping("cursoGrabar")
    public ModelAndView cursoGrabar(@Valid @ModelAttribute("cursoBean") CursoEntity ce,
                                    BindingResult valida,
                                    @RequestParam(value = "accion", required = false) String accion) {
        log.debug("Antes de insertar un curso");
        ModelAndView mv = new ModelAndView("curso");
        System.out.println(valida.toString());
        if (valida.hasErrors()) {
            log.warn("Falló el insertar un curso");
            mv.addObject("lista", cursoService.listarTodos());
            mv.addObject("cursoBean", ce);
        } else {
            if (accion != null && accion.equals("Modificar")) {
                cursoService.actualizar(ce);
            } else {
                cursoService.insertar(ce);
            }
            //cursoService.insertar(ce);
            mv.addObject("lista", cursoService.listarTodos());
            mv.addObject("cursoBean", new CursoEntity());
            log.warn("Grabó el curso! "+ce.getNomCurso());
        }
        return mv;
    }

    @RequestMapping("cursoEliminar")
    public ModelAndView cursoEliminar(@RequestParam("codigo") int codigo) {
        log.info("Antes de eliminar un curso");
        cursoService.eliminar(codigo);
        log.warn("Despues de eliminar un curso "+codigo);
        return new ModelAndView("redirect:cursoListar");
    }
    @RequestMapping("cursoModificar")
    public ModelAndView cursoModificar(@RequestParam("codigo") int codigo){
        ModelAndView mv = new ModelAndView("curso", "cursoBean",
                cursoService.getUsuario(codigo));
        mv.addObject("accion","Modificar");
        return mv;
    }
}
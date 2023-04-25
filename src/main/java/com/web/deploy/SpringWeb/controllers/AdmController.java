package com.web.deploy.SpringWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.deploy.SpringWeb.models.Administrador;
import com.web.deploy.SpringWeb.repositorio.AdministradoresRepo;

// import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller
public class AdmController {

  @Autowired
  private AdministradoresRepo repo;

  @GetMapping("/administradores")
  public String index(Model model) {
    List<Administrador> administradores = (List<Administrador>) repo.findAll();
    model.addAttribute("administradores", administradores);

    return "administradores/index";
  }

  // @GetMapping("/administradores")
  // public String index() {
  // return "administradores/index";

  @GetMapping("/administradores/novo")
  public String novo() {
    return "administradores/novo";
  }

  @PostMapping("/administradores/criar")
  public String criar(Administrador administrador) {
    repo.save(administrador);
    return "redirect:/administradores";
  }

  @GetMapping("/administradores/{id}/excluir")
  public String excluir(@PathVariable int id) {
    repo.deleteById(id);
    return "redirect:/admnistradores";
  }
}

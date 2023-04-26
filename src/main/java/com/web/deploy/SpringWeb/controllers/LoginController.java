package com.web.deploy.SpringWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.deploy.SpringWeb.models.Administrador;
import com.web.deploy.SpringWeb.repositorio.AdministradoresRepo;

// import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller
public class LoginController {
  @Autowired
  private AdministradoresRepo repo;

  @GetMapping("/login")
  public String home() {
    return "login/index";
  }

  @PostMapping("/logar")
  public String logar(Model model, Administrador admParam, String lembrar) {
    Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
    if (adm != null) {
      return "redirect:/";
    }
    model.addAttribute("erro", "Usuário ou senha inválidos");
    return "login/index";
  }
}

package com.web.deploy.SpringWeb.controllers;

// import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;

import com.web.deploy.SpringWeb.models.Administrador;
import com.web.deploy.SpringWeb.repositorio.AdministradoresRepo;

// import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;

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

  @GetMapping("/administradores/novo")
  public String novo() {
    return "administradores/novo";
  }

  @PostMapping("/administradores/criar")
  // public String criar(@Validated Administrador administrador, BindingResult
  // result,
  // @RequestParam("imagem") MultipartFile imagem) throws IOException {
  public String criar(Administrador administrador) {

    // if (result.hasErrors()) {
    // return "redirect:/administradores";
    // }
    // administrador.setImagem(imagem.getBytes());
    repo.save(administrador);
    return "redirect:/administradores";
  }

  @GetMapping("/administradores/{id}")
  public String busca(@PathVariable int id, Model model) {
    Optional<Administrador> admin = repo.findById(id);
    try {
      model.addAttribute("administrador", admin.get());
    } catch (Exception err) {
      return "redirect:/administradores";
    }

    return "/administradores/editar";
  }

  @PostMapping("/administradores/{id}/atualizar")
  public String atualizar(@PathVariable int id, Administrador administrador) {
    // if(!repo.exist(id)){
    if (!repo.existsById(id)) {
      return "redirect:/administradores";
    }

    repo.save(administrador);

    return "redirect:/administradores";
  }

  @GetMapping("/administradores/{id}/excluir")
  public String excluir(@PathVariable int id) {
    repo.deleteById(id);
    return "redirect:/administradores";
  }
}

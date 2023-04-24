package com.web.deploy.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmController {

  @GetMapping("/administradores")
  public String index() {
    return "administradores/index";
  }
}

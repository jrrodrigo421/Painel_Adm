package com.web.deploy.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {

    model.addAttribute("Nome", "Rodrigo");

    return "index";
  }
}

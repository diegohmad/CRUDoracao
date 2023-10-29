package iftm.edu.tspi.crudoracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iftm.edu.tspi.crudoracao.dao.CrudDao;
import iftm.edu.tspi.crudoracao.domain.Contato;

@Controller
public class CrudController {
    @Autowired
    private CrudDao dao;
    
    @RequestMapping("contatos")
    public String getContatos(Model model) {
        model.addAttribute("contato",new Contato());
        model.addAttribute("contatos",dao.getContatos());
        model.addAttribute("edit",false);
        return "contatosList";
    }

    @PostMapping("contatos")
    public String inserirContatos(Contato contato,Model model) {
        // Contato contatoDb = dao.getContato(contato.getId());
        if (contato.getId() == null) {
            dao.inserirContato(contato);
        } else {
            dao.updateContato(contato);
        }
        
        return getContatos(model);
    }

    @RequestMapping("contatosBusca")
    public String getContatos(@RequestParam(value = "nome", required = true) String nome, Model model) {
        model.addAttribute("contatos",dao.getContatos(nome));
        model.addAttribute("contato",new Contato());
        model.addAttribute("edit",false);
        return "contatosList";
    }

    @RequestMapping("excluirContato")
    public String deleteContato(@RequestParam(value = "id", required = true) Integer id, Model model) {
        dao.deleteContato(id);
        return getContatos(model);
    }

    @RequestMapping("editarContato")
    public String editarContato(@RequestParam(value = "id", required = true) Integer id, Model model) {
        Contato contato = dao.getContato(id);
        model.addAttribute("contato", contato);
        model.addAttribute("contatos", dao.getContatos());
        model.addAttribute("edit",true);
        return "contatosList";
    }
}

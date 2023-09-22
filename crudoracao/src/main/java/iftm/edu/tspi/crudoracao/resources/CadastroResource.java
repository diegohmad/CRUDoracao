package iftm.edu.tspi.crudoracao.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iftm.edu.tspi.crudoracao.dto.CadastroDTO;

@Controller
public class CadastroResource {
    private List<CadastroDTO> cadastros = new ArrayList<>();

    public CadastroResource() {
        CadastroDTO cadastro = new CadastroDTO();
        cadastro.setNome("Gretchen");
        cadastro.setSobrenome("Cantora");
        cadastro.setCelular("11-99999-0000");
        cadastro.setEmail("gretchen@cantora.mulher");
        cadastros.add(cadastro);
    }

    @RequestMapping("cadastroGet")
    public String cadastroGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        model.addAttribute("cadastro", new CadastroDTO());
        return "lista";
    }

    @PostMapping("cadastroPost")
    public String cadastroPost(CadastroDTO dto, Model model) {
        boolean contatoDuplicado = false;
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getNome().equalsIgnoreCase(dto.getNome())) {
                cadastro.setSobrenome(dto.getSobrenome());
                cadastro.setCelular(dto.getCelular());
                cadastro.setEmail(dto.getEmail());
                contatoDuplicado = true;
                break;
            }
        }
        if (contatoDuplicado == false) {
            cadastros.add(dto);
        }
        return cadastroGet(model);
    }

    @RequestMapping("cadastroDelete")
    public String cadastroDelete(@RequestParam("nome") String nome, Model model) {
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getNome().equals(nome)) {
                cadastros.remove(cadastro);
                break;
            }
        }
        return cadastroGet(model);
    }

    @RequestMapping("/cadastroUpdate")
    public String cadastroUpdate(CadastroDTO dto, Model model) {
        CadastroDTO cadastroDTO = new CadastroDTO();

        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getNome().toUpperCase().equals(dto.getNome().toUpperCase())) {
                cadastroDTO = cadastro;
                break;
            }
        }
        model.addAttribute("cadastro", cadastroDTO);
        model.addAttribute("cadastros", cadastros);
        return "lista";
    }
}
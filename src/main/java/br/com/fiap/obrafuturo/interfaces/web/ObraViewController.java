package br.com.fiap.obrafuturo.interfaces.web;

import br.com.fiap.obrafuturo.application.dto.ObraRequest;
import br.com.fiap.obrafuturo.application.dto.ObraResponse;
import br.com.fiap.obrafuturo.application.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/obras")
public class ObraViewController {

    private final ObraService service;

    public ObraViewController(ObraService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("obras", service.listarTodas());
        return "obras/list";
    }

    @GetMapping("/nova")
    public String novaObraForm(Model model) {
        model.addAttribute("obraRequest", new ObraRequest());
        model.addAttribute("titulo", "Nova obra");
        model.addAttribute("acao", "Criar");
        return "obras/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("obraRequest") ObraRequest request,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Nova obra");
            model.addAttribute("acao", "Criar");
            return "obras/form";
        }
        service.criar(request);
        return "redirect:/obras";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        ObraResponse obra = service.buscarPorId(id);

        ObraRequest request = new ObraRequest();
        request.setNome(obra.getNome());
        request.setCnpj(obra.getCnpj());
        request.setLogradouro(obra.getLogradouro());
        request.setNumero(obra.getNumero());
        request.setCidade(obra.getCidade());
        request.setEstado(obra.getEstado());
        request.setCep(obra.getCep());
        request.setDataInicio(obra.getDataInicio());
        request.setDataFim(obra.getDataFim());
        request.setAtiva(obra.getAtiva());

        model.addAttribute("obraId", obra.getId());
        model.addAttribute("obraRequest", request);
        model.addAttribute("titulo", "Editar obra");
        model.addAttribute("acao", "Salvar alterações");
        return "obras/form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("obraRequest") ObraRequest request,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("obraId", id);
            model.addAttribute("titulo", "Editar obra");
            model.addAttribute("acao", "Salvar alterações");
            return "obras/form";
        }

        service.atualizar(id, request);
        return "redirect:/obras";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/obras";
    }
}

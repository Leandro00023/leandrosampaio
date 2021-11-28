package leandrosampaio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import leandrosampaio.domain.Profissao;
import leandrosampaio.domain.Empresa;
import leandrosampaio.service.ProfissaoService;
import leandrosampaio.service.EmpresaService;

@Controller
@RequestMapping("/profissoes")

public class ProfissaoController {

	@Autowired
	private ProfissaoService profissaoService;

	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Profissao profissao) {

		return "/profissao/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {

		model.addAttribute("profissoes", profissaoService.buscarTodos());
		return "/profissao/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Profissao profissao, RedirectAttributes attr) {

		profissaoService.salvar(profissao);
		attr.addFlashAttribute("success", "Profissão inserida com sucesso.");
		return "redirect:/profissoes/cadastrar";
	}

	@ModelAttribute("empresas")
	public List<Empresa> listaDeEmpresas() {

		return empresaService.buscarTodos();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("profissao", profissaoService.buscarPorId(id));
		return "/profissao/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Profissao profissao, RedirectAttributes attr) {
		profissaoService.editar(profissao);
		attr.addFlashAttribute("success", "Profissão alterada com sucesso.");
		return "redirect:/profissoes/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {

		if (profissaoService.profissaoTemCliente(id)) {
			attr.addFlashAttribute("fail", "Profissão não removida. Possui profissão vinculada.");
		}

		else {
			profissaoService.excluir(id);
			attr.addFlashAttribute("success", "Profissão excluída com sucesso.");
		}

		return "redirect:/profissoes/listar";
	}
}

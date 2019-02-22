package es.urjc.etsii.dad.helloworld;


import javax.annotation.PostConstruct;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AnunciosController {

	@Autowired
	private AnunciosRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Anuncios("Anuncio1", "este es el primer anuncio que hago jajajaja", "Autor: Pepe"));
		repository.save(new Anuncios("Anuncio2", "este es el segundo anuncio blablabla blabla blabla blabla bla blabla blabla blabla ", "Autor:Antonio"));
	}

	@RequestMapping("/anunci")
	public String anuncio(Model model, Pageable page) {

		model.addAttribute("anuncio", repository.findAll(page));

		return "anuncios";
	}
	
	
/*	public String showItem(Model ..., long id) {
		Item i = repo.findById(id).ortlseThrow(
				()-> new EntityNotFound("id no encontrado" +id));
	}
*/
}
package topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.entity.Commentaire;
import topcolleguesbackend.repository.CommentaireRepository;


@RestController
@RequestMapping("/commentaires")
public class CommentaireController {
	
	@Autowired
	private CommentaireRepository comRepo;

	@RequestMapping(method = RequestMethod.POST)
	public List<Commentaire> sauvergarder(@RequestBody Commentaire com) {
		// enregister un nouveau commentaire
		this.comRepo.save(com);
		return this.comRepo.findAll();
	}
}
	
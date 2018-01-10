package topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.entity.Collegue;
import topcolleguesbackend.repository.CollegueRepository;

@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository colRepo;

	@GetMapping
	public List<Collegue> listercollegue() {
		return this.colRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Collegue> sauvergarder(@RequestBody Collegue c) {
		//enregister un nouveau collegue
		Collegue collegue = new Collegue();
		collegue.setPseudo(c.getPseudo());
		collegue.setImageURL(c.getImageURL());
		collegue.setScore(c.getScore());
		this.colRepo.save(collegue);
		//verification du doublon
		
		//retourne la liste
		return this.colRepo.findAll();

	}
}
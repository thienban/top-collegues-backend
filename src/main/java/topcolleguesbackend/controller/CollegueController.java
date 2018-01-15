package topcolleguesbackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.entity.Avis;
import topcolleguesbackend.entity.Collegue;
import topcolleguesbackend.entity.Vote;
import topcolleguesbackend.repository.CollegueRepository;
import topcolleguesbackend.repository.VoteRepository;

@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository colRepo;
	
	@Autowired
	private VoteRepository voteRepo;

	@GetMapping
	public List<Collegue> listercollegue() {
		return this.colRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<Collegue> sauvergarder(@RequestBody Collegue c) {
		// enregister un nouveau collegue
		Collegue collegue = new Collegue();
		collegue.setPseudo(c.getPseudo());
		collegue.setImageURL(c.getImageURL());
		collegue.setScore(c.getScore());
		this.colRepo.save(collegue);
		// verification du doublon

		// retourne la liste
		return this.colRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.PATCH, path = "/{pseudo}")
	public Collegue action(@RequestBody Map<String, String> act, @PathVariable String pseudo) {
		
		Optional<Collegue> optCol = colRepo.findByPseudo(pseudo);
		if(optCol.isPresent()) {   
			Collegue col = optCol.get();
			if (act.get("action").equals("aimer")) {
				Vote v = new Vote(Avis.aime,col);
				this.voteRepo.save(v);
				col.setScore(col.getScore() + 10);
				this.colRepo.save(col);
			} else if (act.get("action").equals("detester")) {
				Vote v = new Vote(Avis.deteste,col);
				this.voteRepo.save(v);
				col.setScore(col.getScore() - 5);
				this.colRepo.save(col);
			}
			return col;
		}
		return null;
	}
	
}
















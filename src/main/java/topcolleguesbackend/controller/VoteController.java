package topcolleguesbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.entity.Vote;
import topcolleguesbackend.repository.VoteRepository;

@RestController
@RequestMapping("/votes")
public class VoteController {
	@Autowired
	private VoteRepository voteRepo;
	
	@RequestMapping(method = RequestMethod.GET, params = {"since"})
	public List<Vote> getVotes(@RequestParam("since") Optional<Integer> since){
		if(since.isPresent()) {
			return voteRepo.findTop3ById(since.get());
		} else {
			return voteRepo.findAll();
		}
		
	}
}

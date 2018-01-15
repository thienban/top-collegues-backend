package topcolleguesbackend.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import topcolleguesbackend.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{
	List<Vote> findTop3ById( Integer id);
}


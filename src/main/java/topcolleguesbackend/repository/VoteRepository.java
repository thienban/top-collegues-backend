package topcolleguesbackend.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import topcolleguesbackend.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{
	List<Vote> findByIdGreaterThan( Integer id);
	List<Vote> findFirst3ByOrderByIdDesc();
}


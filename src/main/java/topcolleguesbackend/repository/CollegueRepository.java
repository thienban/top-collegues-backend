package topcolleguesbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import topcolleguesbackend.entity.Collegue;

public   interface CollegueRepository extends JpaRepository<Collegue, Integer>{
	Optional<Collegue> findByPseudo(String pseudo);
}


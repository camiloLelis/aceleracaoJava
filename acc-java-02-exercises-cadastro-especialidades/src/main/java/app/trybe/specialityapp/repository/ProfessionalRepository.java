package app.trybe.specialityapp.repository;

import app.trybe.specialityapp.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// o JpaRepository já traz a anotaçao @Repository,
// porém optei em deixar nitido que é um Repository
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

}

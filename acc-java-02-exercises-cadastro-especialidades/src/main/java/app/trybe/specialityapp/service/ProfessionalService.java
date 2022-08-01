package app.trybe.specialityapp.service;

import app.trybe.specialityapp.commons.BadRequestCreate;
import app.trybe.specialityapp.commons.DeleteNotFound;
import app.trybe.specialityapp.commons.EditNotFound;
import app.trybe.specialityapp.commons.RegistryNotFound;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {
  // ponto de injeção
  /*  @Autowired
  ProfessionalRepository repository; 
  */

  final ProfessionalRepository repository;

  public ProfessionalService(ProfessionalRepository repository) {
    this.repository = repository;
  }

  /**
   * Método usando o verbo post(create).
   */

  public void create(Professional professional) {
    if (professional.getId() != null) {
      throw new BadRequestCreate();
    } else {
      repository.save(professional);
    }
  }

  /**
   * Método usando o verbo get(read).
   */

  public List<Professional> getAllProfessionals() {
    List<Professional> registrosProfessinals =  repository.findAll();

    if (registrosProfessinals.isEmpty()) {
      throw new RegistryNotFound();
    }

    return registrosProfessinals;
  }


  /**
   * verbo put(update).
   */

  public void updateById(Integer id, Professional professional) {
 
    Optional<Professional> verifiedProfessional = repository.findById(id);
    if (verifiedProfessional.isPresent()) {
      verifiedProfessional.get().setName(professional.getName());
      verifiedProfessional.get().setSpeciality(professional.getSpeciality());
      repository.save(verifiedProfessional.get());
    } else {
      throw new EditNotFound();
    }
  }

  /**
   * verbo delete.
   */

  public void deleteProfessionalById(Integer id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new DeleteNotFound();
    }

  }

}

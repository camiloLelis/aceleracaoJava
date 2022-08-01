package com.trybe.acc.java.minhasseries.repository;

import com.trybe.acc.java.minhasseries.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {

}

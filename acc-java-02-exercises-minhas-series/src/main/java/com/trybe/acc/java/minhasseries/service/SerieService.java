package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.commons.SerieExistenteException;
import com.trybe.acc.java.minhasseries.commons.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.EpisodioRepository;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private EpisodioRepository episodioRepository;

  /**
   * cria uma nova serie.
   */
  public Serie createNewSerie(Serie serie) {

    if (serieRepository.existsByNome(serie.getNome())) {
      throw new SerieExistenteException();
    }

    return serieRepository.save(serie);
  }

  /**
   * listar series criadas.
   */
  public List<Serie> listAllSerie() {
    return serieRepository.findAll();
  }

  /**
   * deleta uma serie tendo como referencia o id.
   */
  public void deleteSerieId(Integer id) {
    Optional<Serie> serieFound = serieRepository.findById(id);

    if (serieFound.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }

    serieRepository.delete(serieFound.get());
  }

  /**
   * adiciona episódio de uma serie especifida pelo seu parametro Id.
   */
  public Serie addEpisodeBySeriesIdParameter(Integer id, Episodio episodio) {

    Optional<Serie> serieToBe = serieRepository.findById(id);

    if (serieToBe.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }

    Serie serieAddEpisode = serieToBe.get();
    serieAddEpisode.adicionarEpisodio(episodio);
    episodio.setSerie(serieAddEpisode);
    serieRepository.save(serieAddEpisode);
    episodioRepository.save(episodio);

    return serieAddEpisode;
  }

  /**
   * lista de episodios de uma serie específica.
   */
  public List<Episodio> specificSerieEpisodesList(Integer id) {
    Optional<Serie> serieFound = serieRepository.findById(id);

    if (serieFound.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }

    return serieFound.get().getEpisodios();
  }


}

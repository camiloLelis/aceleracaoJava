package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/series")
public class SerieController {

  @Autowired
  private SerieService serieService;

  @PostMapping
  public ResponseEntity<Serie> createSerie(@RequestBody Serie serie) {
    Serie serieNew = serieService.createNewSerie(serie);
    return ResponseEntity.ok(serieNew);
  }

  @PostMapping("/{id}/episodios")
  public ResponseEntity<Serie> createEpisodioBySerie(
      @PathVariable Integer id, @RequestBody Episodio episodio) {
    Serie serieEpAdd = serieService.addEpisodeBySeriesIdParameter(id, episodio);
    return ResponseEntity.ok(serieEpAdd);
  }

  /**
   * metodo get all series.
   */
  @GetMapping
  public ResponseEntity<List<Serie>> listCreatedSeries() {
    return ResponseEntity.ok(serieService.listAllSerie());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Serie> delete(@PathVariable Integer id) {
    serieService.deleteSerieId(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}/episodios")
  public ResponseEntity<List<Episodio>> listOfSerieEpisodesById(@PathVariable Integer id) {
    List<Episodio> episodios = serieService.specificSerieEpisodesList(id);
    return ResponseEntity.ok(episodios);
  }

  /**
   * teste.
   */
  @GetMapping("/tempo")
  @ResponseStatus(code = HttpStatus.OK)
  public Object timeEpisodes() {
    Map<String, Object> result = new LinkedHashMap<>();
    result.put("tempoEmMinutos", 0);
    return result;
  }

}

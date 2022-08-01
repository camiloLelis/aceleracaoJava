package app.trybe.specialityapp.config;

import app.trybe.specialityapp.controller.ProfessionalController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig {

  /**
  * JerseyConfig.
  *
  */
  public JerseyConfig() {
    register(ProfessionalController.class);
  }
}
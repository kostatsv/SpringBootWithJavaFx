package com.formfill.frontend;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.formfill.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

@Component
public class FxApplication extends javafx.application.Application {

  private ConfigurableApplicationContext applicationContext;

  @Override
  public void start(Stage stage) {
    applicationContext.publishEvent(new StageReadyEvent(stage));
  }

  @Override
  public void init() {
    applicationContext = new SpringApplicationBuilder(Application.class).run();
  }

  @Override
  public void stop() {
    applicationContext.close();
    Platform.exit();
  }

  public static class StageReadyEvent extends ApplicationEvent {

    public StageReadyEvent(Stage stage) {
      super(stage);
    }

    public Stage getStage() {
      return ((Stage) getSource());
    }
  }
}

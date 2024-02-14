package com.formfill.frontend;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class StageInitializer implements ApplicationListener<FxApplication.StageReadyEvent> {

  @Value("classpath:/screens/main.fxml")
  private Resource resource;

  @Value("${project.version}")
  private String projectVersion;

  @Value("${project.description}")
  private String projectName;

  private final ApplicationContext applicationContext;

  public StageInitializer(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void onApplicationEvent(FxApplication.StageReadyEvent event) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(resource.getURL());
      fxmlLoader.setControllerFactory(applicationContext::getBean);
      Parent parent = fxmlLoader.load();
      Stage stage = event.getStage();
      stage.setTitle(projectName + " " + projectVersion);
      stage.setMaximized(false);
      stage.setScene(new Scene(parent));
      stage.show();
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

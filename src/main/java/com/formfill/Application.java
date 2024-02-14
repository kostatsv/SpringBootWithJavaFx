package com.formfill;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formfill.frontend.FxApplication;

@SpringBootApplication(scanBasePackages = { "com.formfill" })
public class Application {

  public static void main(String[] args) {
    javafx.application.Application.launch(FxApplication.class, args);
  }
}

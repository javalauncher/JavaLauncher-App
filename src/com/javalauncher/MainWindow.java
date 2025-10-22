package com.javalauncher;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MainWindow {
    private Stage primaryStage;
    
    public MainWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setupWindow();
    }
    
    private void setupWindow() {
        // Настройка основного окна
        primaryStage.setTitle("JavaLauncher");
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        
        // Загрузка иконки
        try {
            Image icon = new Image(getClass().getResourceAsStream("/images/javalauncherlogo.png"));
            primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            System.out.println("Не удалось загрузить иконку");
        }
        
        // Создание интерфейса
        VBox root = createInterface();
        Scene scene = new Scene(root);
        
        // Загрузка CSS стилей
        try {
            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        } catch (Exception e) {
            System.out.println("Не удалось загрузить CSS стили");
        }
        
        primaryStage.setScene(scene);
    }
    
    private VBox createInterface() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.getStyleClass().add("root");
        
        // Заголовок
        HBox header = createHeader();
        
        // Основной контент
        VBox content = createContent();
        
        // Футер с кнопками
        HBox footer = createFooter();
        
        root.getChildren().addAll(header, content, footer);
        return root;
    }
    
    private HBox createHeader() {
        HBox header = new HBox(15);
        header.setAlignment(Pos.CENTER_LEFT);
        
        try {
            Image logoImage = new Image(getClass().getResourceAsStream("/images/javalauncherlogo.png"));
            ImageView logo = new ImageView(logoImage);
            logo.setFitWidth(50);
            logo.setFitHeight(50);
            header.getChildren().add(logo);
        } catch (Exception e) {
            System.out.println("Не удалось загрузить логотип");
        }
        
        Label title = new Label("JavaLauncher");
        title.getStyleClass().add("header-title");
        
        header.getChildren().add(title);
        return header;
    }
    
    private VBox createContent() {
        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(40, 0, 40, 0));
        
        Label welcomeText = new Label("Добро пожаловать в JavaLauncher!");
        welcomeText.getStyleClass().add("welcome-text");
        
        content.getChildren().add(welcomeText);
        return content;
    }
    
    private HBox createFooter() {
        HBox footer = new HBox(20);
        footer.setAlignment(Pos.CENTER);
        
        Button playButton = new Button("🚀 ИГРАТЬ");
        playButton.getStyleClass().add("play-button");
        
        Button settingsButton = new Button("⚙️ НАСТРОЙКИ");
        settingsButton.getStyleClass().add("settings-button");
        
        footer.getChildren().addAll(playButton, settingsButton);
        return footer;
    }
    
    public void show() {
        primaryStage.show();
    }
}

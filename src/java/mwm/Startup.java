package mwm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Startup extends Application{
	private static SessionFactory sessionFactory;
	private static DataImporter importer;
	private static Stage mainStage;
	protected static void initSession() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("mwm/hibernate/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	@Override
    public void start(Stage primaryStage) {
		importer = new DataImporter();
		mainStage = primaryStage;
		
        Button btn1 = new Button();
        btn1.setText("Import US Price Data");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseFile();
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Import CAD Price Data");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseFile();
            }
        });
        
        Button btn3 = new Button();
        btn3.setText("Import ADR Price Data");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseFile();
            }
        });
        
        Button btn4 = new Button();
        btn4.setText("Import Price Index Data");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseFile();
            }
        });
        
        StackPane root = new StackPane();
        btn1.setTranslateY(-75);
        btn2.setTranslateY(-25);
        btn3.setTranslateY(25);
        btn4.setTranslateY(75);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        
        double width = 250;
        double height = 300;
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setTitle("Moore Wealth Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public File chooseFile(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select a CSV File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("CSV Files", "*.csv"),
				new ExtensionFilter("All Files", "*.*"));
		File selectedFile = fileChooser.showOpenDialog(mainStage);
		return selectedFile;
	}
	
	public static void main(String[] args) throws Exception {
		//initSession();
		//import
		launch(args);
	}
	
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

}

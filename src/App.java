import java.awt.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.*;

public class App extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Application");
		GridPane rootNode = new GridPane();
		rootNode.setPadding( new Insets(15, 0, 0, 0) );
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode, 500, 500);
		
		rootNode.add(new Label("Text Field:"), 0, 0);
		TextField inputField = new TextField();
		//rootNode.add(inputField, 0, 1);
		
		Button btn = new Button();
		btn.setText("Launch calc-app");
		btn.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				ToBinary toBinary = new ToBinary();
				toBinary.decide(inputField.getText());
				
			}
		});
		rootNode.add(btn, 0, 2);
		
		primaryStage.setScene(myScene);
		primaryStage.show();
	}


}

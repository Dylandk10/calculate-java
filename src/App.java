import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
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
		rootNode.setPadding(new Insets(15, 0, 0, 0) );
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode, 500, 500);
		TextField inputField = new TextField();
		
		Button btn = new Button();
		btn.setText("Launch calc-app");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ToBinary toBinary = new ToBinary();
				toBinary.decide(inputField.getText());
				
			}
		});
		//number buttons
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		Button button4 = new Button();
		button1.setText("1");
		button2.setText("2");
		button3.setText("3");
		button4.setText("4");
		//adding to rootnode
		rootNode.add(btn, 0, 2);
		rootNode.add(new Label("Enter hexidecimal data:"), 0, 0);
		rootNode.add(inputField, 0, 1);
		rootNode.add(button1, 1, 0);
		rootNode.add(button2, 2, 0);
		rootNode.add(button3, 1, 1);
		rootNode.add(button4, 2, 1);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}


}

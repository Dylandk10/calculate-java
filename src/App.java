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
		Label input = new Label();
		Button btn = new Button();
		btn.setText("Launch calc-app");
		//launches app with button input
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
		Button button5 = new Button();
		Button button6 = new Button();
		ButtonHandler buttonHandler = new ButtonHandler();
		button1.setText("1");
		button2.setText("2");
		button3.setText("3");
		button4.setText("4");
		button5.setText("5");
		button6.setText("6");
		//adding method for all buttons to add value to them...
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "1";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}
			
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "2";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}	
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "3";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}
		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "4";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}
		});
		button5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "5";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}
		});
		button6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String value = "6";
				buttonHandler.addResult(value);
				input.setText(buttonHandler.returnResult());
			}
		});
		
		//adding to rootnode
		rootNode.add(btn, 0, 2);
		rootNode.add(input, 0, 0);
		rootNode.add(inputField, 0, 1);
		rootNode.add(button1, 1, 0);
		rootNode.add(button2, 2, 0);
		rootNode.add(button3, 3, 0);
		rootNode.add(button4, 1, 1);
		rootNode.add(button5, 2, 1);
		rootNode.add(button6, 3, 1);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	

}

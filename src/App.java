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
	Button button1 = new Button("1");
	Button button2 = new Button("2");
	Button button3 = new Button("3");
	Button button4 = new Button("4");
	Button button5 = new Button("5");
	Button button6 = new Button("6");
	Button buttonAdd = new Button("+");
	Button buttonSubtract = new Button("-");
	Button buttonEqual = new Button("=");
	Button buttonClear = new Button("C");
	Button buttonBinary = new Button("To Bianry");
	
	TextField inputField = new TextField();
	Label input = new Label();

	ButtonHandler buttonHandler = new ButtonHandler();
	Calculate calculate = new Calculate();
	
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

		buttonBinary.setOnAction(e -> buttonPressed(e));
		
		//adding method for all number buttons to add value to them...
		button1.setOnAction(e -> buttonPressed(e)); // Sends the action event to the buttonPressed method
		button2.setOnAction(e -> buttonPressed(e));
		button3.setOnAction(e -> buttonPressed(e));
		button4.setOnAction(e -> buttonPressed(e));
		button5.setOnAction(e -> buttonPressed(e));
		button6.setOnAction(e -> buttonPressed(e));
		
		//button actions for operators
		buttonAdd.setOnAction(e -> buttonPressed(e));
		buttonSubtract.setOnAction(e -> buttonPressed(e));
		buttonEqual.setOnAction(e -> buttonPressed(e));
		buttonClear.setOnAction(e -> buttonPressed(e));
		//adding to rootnode
		rootNode.add(buttonBinary, 0, 2);
		rootNode.add(input, 0, 0);
		rootNode.add(inputField, 0, 1);
		rootNode.add(button1, 1, 0);
		rootNode.add(button2, 2, 0);
		rootNode.add(button3, 3, 0);
		rootNode.add(button4, 1, 1);
		rootNode.add(button5, 2, 1);
		rootNode.add(button6, 3, 1);
		rootNode.add(buttonAdd, 4, 0);
		rootNode.add(buttonSubtract, 4, 1);
		rootNode.add(buttonEqual, 4, 2);
		rootNode.add(buttonClear, 4, 3);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	
	public void buttonPressed(ActionEvent e)
	{
		String value = "";
		
		if(e.getSource() == button1){
			value = "1";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == button2){
			value = "2";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == button3){
			value = "3";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == button4){
			value = "4";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == button5){
			value = "5";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == button6){
			value = "6";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if(e.getSource() == buttonAdd){
			value = "+";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if(e.getSource() == buttonSubtract){
			value = "-";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if(e.getSource() == buttonEqual){
			String numberSend = buttonHandler.returnResult();
			int answer = calculate.calculate(numberSend);
			String inputAnswer = Integer.toString(answer);
			input.setText(inputAnswer);
		}
		else if(e.getSource() == buttonClear){
			buttonHandler.clearAll();
			input.setText("");
		}
		else if(e.getSource() == buttonBinary) {
			String result = calculate.toBinary();
			input.setText(result);
			//ToBinary toBinary = new ToBinary();
			//toBinary.decide(inputField.getText());
		}
	}

}

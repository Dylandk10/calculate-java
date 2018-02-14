import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.*;

public class App extends Application {
	Button button0 = new Button("0");
	Button button1 = new Button("1");
	Button button2 = new Button("2");
	Button button3 = new Button("3");
	Button button4 = new Button("4");
	Button button5 = new Button("5");
	Button button6 = new Button("6");
	Button button7 = new Button("7");
	Button button8 = new Button("8");
	Button button9 = new Button("9");
	//button operators
	Button buttonAdd = new Button("+");
	Button buttonSubtract = new Button("-");
	Button buttonMultiply = new Button("x");
	Button buttonDivide = new Button("/");
	Button buttonEqual = new Button("=");
	Button buttonClear = new Button("C");
	//button convert
	Button buttonBinary = new Button("To Bianry");
	Button buttonHexidecimal = new Button("To Hexidecimal");
	Button buttonPop = new Button("Enter hexidecimal manually");
	//popup window buttons
	Button btnBinary = new Button("To Binary");
	
	//main label for app
	Label input = new Label("00000");
	//popup label
	Label label = new Label("Enter hexidecimal");
	//Textfield popup
	TextField text = new TextField();
	//class handlers...
	ButtonHandler buttonHandler = new ButtonHandler();
	Calculate calculate = new Calculate();
	ToBinary toBinary = new ToBinary();
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Application");
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(10, 0, 0, 0) );
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode, 500, 500);
		//convert options
		buttonBinary.setOnAction(e -> convertPressed(e));
		buttonHexidecimal.setOnAction(e -> convertPressed(e));
		buttonPop.setOnAction(e -> convertPressed(e));
		
		//adding method for all number buttons to add value to them...
		button0.setOnAction(e -> buttonPressed(e));
		button1.setOnAction(e -> buttonPressed(e)); 
		button2.setOnAction(e -> buttonPressed(e));
		button3.setOnAction(e -> buttonPressed(e));
		button4.setOnAction(e -> buttonPressed(e));
		button5.setOnAction(e -> buttonPressed(e));
		button6.setOnAction(e -> buttonPressed(e));
		button7.setOnAction(e -> buttonPressed(e));
		button8.setOnAction(e -> buttonPressed(e));
		button9.setOnAction(e -> buttonPressed(e));
		
		//button actions for operators
		buttonAdd.setOnAction(e -> operatorPressed(e));
		buttonSubtract.setOnAction(e -> operatorPressed(e));
		buttonMultiply.setOnAction(e -> operatorPressed(e));
		buttonDivide.setOnAction(e -> operatorPressed(e));
		buttonEqual.setOnAction(e -> operatorPressed(e));
		buttonClear.setOnAction(e -> operatorPressed(e));
		//adding to rootnode convert input...
		rootNode.add(input, 0, 0);
		rootNode.add(buttonBinary, 0, 1);
		rootNode.add(buttonHexidecimal, 0, 2);
		rootNode.add(buttonPop, 0, 3);
		//adding to rootnode numbers
		rootNode.add(button0, 4, 4);
		rootNode.add(button1, 1, 0);
		rootNode.add(button2, 2, 0);
		rootNode.add(button3, 3, 0);
		rootNode.add(button4, 1, 1);
		rootNode.add(button5, 2, 1);
		rootNode.add(button6, 3, 1);
		rootNode.add(button7, 1, 2);
		rootNode.add(button8, 2, 2);
		rootNode.add(button9, 3, 2);
		//adding to rootnode operators
		rootNode.add(buttonAdd, 4, 0);
		rootNode.add(buttonSubtract, 4, 1);
		rootNode.add(buttonMultiply, 3, 3);
		rootNode.add(buttonDivide, 2, 3);
		rootNode.add(buttonEqual, 4, 2);
		rootNode.add(buttonClear, 4, 3);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	//button handling for number events...
	public void buttonPressed(ActionEvent e) {
		String value = "";
		if (e.getSource() == button0) {
			value="0";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button1) {
			value = "1";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button2) {
			value = "2";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button3) {
			value = "3";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button4) {
			value = "4";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button5) {
			value = "5";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button6) {
			value = "6";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button7) {
			value = "7";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button8) {
			value = "8";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}
		else if (e.getSource() == button9) {
			value="9";
			buttonHandler.addResult(value);
			input.setText(buttonHandler.returnResult());
		}

	}
	
	public void operatorPressed(ActionEvent e) {
		String value = "";
		if (e.getSource() == buttonAdd) {
			value = "+";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if (e.getSource() == buttonSubtract) {
			value = "-";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if (e.getSource() == buttonMultiply) {
			value = "*";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if (e.getSource() == buttonDivide) {
			value = "/";
			//calculate.init(buttonHandler.returnResult());
			calculate.setOperator(value, buttonHandler.returnResult());
			buttonHandler.clearResult();
			input.setText("");
		}
		else if (e.getSource() == buttonEqual) {
			String numberSend = buttonHandler.returnResult();
			int answer = calculate.calculate(numberSend);
			String inputAnswer = Integer.toString(answer);
			input.setText(inputAnswer);
		}
		else if (e.getSource() == buttonClear) {
			buttonHandler.clearAll();
			input.setText("00000");
		}
	}
	
	public void convertPressed(ActionEvent e) {
		if (e.getSource() == buttonBinary) {
			String result = calculate.toBinary();
			input.setText(result);
			//ToBinary toBinary = new ToBinary();
			//toBinary.decide(inputField.getText());
		}
		else if (e.getSource() == buttonHexidecimal) {
			String hexResult = calculate.toHexidecimal();
			input.setText(hexResult);
		} else if (e.getSource() == buttonPop) {
			//Stage theStage = (Stage) e.getSource();
			createPopUp();
			
		}
	}
	//popup to override primary stage...
	public void createPopUp() {
		Stage theStage = new Stage();
		HBox layout = new HBox(60);
		btnBinary.setOnAction(e -> popupBinaryPressed(e));
		layout.setSpacing(30);;
		layout.getChildren().addAll(label, text, btnBinary);
		theStage.setScene(new Scene(layout));
		theStage.show();
		   
	}
	public void popupBinaryPressed(ActionEvent e) {
		if(e.getSource() == btnBinary) {
			String toSend = text.getText();
			if(toBinary.decide(toSend)) {
				label.setText(toBinary.convertStringHex(toSend));
			} else {
				label.setText("Enter Valid Hexidecimal");
			}
		}
	}
}

import sockets.ClientSocket;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
	Button buttonHexadecimal = new Button("To Hexadecimal");
	Button buttonPopHex = new Button("Enter hexadecimal manually");
	Button buttonPopBi = new Button("Enter Binary manually");
	//popup window buttons
	Button btnBinary = new Button("To Binary");
	Button btnHexadecimal = new Button("To Hexadecimal");
	
	//main label for app
	Label input = new Label("00000");
	//popup label
	Label labelHex = new Label("Enter hexadecimal");
	Label labelBi = new Label("Enter Bianry");
	//Textfield popup
	TextField textHex = new TextField();
	TextField textBi = new TextField();
	//class handlers...
	ButtonHandler buttonHandler = new ButtonHandler();
	Calculate calculate = new Calculate();
	ToBinary toBinary = new ToBinary();
	ToHexadecimal toHexadecimal = new ToHexadecimal();
	//socket
	ClientSocket clientSocket;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//set up sockets
		clientSocket = new ClientSocket();
		clientSocket.run();
		
		//app set up
		primaryStage.setTitle("Application");
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(10, 0, 0, 0) );
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode, 500, 500);
		//convert options
		buttonBinary.setOnAction(e -> convertPressed(e));
		buttonHexadecimal.setOnAction(e -> convertPressed(e));
		buttonPopHex.setOnAction(e -> convertPressed(e));
		buttonPopBi.setOnAction(e -> convertPressed(e));
		
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
		rootNode.add(buttonHexadecimal, 0, 2);
		rootNode.add(buttonPopHex, 0, 3);
		rootNode.add(buttonPopBi, 0, 4);
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
		//close ports on close event
	    primaryStage.setOnCloseRequest((WindowEvent ev) -> {
	    	   	clientSocket.close();
	    	   	primaryStage.close();
	    });
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
			//send to socket
			clientSocket.sendData(Integer.parseInt(inputAnswer));
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
		else if (e.getSource() == buttonHexadecimal) {
			String hexResult = calculate.toHexidecimal();
			input.setText(hexResult);
		} 
		else if (e.getSource() == buttonPopHex) {
			//Stage theStage = (Stage) e.getSource();
			createPopUpHex();
		}
		else if (e.getSource() == buttonPopBi) {
			createPopBinary();
		}
	}
	//popup to override primary stage...hexadecimal
	public void createPopUpHex() {
		Stage theStage = new Stage();
		HBox layout = new HBox(60);
		//button action to call popup methods...
		btnBinary.setOnAction(e -> popupBinaryPressed(e));
		layout.setSpacing(30);;
		layout.getChildren().addAll(labelHex, textHex, btnBinary);
		theStage.setScene(new Scene(layout));
		theStage.show();
		   
	}
	//popup to override primary stage...Binary
	public void createPopBinary() {
		Stage theStage = new Stage();
		HBox layout = new HBox(60);
		//button action to call popup methods...
		btnHexadecimal.setOnAction(e -> popupHexPressed(e));
		layout.setSpacing(30);;
		layout.getChildren().addAll(labelBi, textBi, btnHexadecimal);
		theStage.setScene(new Scene(layout));
		theStage.show();
		   
	}
	//action handlers for hexadecimal popup window
	public void popupBinaryPressed(ActionEvent e) {
		if(e.getSource() == btnBinary) {
			String toSend = textHex.getText();
			if(toBinary.decide(toSend)) {
				labelHex.setText(toBinary.convertStringHex(toSend));
			} else {
				labelHex.setText("Enter Valid Hexadecimal");
			}
		}
	}
	public void popupHexPressed(ActionEvent e) {
		String toSend = textBi.getText();
		labelBi.setText(toHexadecimal.binaryToHexadecimal(toSend));
	}
}

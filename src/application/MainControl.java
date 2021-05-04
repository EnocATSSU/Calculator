package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/****
 * 
 * @author Enoc Gonzalez 
 *
 */

public class MainControl {
	
	/**
	 * Variable declaration and connections made to FXML on SceneBuilder,
	 * number declaration for basic operations on calculator
	 * x and y variables for the closing pane of calculator 
	 * 
	 */
	
	@FXML private Pane titlePane; //Pane to make closing button work
	@FXML private ImageView bclose, bminimize; //connection of closing and minimize button
	@FXML private Label results; //display screen of results
	@FXML private String operator = ""; 
	@FXML private boolean start; 
	
	@FXML private Button clear; 

	private long num1 = 0;
	private long num2 = 0;

	private double x;
	private double y;
	
	
	// Handle closing button and dragging calculator on the screen
	public void initialize(Stage s) {
		
		
		titlePane.setOnMousePressed(mouseEvent->{
		x = mouseEvent.getSceneX();
		y = mouseEvent.getSceneY();
		
		});
		titlePane.setOnMouseDragged(mouseEvent->{
			s.setX(mouseEvent.getScreenX()-x);
			s.setY(mouseEvent.getScreenY()-y);
			
		});
		bclose.setOnMouseClicked(mouseEvent ->{ 
			s.close();
		});
		
		bminimize.setOnMouseClicked(mouseEvent ->{
			s.setIconified(true);
		});		
		
} 
	
	/**
	 * Handles number display on the calculator by getting the number as a String and 
	 * When start is true the screen of results is set to default, set to false to exit the if statement
	 * @FXML connection
	 * @param event
	 */
		@FXML 
	public void Numbers(ActionEvent event) {
			
		if(start) {
			results.setText("");
			start=false;
		}
		
		String value = ((Button)event.getSource()).getText(); //Get number
		results.setText(results.getText() + value); //set number 
	
	}

		/**
		 * Handles operators input into the screen
		 * Also handles Parsing numbers from String to Long, and calls Operator methods to 
		 * do the operations
		 * @param event
		 */
	@FXML 
	public void processOperators(ActionEvent event)  {
		
		String value = ((Button)event.getSource()).getText(); //get operator
		
		
			
		if(!value.equals("=")) 
		{
			
				
			if(!operator.isEmpty())
				return;

			
			operator = value;
			num1 = Long.parseLong(results.getText());
			results.setText("");
			
		}
		else
		{
			if(operator.isEmpty()) 
				return;	
			
			num2 = Long.parseLong(results.getText());
			float call = Operators(num1,num2,operator);
			results.setText(String.valueOf(call));
			operator ="";
			start = true;
		}
	}
	
	/**
	 * Clear Button method to handle clearing the screen when pressed
	 * @param e
	 */
	public void clearbutton(ActionEvent e) {
		if(e.getSource()==clear) { 
		results.setText("");
		}
	}
	
	/**
	 * Operator method handles the math done in the calculator
	 * @param num1 is the first number passed from ProcessOperators method
	 * @param num2 is the second number
	 * @param operator Operator in String form passed to the method, switch case scenario to handle
	 * operations
	 * @return
	 */
	public float Operators(long num1, long num2, String operator) {
		
		
		switch(operator) 
		{
		case"+":
			return num1 + num2;
		case"-":
			return num1-num2;
		case"x":
			return num1 * num2;
		case"/":
			if(num2==0) 
				return 0;
			return num1/num2;
		
		default:
			return 0;
		
		
	}
	}
	
	}
	
	
	


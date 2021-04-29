package application;
	

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/****
 * 
 * @author Enoc Gonzalez & Preet
 *
 */

public class Main extends Application { 

	
	
	@FXML Button mainColor; //Changes scene to Stardust Calculator
	@FXML Button blueColor; //Changes scene to Ocean Soul 
	@FXML Button blackColor; //Changes color to void. color
	
	@FXML
    private Label lblLogin;  //Login Label
    @FXML
    private TextField txtUserName; 
    @FXML
    private TextField txtPassword;
    
	
	@Override //Start method holding first scene (log in)
	public void start(Stage c) throws Exception {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginScene.fxml"));
		c.initStyle(StageStyle.TRANSPARENT);
		Scene scene1 = new Scene(loader.load());
		scene1.setFill(Color.TRANSPARENT); 
		c.setScene(scene1);
		c.setResizable(false);
		c.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
		
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/**
	 * handle method to take care of color selection and scene change from scene 2 to calculators
	 * @param e
	 * @throws Exception
	 */
	
	@FXML 
	public void handle(ActionEvent e)throws Exception {
		
		try {
		Stage c;
		FXMLLoader loader;
	
		 if(e.getSource()==mainColor) {
			c = (Stage)mainColor.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("NewCalc.fxml"));
		}else if(e.getSource()==blueColor) {
			c = (Stage)blueColor.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("Stage2.fxml"));
		}else {
			c = (Stage)blackColor.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("Stage3.fxml"));
		}
		 c.initStyle(StageStyle.TRANSPARENT);
		Scene scene = new Scene(loader.load());
		
		((MainControl)loader.getController()).initialize(c);
		c.setScene(scene);
		scene.setFill(Color.TRANSPARENT); 
		
		c.setResizable(false);
		//c.setTitle("Calculator");
		c.getIcons().add(new Image(getClass().getResourceAsStream("/calc.jpeg")));
		
		c.show();
		}catch(Exception el) {
			el.printStackTrace();
		}
	}
	/**
	 * Log method to handle change from scene to scene 2,
	 * also handles the user putting in the right log in information, 
	 * Try and catch  implemented to hadnle exceptions
	 * @Username  = User
	 * @Password = Pass  
	 * @param e
	 * @throws Exception
	 */
	public void Log(ActionEvent e)throws Exception {
		 
		   try {
		        if(txtUserName.getText().equals("User")&&txtPassword.getText().equals("Pass")) {
		                 lblLogin.setText("Login Success"); 
		                 
		                 Stage primaryStage = new Stage();
		                 primaryStage.initStyle(StageStyle.TRANSPARENT);
		                 
		                 FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ColorSelec.FXML"));
		                 Scene scene = new Scene(root.load());
		                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		         		
		                 scene.setFill(Color.TRANSPARENT); 
		         		 
		                 primaryStage.setScene(scene);
		                 primaryStage.setResizable(false);
		                
		                 primaryStage.show();
		}
		        else {
		                 lblLogin.setText("Login Failed");
	      	}
		   }catch(Exception x){
			x.printStackTrace();
		     }
		}
	
		
	}
	
	


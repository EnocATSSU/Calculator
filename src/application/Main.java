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

	
	@FXML ImageView bcloseColor, bminimizeColor; //Only for Color Selection Screen
	@FXML Pane titlePaneColor;
	FXMLLoader loading;
	@FXML private Pane titlePane; //Pane to make closing button work
	private double x;
	private double y;
	private double z;
	private double w;
	@FXML ImageView bclose, bminimize; //Only for Log in Screen
	@FXML Button submit; //Submit button to change scene
	@FXML Button mainColor; //Changes scene to Stardust Calculator
	@FXML Button blueColor; //Changes scene to Ocean Soul 
	@FXML Button blackColor; //Changes color to void. color
	@FXML
    private Label lblLogin;  //Login Label
    @FXML
    private TextField txtUserName; //Username
    @FXML
    private TextField txtPassword; //Password
    

	@Override //Start method holding first scene (log in)
	public void start(Stage c) throws Exception {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginScene.fxml"));
		
			c.initStyle(StageStyle.TRANSPARENT);
			Scene scene1 = new Scene(loader.load());
			scene1.setFill(Color.TRANSPARENT); 
			c.setScene(scene1);
			c.setResizable(false);
			((Main)loader.getController()).bttC(c);

			c.show();
			}catch(Exception ex) {
				ex.printStackTrace();
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
			// c.initStyle(StageStyle.TRANSPARENT);
			Scene scene = new Scene(loader.load());
		
			c.setScene(scene);
			scene.setFill(Color.TRANSPARENT); 
			
			
			c.setResizable(false);
			//c.setTitle("Calculator");
			c.getIcons().add(new Image(getClass().getResourceAsStream("/calc.jpeg")));
			((MainControl)loader.getController()).initialize(c);
			c.show();
			}catch(Exception el) {
				el.printStackTrace();
			}
		}
	
	/**
	 * Log method to handle change from scene to scene 2,
	 * also handles the user putting in the right log in information, 
	 * Try and catch  implemented to handle exceptions
	 * @Username  = User
	 * @Password = Pass  
	 * @param e
	 * @throws Exception
	 */
	
	@FXML
	public void Log(ActionEvent ev)throws Exception{
	
		
		Stage c = new Stage();
		try {
		
			
		if(txtUserName.getText().equals("User")&&txtPassword.getText().equals("Pass")&&ev.getSource().equals(submit)) {
            lblLogin.setText("Login Success"); 
			c = (Stage)submit.getScene().getWindow();
			loading = new FXMLLoader(getClass().getResource("ColorSelec.fxml"));
		Scene scene = new Scene(loading.load());
		c.setScene(scene);
		scene.setFill(Color.TRANSPARENT); 
		
		c.setResizable(false);
		//c.setTitle("Calculator");
		((Main)loading.getController()).closeColor(c);
		c.getIcons().add(new Image(getClass().getResourceAsStream("/calc.jpeg")));
		c.show();
		
		}else if (!txtUserName.getText().equals("User")||!txtPassword.getText().equals("Pass")){
			if(ev.getSource().equals(submit)) {
				 lblLogin.setText("Login Failed");}
			
			}
		
		}catch(Exception el) {
			el.printStackTrace();
		}
		
		
		
	}
	
	/***
	 * Method to handle closing button and moving around in Login Scene
	 * @param s
	 */
	public void bttC(Stage s) {
		

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
	 * Method to handle closing button and moving around in Color Scene
	 * @param s
	 */
	public void closeColor(Stage s) {
		titlePaneColor.setOnMousePressed(mouseEvent->{
			z = mouseEvent.getSceneX();
			w = mouseEvent.getSceneY();
			
			});
			titlePaneColor.setOnMouseDragged(mouseEvent->{
				s.setX(mouseEvent.getScreenX()-z);
				s.setY(mouseEvent.getScreenY()-w);
				
			});
			bcloseColor.setOnMouseClicked(mouseEvent ->{ 
				s.close();
			});
			
			bminimizeColor.setOnMouseClicked(mouseEvent ->{
				s.setIconified(true);
			});		
			
	}
	}

	
	
	
	


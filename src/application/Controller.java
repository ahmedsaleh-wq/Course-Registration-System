package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private AnchorPane root2;

    @FXML
    private Label StudentNameLabel;

    @FXML
    private Label StudentIDLabel;

    @FXML
    private Label StudentDegreeLabel;

    @FXML
    private Label StudentYearLabel;

    @FXML
    private ListView<?> EnrolledCourses;

    @FXML
    private ListView<?> CompletedCourses;

    @FXML
    private Label StudentGPALabel;

    @FXML
    private ComboBox<?> ListOfCourses;

    @FXML
    private Button EnrollButton;
	
	@FXML
    private AnchorPane LoginStage;
	
	
	@FXML
	private Pane StudSignupPane;
	

	@FXML
	private Pane LecSignupPane;
	
    @FXML
    private Pane MainPane;

    @FXML
    private Button StudentsButton;

    @FXML
    private Button LectrureButton;

    @FXML
    private Pane LecturersPane;

    @FXML
    private Button signupLectrure;

    @FXML
    private Pane StudentsPane;

    @FXML
    private Button signupStudent;
    
    @FXML
    private PasswordField studentPassword;

    @FXML
    private TextField studentID;
    
    @FXML
    private PasswordField lecturerPassword;

    @FXML
    private TextField lecturerID;
   
    
    @FXML
    void showLecLogin() {
    	MainPane.setVisible(false);
    	LecturersPane.setVisible(true);
    	StudentsPane.setVisible(false);
    }
    
    @FXML
    void showStudLogin() {
    	MainPane.setVisible(false);
    	LecturersPane.setVisible(false);
    	StudentsPane.setVisible(true);
    }
    
    @FXML
    void BackToMain() {
    	MainPane.setVisible(true);
    	LecturersPane.setVisible(false);
    	StudentsPane.setVisible(false);
    	LecSignupPane.setVisible(false);
    	StudSignupPane.setVisible(false);
    }
    
    @FXML
    void LecSignup() {
    	MainPane.setVisible(false);
    	LecturersPane.setVisible(false);
    	StudentsPane.setVisible(false);
    	LecSignupPane.setVisible(true);
    	StudSignupPane.setVisible(false);
    }
    
    @FXML
    void StudSignup() {
    	MainPane.setVisible(false);
    	LecturersPane.setVisible(false);
    	StudentsPane.setVisible(false);
    	LecSignupPane.setVisible(false);
    	StudSignupPane.setVisible(true);
    }
    
    @FXML
    void StudentLog(ActionEvent e) throws IOException {
    	String filePath = "src\\application\\source\\students.txt";
    	Map<String, String> StudentsLogin = new HashMap<String, String>();
    	String delimiter = ",";
    	
    	try(Stream<String> lines = Files.lines(Paths.get(filePath))){    
            lines.filter(line -> line.contains(delimiter)).forEach(
                line -> StudentsLogin.putIfAbsent(line.split(delimiter)[1], line.split(delimiter)[2])
            );
        }
    	
   	if(StudentsLogin.get(studentID.getText()).equals(studentPassword.getText())) {
   		File myObj = new File("src\\application\\source\\temp.txt");
   		FileWriter myWriter = new FileWriter("src\\application\\source\\temp.txt");
        myWriter.write(studentID.getText());
        myWriter.close();
   		loadStudent();
    	}else{
   		JOptionPane.showMessageDialog(null, "Wrong password or ID");}
   
    }
    
    
    @FXML
    void loadStudent() throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	LoginStage.getChildren().setAll(pane);
    	
    }
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    @FXML
    void LecturerLog(ActionEvent e) throws IOException {
    	String filePath = "src\\application\\source\\lecturers.txt";
    	Map<String, String> lecturerLogin = new HashMap<String, String>();
    	String delimiter = ",";
    	
    	try(Stream<String> lines = Files.lines(Paths.get(filePath))){    
            lines.filter(line -> line.contains(delimiter)).forEach(
                line -> lecturerLogin.putIfAbsent(line.split(delimiter)[1], line.split(delimiter)[2])
            );
        }
    	
   	if(lecturerLogin.get(lecturerID.getText()).equals(lecturerPassword.getText())) {

   		loadLecturer(); 
    	}else{
   		JOptionPane.showMessageDialog(null, "Wrong password or ID");}
    }
    
    
    
    @FXML
    void loadLecturer() throws IOException {
    	AnchorPane pane2 = FXMLLoader.load(getClass().getResource("Sample3.fxml"));
    	LoginStage.getChildren().setAll(pane2);
    }
    

    
    
}

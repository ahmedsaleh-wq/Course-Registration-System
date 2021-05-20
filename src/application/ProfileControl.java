package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ProfileControl {
    
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
    private ListView EnrolledCourses;

    @FXML
    private ListView CompletedCourses;

    @FXML
    private Label StudentGPALabel;

    @FXML
    private ComboBox ListOfCourses;

    @FXML
    private Button EnrollButton;
    
    @FXML
    private Pane WelcomePane;

    @FXML
    private Button letsGo;
    
    String name = "", id = "", degree = "";
    Double GPA = 0.0;
    int year = 0;
    
    @FXML
    void  showStudent(ActionEvent e) throws IOException {
    	WelcomePane.setVisible(false);
    	File myObj = new File("src\\application\\source\\temp.txt");
    	Scanner tempReader = new Scanner(myObj);
        String data = tempReader.nextLine();
        
          
        File filePath = new File("src\\application\\source\\students.txt");
      	Scanner Reader = new Scanner(filePath);
      	
      	while(Reader.hasNextLine()) {
      		String temp = Reader.nextLine();
      		String[] array = temp.split( "," );
      		for(int j = 0; j<array.length;j++)
     			if(array[j].equals(data)) {
     				name = array[0];
     				id = array[1];
     				degree = array[4];
     				GPA = Double.parseDouble(array[3]);
     				year = Integer.parseInt(array[5]);
      		}
      	}

      	
      	tempReader.close();
      	Reader.close();
      	
    	Students s1 =  new Students(name, id, GPA, degree, year);
    	StudentNameLabel.setText("Name: "+name);
    	StudentIDLabel.setText("ID: "+id);
    	StudentDegreeLabel.setText("Degree: "+degree);
    	StudentGPALabel.setText(String.valueOf("GPA: "+GPA));
    	StudentYearLabel.setText(String.valueOf("Year: "+year));
    	
    	String coursePath = "";
    	switch(degree){
    	case "CS":
    		coursePath = "src\\application\\source\\CS.txt";
    		break;
    	case "ENG":
    		coursePath = "src\\application\\source\\ENG.txt";
    		break;
    	case "BUS":
    		coursePath = "src\\application\\source\\BUS.txt";
    		break;
    		default:
    			}    
    	
    	
    	List<String> CourseList;	
    	CourseList = Files.lines(Paths.get(coursePath)).collect(Collectors.toList());		
     	ListOfCourses.setItems(FXCollections.observableArrayList(CourseList));
     	
     	String idPath ="src\\application\\source\\students data\\"+id+".txt";
     	File file = new File(idPath);
     	if (file.createNewFile()){
     		System.out.println("File is created!");
     	}else {
     	    System.out.println("File already exists.");
     	}

     	List<String> completedCourses = new ArrayList<String>();
     	completedCourses = Files.lines(Paths.get(idPath)).collect(Collectors.toList());		
    	CompletedCourses.getItems().addAll(completedCourses);
     	
    	
    	String idEnrolledPath ="src\\application\\source\\students data\\"+id+"enrolled.txt";
     	File enrolledFile = new File(idEnrolledPath);
     	if (enrolledFile.createNewFile()){
     		System.out.println("File is created!");
     	}else {
     	    System.out.println("File already exists.");
     	}
     	
     	List<String> enrolledCourses = new ArrayList<String>();
     	enrolledCourses = Files.lines(Paths.get(idEnrolledPath)).collect(Collectors.toList());		
    	EnrolledCourses.getItems().addAll(enrolledCourses);
  }
    
    @FXML
    void EnrolCourse(ActionEvent e) throws IOException { 	
    	if(EnrolledCourses.getItems().contains(ListOfCourses.getValue())) {
    		JOptionPane.showMessageDialog(null, "Already exist");
    	}else {
    	EnrolledCourses.getItems().add(ListOfCourses.getValue());
    	String Course = (String) ListOfCourses.getValue();
    	String idEnrolledPath ="src\\application\\source\\students data\\"+id+"enrolled.txt";
     	FileWriter fw = new FileWriter(idEnrolledPath,true);
        fw.write(Course);
        fw.close();}
    }
    
    
    
}



    





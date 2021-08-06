package Application;

import java.awt.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class StudentRegistrationController  {

	@FXML
    private DatePicker calendarpicker;

    @FXML
    private TextField txt_StudentName;

    @FXML
    private TextField txt_stdntIC;

    @FXML
    private TextField txt_adress;

    @FXML
    private TextField txt_formerschool;

    @FXML
    private TextField txt_primaryschool;

    @FXML
    private TextField txt_healthcondition;

    @FXML
    private TextField txt_FathertName;

    @FXML
    private TextField txt_idFather;

    @FXML
    private TextField txt_emailFather;

    @FXML
    private TextField txt_PhoneNumFather;

    @FXML
    private TextField txt_MotherName;

    @FXML
    private TextField txt_IdMother;

    @FXML
    private TextField txt_emailmother;

    @FXML
    private TextField txt_phoneNumMother;

    @FXML
    private TextField txt_GuardianName;

    @FXML
    private TextField txt_IdGuardian;

    @FXML
    private TextField txt_emailGuardian;

    @FXML
    private TextField txt_phoneNumGuardian;
    
    @FXML
    private Button buttonchoosefile2;

    @FXML
    private Button buttonchoosefile1;

    @FXML
    private Button buttonchoosefile3;

    @FXML
    private ChoiceBox<Religion> CB_RELIGION;

    @FXML
    private ChoiceBox<Race> CB_RACE;

    @FXML
    private ChoiceBox<Citizenship> CB_CTZNSHIP;

    @FXML
    private ChoiceBox<Sex> cb_sex;


	    int index = -1;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
	
		public void Register() {
		
		con= MySQLConnect.ConnectDB();
		String sql = " insert into students(stdntName,stdntIc,adress,formerschool,primaryschool,healthconditon,FatherName,idFather,emailFather,PhoneNumFather,MotherName,idMother,emailMother,PhoneNumMother,GuardianName,GuardianId,GuardianEmail,GUardianPhoneNum)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, txt_StudentName.getText());
			pst.setString(2, txt_stdntIC.getText());
			pst.setString(3, txt_adress.getText());
			pst.setString(4, txt_formerschool.getText());
			pst.setString(5, txt_primaryschool.getText());
			pst.setString(6, txt_healthcondition.getText());
			pst.setString(7, txt_FathertName.getText());
			pst.setString(8, txt_idFather.getText());
			pst.setString(9, txt_emailFather.getText());
			pst.setString(10,txt_PhoneNumFather.getText());
			pst.setString(11, txt_MotherName.getText());
			pst.setString(12, txt_IdMother.getText());
			pst.setString(13, txt_emailmother.getText());
			pst.setString(14, txt_phoneNumMother.getText());
			pst.setString(15, txt_GuardianName.getText());
			pst.setString(16, txt_IdGuardian.getText());
			pst.setString(17, txt_emailGuardian.getText());
			pst.setString(18, txt_phoneNumGuardian.getText());
			
			String value1 = CB_RELIGION.getSelectionModel().getSelectedItem().toString();
			pst.setString(19, value1);
			
			String value2 = CB_RACE.getSelectionModel().getSelectedItem().toString();
			pst.setString(20, value2);
			
			String value3 = CB_RELIGION.getSelectionModel().getSelectedItem().toString();
			pst.setString(21, value3);
			
			String value4 = cb_sex.getSelectionModel().getSelectedItem().toString();
			pst.setString(22, value4);
			
			pst.setString(23, ((TextField)calendarpicker.getEditor()).getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Student Add Success");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}	



package Project;

import java.io.IOException;

import javax.swing.text.Highlighter.HighlightPainter;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.StudentManagement.comcast.BaseUtility.Baseclass;
import com.StudentManagement.comcast.ObjectRepository.AddTeacherPage;
import com.StudentManagement.comcast.ObjectRepository.EventPage;
import com.StudentManagement.comcast.ObjectRepository.HomePage;
import com.StudentManagement.comcast.ObjectRepository.LoginPage;
import com.StudentManagement.comcast.ObjectRepository.TeacherPage;

public class TeacherEventTest extends Baseclass{
	String title;
	@Test
	public void createEvent() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getEventlink().click();
		hp.getMyeventslink().click();
		EventPage ep=new EventPage(driver);
		ep.getCreateeventBtn().click();
		String title=eLib.getDataFromExcel("sheet1", 1, 9);
		String Note=eLib.getDataFromExcel("sheet1", 1, 10);
		String color=eLib.getDataFromExcel("sheet1", 1, 11);
		
		
		ep.getTitleEdt().sendKeys(title);
	WebElement category=	ep.getCategoryEdt();
	wLib.selectbyIndex(category, 2);
	ep.getReservetimeEdt().click();
	ep.getFromEdt().click();
	ep.getToEdt().click();
	ep.getApplyBtn().click();
	ep.getNoteEdt().sendKeys(Note);
	ep.getColorEdt().sendKeys(color);
	ep.getSubmitBtn().click();
	hp.getProfilelink().click();
	hp.getLogoutlink().click();
	}
	@Test
	public void event() {
//	String Url=fLib.getdatafromPropertiesfile("url");
//	String Email=fLib.getdatafromPropertiesfile("teacher1email");
//	String Password=fLib.getdatafromPropertiesfile("adminpassword");
//	LoginPage lp=new LoginPage(driver);
////	lp.loginToapp(Url, Email, Password);
//	
//	lp.getUsernameEdt().sendKeys(Email);
//	lp.getPasswordEdt().sendKeys(Password);
//	lp.getLoginBtn().click();
//	  
	   TeacherPage tp=new TeacherPage(driver);
	   tp.getNotificationIcon().click();
	   tp.getEventlist().click();
	String ename=   tp.getTieleEdt().getText();
	if(ename.equals(title))
	{
		System.out.println("event is not  created");
	}
	else {
		System.out.println("event is  created");
	}
	tp.getCloseBtn().click();
	
	   
	
	
		
	}

}

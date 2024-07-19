package Project;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.StudentManagement.comcast.BaseUtility.Baseclass;
import com.StudentManagement.comcast.ObjectRepository.AddTeacherPage;
import com.StudentManagement.comcast.ObjectRepository.HomePage;
import com.StudentManagement.comcast.ObjectRepository.LoginPage;
import com.StudentManagement.comcast.ObjectRepository.TeacherPage;

public class TeacherTest extends Baseclass{
    String fname;
	@Test
	public void createteacheraccount() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTeacherlink().click();
		hp.getAddteacherlink().click();
		String index=eLib.getDataFromExcel("sheet1", 1, 5);
		 fname=eLib.getDataFromExcel("sheet1", 1, 3)+jLib.getRandomNo();
		String initialname=eLib.getDataFromExcel("sheet1", 1, 4);
		String address=eLib.getDataFromExcel("sheet1", 1, 6);
		String phone=eLib.getDataFromExcel("sheet1", 1, 8);
		String email=eLib.getDataFromExcel("sheet1", 1, 7);
		
		AddTeacherPage atp=new AddTeacherPage(driver);
		atp.getIndexEdt().sendKeys(index);
		atp.getFullnameEdt().sendKeys(fname);
		atp.getInitialEdt().sendKeys(initialname);
		atp.getAddressEdt().sendKeys(address);
		atp.getPhoneEdt().sendKeys(phone);
		atp.getEmailEdt().sendKeys(email);
		WebElement gender=atp.getGenderEdt();
		wLib.selectbyIndex(gender, 2);
		String Image=fLib.getdatafromPropertiesfile("image");
		atp.getFileEdt().sendKeys(Image);
		wLib.waitToLoad(driver);
  WebElement submit=
		  atp.getSubmitEdt();
  wLib.waitToelement(driver, submit);
     //driver.navigate().back();
       TeacherPage tp=new TeacherPage(driver);
       
  
		hp.getProfilelink().click();
		hp.getLogoutlink().click();
	}
		@Test(dependsOnMethods = "createteacheraccount")
		public void Teacher() {
//		String Url=fLib.getdatafromPropertiesfile("url");
//		String Email=fLib.getdatafromPropertiesfile("teacher1email");
		//String Password=fLib.getdatafromPropertiesfile("12345");
//		LoginPage lp=new LoginPage(driver);
//		lp.loginToapp(Url, "xyy@gmail.com", "12345");
			HomePage hp=new HomePage(driver);
			hp.getTeacherlink().click();
		hp.getAllteacherlink().click();
		TeacherPage tp=new TeacherPage(driver);
		String fname1="mm";
		tp.getSearchEdt().sendKeys(fname1);
	String actName=	tp.getNameEdt().getText();
		if(actName.equals(fname1)) {
		System.out.println("Teacher account is created");
	}
	else {
		System.out.println("Teacher account is not created");
	}
	hp.getProfilelink().click();
	hp.getLogoutlink().click();
		
	}

}

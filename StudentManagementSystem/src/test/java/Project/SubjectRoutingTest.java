package Project;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.StudentManagement.comcast.BaseUtility.Baseclass;
import com.StudentManagement.comcast.ObjectRepository.AddTeacherPage;
import com.StudentManagement.comcast.ObjectRepository.GradePage;
import com.StudentManagement.comcast.ObjectRepository.HomePage;
import com.StudentManagement.comcast.ObjectRepository.SubjectPage;
import com.StudentManagement.comcast.ObjectRepository.SubjectRoutingPage;

public class SubjectRoutingTest extends Baseclass {
	@Test
	public void createSubjectRouting() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
	//	hp.getGradelink().click();
		GradePage gp=new GradePage(driver);
//		String Grade=eLib.getDataFromExcel("Sheet1",7,0)+jLib.getRandomNo();
//		gp.getGradeNameEdt().sendKeys(Grade);
//		gp.getAdmissionFeeEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,3));
//		gp.getHallchargeEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,4));
//		gp.getNextBtn().click();
//		gp.getRangeEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,5));
//		gp.getGradeEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,6));
//		gp.getSubmitBtn().click();
		SubjectPage sp=new SubjectPage(driver);
		wLib.waitToLoad(driver);
//		Thread.sleep(2000);
//	WebElement subject=	sp.getSubjectlink();
//	wLib.waitToelement(driver, subject);
//		hp.getSubjectlink().click();
//		sp.getEnterSubEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,1));
//		sp.getSubmitbtn().click();
//		Thread.sleep(2000);
		hp.getTeacherlink().click();
		
		hp.getAddteacherlink().click();
		AddTeacherPage atp=new AddTeacherPage(driver);
		String Index=eLib.getDataFromExcel("Sheet1",7,7)+jLib.getRandomNo();
		atp.getIndexEdt().sendKeys(Index);
		atp.getFullnameEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,2));
		atp.getInitialEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,8));
		atp.getAddressEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,9));
		atp.getGenderEdt().click();
		atp.getMaleEdt().click();
		atp.getPhoneEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,10));
		atp.getEmailEdt().sendKeys(eLib.getDataFromExcel("Sheet1",7,11));
		String Image=fLib.getdatafromPropertiesfile("image");
		atp.getFileEdt().sendKeys(Image);
	WebElement submit=	atp.getSubmitEdt();
	wLib.waitToelement(driver, submit);
		SubjectRoutingPage srp=new SubjectRoutingPage(driver);
		hp.getSubjectRoutelink().click();
		srp.getAddBtn().click();
		wLib.waitToLoad(driver);
	WebElement gradedrop=	srp.getGradedropdown();
	wLib.waitToelement(driver, gradedrop);
	gradedrop.click();
		wLib.selectbyText(srp.getGradedropdown(),"Grade 3");
		srp.getSubjectDropdown().click();
		wLib.selectbyText(srp.getSubjectDropdown(),"SQL");
		srp.getTeacherdropdown().click();
		wLib.selectbyText(srp.getTeacherdropdown(),"ahanu");
		srp.getFeeEdt().sendKeys("100");
		srp.getSubmitBtn().click();		
	}
}

	



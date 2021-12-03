package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass   {
	
	public static void screenshot(WebDriver driver) throws IOException {
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);                    
		String timestamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File dest=new File("H:\\shubham\\screenshot\\img"+timestamp+".jpg");
		FileHandler.copy(scr, dest);
	}
	
	public static String xls(int i,int j) throws IOException {
		String path = "H:\\shubham\\automation\\A.xlsx";
		FileInputStream f = new FileInputStream(path);
		String S;
		try {
				S = WorkbookFactory.create(f).getSheet("Log_in").getRow(i).getCell(j).getStringCellValue();
				return S ;
		}catch(IllegalStateException e){
			    double P = WorkbookFactory.create(f).getSheet("Log_in").getRow(i).getCell(j).getNumericCellValue();
			    S=String.valueOf(P);
			return S;
		}
		
	}

}

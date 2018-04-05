package mBankingUtilityCenter;

import java.io.File;
import java.io.FileInputStream;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class AnotationListner implements IAnnotationTransformer {

	public List<String> testsEnabled = new ArrayList<>();
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
   		//System.out.println("Transformer running for " + testMethod.getName());
		testsEnabled=ExcelReader.getEnabledTests("Data","Test_Cases_Flag");
		if(testsEnabled.contains(testMethod.getName()))
			{
				annotation.setEnabled(false);
			}			
		}
}

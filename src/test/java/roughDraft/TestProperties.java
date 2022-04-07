package roughDraft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		Properties Config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.Properties");
		Config.load(fis);
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.Properties");
		OR.load(fis);
		
		System.out.println(Config.getProperty("Browser"));
		
		System.out.println(OR.getProperty("bmlBtn"));
	
		
	}
	
}

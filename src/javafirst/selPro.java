package javafirst;

import java.io.FileInputStream;
import java.util.Properties;

public class selPro {

	public static void main(String[] args) throws Exception {
		browerLaunch lun = new browerLaunch();
		Properties pro = new Properties();
		FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "\\app.properties");
		pro.load(fl);

		lun.driverset();
		lun.Launch(pro.getProperty("link"));
		lun.Launch1();
		lun.actionclass(); 
		lun.contact();
		lun.takeSnapShot();
		lun.closeBrowser();

	}

}

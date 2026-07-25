package pkg_utility;

import org.testng.Assert;
import pkg_global.GlobalObjects;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class Utility_Filehandler extends GlobalObjects {

    public void CsvDataReaderInit() {
        File oFile = new File(sCsvFilePath);
        String sOneLine = null;
        try {
            BufferedReader oBufRd = new BufferedReader(new FileReader(oFile));
            // Assuming all valid search terms are on line 0, separated by comma
            // e.g. dress,shows,toys,watch
            sOneLine = oBufRd.readLine();
            hmGlobalData.put("Searchterm_Valid", sOneLine);
            // Assuming all invalid valid search terms are on line 1, seperated by comma
            // e.g. candle
            sOneLine = oBufRd.readLine();
            hmGlobalData.put("Searchterm_Invalid", sOneLine);
            oBufRd.close();
        } catch (FileNotFoundException exFile) {
            Assert.fail("Log: Given csv file not found by buffered reader " + sCsvFilePath);
        } catch (IOException exFile) {
            Assert.fail("Log: Given csv file line reading error " + sCsvFilePath);
        }
    }

    public void PropertiesDataReaderInit() {
        Properties objProp = new Properties();
        try {
            objProp.load(new FileInputStream(sPropertiesFilePath));
            Set<String> stAllPropertyNames = objProp.stringPropertyNames();
            for (String sOnePropertyName : stAllPropertyNames) {
                hmGlobalData.put(sOnePropertyName, objProp.getProperty(sOnePropertyName));
            }
        } catch (Exception ex) {
            Assert.fail("Log: Properties file failure" + sPropertiesFilePath);
        }
    }
}

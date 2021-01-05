package com.phptravels.qa.util;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;


    public static Object[][] getData(Xls_Reader xls, String TestCaseName){

        if(!xls.isSheetExist(TestCaseName)){
            xls = null;
            return new Object[1][0];
        }

        int rows = xls.getRowCount(TestCaseName);
        int columns = xls.getColumnCount(TestCaseName);

        Object[][] Data = new Object[rows-1][columns-3];

        for(int rownum=2; rownum<=rows; rownum++){
            for(int columnnum=0; columnnum < columns-3 ; columnnum++){

                Data[rownum-2][columnnum] = xls.getCellData(TestCaseName, columnnum, rownum);
            }
        }

        return Data;
    }


}



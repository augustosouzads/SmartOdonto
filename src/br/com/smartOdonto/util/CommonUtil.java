package br.com.smartOdonto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate; 

public class CommonUtil {

    public static Boolean isNullOrEmpty(String value) {
        Predicate<String> result = v -> v.isEmpty();
        return result.test(value);
    }
    
    static public String brazilianMysqlDate(final String inputDate) {
        final String BRASIL_DATE_FORMAT = "dd/MM/yyyy";
        final String MYSQL_DATE_FORMAT = "yyyy-MM-dd";
        try {
            Date date = new SimpleDateFormat(BRASIL_DATE_FORMAT).parse(inputDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MYSQL_DATE_FORMAT);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            return "";
        }
    }

    static public String mysqlBrasilianDate(final String inputDate) {
    	 final String BRASIL_DATE_FORMAT = "dd/MM/yyyy";
         final String MYSQL_DATE_FORMAT = "yyyy-MM-dd";
        try {
            Date date = new SimpleDateFormat(MYSQL_DATE_FORMAT).parse(inputDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BRASIL_DATE_FORMAT);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            return "";
        }
    }
    
    public static void main(String[] args) {
		System.out.println(":: BRASILIAN DATE TO MYSQL DATE: "+brazilianMysqlDate("11/01/2019"));
		System.out.println(":: MYSQL DATE TO BRASILIAN DATE: "+mysqlBrasilianDate("2019-01-11"));
	}
	
	
}

package com.offcn.shopping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtils {
    public static Date stringToDate(String str){
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
             date=simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
}

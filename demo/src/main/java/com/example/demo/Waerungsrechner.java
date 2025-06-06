package com.example.demo;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Waerungsrechner {
    private HashMap<String,Double> hashMap=new HashMap<>();
    private static boolean banane=false;
    private static Waerungsrechner w;
    private double value;
    private DecimalFormat df;

    private Waerungsrechner(){
        df=new DecimalFormat("#.##");

        hashMap.put("Euro", 1.0);
        hashMap.put("US Dollar", 1.048);
        hashMap.put("British Pound", 0.83);
        hashMap.put("Japanese Yen", 160.16);
        hashMap.put("Swiss Franc", 0.95);
        hashMap.put("Canadian Dollar", 1.42);
        hashMap.put("Australian Dollar", 1.57);
        hashMap.put("Chinese Yuan", 7.29);
        hashMap.put("Indian Rupee", 87.50);
        hashMap.put("Brazilian Real", 5.20);
    }

    public static Waerungsrechner createWaerungsrechner(){
        if(!banane){
            Waerungsrechner.w=new Waerungsrechner();
            Waerungsrechner.banane=true;
            return w;
        }else {
            return w;
        }
    }
    public void saveEur(String key,double value){
        this.value=value/hashMap.get(key);
    }

    public String umrechner(String s1){
        return df.format(this.value* hashMap.get(s1))+ " " + s1;
    }
}

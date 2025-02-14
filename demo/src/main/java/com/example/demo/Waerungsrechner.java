package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Waerungsrechner {
    private HashMap<String,Double> hashMap=new HashMap<>();
    private static boolean banane=false;
    private static Waerungsrechner w;
    private double waerung1;

    private Waerungsrechner(){
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
        this.waerung1=value/hashMap.get(key);
    }

    public double umrechner(String s1){
        return this.waerung1* hashMap.get(s1);
    }

}

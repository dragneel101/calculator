package com.example.Calculator;

import android.content.Context;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.lang.Math;

public class Calculator {
    Context context;
    String numberString="0";
    String detailsString=" ";
    String operation,memoperation;
    double memory,num1,intNumber=0;
    boolean clear,divs,subs,adds,mul = false;

    DecimalFormat format = new DecimalFormat("0.#########");


    public Calculator(Context context) {
        this.context = context;
    }

    public void checkLength(){
        clear=false;
        if(numberString.length()>12){
            numberString= numberString.substring(0,12);
            Toast.makeText(context, "Result too large to display\nFirst 10 digits displayed",
                    Toast.LENGTH_LONG).show();
        }
        else if(detailsString.length()>20)
        {
            detailsString="calculation is too large";
            Toast.makeText(context, "calculation is too large",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
                intNumber = intNumber * 10 + i;
                numberString = format.format(intNumber);
                detailsString = detailsString + i;
        }
        else
            detailsString="The number is too long..";
        checkLength();

    }

    public void masterClear()
    {
        if(!clear){
            clear= true;

            detailsString=" ";
            intNumber=0;
            numberString= format.format(intNumber);
        }
        else{
            numberString="0";
            detailsString=" ";
            intNumber = 0;
            num1 =0;
            operation="";
            divs = mul = subs = adds = false;
            memory = 0;
            clear= false;
        }

    }

    public void addition(){
        if(operation != null)equals();
        operation="+";
        if(!adds){
            numberString = format.format(intNumber);
            detailsString=numberString+"+";
            num1 = intNumber;
            adds = !adds;
        }
        else
        {

            intNumber=num1+intNumber;
            num1 = intNumber;
            numberString = format.format(intNumber);
            detailsString=numberString +"+";
        }
        intNumber=0;
        checkLength();
    }

    public void subtraction(){
        if(operation != null)equals();
        operation="-";
        if(!subs){
            numberString = format.format(intNumber);
            detailsString=numberString+"-";
            num1 = intNumber;
            subs=!subs;
        }
        else
        {

            intNumber=num1-intNumber;
            num1 = intNumber;
            numberString = format.format(intNumber);
            detailsString=numberString +"-";
        }
        intNumber=0;
        checkLength();
    }

    public void multiply(){
        if(operation != null)equals();
        operation="*";
        if(!mul){
            numberString = format.format(intNumber);
            detailsString=numberString+"*";
            num1 = intNumber;
            mul=!mul;
        }
        else
        {

            intNumber=num1*intNumber;
            num1 = intNumber;
            numberString = format.format(intNumber);
            detailsString=numberString +"*";
        }
        intNumber=0;
        checkLength();
    }

    public void divide(){
        if(operation != null)equals();
        operation="/";
        if(!divs){
            numberString=format.format(intNumber);
            detailsString=numberString+"/";
            num1 = intNumber;
            divs=!divs;
        }
        else
        {

            intNumber=num1/intNumber;
            num1 = intNumber;
            numberString=format.format(intNumber);
            detailsString=numberString +"/";
        }
        intNumber=0;
        checkLength();
    }

    public void percent(){
        if(operation != null)memoperation=operation;
        operation="%";
        detailsString=detailsString +"%";
        numberString= format.format(intNumber);
        if(num1 !=0 && memoperation!="*"&& memoperation!="/")intNumber=(intNumber/100)*num1;
        else intNumber=(intNumber/100);

        checkLength();
    }

    public void exp(){
        if(intNumber!=0)multiply();
        operation="e";
        detailsString=detailsString+"e^(";
        intNumber = 0;
    }

    public void memoryClear(){
        detailsString="MC";
        memory=0;
    }

    public void memoryAdd(){
        memory= memory+intNumber;
        intNumber =0;
        detailsString="M+";
    }

    public void memorySubtract(){
        memory= memory-intNumber;
        intNumber =0;
        detailsString="M-";
    }

    public void memoryRecall(){
        numberString = format.format(memory);
        detailsString="MR";
    }

    public void equals(){
        switch(operation){
            case "+":
                detailsString= detailsString+"=";
                intNumber= num1+intNumber;
                numberString=format.format(intNumber);
                adds=!adds;
                operation="";
                checkLength();
            break;
            case "-":
                detailsString= detailsString+"=";
                intNumber= num1-intNumber;
                numberString=format.format(intNumber);
                subs=!subs;
                operation="";
                checkLength();
                break;
            case "*":
                detailsString= detailsString+"=";
                intNumber= num1*intNumber;
                numberString=format.format(intNumber);
                mul=!mul;
                operation="";
                checkLength();
                break;
            case "/":
                detailsString= detailsString+"=";
                intNumber= (num1/intNumber);
                numberString=format.format(intNumber);
                divs=!divs;
                operation="";
                checkLength();
                break;
            case "%":
                if(memoperation != null){
                    operation=memoperation;
                    equals();
                    memoperation="";
                }
                else{
                    detailsString= detailsString+"=";
                    numberString=format.format(intNumber);
                    operation="";
                    checkLength();

                }

                break;
            case "e":
                intNumber=Math.exp(intNumber);
                numberString=format.format(intNumber);
                num1 = intNumber;
                operation="";
                checkLength();
                break;

        }

    }

}

package com.darwin.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {

//    private int calculatorIntValue;
//    private double calculatorDoubleValue;
    private String calculatorStringValue = "";
    private PropertyChangeSupport support;
    private List<String> numbersToCalculate = new ArrayList<String>();

    public CalculatorModel(){
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener object){
        support.addPropertyChangeListener(object);
    }

    public void removePropertyChangeListener(PropertyChangeListener object){
        support.removePropertyChangeListener(object);
    }

    public void changeCalculatorValue(String newValue){
//        if it receives an empty string it will reset the display
        if(newValue.equals("")){
            support.firePropertyChange("calculatorStringValue",this.calculatorStringValue,newValue);
            this.calculatorStringValue = "0";
        }else {
            support.firePropertyChange("calculatorStringValue", this.calculatorStringValue, newValue);
            this.calculatorStringValue = newValue;
        }
    }

    public List<String> getNumbersToCalculate(){ return numbersToCalculate; }

    public String getCalculatorStringValue(){
        return calculatorStringValue;
    }

    public void deleteNumber(){

        StringBuilder stringBuilder = new StringBuilder(this.calculatorStringValue);
        String newValue;
//        get the length of the string
        int calculatorDisplayLength =  this.calculatorStringValue.length();

        try{
//            remove the last character of string
            stringBuilder.deleteCharAt(calculatorDisplayLength -1);
        }catch (StringIndexOutOfBoundsException e){
            this.calculatorStringValue = "";
            System.out.println("the value was emptyString");
        }

        newValue = stringBuilder.toString();
//       update changes in display
        this.changeCalculatorValue(newValue);
    }

    public void calculate(String operation){

        long longNum1;
        long longNum2;
        double doubleNum1;
        double doubleNum2;
        String result = "";
//        check if there's a first set of numbers
//        if there's any then add the second set of numbers to array
//        and calculate all the numbers within the array.
//        If array was empty then add the first set of numbers.
        if(numbersToCalculate.size() == 1){
//          add the second number to array
            numbersToCalculate.add(this.calculatorStringValue);
//            handle error exception when parsing Long or Double on both set of Numbers
            try{
//                get the first number
                longNum1 = Long.parseLong(numbersToCalculate.get(0));
//                get the second number
                longNum2 = Long.parseLong(numbersToCalculate.get(1));
                System.out.println(longNum1+" | "+longNum2);
//             calculate numbers based on the operation and covert the result to string
                switch (operation) {
                    case "+" -> result = Long.toString((longNum1 + longNum2));
                    case "-" -> result = Long.toString((longNum1 - longNum2));
                    case "*" -> result = Long.toString((longNum1 * longNum2));
                    case "/" -> result = Long.toString((longNum1 / longNum2));
                }
                System.out.println("Answer:"+result);
//                display result
                this.changeCalculatorValue(result);
//              remove all the numbers to calculate
                numbersToCalculate.clear();
//              store the result in the numbers to calculate
                numbersToCalculate.add(result);
            }catch(NumberFormatException e){
                try{
                    doubleNum1 = Double.parseDouble(numbersToCalculate.get(0));
                    longNum2 = Long.parseLong(numbersToCalculate.get(1));
                    System.out.println(doubleNum1+" | "+longNum2);
                    switch (operation) {
                        case "+" -> result = Double.toString((doubleNum1 + longNum2));
                        case "-" -> result = Double.toString((doubleNum1 - longNum2));
                        case "*" -> result = Double.toString((doubleNum1 * longNum2));
                        case "/" -> result = Double.toString((doubleNum1 / longNum2));
                    }
                    System.out.println("Answer:"+result);
//                  display result
                    this.changeCalculatorValue(result);
//                  remove all the numbers to calculate
                    numbersToCalculate.clear();
//                  store the result in the numbers to calculate
                    numbersToCalculate.add(result);
                }catch (NumberFormatException f){
                    try{
                        longNum1 = Long.parseLong(numbersToCalculate.get(0));
                        doubleNum2 = Double.parseDouble(numbersToCalculate.get(1));
                        System.out.println(longNum1+" | "+doubleNum2);
                        switch (operation) {
                            case "+" -> result = Double.toString((longNum1 + doubleNum2));
                            case "-" -> result = Double.toString((longNum1 - doubleNum2));
                            case "*" -> result = Double.toString((longNum1 * doubleNum2));
                            case "/" -> result = Double.toString((longNum1 / doubleNum2));
                        }
                        System.out.println("Answer:"+result);
//                      display result
                        this.changeCalculatorValue(result);
//                      remove all the numbers to calculate
                        numbersToCalculate.clear();
//                      store the result in the numbers to calculate
                        numbersToCalculate.add(result);
                    }catch (NumberFormatException g){
                        doubleNum1 = Double.parseDouble(numbersToCalculate.get(0));
                        doubleNum2 = Double.parseDouble(numbersToCalculate.get(1));
                        System.out.println(doubleNum1+" | "+doubleNum2);
                        switch (operation) {
                            case "+" -> result = Double.toString((doubleNum1 + doubleNum2));
                            case "-" -> result = Double.toString((doubleNum1 - doubleNum2));
                            case "*" -> result = Double.toString((doubleNum1 * doubleNum2));
                            case "/" -> result = Double.toString((doubleNum1 / doubleNum2));
                        }
                        System.out.println("Answer:"+result);
//                      display result
                        this.changeCalculatorValue(result);
//                      remove all the numbers to calculate
                        numbersToCalculate.clear();
//                      store the result in the numbers to calculate
                        numbersToCalculate.add(result);
                    }
                }
            }
        }else{
            numbersToCalculate.add(this.calculatorStringValue);
        }
    }
    public void removeAllNumbersToCalculate(){
        this.numbersToCalculate.clear();
    }
}
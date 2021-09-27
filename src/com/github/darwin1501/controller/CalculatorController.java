package com.github.darwin1501.controller;

import com.github.darwin1501.view.CalculatorComponents;
import com.github.darwin1501.model.CalculatorModel;

public class CalculatorController {

    private CalculatorComponents calculatorComponents;
    private CalculatorModel calculatorModel;
    private String inputValue = "";
    private int clearDisplay = 0;
    private String currentOperation;

    public CalculatorController(CalculatorComponents calculatorComponents, CalculatorModel calculatorModel){
        this.calculatorComponents = calculatorComponents;
        this.calculatorModel = calculatorModel;
        initController();
    }

    public void initController(){

        calculatorModel.addPropertyChangeListener(calculatorComponents);

        calculatorComponents.getClearBtn().addActionListener((e)->{
            this.inputValue = "";
            calculatorModel.removeAllNumbersToCalculate();
            calculatorModel.changeCalculatorValue(this.inputValue);
        });

        calculatorComponents.getBackSpaceBtn().addActionListener((e)->{
            calculatorModel.deleteNumber();
//           get current calculator value in model to update stored value in the inputValue
            this.inputValue = calculatorModel.getCalculatorStringValue();
//          tell the program to not clear the display after deleting a number
            this.clearDisplay = 0;
        });

        calculatorComponents.getDotBtn().addActionListener((e)->{
            int hasDotExist = calculatorComponents.getCalculatorDisplay().getText().indexOf(".");
                if(hasDotExist == -1){
                    setDisplay(".");
                }
        });

        calculatorComponents.getEqualsBtn().addActionListener((e)->{

            switch (this.currentOperation) {
                case "+" -> this.calculatorModel.calculate("+");
                case "-" -> this.calculatorModel.calculate("-");
                case "*" -> this.calculatorModel.calculate("*");
                case "/" -> this.calculatorModel.calculate("/");
            }

//          set the command to reset the display when inserting the second number.
            this.clearDisplay = 1;
//            clear the numbers to calculate in model
            calculatorModel.getNumbersToCalculate().clear();
        });

        calculatorComponents.getAddBtn().addActionListener((e)->{
            calculatorModel.calculate("+");
            this.currentOperation = "+";
//          set the clear display to 1, so the display will clear when entering another numbers to calculate.
            this.clearDisplay = 1;
        });

        calculatorComponents.getSubtractBtn().addActionListener((e)->{
            calculatorModel.calculate("-");
            this.currentOperation = "-";
            this.clearDisplay = 1;
        });

        calculatorComponents.getMultiplyBtn().addActionListener((e)->{
            calculatorModel.calculate("*");
            this.currentOperation = "*";
            this.clearDisplay = 1;
        });

        calculatorComponents.getDivideBtn().addActionListener((e)->{
            calculatorModel.calculate("/");
            this.clearDisplay = 1;
        });

        calculatorComponents.getOneBtn().addActionListener((e)->{
            setDisplay("1");
        });

        calculatorComponents.getTwoBtn().addActionListener((e)->{
            setDisplay("2");
        });

        calculatorComponents.getThreeBtn().addActionListener((e)->{
            setDisplay("3");
        });

        calculatorComponents.getFourBtn().addActionListener((e)->{
            setDisplay("4");
        });

        calculatorComponents.getFiveBtn().addActionListener((e)->{
            setDisplay("5");
        });

        calculatorComponents.getSixBtn().addActionListener((e)->{
            setDisplay("6");
        });

        calculatorComponents.getSevenBtn().addActionListener((e)->{
            setDisplay("7");
        });

        calculatorComponents.getEightBtn().addActionListener((e)->{
            setDisplay("8");
        });

        calculatorComponents.getNineBtn().addActionListener((e)->{
            setDisplay("9");
        });

        calculatorComponents.getZeroBtn().addActionListener((e)->{
            setDisplay("0");
        });
    }

    public void setDisplay(String number){
//      check if the display needs to reset for entering the second set of numbers to calculate
        if(this.clearDisplay == 1){
            this.inputValue = "";
        }
        this.inputValue += number;
        calculatorModel.changeCalculatorValue(this.inputValue);
//      change it back to 0, so it will not clear the display when entering another number.
        this.clearDisplay = 0;
    }
}
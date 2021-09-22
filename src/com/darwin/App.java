package com.darwin;

import com.darwin.controller.CalculatorController;
import com.darwin.model.CalculatorModel;
import com.darwin.view.CalculatorComponents;
import com.darwin.view.CalculatorFrame;

public class App {

    public static void main(String[] args) {
	// write your code here
        CalculatorComponents calculatorComponents = new CalculatorComponents();
        CalculatorModel calculatorModel = new CalculatorModel();

        CalculatorController calculatorController = new CalculatorController(calculatorComponents, calculatorModel);
    }
}

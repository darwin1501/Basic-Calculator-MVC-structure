package com.github.darwin1501;

import com.github.darwin1501.controller.CalculatorController;
import com.github.darwin1501.model.CalculatorModel;
import com.github.darwin1501.view.CalculatorComponents;

public class App {

    public static void main(String[] args) {
	// write your code here
        CalculatorComponents calculatorComponents = new CalculatorComponents();
        CalculatorModel calculatorModel = new CalculatorModel();

        CalculatorController calculatorController = new CalculatorController(calculatorComponents, calculatorModel);
    }
}

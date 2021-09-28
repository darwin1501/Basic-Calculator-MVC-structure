package com.github.darwin1501.view;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

public class CalculatorComponents extends JFrame implements PropertyChangeListener{

    private JPanel numPad;
    private JPanel btnPanelTop;
    private JPanel btnPanelSide;
    private JButton clearBtn;
    private JButton divideBtn;
    private JButton multiplyBtn;
    private JButton subtractBtn;
    private JButton addBtn;
    private JButton equalsBtn;
    private JButton sevenBtn;
    private JButton eightBtn;
    private JButton nineBtn;
    private JButton fourBtn;
    private JButton fiveBtn;
    private JButton sixBtn;
    private JButton oneBtn;
    private JButton twoBtn;
    private JButton threeBtn;
    private JButton zeroBtn;
    private JButton backSpaceBtn;
    private JButton dotBtn;
    private JLabel calculatorDisplay;
    private int btnNumHeight = 50;
    private int btnNumWidth = 100;
    private String calculatorStringValue = "0";

    public CalculatorComponents(){

        this.setTitle("Basic Calculator");
        this.setSize(435,393);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        display
        calculatorDisplay = new JLabel(getCalculatorStringValue(), SwingConstants.RIGHT);
        calculatorDisplay.setBounds(10,10,400,70);
        calculatorDisplay.setOpaque(true);
        calculatorDisplay.setFont(new Font("Roboto",Font.PLAIN,30));
        calculatorDisplay.setBackground(Color.GRAY);
        calculatorDisplay.setBorder(BorderFactory.createLineBorder(Color.GRAY, 10));
        this.add(calculatorDisplay);
//        btnPanelTop
        btnPanelTop = new JPanel();
        btnPanelTop.setBounds(10,95,300,50);
        btnPanelTop.setOpaque(true);
        btnPanelTop.setBackground(Color.red);
        btnPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        this.add(btnPanelTop);

        btnPanelSide = new JPanel();
        btnPanelSide.setBounds(310,95,100,250);
        btnPanelSide.setOpaque(true);
        btnPanelSide.setBackground(Color.GRAY);
        btnPanelSide.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        this.add(btnPanelSide);

        numPad = new JPanel();
        numPad.setOpaque(true);
        numPad.setBackground(Color.GRAY);
        numPad.setBounds(10,145,300,200);
        numPad.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        this.add(numPad);
        //        buttons
        sevenBtn = new JButton("7");
        sevenBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        sevenBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(sevenBtn);

        eightBtn = new JButton("8");
        eightBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        eightBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(eightBtn);

        nineBtn = new JButton("9");
        nineBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        nineBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(nineBtn);

        fourBtn = new JButton("4");
        fourBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        fourBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(fourBtn);

        fiveBtn = new JButton("5");
        fiveBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        fiveBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(fiveBtn);

        sixBtn = new JButton("6");
        sixBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        sixBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(sixBtn);

        oneBtn = new JButton("1");
        oneBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        oneBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(oneBtn);

        twoBtn = new JButton("2");
        twoBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        twoBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(twoBtn);

        threeBtn = new JButton("3");
        threeBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        threeBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(threeBtn);

        dotBtn = new JButton(".");
        dotBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        dotBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(dotBtn);

        zeroBtn = new JButton("0");
        zeroBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        zeroBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(zeroBtn);

        backSpaceBtn = new JButton("<-");
        backSpaceBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        backSpaceBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        numPad.add(backSpaceBtn);

        clearBtn = new JButton("C");
        clearBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        clearBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelTop.add(clearBtn);

        divideBtn = new JButton("/");
        divideBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        divideBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelTop.add(divideBtn);

        multiplyBtn = new JButton("*");
        multiplyBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        multiplyBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelTop.add(multiplyBtn);

        subtractBtn = new JButton("-");
        subtractBtn.setPreferredSize(new Dimension(btnNumWidth, btnNumHeight));
        subtractBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelSide.add(subtractBtn);

        addBtn = new JButton("+");
        addBtn.setPreferredSize(new Dimension(btnNumWidth, 100));
        addBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelSide.add(addBtn);

        equalsBtn = new JButton("=");
        equalsBtn.setPreferredSize(new Dimension(btnNumWidth, 100));
        equalsBtn.setFont(new Font("Roboto",Font.PLAIN,20));
        btnPanelSide.add(equalsBtn);

        this.setVisible(true);
    }

    public JLabel getCalculatorDisplay(){
        return calculatorDisplay;
    }

    public String getCalculatorStringValue(){
        return calculatorStringValue;
    }

    public JButton getClearBtn(){ return clearBtn; }

    public JButton getOneBtn(){
        return oneBtn;
    }

    public JButton getTwoBtn() { return twoBtn; }

    public JButton getThreeBtn() { return threeBtn; }

    public JButton getFourBtn() { return fourBtn; }

    public JButton getFiveBtn() { return fiveBtn; }

    public JButton getSixBtn() { return sixBtn; }

    public JButton getSevenBtn() { return sevenBtn; }

    public JButton getEightBtn()  { return eightBtn; }

    public JButton getNineBtn() { return nineBtn; }

    public JButton getZeroBtn() { return zeroBtn; }

    public JButton getDotBtn() { return dotBtn; }

    public JButton getBackSpaceBtn() { return backSpaceBtn; }

    public JButton getEqualsBtn() { return equalsBtn; }

    public JButton getAddBtn() { return addBtn; }

    public JButton getSubtractBtn()  { return subtractBtn; }

    public JButton getMultiplyBtn() { return multiplyBtn; }

    public JButton getDivideBtn() { return divideBtn; }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.changeCalculatorValue((String) evt.getNewValue());
    }

    public void changeCalculatorValue(String newValue){
       if(newValue.equals("")){
           this.calculatorStringValue = "0";
       }else{
           this.calculatorStringValue = newValue;
       }
        formatDisplayValue();
    }

    public void formatDisplayValue(){

        DecimalFormat number = new DecimalFormat("###,###,###,###,###,###");

        try{
//          format integer value
                getCalculatorDisplay().setText(number.format(Long.parseLong(this.calculatorStringValue)
                ));
        }catch (NumberFormatException e){
//            format decimal value
            try{
//            break the decimal number into two parts
                String[] splitNumber =  this.calculatorStringValue.split("\\.");
//            numbers before decimal
                String numbersOnLeft = splitNumber[0];
//            leave an empty string after decimal point if decimal number doesn't have number after decimal point.
                String numbersOnRight = splitNumber.length == 1 ? "" : splitNumber[1];
//            format the numbers before decimal point and then combine the remaining number after decimal point
                getCalculatorDisplay().setText(number.format(Long.parseLong(numbersOnLeft))+"."+numbersOnRight);
            }catch (NumberFormatException f){
//                display Syntax error if the number exceeds at the maximum number that Long can handle.
                getCalculatorDisplay().setText("Syntax Error");
            }
        }
    }
}
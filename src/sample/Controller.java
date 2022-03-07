package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {

    @FXML
    private GridPane gridPane;

    private String originalEquation;
    private String number;
    private ArrayList<Module> list;

    public void initializeAfterLoad()
    {
        originalEquation = "";
        list = new ArrayList<>();
        /*
        for(Node node: gridPane.getChildren())
            GridPane.setHalignment(node, HPos.CENTER);
        */

    }
    //3 + 5.2 / 67 * 103 - (345 % 2) - 9=
    @FXML
    void buttonPressed(ActionEvent event)
    {
        String text = ((Button)(event.getSource())).getText();

        // First input will be number (or parentheses)

        if(text.contentEquals("=")) {
            if(!number.isEmpty()){
                list.add(new Module(number));
                number = "";}
            solveEquation();
        }
        else if(isNumber(text.charAt(0)))
            number += text;
        else {
            list.add(new Module(number));
            list.add(new Module(text));
            number = "";
        }


    }

    private void solveEquation()
    {
        // Traverse through ArrayList

    @FXML
    void numberPressed(ActionEvent event)
    {
        String text = ((Button)(event.getSource())).getText();

        if(text.charAt(0) == 61) // if its equal sign
        {
            solveEquation(originalEquation);
        }
        else
        {
            //Don't add operations if
            originalEquation += text;
        }
    }

    @FXML
    void operationPressed(ActionEvent event)
    {
        String text = ((Button)(event.getSource())).getText();

        if(text.charAt(0) == 61) // if its equal sign
        {
            solveEquation(originalEquation);
        }
        else
        {
            //Don't add operations if
            originalEquation += text;
        }
    }

    /*
    private void solveEquation(String equation)
    {
        if(equation.contains("+"))
        {
            int indexOfPlusSign = equation.indexOf("+");
            int i = 0;
            String firstNumber = "";
            //find First number
            for(i = indexOfPlusSign-1; i >= 0; i--)
            {
                //Until another operation is reached,
                if(isNumber(equation.charAt(i)))
                    firstNumber += equation.charAt(i);
                else
                    break;
            }

            String secondNumber = "";
            int j = 0;
            //find second number
            for(j = indexOfPlusSign+1; i < equation.length(); i++)
            {
                //Until another operation is reached,
                if(isNumber(equation.charAt(i)))
                    secondNumber += equation.charAt(i);
                else
                    break;
            }

            Double sum = Double.valueOf(firstNumber) + Double.valueOf(secondNumber);

            equation = equation.substring(0, i+1) + String.valueOf(sum) + equation.substring(j, equation.length());

            return solveEquation(equation);

        }
*/
        /*
            32/52.2*(657+24)

            PEMDAS - parentheses, exponent, mult, divide, add, subtract
            1. if find first parentheses
                - find second parentheses
                - substring it -> solveEquation
                - 681 -> return solveEquation(equation.substring(0, firstParentheses) + 681)
            2. if mult
                - 32/52.5*681
                - find mult -> index = 7
                - From index 7, backtrack until /,+,- comes out
            3. if divide
            4. if add
            5. if subtract
            6. if no operation
                - return equation

         */
    }

    private double add()

    private boolean isNumber(char chr)
    {
        if(chr == ('+') ||
           chr == ('/') ||
           chr == ('-') ||
           chr == ('(') ||
           chr == (')') ||
            chr == ('%') ||
            chr == ('*'))
        {
            return false;
        }
        return true;

    }
    /*

        Add, Sub, Mult, Divide

        5 + 2

        5 - add to queue

        + - add to queue

        2 - add to queue

        = - solve the equation



     */



}

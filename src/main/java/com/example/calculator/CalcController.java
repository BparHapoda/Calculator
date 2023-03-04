package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CalcController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea result;


    @FXML
    public void input(ActionEvent event) {
        if (result.getText().equals("0.00") || result.getText().contains("= ")) {
            result.setText("");
        }

        String numbers = "0123456789";
        String operators = "-+/*";
        Button button = (Button) event.getTarget();
        if (numbers.contains(button.getText())) {
            result.setText(result.getText() + button.getText());

        } else if (button.getText().equals("C")) {
            result.setText("0.00");
        } else if (operators.contains(button.getText())) {
            result.setText(result.getText() + button.getText());
        } else result.setText("= " + getResult(result.getText()));

    }

    public void printResult(String string) {
        result.setText("");
        result.setText(string);
    }

    public void clearResult() {
        result.setText("");
    }

    public String plus(String a, String b) {
        int aN = Integer.parseInt(a);
        int bN = Integer.parseInt(b);
        int res = aN + bN;
        return res + "";
    }

    public String minus(String a, String b) {
        int aN = Integer.parseInt(a);
        int bN = Integer.parseInt(b);
        int res = aN - bN;
        return res + "";
    }

    public String div(String a, String b) {
        float aN = Float.parseFloat(a);
        float bN = Float.parseFloat(b);
        float res = aN / bN;
        return res + "";
    }

    public String mult(String a, String b) {
        int aN = Integer.parseInt(a);
        int bN = Integer.parseInt(b);
        int res = aN * bN;
        return res + "";
    }

    public String getResult(String string) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder op = new StringBuilder();
        boolean n = false;
        String numbers = "0123456789";
        String operators = "-+/*";
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (operators.contains(string.charAt(i) + "")) {
                op.append(string.charAt(i));
                n = true;
            } else if (numbers.contains(string.charAt(i) + "") & !n) {
                a.append(string.charAt(i));
            } else if (numbers.contains(string.charAt(i) + "") & n) {
                b.append(string.charAt(i));
            }

        }

        switch (op.toString()) {
            case "+": {
                result = plus(a.toString(), b.toString());
                break;
            }
            case "-": {
                result = minus(a.toString(), b.toString());
                break;
            }
            case "/": {
                result = div(a.toString(), b.toString());
                break;
            }
            case "*": {
                result = mult(a.toString(), b.toString());
                break;
            }

        }


        return result;
    }

}
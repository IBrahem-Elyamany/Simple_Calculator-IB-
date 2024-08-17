package com.example.simple_calculatorib;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button btn_dot,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnD,btnM,btnS,btnA,btnE,btnR,btnAns,btnDel,btnAC;
    TextView screen;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=findViewById(R.id.screen);
        btn_dot=findViewById(R.id.btn_dot);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnD=findViewById(R.id.btn_D);
        btnM=findViewById(R.id.btn_M);
        btnS=findViewById(R.id.btn_S);
        btnA=findViewById(R.id.btn_A);
        btnE=findViewById(R.id.btn_E);
        btnR=findViewById(R.id.btn_R);
        btnAns=findViewById(R.id.btn_Ans);
        btnDel=findViewById(R.id.btn_Del);
        btnAC=findViewById(R.id.btn_AC);
    }
    public boolean isResult(String eq){
        for (int i=0 ;i<eq.length();i++) {
            if(eq.charAt(i)=='='){
                return true;
            }
        }
        return false;
    }
    public void clickBtnDot(View view){
        String eq=screen.getText().toString();
        boolean oneDot=true;
        for (int i=0 ;i<eq.length();i++){
            if(eq.charAt(i)=='+'||eq.charAt(i)=='-'||eq.charAt(i)=='×'||eq.charAt(i)=='÷'){
                oneDot=true;
            }
            else if(eq.charAt(i)=='.'){
                oneDot=false;
            }
        }
        if (oneDot){
            if(isResult(screen.getText().toString())||screen.getText().toString()=="")
                screen.setText("0.");
            else
                screen.setText(screen.getText() + ".");
        }
    }
    public void clickBtn0(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("0");
        else
            screen.setText(screen.getText()+"0");
    }
    public void clickBtn1(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("1");
        else
            screen.setText(screen.getText()+"1");
    }
    public void clickBtn2(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("2");
        else
            screen.setText(screen.getText()+"2");
    }
    public void clickBtn3(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("3");
        else
            screen.setText(screen.getText()+"3");
    }
    public void clickBtn4(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("4");
        else
            screen.setText(screen.getText()+"4");
    }
    public void clickBtn5(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("5");
        else
            screen.setText(screen.getText()+"5");
    }
    public void clickBtn6(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("6");
        else
            screen.setText(screen.getText()+"6");
    }
    public void clickBtn7(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("7");
        else
            screen.setText(screen.getText()+"7");
    }
    public void clickBtn8(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("8");
        else
            screen.setText(screen.getText()+"8");
    }
    public void clickBtn9(View view){
        if(isResult(screen.getText().toString()))
            screen.setText("9");
        else
            screen.setText(screen.getText()+"9");
    }
    public void clickBtnD(View view){
        if(screen.getText().toString()!="")
            screen.setText(screen.getText()+"÷");
    }
    public void clickBtnM(View view){
        if(screen.getText().toString()!="")
            screen.setText(screen.getText()+"×");
    }
    public void clickBtnS(View view){
        screen.setText(screen.getText()+"-");
    }
    public void clickBtnA(View view){
        screen.setText(screen.getText()+"+");
    }
    public void clickBtnR(View view){
        if(screen.getText().toString()!=""){
            if(!isResult(screen.getText().toString())){
                ans=Math.sqrt(Double.parseDouble(screen.getText().toString()));
                screen.setText("√"+screen.getText()+" = "+ans);
            }
        }
    }
    public void clickBtnAns(View view){
        screen.setText(""+ans);

        //ans
    }
    public void clickBtnDel(View view){
        if(screen.getText().toString().length() != 0){
            screen.setText(screen.getText().toString().substring(0, screen.getText().toString().length()-1));
        }
        //del
    }
    public void clickBtnAC(View view){
        screen.setText("");
    }

    public double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (c == '-' && (i == 0 || isOperator(expression.charAt(i - 1)) || expression.charAt(i - 1) == '(')) {
                // Handle negative numbers after an operator or at the start of the expression
                StringBuilder sb = new StringBuilder();
                sb.append('-');
                i++;
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                numbers.push(Double.parseDouble(sb.toString()));
            }
            else if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c == '+' || c == '-' || c == '×' || c == '÷') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
                i++;
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private  boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷';
    }
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '×' || op1 == '÷') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '×':
                return a * b;
            case '÷':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public void clickBtnE(View view){
        if(screen.getText().toString()!=""){
            if(!isResult(screen.getText().toString())) {
                ans = evaluateExpression(screen.getText().toString());
                screen.setText(screen.getText() + " = " + ans);
            }
        }
    }


}
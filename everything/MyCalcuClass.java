package com.example.everything;

import android.widget.Toast;

import java.util.Stack;

public class MyCalcuClass{
    Calculator calcu;
    int opct=0;
    public MyCalcuClass(Calculator calcu) {
        this.calcu=calcu;
    }

    void solve() {
        opct=0;
        String str = String.valueOf(calcu.input.getText());
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (Character.isDigit(str.charAt(i))||String.valueOf(str.charAt(i)).equals(".")) {
                postfix.append(c);
            } else {
                opct++;
                postfix.append(',');
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {

                    postfix.append(stack.pop()+",");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(","+stack.pop()+",");
        }
        if(opct==0){
            calcu.display.setText(calcu.input.getText());
//            calcu.input.setText(tempp);
            return;
        }
        String temp="";
        String dbg="";
        for (int i=0;i<postfix.length();i++){
            if(postfix.charAt(i)!=','){
                temp+=postfix.charAt(i);
            }
            else{
                if(temp.isEmpty()){
                    continue;
                }
                dbg+=temp;
                stack.push(temp);
                temp="";
            }

        }
//        display.setText(stack.pop());
//        display.setText(postfix);
        temp="";
        Stack<String> stack2=new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        Double a,b;
        Double answer ;
        while (!stack2.isEmpty()) {
            temp=stack2.pop();
            if(temp.equals("*")) {
                a = Double.parseDouble(stack.pop());

                b = Double.parseDouble(stack.pop());
                answer = a * b;
                stack.push(String.valueOf(answer));
            } else if (temp.equals("\\")) {
                b= Double.parseDouble(stack.pop());
                a= Double.parseDouble(stack.pop());
                answer=a/b;
                stack.push(String.valueOf(answer));


            } else if (temp.equals("+")) {
                b= Double.parseDouble(stack.pop());
                a= Double.parseDouble(stack.pop());
                answer=a+b;
                stack.push(String.valueOf(answer));

            } else if (temp.equals("-")) {
                a = Double.parseDouble(stack.pop());
                b = Double.parseDouble(stack.pop());
                answer = b-a;
                stack.push(String.valueOf(answer));
            }
            else {
                stack.push(String.valueOf(temp));
            }

        }
        String tempp=stack.pop();
        calcu.display.setText(tempp);
        calcu.input.setText(tempp);
        Toast.makeText(calcu.getApplicationContext(),tempp,Toast.LENGTH_SHORT).show();
    }

    int precedence(String op) {
        switch (op) {
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 4;
            case "\\":
                return 3;

        }
        return -1;
    }
    void seq(){
        opct=0;
        String str = String.valueOf(calcu.input.getText());
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (Character.isDigit(str.charAt(i))||String.valueOf(str.charAt(i)).equals(".")) {
                postfix.append(c);
            } else {
                opct++;
                postfix.append(',');
                while (!stack.isEmpty() ) {

                    postfix.append(stack.pop()+",");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(","+stack.pop()+",");
        }
        if(opct==0){

            return;
        }
        String temp="";
        String dbg="";
        for (int i=0;i<postfix.length();i++){
            if(postfix.charAt(i)!=','){
                temp+=postfix.charAt(i);
            }
            else{
                if(temp.isEmpty()){
                    continue;
                }
                dbg+=temp;
                stack.push(temp);
                temp="";
            }

        }
//        display.setText(stack.pop());
//        display.setText(postfix);
        temp="";
        Stack<String> stack2=new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        Double a,b;
        Double answer ;
        while (!stack2.isEmpty()) {
            temp=stack2.pop();
            if(temp.equals("*")) {
                a = Double.parseDouble(stack.pop());

                b = Double.parseDouble(stack.pop());
                answer = a * b;
                stack.push(String.valueOf(answer));
            } else if (temp.equals("\\")) {
                b= Double.parseDouble(stack.pop());
                a= Double.parseDouble(stack.pop());
                answer=a/b;
                stack.push(String.valueOf(answer));


            } else if (temp.equals("+")) {
                b= Double.parseDouble(stack.pop());
                a= Double.parseDouble(stack.pop());
                answer=a+b;
                stack.push(String.valueOf(answer));

            } else if (temp.equals("-")) {
                a = Double.parseDouble(stack.pop());
                b = Double.parseDouble(stack.pop());
                answer = b-a;
                stack.push(String.valueOf(answer));
            }
            else {
                stack.push(String.valueOf(temp));
            }

        }
        String tempp=stack.pop();
        calcu.display.setText(tempp);
//        calcu.input.setText(tempp);
        Toast.makeText(calcu.getApplicationContext(),tempp,Toast.LENGTH_SHORT).show();
    }
}

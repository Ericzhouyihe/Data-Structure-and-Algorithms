package school.Test3;
/*
(1)实验内容
	栈是数据结构中一个非常重要的结构。表达式计算是掌握程序设计语言的重要部分之一，	也是栈的应用的一个典型例子。
	本次实验的主要内容是利用栈的基本操作，设计一个程序，实现用算符优先法对算术表达式求值的过程。
	对本设计系统实现+、-、*、/、%和乘方（^）运算。
	符合要求，同时提高自己的编程能力。实现算术表达式求值。
(2)实验要求
	1．认真阅读和掌握本实验的算法。
	2．上机将本算法实现。
	3．在程序的编写中尽量与专业的编程规范靠拢，系统代码采用结构化的编程方式，力求设	计代码以及注释等规范，
	4．保存和打印出程序的运行结果，并结合程序进行分析。
需求分析:
    本实验为用栈实现对算术表达式求值的功能。
    输出的形式：直接输出结果
    程序所能达到的功能：对含有±/%^的算术表达式求值
    测试数据：
    测试一：3+6/2%2^1-4
    输出结果：0
    测试二：5-6^2+5%76/2
    输出结果：-16
    测试三：3^2+6&2
    输出结果：你输入了不符合要求的字符
*/

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String expression = "5-6^2+5%76/2"; // 测试数据
        int result = evaluateExpression(expression);
        if (result == Integer.MIN_VALUE){
            return;
        }
        System.out.println("输出结果：" + result);
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^') {
                while (!operatorStack.isEmpty() && getOperatorPriority(ch) <= getOperatorPriority(operatorStack.peek())) {
                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    int result = applyOperator(operand1, operand2, operator);
                    operandStack.push(result);
                }
                operatorStack.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                int operand = ch - '0';
                while (i + 1 < expression.length() && expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') {
                    operand = operand * 10 + expression.charAt(i + 1) - '0';
                    i++;
                }
                operandStack.push(operand);
            } else {
                System.out.println("你输入了不符合要求的字符");
                return Integer.MIN_VALUE;
            }
        }

        while (!operatorStack.isEmpty()) {
            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            char operator = operatorStack.pop();
            int result = applyOperator(operand1, operand2, operator);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    public static int getOperatorPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }


    public static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                return 0;
        }
    }
}

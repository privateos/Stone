package com;

import com.AST.ASTree;
import com.AST.BasicParser;
import com.Lexer.CodeDialog;
import com.Lexer.Lexer;
import com.Lexer.ParseException;
import com.Lexer.Token;

import javassist.gluonj.util.Loader;

public class Main {
    public static void main(String [] args) throws Throwable {
        runInterprete(args);
    }
    public static void runAST(String [] args) {
/*
even = 0
odd = 0
i = 1
while i < 10 {
    if i % 2 {
        even = even + i
    } else {
        odd = odd + i
    }
    i = i + 1
}
even + odd
*/
        Lexer l = new Lexer(new CodeDialog());
        BasicParser bp = new BasicParser();
        try {
            while (l.peek(0) != Token.EOF) {
                ASTree ast = bp.parser(l);
                System.out.println(" => " + ast.toString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
/*
sum = 0
i = 1
while i < 10 {
    sum = sum + i
    i = i + 1
}
sum
*/
    public static void runInterprete(String[] args) throws Throwable {
        Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
    }
}
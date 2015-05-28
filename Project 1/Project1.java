/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Michael
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
//State Initialization
        State q0 = new State("q0",true,false);
        State q1 = new State("q1",false,true);
        State q2 = new State("q2",false,true);
        State q3 = new State("q3",false,false);
        State q4 = new State("q4",false,false);
        State q5 = new State("q5",false,true);
        State q6 = new State("q6",false,true);
        State q7 = new State("q7",false,true);
        State q8 = new State("q8",false,true);
        State q9 = new State("q9",false,true);
        State q10 = new State("q10",false,true);
        State q11= new State("q11",false,true);
        State q12 = new State("q12",false,true);
        State q13 = new State("q13",false,true);
        State q14 = new State("q14",false,true);
        State q15 = new State("q15",false,false);
        State q16 = new State("q16",false,true);
        State q17 = new State("q17",false,false);
        State q18 = new State("q18",false,false);
        State q19 = new State("q19",false,true);
        //Conditions
        Condition identifier = new Condition("indentifier");
        Condition character = new Condition("Character");
        Condition integer = new Condition("Integer");
        Condition string = new Condition("String");//going to be in between quotations, "example "
        Condition floating = new Condition("Float");
        Condition multiply = new Condition("Multiply");
        Condition equals = new Condition("Equals");
        Condition plus = new Condition("Plus");
        Condition leftBracket = new Condition("leftBracket");
        Condition rightBracket = new Condition("rightBracket");
        Condition semicolon = new Condition("Semi-Colon");
        Condition quotation = new Condition("Quotation");
        Condition anyChar = new Condition("Any Char");
        Condition decimal = new Condition("Decimal");
        Condition evalue = new Condition("e");
        Condition charint = new Condition("Char/Int");
        //Transitions
        Transition t1 = new Transition(q0,character,q1);
        Transition t2 = new Transition(q0,integer,q2);
        Transition t3 = new Transition(q0,quotation,q3);
        Transition t4 = new Transition(q3,anyChar,q4);
        Transition t5 = new Transition(q4,quotation,q5);
        Transition t6 = new Transition(q0,equals,q6);
        Transition t7 = new Transition(q0,plus,q7);
        Transition t8 = new Transition(q7,plus,q8);
        Transition t9 = new Transition(q7,equals,q9);
        Transition t10 = new Transition(q0,multiply,q10);
        Transition t11 = new Transition(q10,equals,q11);
        Transition t12 = new Transition(q0,leftBracket,q12);
        Transition t13 = new Transition(q0,rightBracket,q13);
        Transition t14 = new Transition(q0,semicolon,q14);
        Transition t15 = new Transition(q0,integer,q15);
        Transition t16 = new Transition(q15,decimal,q16);
        Transition t17 = new Transition(q0,decimal,q17);
        Transition t18 = new Transition(q17,integer,q16);
        Transition t19 = new Transition(q16,evalue,q18);
        Transition t20 = new Transition(q18,integer,q19);
        Transition t21 = new Transition(q1,character,q1);
        Transition t22 = new Transition(q2,integer,q2);
        Transition t23 = new Transition(q19,integer,q19);
        Transition t24 = new Transition(q1,integer,q1);
        
        ArrayList<Transition> Transitions = new ArrayList<Transition>();
        Transitions.add(t1);
        Transitions.add(t2);
        Transitions.add(t3);
        Transitions.add(t4);
        Transitions.add(t5);
        Transitions.add(t6);
        Transitions.add(t7);
        Transitions.add(t8);
        Transitions.add(t9);
        Transitions.add(t10);
        Transitions.add(t11);
        Transitions.add(t12);
        Transitions.add(t13);
        Transitions.add(t14);
        Transitions.add(t15);
        Transitions.add(t16);
        Transitions.add(t17);
        Transitions.add(t18);
        Transitions.add(t19);
        Transitions.add(t20);
        Transitions.add(t21);
        Transitions.add(t22);
        Transitions.add(t23);
        
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = "";
            
            System.out.println(line);
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                
                if (line == null){
                    break;
                }
               
               getToken(0,line,q0,Transitions,"",q0,"");
            }
            
        }finally {
            br.close();
        }
       
        
    System.out.println();
        
    }
    public static void getToken(int index, String line, State current, ArrayList<Transition> list,String Token,State q0,String prevCondition){
        String Condition;
        boolean matchFlag = false;
        if(index <= line.length()-1){
            Condition = match(line.charAt(index));
            for(int j = 0; j < list.size();j++){
                if((list.get(j).conditions.condition.equals(Condition))&&(list.get(j).from.state.equals(current.state))){
                         current = list.get(j).to;
                         Token = Token + line.charAt(index);
                         matchFlag = true;
                }
                if(matchFlag){
                    break;
                }
            }
            if(matchFlag){
                getToken(index + 1,line,current,list,Token,q0,Condition);
                return;
            }else if(!matchFlag){
                if(prevCondition.equals("Quotation")){
    
                    for(int i = index; i < line.length();i++){
                        Token = Token + line.charAt(i);
                        if(line.charAt(i) == '"'){
                            index = i;
                            break;
                        }
                    }
                }
                if(!prevCondition.equals("Whitespace")){
                    
                    printInfo(Token,prevCondition);
                    
                }
                Token = "";
                current = q0;
                for(int j = 0; j < list.size();j++){
                    if((list.get(j).conditions.condition.equals(Condition))&&(list.get(j).from.state.equals(current.state))){
                             current = list.get(j).to;
                             Token = Token + line.charAt(index);
                             matchFlag = true;
                            
                    }
                    if(matchFlag){
                        break;
                    }
                }
                    getToken(index + 1,line,current,list,Token,q0,Condition);
                    return;
                
            }
        }else{
            if(!prevCondition.equals("Whitespace"))
                printInfo(Token,prevCondition);
            return;
        }
    }
    
    public static void printInfo(String Token, String Type){
        System.out.println("The token is: '" + Token + "' The length of said token is: " + Token.length() + " The lexical type of the token is: " + Type);
 
    }
    public static String match(char line){
        if((int)line == 32){
            return "Whitespace";
        }
        if((((int)line >= 97) && ((int)line <= 122))||(((int)line >= 65) && ((int)line <=90))){
            return "Character";
        }
        if(((int)line >= 48) && ((int)line <= 57)){
            return "Integer";
        }
        if(((int)line == 34)){
            return "Quotation";
        }
        if(((int)line == 61)){
            return "Equals";
        }
        if(((int)line == 43)){
            return "Plus";
        }
        if(((int)line == 42)){
            return "Multiply";
        }
        if(((int)line == 41)){
            return "rightBracket";
        }
        if(((int)line == 40)){
            return "leftBracket";
        }
        if(((int)line == 59)){
            return "Semi-Colon";
        }
        if(((int)line == 46)){
            return "Decimal";
        }
        if(((int)line == 101)){
            return "e";
        }
        if((((int)line >= 0) &&((int)line < 34)) ||((int)line >= 35)){
            return "anyChar";
        }
        
        
        return null;
    }
    
}

class Transition {
    State from;
    Condition conditions;
    State to;
    Transition(State fstate, Condition mycond, State tstate){
        from = fstate;
        conditions = mycond;
        to = tstate;
    }
}

class State {
    String state;
    boolean Initial;
    boolean Final;
    State(String name, boolean init, boolean fin) {
        state = name;
        Initial = init;
        Final = fin;
    }
}

class Condition {
    String condition;
    
    Condition(String name){
        condition = name;
    }
}


package parser;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Parser {

       
       public static Symbol sym = new Symbol("" , 0);
       public static Symbol SEMI = new Symbol("SEMI", 1);
       public static Symbol WHILE = new Symbol("WHILE", 2);
       public static Symbol READ = new Symbol("READ", 3);
       public static Symbol WRITE = new Symbol("WRITE", 4);
       public static Symbol IF = new Symbol("IF", 5);
       public static Symbol DO = new Symbol("DO", 6);
       public static Symbol ID = new Symbol("ID", 7);
       public static Symbol INT = new Symbol("INT", 8);
       public static Symbol SMALLER = new Symbol("SMALLER", 9);
       public static Symbol GREATER = new Symbol("GREATER", 10);
       public static Symbol EQL = new Symbol("EQL", 11);
       public static Symbol SMALLEQL = new Symbol("SMALLEQL", 12);
       public static Symbol GREATEQL = new Symbol("GREATEQL", 13);
       public static Symbol NOTEQL = new Symbol("NOTEQL", 14);
       public static Symbol THEN = new Symbol("THEN", 15);
       public static Symbol BEGIN = new Symbol("BEGIN", 16);
       public static Symbol END = new Symbol("END", 17);
       public static Symbol LPAREN = new Symbol("LPAREN", 18);
       public static Symbol RPAREN = new Symbol("RPAREN", 19);
       public static Symbol COMMA = new Symbol("COMMA", 20);
       public static ArrayList<Integer> Tokens= new ArrayList();
       public static ArrayList<Symbol> list = new ArrayList();
       public static int index = 0;
       public static int errorCount = 0;
       public static int tabNum = 0;
       
    public static void main(String[] args) throws IOException {

        getToken();

    }
    public static void getToken() throws IOException {
        
        list.add(SEMI);
        list.add(WHILE);
        list.add(READ);
        list.add(WRITE);
        list.add(IF);
        list.add(DO);
        list.add(ID);
        list.add(INT);
        list.add(SMALLER);
        list.add(GREATER);
        list.add(EQL);
        list.add(SMALLEQL);
        list.add(GREATEQL);
        list.add(NOTEQL);
        list.add(THEN);
        list.add(BEGIN);
        list.add(END);
        list.add(LPAREN);
        list.add(RPAREN);
        list.add(COMMA);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the name of the file with the extension?:");
        String input = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            int i = 0;
            while(i < parts.length){
                Tokens.add(Integer.parseInt(parts[i]));
                i++;
            } 
        }
        
        sym =list.get(Tokens.get(index)-1);
        
        System.out.println("Parse begins...");
        statement_list();
        System.out.print("Parse Complete... ");
        if(errorCount == 0){
            System.out.print("no errors\n");
        }else{
            System.out.print(errorCount + " errors\n");
        }
    }
    public static void getsym(){
        index++;
        if(index < Tokens.size()){
        sym = list.get(Tokens.get(index)-1);
        }else{
            
        }
    }
    
    public static void error(String myStr){
        errorCount++;
        System.out.println(myStr);
    }
    public static void printTab(){
        for(int i = 0; i < tabNum; i++){
            System.out.print("\t");
        }
    }
    public static boolean statement_list(){
        tabNum++;
        printTab();
        System.out.print("Enter Statement List\n");
        
        statement();
        getsym();
        /*
        if(sym.value == 1){
            System.out.println("found a semi");
            if(index != Tokens.size()-1){
                getsym();
                statement();
            }
        }
        getsym();
        System.out.println(sym.name);      
        */
        while(sym.value == 1){
            getsym();
            if(sym.value != 1){
            statement();
            }else{
                break;
            }
            getsym();
        }
        printTab();
        System.out.print("Exit Statement List\n");      
        tabNum--;
        return false;
    }
    public static boolean statement(){
        tabNum++;
        printTab();
        System.out.print("Enter Statement\n");
        
        if(sym.value == 2){
            while_statement();
        }else if(sym.value == 3){
            iolist();
        }else if(sym.value == 4){
            iolist();
        }else if(sym.value == 5){
            if_statement();
        }else{
            error("Error Expected either while,read,write,or if: " + sym.name);
        }
        
        printTab();
        System.out.print("Exit Statement\n");
        tabNum--;
        return false;
    }
    public static boolean while_statement(){
        tabNum++;
        printTab();
        System.out.println("Enter While Statement\n");
        boolean_expression();
        
       
        getsym();
        if(sym.value == 6){
            statement_body();
        }else{
            error("Error Expected DO");
        }
        
        printTab();
        System.out.print("Exit While Statement\n");
        tabNum--;
        return false;
    }
    public static boolean boolean_expression(){
        tabNum++;
        printTab();
        System.out.print("Enter Boolean Expression\n");
        getsym();
        if(sym.value == 7){
            relop();
            
            value();
        }else{
            error("Error Expected ID");
        }
        
        printTab();
        System.out.print("Exit Boolean Expression\n");
        tabNum--;
        return false;
    }
    public static boolean relop(){
        tabNum++;
        printTab();
        System.out.print("Enter relop\n");
        getsym();
        if(sym.value == 9){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }else if(sym.value == 10){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }else if(sym.value == 11){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }else if(sym.value == 12){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }else if(sym.value == 13){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }else if(sym.value == 14){
            
            printTab();
            System.out.print("Exit relop\n");
            tabNum--;
            return true;
        }
        
        printTab();
        System.out.print("Exit relop\n");
        tabNum--;
        return false;
    }
    public static boolean value(){
        tabNum++;
        printTab();
        System.out.print("Enter Value\n");
        getsym();
        if(sym.value == 7){
            
            printTab();
            System.out.print("Exit Value\n");
            tabNum--;
            return true;
        }else if(sym.value == 8){
            
            printTab();
            System.out.print("Exit Value\n");
            tabNum--;
            return true;
        }else{
            error("Error Expected ID or INT");
        }
        
        printTab();
        System.out.print("Exit Value\n");
        tabNum--;
        return false;
    }
    public static boolean statement_body(){
        tabNum++;
        printTab();
        System.out.print("Enter Statement Body\n");
        getsym();
        if(sym.value == 16){
            getsym();
            statement_list();
           
            if(sym.value == 17){
                
                printTab();
                System.out.print("Exit Statement Body\n");
                tabNum--;
                return true;
            }else{
                error("Error expected end");
            }
        }else{
            error("Error Expected begin: "+ sym.name);
        }
        
        printTab();
        System.out.print("Exit Statement Body\n");
        tabNum--;
        return false;
    }
    public static boolean iolist(){
        tabNum++;
        printTab();
        System.out.print("Enter IO List\n");
        getsym();
        if(sym.value == 18){
            getsym();
            if(sym.value == 7){
                getsym();
                if(sym.value == 20){
                    getsym();
                    while(true){
                        if(sym.value == 19){
                            break;
                        }else if(sym.value != 7 && sym.value != 20){
                            error("Error Expected a RPAREN:" + sym.name);
                        }else{
                            getsym();
                        }
                    }
                }
                if(sym.value == 19){
                    printTab();
                    
                    System.out.print("Exit IO List\n");
                    tabNum--;
                    return true;  
                }else{
                    error("Error Expected a RPAREN:" + sym.name);
                }
            }else{
                error("Error Expected ID");
            }
        }else{
            error("Error Expected LPAREN");
        }
        
        printTab();
        System.out.print("Exit IO List\n");
        tabNum--;
        return false;
    }
    public static boolean if_statement(){
        tabNum++;
        printTab();
        System.out.print("Enter IF Statement\n");
        boolean_expression();
        
        getsym();
        if(sym.value == 15){
            statement_body();
        }else{
            error("Error Expected DO");
        }
        
        printTab();
        System.out.print("Exit IF Statement\n");
        tabNum--;
        return false;
    }
    
static class Symbol {
        public String name;
        public int value;
        Symbol (String v1, int v2){
            name = v1;
            value = v2;
        }

 }
}
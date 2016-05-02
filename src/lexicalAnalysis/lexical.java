/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicalAnalysis;

import java.io.*;

/**
 *
 * @author Mahfuzur Rahman Khan
 */
public class lexical {

String key[]={"int","float","double","String","return"};
String iden[]=new String[1000];
String keyWord="";
boolean check [] = new boolean[10];
String str1="";
String symbolTable[] = new String[10];
int k;

void setCheckFalse()
{
          for(int i=0; i<=key.length; i++)
          {
              check[i] = false;
          }
}
boolean keyword(String str, PrintWriter pw)throws IOException
  {
	  for(int i=0;i<5;i++)
	  {
		  if(str.compareTo(key[i])==0)
		  {
			  System.out.println(str+"\tkeyword");
			  pw.println(str+"\tkeyword");
                          if(str.equals("int") || str.equals("float") ||str.equals("double") ||str.equals("String") )
                          {
                              keyWord=str;
                              System.out.println("keyWord =:" +keyWord);
                          }
                          //System.out.println("keyWord fghjkjhgfhj =:" +keyWord);

			  return true;

		  }
	  }
	  return false;
  }

  //find symbol
  void symbol(String st, PrintWriter pw)throws IOException
    {
	   for(int i=0; i<st.length();i++)
	   {
                      char ch=st.charAt(i);
                      if(ch=='+')
                      {
                          System.out.println(""+ch+"\toperator\taddition");
			  pw.println(""+ch+"\toperator\taddition");
                      }
                      else if(ch == '-')
                      {
                          System.out.println(""+ch+"\toperator\tsubtraction");
			  pw.println(""+ch+"\toperator\tsubtraction");
                      }
                      else if(ch=='*')
                      {
                          System.out.println(""+ch+"\toperator\tmultiplication");
			  pw.println(""+ch+"\toperator\tmultiplication");
                      }
                      else if(ch=='/')
                      {
                          System.out.println(""+ch+"\toperator\tdivision");
			  pw.println(""+ch+"\toperator\tdivision");
                      }
                      else if(ch=='%')
                      {
                          System.out.println(""+ch+"\toperator\tmodulus");
			  pw.println(""+ch+"\toperator\tmodulus");
                      }
                     
                      else if(ch=='(')
                      {
                          System.out.println(""+ch+"\tspecial symbol \topening  braces");
			  pw.println(""+ch+"\tspecial symbol \topening  braces");
                      }
                      else if(ch==')')
                      {
                          System.out.println(""+ch+"\tspecial symbol \tclosing braces");
			  pw.println(""+ch+"\tspecial symbol \tclosing braces");
                      }
                      else if(ch=='{')
                      {
                          System.out.println(""+ch+"\tspecial symbol \tleft curly braces");
			  pw.println(""+ch+"\tspecial symbol \tleft curly braces");
                      }
                      else if(ch=='}')
                      {
                          System.out.println(""+ch+"\tspecial symbol \tright curly braces");
			  pw.println(""+ch+"\tspecial symbol \tright curly braces");
                      }

                      
            }

	  }


//find identifier

boolean identifier(String s, PrintWriter pw)throws IOException
 {

          
          int checkPoint=0;
	  int length=s.length();


          if(s.equals("main"))
          {
              k=noOfIdentifier(s);
              System.out.println(s+"\tid\t");
              pw.println(s+"\tid\t");
              symbolTable[k]=""+s+"\tid\t"+""+k+"";
              //symbolTable[k]=s+"+id+";

          }

          else if((s.charAt(0) >= 65 && s.charAt(0) <= 90) || (s.charAt(0) >= 97 && s.charAt(0) <= 122))
	  {
		  k=noOfIdentifier(s);	//call method for counting identifier

		  System.out.println(s+"\tid\tpointer to symbol table entry");
		  pw.println(s+"\tid\tpointer to symbol table entry");
                  if(check[k]==false)
                  {
                      symbolTable[k]=""+s+"\tid\t"+keyWord+"\t"+""+k+"";
                      check[k]=true;
                  }
                  //symbolTable[k]="+s\t+id\tint\t+k+";


	  }

	  else if(s.charAt(0)>47 && s.charAt(0)<58)
	  {
		  for(int i=0;i<length;i++)
		  {
			  if(s.charAt(i)=='.')
			  {
				checkPoint++;
			  }
		  }

		  if(checkPoint>1)
		  {
		  	  System.out.println(s+"\tinvalid number");
		  	  pw.println(s+"\tinvalid number");
		  }

		  else
		  {
		     System.out.println(s+"\tnumber\tconstant");
	    	     pw.println(s+"\tnumber\tconstant");
		  }
	  }
          /*else
          {
                System.out.println("others");
          }*/


          return false;
  }

 int noOfIdentifier(String s)
  {
	  int i=0,j=0;
	  while(iden[i]!=null)
	  {
		  if(iden[i].compareTo(s)==0)
		  {

			  j=1;
			  break;
		  }
		  i++;
	  }

	  if(j==0)
	  {
		  iden[i]=s;
	  }

	  return i;
  }

 void printSymbolTable(PrintWriter pw)
 {
     System.out.println("\n\nSymbol  Table");
     pw.println("\n\nSymbol  Table");
     for(int i=0; symbolTable[i]!=null; i++)
     {
         System.out.println(symbolTable[i]);
         pw.println(symbolTable[i]);
     }

 }

}
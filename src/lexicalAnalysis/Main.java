package lexicalAnalysis;
import java.io.*;
import java.util.Scanner;


/**
 *
 * @author Mahfuzur Rahman Khan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException
    {
        // TODO code application logic here
        //Scanner sc = new Scanner(new File("E:\\STUDY\\All Code\\CompilerLab01\\input.txt"));

        Scanner sc = new Scanner( new File("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        lexical la = new lexical();
        la.setCheckFalse();
        String  line;
        boolean flag;
        while(sc.hasNextLine())
        {
            line = sc.nextLine();
            if(2<line.length())
            {
                if((line.substring(0, 2)).equals("//"))
                {
                    continue;
                }
                if((line.substring(0, 2)).equals("/*"))
                {
                    /*int abc;
                    double bbc;*/
                    line =sc.nextLine();
                    while(sc.nextLine().substring(line.length()-2).equals("*/"))
                    {
                        break;
                    }
                }
                
            }
            
            
            System.out.println("line value= "+line);
            char ch;
            String token="";
            for(int i=0; i<line.length(); i++)
            {
                ch = line.charAt(i);
                //System.out.println(ch);
                while(ch!=' ' && ch!=',' && ch!=';' && ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='%' && ch!='=' && i<line.length() )
                {
                    token = token + ""+ch+"";
                    //System.out.println("before token := "+token +"   i= "+i);
                    i=i+1;
                    //System.out.println(token+"value of i="+i);
                    if(i==line.length())
                    {
                        break;
                    }
                    ch = line.charAt(i);
                }
                System.out.println("after token = :"+token);
                
                if(token=="")
                {
                    continue;
                }

                if((la.keyword(token, pw)) == false)
                {
                    flag=la.identifier(token, pw);
                    if(flag==false)
                    {
                        la.symbol(token, pw);
                    }
                }

                if(ch==',')
                      {
                          System.out.println(""+ch+"\tspecial symbol \tcomma");
			  pw.println(""+ch+"\tspecial symbol \tcomma");
                      }
                if(ch==';')
                      {
                          System.out.println(""+ch+"\tspecial symbol \tsemicolon");
			  pw.println(""+ch+"\tspecial symbol \tsemicolon");
                          break;
                      }
                      if(ch=='+')
                      {
                          System.out.println(""+ch+"\toperator\taddition");
			  pw.println(""+ch+"\toperator\taddition");
                      }
                      if(ch=='-')
                      {
                          System.out.println(""+ch+"\toperator\tsubtraction");
			  pw.println(""+ch+"\toperator\tsubtraction");
                      }
                      if(ch=='*')
                      {
                          System.out.println(""+ch+"\toperator\tmultiplication");
			  pw.println(""+ch+"\toperator\tmultiplication");
                      }
                      if(ch=='/')
                      {
                          System.out.println(""+ch+"\toperator\tdivision");
			  pw.println(""+ch+"\toperator\tdivision");
                      }
                if(ch=='%')
                      {
                          System.out.println(""+ch+"\toperator\tModulus");
			  pw.println(""+ch+"\toperator\tModulus");
                      }
                if(ch=='=')
                      {
                          System.out.println(""+ch+"\toperator\tassignment");
			  pw.println(""+ch+"\toperator\tassignment");
                      }


                token="";

            }
        }
        la.printSymbolTable(pw);
        pw.close();


    }
}

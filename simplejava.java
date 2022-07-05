import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.chrono.ChronoPeriod;
import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.PrintWriter;
import java.util.*;
import java.lang.invoke.TypeDescriptor.OfMethod;

public class simplejava {
    public static void main(String[] args) {

        askforChoice();
        
    }

    public static void askforChoice(){
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice: ");
        System.out.println("1. Create a new Todo list");
        System.out.println("2. write Todo list");
        System.out.println("3. Display Todo list");
        System.out.println("4. update the list");
        System.out.println("5. Search in list items");
        System.out.println("6. Delete the list");
        System.out.println("0. Exit");
       
        

        choice = sc.nextInt();
    
        switch(choice) {

            case 1:
                    CreateTodoList();
                    break;

            case 2:
                    WriteTodoList();
                    break;

            case 3:
                    DisplayTodoList();
                    break;        
            
            case 6:
                    DeletenowTodoList();
                    break;

            case 5:    
                    SearchTodoList();
                    break; 
                    
            case 4:
                    updateTodoList();   
                    break; 
                    
            case 0:
                    System.exit(0);   
                
                    
            } 
            sc.close();
    }




    public static void CreateTodoList(){
        try {
            String filename;
            Scanner scWritter  = new Scanner(System.in);
            System.out.println("Enter the todo list Name to create:");
            filename = scWritter.nextLine();
             File myObj = new File("/Users/yogendrak/Downloads/"+filename);
            if (myObj.createNewFile()) {
                System.out.println("File created :"+ myObj.getName());
                askforChoice();

            } else {
                System.out.println("File already exists.");
                askforChoice();
            }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                 e.printStackTrace();
            }

            scWritter.close();
         
    }

    public static void WriteTodoList(){
        try {
            String filename;
            Scanner scWritter  = new Scanner(System.in);
            System.out.println("Enter the todo list Name to write:");
            filename = scWritter.nextLine();
             File myObj = new File("/Users/yogendrak/Downloads/"+filename);
            //File myObj = new File("/Users/yogendrak/Downloads/"+choice);
            if (myObj.exists()) {
                FileWriter writer = new FileWriter(myObj,true);
                BufferedWriter wri = new BufferedWriter(writer);
                //String line = scWritter.nextLine();
                wri.write(scWritter.nextLine());
                wri.newLine();
                wri.close();
                writer.close();
                askforChoice();

            } else {
               CreateTodoList();

            }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                 e.printStackTrace();
            }
    }
    public static void DisplayTodoList(){
        try {
            String filename,data;
            Scanner scReader  = new Scanner(System.in);
            System.out.println("Enter the todo list Name to display:");
            filename = scReader.nextLine();
             File myObj = new File("/Users/yogendrak/Downloads/"+filename);
            if (myObj.exists()) {
                FileReader fr = new FileReader(myObj);
                Scanner scReader1  = new Scanner(myObj);
                while (scReader1.hasNextLine()) {
                    data = scReader1.nextLine();
                    System.out.println(data); 
                     
                }
                askforChoice();

            } else {
               CreateTodoList();
            }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                 e.printStackTrace();
            }
    }

    public static void DeletenowTodoList(){
            String filename;
            Scanner sc  = new Scanner(System.in);
            System.out.println("Enter the todo list Name to delete: ");
            filename = sc.nextLine();
            File myObj = new File("/Users/yogendrak/Downloads/"+filename);
            if (myObj.delete()) {
                    System.out.println("Deleted ");  
                    askforChoice();
                }
             else {
                System.out.println("file cannot be deleted");
             }
    }

    public static void SearchTodoList(){
        String filename,Search,str;
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the todo list Name to search: ");
        filename = sc.nextLine();
        File myObj = new File("/Users/yogendrak/Downloads/"+filename);
        FileReader fr = null;
        System.out.println("Enter the word to search : ");
        Search = sc.nextLine();
        try{
            fr = new FileReader(myObj);
            BufferedReader br = new BufferedReader(fr);
            while ((str = br.readLine()) != null){
                if (str.contains(Search)) {
                    System.out.println(str);
                }
                askforChoice();
            }
            fr.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
                 e.printStackTrace(); 
        }
        
    }

    public static void updateTodoList(){
        String filename,Search,str,update,newString;
        Scanner sc  = new Scanner(System.in);
        
        System.out.println("Enter the todo list Name to update: ");
        filename = sc.nextLine();
        File myObj = new File("/Users/yogendrak/Downloads/"+filename);
        FileReader fr = null;
        try (Scanner sc1 = new Scanner(myObj)) {
            //StringBuffer buffer = new StringBuffer();
            System.out.println("Enter the word to search : ");
            Search = sc.nextLine();

            
            StringBuffer buffer = new StringBuffer();
    
     while (sc1.hasNextLine()) {
             buffer.append(sc1.nextLine()+System.lineSeparator());
     }

     String fileContents = buffer.toString();
     System.out.println("Contents of the file: "+fileContents);
       
       
        System.out.println("enter the word to update  :");
         newString = sc.nextLine();
      System.out.println(newString);
      fileContents = fileContents.replace(Search, newString);
      System.out.println("new data:i file now "+fileContents);
      try (FileWriter writer = new FileWriter(myObj)) {
        System.out.println("");
          System.out.println("new data: "+fileContents);
          writer.append(fileContents);
          writer.flush();
          askforChoice();
    } catch (IOException e) {
        System.out.println("An error occurred.");
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
}

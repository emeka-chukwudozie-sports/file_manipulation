package fileManipulation;


import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {
        try {

            File myFile = new File("hello.txt");
            File myFileTwo = new File("src/fileManipulation/second.txt");
            File pdfFile = new File("/home/emeka/Desktop/user/Documents/Big Data/Big_Data_Taxonomy.pdf");
            if(myFile.createNewFile()){
                System.out.println("File Created: "+myFile.getName());
                System.out.println(myFile.getAbsolutePath());

            } else {
                System.out.println("File Already Exist");
                System.out.println(myFile.getAbsolutePath());
//                writeToFile();
                System.out.println(readFromFile(myFile));

            }

        }catch (IOException e){
            System.err.println("File Error!!!");
        }

    }

    public static void writeToFile(){
        try{
            FileWriter myWriter = new FileWriter("hello.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.write("\nYou get to use it better if you practice long enough");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String readFromFile(File file){
        StringBuilder data = new StringBuilder();
        try {
            Scanner myReader = new Scanner(file);
            data = new StringBuilder(myReader.nextLine());
            while (myReader.hasNextLine()){
                data.append("\n");
                data.append(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static void readFromPDF(File file){
        BodyContentHandler ch = new BodyContentHandler();
    }
}

package app;

import java.io.*;

public class Main{
    public static void main(String[] args) {
        File myObj = new File("src/files/donald_duck.jpg");
        File myObj2 = new File("src/files/provatxt.txt");
        File myObj4 = new File("src/files/sample.doc");
        File myObj5 = new File("src/files/pptexamples.ppt");
        File myObj6 = new File("src/files/sample.xlsx");
        File myObj8 = new File("src/files/Sample_data.epub");
        File myObj7 = new File("src/files/zip_2MB.zip");
        if (myObj.exists()) {
            try {
                System.out.println("JPG " + CheckFileExtensionMime.getInstance().checkFile(myObj) );
                System.out.println();
                System.out.println("TXT " + CheckFileExtensionMime.getInstance().checkFile(myObj2) );
                System.out.println();
                System.out.println("DOC " + CheckFileExtensionMime.getInstance().checkFile(myObj4) );
                System.out.println();
                System.out.println("PPT " + CheckFileExtensionMime.getInstance().checkFile(myObj5) );
                System.out.println();
                System.out.println("XLSX " + CheckFileExtensionMime.getInstance().checkFile(myObj6) );
                System.out.println();
                System.out.println("XLSX 8: " + CheckFileExtensionMime.getInstance().checkFile(myObj8) );
                System.out.println();
                System.out.println("ZIP " + CheckFileExtensionMime.getInstance().checkFile(myObj7) );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
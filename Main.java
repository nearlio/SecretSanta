/*
This program gets two arrays of names, randomly sorts them, then pairs them together ina file names secret santa.
Hart will onyl have to read the first names and will not look at the second column.
 */
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        String[] sender = {"A", "B", "C", "D", "E", "F", "G"};
        String[] rec = {"A", "B", "C", "D", "E", "F", "G"};

        // Shuffle the elements in the array
        List<String> sendSant = Arrays.asList(sender);
        List<String> recSant = Arrays.asList(rec);
        
        shuffle(sendSant, recSant);
        print(sendSant, recSant);
    }//main
    
    public static void shuffle(List<String> sendSant, List<String> recSant){
        Collections.shuffle(sendSant);
        Collections.shuffle(recSant);
        
        for(int counter = 0; counter < sendSant.size(); counter++){
            if(sendSant.get(counter).equals(recSant.get(counter))){
                Collections.swap(sendSant, counter, counter+1);
            }//if
        }//for
    }//shuffle
    public static void print(List<String> sender, List<String> rec){
        try{
            File fout = new File("santa.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            
            for(int counter = 0; counter < sender.size(); counter++){
                String text1 = sender.get(counter);
                String text2 = rec.get(counter);
                
                bw.write(text1);
                bw.write(" ");
                bw.write(text2);
                bw.newLine();
            }//for

            bw.close();
        }//try
        catch (IOException  e){    
            System.out.print("lol fuck");
        }//catch
    }//print

}//Main

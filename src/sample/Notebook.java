
package sample;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Notebook {
    List<Note> notes;
    public Notebook() {
        notes = new ArrayList<Note>();
    }
    public static void addNote(String title, LocalDate date, String body) {

        try (FileWriter file = new FileWriter("C:/Users/Innocentius/Desktop/myNotes.txt", true);
             BufferedWriter buff = new BufferedWriter(file);
             PrintWriter printing = new PrintWriter(buff);) {
            printing.println(title);
            printing.println(date);
            printing.println(body);
            printing.println("*");

            buff.flush();
            buff.close();
            printing.flush();
            printing.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readT(String filename){
        try {
            this.notes.clear();
            String t ="";
            String b ="";
            String d ="";
            String temp ="";
            String x ="";
            Scanner reader = new Scanner(new FileReader(filename));
            while(reader.hasNextLine()){
                t = reader.nextLine();
                d = reader.nextLine();
                b=reader.nextLine();
                temp = reader.nextLine();
                if(!temp.startsWith("*")){
                    b+=temp;
                    temp = reader.nextLine();
                }
                LocalDate tempDate = LocalDate.parse(d);
                Note note = new Note(t,tempDate,b);
                this.notes.add(note);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public List<Note> findTitle(String title){
        List<Note> results = new ArrayList<Note>();
        for(Note temp : this.notes) {
            if(temp.matchTitle(title)){
                results.add(temp);
            }
        }
        return results;
    }
    public List<Note> findDate(LocalDate date) {
        List<Note> results = new ArrayList<Note>();
        for (Note temp : this.notes) {
            if (temp.matchDate(date)) {
                results.add(temp);
            }

        }
        return results;
    }
}

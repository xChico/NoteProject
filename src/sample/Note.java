package sample;

import java.time.LocalDate;

public class Note {
    //title, body,date, set, getters
    String title;
    String body;
    LocalDate date;

    public Note(String title, LocalDate date, String body){
        this.title = title;
        this.body = body;
        this.date = date;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setDate (LocalDate date){
        this.date = date;
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
    public LocalDate getDate(){
        return date;
    }

//boolean
    public boolean matchTitle(String info){
        return title.contains(info);
    }
    public boolean matchDate(LocalDate date){
        return this.date.equals(date);

    }
    @Override
    public String toString(){
        return "Title: " + this.title + "\n" + "Date: " + this.date + "\n" + "Note: " + this.body +"\n" ;

    }
}

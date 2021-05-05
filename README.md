# Note Taking Application

## About the Project:

This project is a note taking application. On the left portion of the application, the user can submit a title for the
note, a date, and the note itself. By clicking 'Save Note', the note is saved on a txt file that is attached on the 
project. On the right side of the application, it offers the user the option to look for specific note based on
titles/partial titles and dates. By clicking 'Search by Title/Search by Date', a list of notes that either matched the 
provided title or date will display in the 'Notes Found' section. If the user wishes to enlarge a specific note, then
they can select the note and click 'View Note'. A po- up message will display the note individually.

## Technical Section:

The Main class is the main class to run the program.

The Main class contains the platforms structure. The GridPane is used to display the labels, text fields, text areas,
buttons, and the list.

The addNote method in the Notebook class reads the file on the project and adds the title, date, and note that was
submitted by the user. A '*' character is added after every note to create a separation between every note.

The readT method, in the Notebook class, reads the file through a scanner and through a while loop adds the title,
date, and note into an arraylist of notes, skipping on the '*' value. 

The readT method then is used in the Main class when searching for notes that match the full/partial titles and dates 
that the user is looking for. The readT is called twice, once in the lambda expression of searchTiBut.setOnAction 
(looking for the note matching the title). In the lambda expression, the findTitle method, from the Notebook class, is 
called. The findTitle method creates a new ArrayList that saves the note and returns it that matches the title that is 
passed through the parameter in the method. To check if the title has any matches in the full list of notes, the method 
matchTitle, from the Note class, is called, returning a boolean value. The user adds the title in the TextField for 
title then by clicking the button 'Search by Title'.


The findTitle method is used again in the inner class of searchDaBut.setOnAction(looking for a note matching the date).
Just like finding the title, a method called findDate method, from the Notebook class, is called to return the note
that has a note matching the date that is passed through the method's parameter. matchDate method, from the Note class,
is used to return the boolean value, verifying if there is a note that has a date matching. The user chooses the
date from the DatePicker control then by clicking the 'Search by Date' button.

For both of the above expressions, to search for the title and the date, an ObservableList interface and a 
ListView class is used to display the notes found when the user searches for the notes.

The last inner class in the Main class gives the user the choice to select the note to view in a separate pop-up window
by clicking the specific note and then the 'View Note' button.

The MessageBox class contains the methods that provide the pop-up windows for the following situations:
* display() method handles the pop-up window indicating no notes were found when searching for a note.
* nothingSaved() method handles the pop-up window indicating the user no note was saved.
* chooseList() methods handles the pop-up window displaying the note that was chosen to view separately from the other
notes in the list.
  
The Note class holds the constructors for the program and the setters/getters.
  
Additional methods:
*ToString method in the Note class sets the notes in the followed structure: title:  , date:  , note:  , .



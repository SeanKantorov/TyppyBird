import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class showAvailVocab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class showAvailVocab extends showText
{
    private ArrayList<String> listOfWords = tutorialText.Word_List; //the list of words used for the game
    public static String toShow = "";
    public void act()
    {
        getWorld().showText(toShow,50,100);
    }
    // This method should be used when setting the array list listOfWords
    // It updates the static variable and the toShow string
    // This needs to be called every time the list of words changes
    public void setListOfWords(ArrayList<String> list){
        listOfWords = list;
        for (int i=0; i<list.size()-1; i++){
            toShow = toShow + list.get(i) + "\n";
        }
    }
    
    public void wordTyped(String justTyped){
        
    }
}

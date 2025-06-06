import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class showTyped here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class showTyped extends showText
{
    /**
     * Act - do whatever the showTyped wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText(toShow,300,350);
    }
    public static void addLetter(String newLetter){
        if (newLetter != "enter" && newLetter != "backspace" && newLetter != "space"){
            toShow = toShow + newLetter;
        } else if (newLetter == "space"){
            toShow = "";
        } else if (newLetter == "backspace"){
            toShow = toShow.substring(0,toShow.length()-1);
        }
        
    }
}

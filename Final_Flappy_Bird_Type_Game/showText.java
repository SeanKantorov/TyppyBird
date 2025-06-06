import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class showText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class showText extends Actor
{
    /**
     * Act - do whatever the showText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static String toShow = "";
    public void act()
    {
        getWorld().showText(toShow,300,200);
    }
    public static void changeShow(String text){
        toShow = text;
    }
}

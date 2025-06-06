import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays; 
/**
 * Write a description of class tutorialText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tutorialText extends showText
{
    
    private tutorialBG beegee;
    //
    public static ArrayList<String> Word_List; //This is the word list array for use in other places
    //
    private String[] tutorialStages = {"Tutorial\nThis version of Flappy Bird flaps the bird with your keyboard.\n(Click to continue)","However, you also must spell words and phrases as you play.","You will receive extra lives as you fly through the pipes,\nand your final score will be based on the number of extra lives you have.\nHave fun!"};
    private int iterator = 0;
    public boolean display_Word_list = false; 
    public void act()
    {
        if (iterator == 0){
            getWorld().showText(tutorialStages[iterator],300,200);
        }
        if (Greenfoot.mouseClicked(beegee)){
            if (iterator == 2){
                getWorld().showText("",300,200);
                //start of user input for the word list
                String input = Greenfoot.ask("Please Input a List of Words for the Game or Leave Blank For Default List Example: hi, hello, bonjour");
                //checks for default list or not
                if(input.length() > 0){
                    //splits and creates an arraylist for the user input list
                    String[] new_input = input.split(", ");
                    Word_List = new ArrayList<String>(Arrays.asList(new_input));
                    //for loop used for testing
                    //for (String s : new_input) 
                        //System.out.println(s);
                } else {
                    /* gets the default word list (as a string) from 
                     * Default_Word_List class splits and creates an 
                     * arraylist for the default list */
                    Default_Word_List defaultwords = new Default_Word_List();
                    String default_words = defaultwords.words;
                    String[] Default = default_words.split("\\r?\\n");
                    Word_List = new ArrayList<String>(Arrays.asList(Default));
                    //for loop used for testing
                    //for (String s : Default) 
                      // System.out.println(s);
                beegee.setLocation(2000,1000);
                beegee.setImage("invisible.png");
                MyWorld.begin(getWorld());
            }
            } else {
            iterator += 1;
            getWorld().showText(tutorialStages[iterator],300,200);
            }
            
        }
        
    }
    public void setBG(tutorialBG bg){
        beegee = bg;
    }
}

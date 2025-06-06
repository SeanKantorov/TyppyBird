import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // The tutorial background and text uncommnet later for tutorial
        tutorialBG tutorialBackground = new tutorialBG();
        tutorialText tutorialText = new tutorialText();
 
        tutorialText.setBG(tutorialBackground);
        addObject(tutorialText,300,300);
        addObject(tutorialBackground,300,200);
        
        //this is the normal code when we want to run the game
        //addObject(new Flappybird(), 100, 300);
        //addObject(new Pipe(), 300, 150);
        //addObject(new Pipe(), 600, 150);
        //addObject(new Score(), 300, 100);
        
        
        // this is code for when you want to test new features
        //addObject(new TypedFlapBaseClass(), 100, 300);
        //addObject(new Pipe(), 300, 150);
        //addObject(new Pipe(), 600, 150);
        //addObject(new Score(), 300, 100);
        
    }
    // This method will begin the game
    // It gets called when the tutorial ends
    // If you want to skip the tutorial just comment out every mention of
    // tutorial and call this method
    public static void begin(greenfoot.World newWorld){
        String difficulty = Greenfoot.ask("Enter your difficulty, easy, medium, or hard.");
        if (difficulty.equals("easy")){
            newWorld.addObject(new Easy(), 100, 500);
        }
        else if (difficulty.equals("medium")){
            newWorld.addObject(new TypedFlapBaseClass(), 100, 500);
        }
        else if (difficulty.equals("hard")){
            newWorld.addObject(new Hard(), 100, 500);
        }
        else {
            newWorld.addObject(new TypedFlapBaseClass(), 100, 500);
        }
        // This resets the static variable toShow (which is what the 
        // player is typing) every time a new game starts
        showTyped showType = new showTyped();
        showType.toShow = "";
        newWorld.addObject(showType,300,300);
        showAvailVocab showVocab = new showAvailVocab();
        showVocab.setListOfWords(tutorialText.Word_List);
        newWorld.addObject(showVocab,300,300);
        
        //newWorld.addObject(new Pipe(), 300, 150);
        //newWorld.addObject(new Pipe(), 600, 150);
        //newWorld.addObject(new Score(), 300, 100);
        //newWorld.addObject(new showTyped(),300,300);
    }
}

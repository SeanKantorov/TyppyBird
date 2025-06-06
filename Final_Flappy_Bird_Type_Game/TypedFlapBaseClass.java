import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TypedFlapBaseClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypedFlapBaseClass extends Flappybird
{
    protected String word = "";
    protected ArrayList<String> words = tutorialText.Word_List; //the list of words used for the game
    public String causeOfDeath;
    
    /**
     * Act - do whatever the TypedFlapBaseClass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TypedFlapBaseClass(){
        super();
        //words.add("a");
    }
    @Override
    public void act()
    {
        getWorld().showText("Medium", 300, 50);
        // Add your action code here.
        //If you press space, the y coordinate will decrease and fly up
        if(flap()){
            g=-2;//The lower the number, the higher the flight

        }
        g +=0.1; //The g value increases by 0.1 each time
        y += g; //In this way, the y value does not change at a constant rate, but becomes increasingly larger
        setLocation(getX(), (int)(y));
        //If you hit a pipe then it's game over
        if(isTouchpipe()){
            isalive = false;
        }
        //voting when game over
        //uncomment this, out for real game
        //useful for testing
        if(isAtEdge()){
            extralives --;
            if (extralives <= 0){
                Greenfoot.playSound("peng.mp3");
                causeOfDeath = "Fall";
                isalive = false;
            }
        }
        if(isalive){
            getWorld().showText("Extra Lives: "+ extralives,500,50);
            getWorld().showText("Score: " + Score.score, 500, 70);
        }
        
        //after falling or hitting a pipe the flappybird disappears and cause of death is shown
        if(!isalive){
            getWorld().addObject(new Gameover(), 300, 200);
            if (causeOfDeath == "pipe") {
            getWorld().showText("Died Due to Pipe",300,50);
            } else if (causeOfDeath == "Spelling") { 
            getWorld().showText("Died Due to Spelling",300,50);
            } else {
            getWorld().showText("Died Due to Falling",300,50);    
            }
            getWorld().removeObject(this);
        }
        //addition of score after passing 1 pipe and voting
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hasaddscore = isacross;
    }
    //Returns when space is pressed
    @Override
    public boolean spacePressed(){
        for (String x : words){
            if (x.equals(word)){
                word = "";
                extralives += 0.5;
                return isalive;
            }
        }
        word = "";
        extralives --;
        if (extralives <= 0) {
            causeOfDeath = "Spelling";
            isalive = false;
        }
        return isalive;
    }
    public boolean flap(){
        boolean pressed = false;
        String key = Greenfoot.getKey();
        if(key != null) {
            if (key.equals("space")){
                if(!haspressed){//If you haven't escaped a space, don't return true
                showTyped.addLetter(key);
                Greenfoot.playSound("flay.mp3");
                pressed = true;
                spacePressed();
            }
                haspressed = true; //spasi telah ditekan
            }
            if(key == "enter" || key == "backspace") {
                haspressed = false;
                pressed = false;
                return pressed;
            }
            if(!haspressed){//If you haven't stopped pressing a key, don't return true
                showTyped.addLetter(key);
                Greenfoot.playSound("flay.mp3");
                pressed = true;
                word = word + key;
                
            }
            //getWorld().showText(word,300,50);
            haspressed = true; //makes it so that once you press it, it wont keep continually flapping
        }
        else {
            haspressed = false;
        }
        return pressed;
    }
    @Override
    public boolean isTouchpipe() {
        isacross = false;
        for(Pipe pipe : getWorld().getObjects(Pipe.class)){
            if(Math.abs(pipe.getX() - getX()) < 60 ){
                if(Math.abs(pipe.getY() + 30 - getY()) > 37){
                    extralives --;
                    if (extralives <= 0){
                        Greenfoot.playSound("peng.mp3");
                        causeOfDeath = "pipe";
                        isalive = false;
                    }
                }
                isacross = true; 
            }
        }
        return !isalive;
    }
}


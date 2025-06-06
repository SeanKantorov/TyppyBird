import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Easy extends TypedFlapBaseClass
{
    /**
     * Act - do whatever the Easy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act()
    {
        getWorld().showText("Easy", 300, 50);
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
            Score.add(0.5);
        }
        hasaddscore = isacross;
    }
    @Override
    public boolean spacePressed(){
        for (String x : words){
            if (x.equals(word)){
                word = "";
                extralives += 1;
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
}

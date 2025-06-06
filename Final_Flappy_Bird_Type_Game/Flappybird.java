import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Flappybird here.
 * setRotation((int)(1 * 16)); Greenfoot.playSound("flay.mp3");
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappybird extends Actor
{
    protected double g = 1; 
    protected int y = 300;
    protected boolean haspressed = false;
    protected boolean isalive = true;
    protected boolean isacross = false;
    protected boolean hasaddscore = false; //The initial value means it hasn't been added too much
    protected double extralives = 0;
    
    public Flappybird() {
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    /**
     * Act - do whatever the Flappybird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //If you press space, the y coordinate will decrease and fly up
        if(spacePressed()){
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
        if(isAtEdge()){
            Greenfoot.playSound("peng.mp3");
            isalive = false;
        }
        //after falling or hitting a pipe the flappybird disappears
        if(!isalive){
            getWorld().addObject(new Gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        //addition of score after passing 1 pipe and voting
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hasaddscore = isacross;
        // Add your action code here.
    }
    //Returns when space is pressed
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")) {
            if(!haspressed){//If you haven't escaped a space, don't return true
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true; //spasi telah ditekan
        }
        else {
            haspressed = false;
        }
        return pressed;
    }
    //voice when hitting a pipe and falling
    public boolean isTouchpipe() {
        isacross = false;
        for(Pipe pipe : getWorld().getObjects(Pipe.class)){
            if(Math.abs(pipe.getX() - getX()) < 60 ){
                if(Math.abs(pipe.getY() + 30 - getY()) > 37){
                    Greenfoot.playSound("peng.mp3");
                    isalive = false;
                }
                isacross = true; 
            }
        }
        return !isalive;
    }

}

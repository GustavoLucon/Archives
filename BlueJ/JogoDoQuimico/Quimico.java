
/**
 * Write a description of class Quimico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quimico
{
    // instance variables - replace the example below with your own
    private int x;
    private int vidas = 9;

    /**
     * Constructor for objects of class Quimico
     */
    public Quimico()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean morreu()
    {
    vidas = vidas-1;
    if(vidas == 0)
    {
    return true;    
    }
    else
    {
    return false;
    }
    }
    
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

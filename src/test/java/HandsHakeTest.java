import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandsHakeTest 
{
    @Test
    public void combinationWith2People()
    {
    	int peopleCount = 2; 
    	HandsShake handsShake = new HandsShake(peopleCount);    	
    	assertEquals(1, handsShake.getCombinatoinCount());
    }
    
    @Test(expected = IllegalArgumentException.class)    
    public void handShakeWithLessThanMinPeople()
    {
    	int peopleCount = 1; 
    	new HandsShake(peopleCount);
    }
    
    @Test(expected = IllegalArgumentException.class)    
    public void handShakeWithGreatherThanMaxPeople()
    {
    	int peopleCount = 101; 
    	new HandsShake(peopleCount);
    }      
    
    @Test(expected = IllegalArgumentException.class)    
    public void handShakeWithOddPeopleCount()
    {
    	int peopleCount = 11; 
    	new HandsShake(peopleCount);
    }       
    
    @Test
    public void combinationWith4People()
    {
    	int peopleCount = 4; 
    	HandsShake handsShake = new HandsShake(peopleCount);    	
    	assertEquals(2, handsShake.getCombinatoinCount());
    }
    
    @Test
    public void combinationWith6People()
    {
    	int peopleCount = 6; 
    	HandsShake handsShake = new HandsShake(peopleCount);    	
    	assertEquals(5, handsShake.getCombinatoinCount());
    }        
}

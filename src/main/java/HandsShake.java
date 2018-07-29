import java.math.BigInteger;

/*
	Задача 112: Совещание
Начинается совещание за круглым столом. Собралось N человек. Как им одновременно пожать руки друг другу так, 
чтобы руки никаких людей не пересекались. Вам необходимо вычислить кол-во вариантов, ктр они могут это сделать.
Входные данные: N - четное натуральное число от 2 до 100.
Вывод: кол-во способов, ктр они могут пожать друг другу руки.
Пример:
N = 4
Answer = 2
 * */
public class HandsShake 
{
	private int N;
	private static final int LOWER_BOUND = 2;
	private static final int UPPER_BOUND = 100;
	
	// for optimization and improvement speed we'll store calculated number combinations 
	// for all count of people < N
	// as number of people always is even, then number of combinations for K people will store in variable combinations[K/2 - 1]  
	private BigInteger[] combinations;
	
	public HandsShake(int N) {
		if (N < LOWER_BOUND) {
			throw new IllegalArgumentException("Parameter N cann't be lower than " + LOWER_BOUND);
		}
		if (N > UPPER_BOUND) {
			throw new IllegalArgumentException("Parameter N cann't be greather than " + UPPER_BOUND);
		}
		if (N%2 != 0) {
			throw new IllegalArgumentException("Parameter N must be even.");
		}
		
		this.N = N;

		combinations = new BigInteger[N/2];
	}
	
	public BigInteger getCombinatoinCount() {	
		return getCombinationCount(N);
	}
	
	// recursive function
	private BigInteger getCombinationCount(int peopleCount) {
		if (peopleCount == 0)
			return BigInteger.ONE;
		if (combinations[peopleCount / 2 - 1] != null) {
			return combinations[peopleCount / 2 - 1];
		}
		
		BigInteger combinationCount = BigInteger.ZERO;
		for (int i = 1; i < peopleCount; i+=2) {
			BigInteger combinationLeftCount = getCombinationCount(i - 1);
			BigInteger combinationRightCount = getCombinationCount(peopleCount - i - 1);
			combinationCount = combinationCount.add(
					combinationLeftCount.multiply(combinationRightCount)
					);
		}
		combinations[peopleCount / 2 - 1] = combinationCount;
		return combinationCount;
	}
	
    public static void main( String[] args )
    {
    	int peopleCount = 4; 
    	HandsShake handsShake = new HandsShake(peopleCount);
        System.out.printf( "Combination count for %s people: %s\n", 
        		peopleCount, 
        		handsShake.getCombinatoinCount());
        
        peopleCount = 6; 
    	handsShake = new HandsShake(peopleCount);
    	System.out.printf( "Combination count for %s people: %s\n", 
    			peopleCount, 
    			handsShake.getCombinatoinCount());
    	
        peopleCount = 20; 
    	handsShake = new HandsShake(peopleCount);
    	System.out.printf( "Combination count for %s people: %s\n", 
    			peopleCount, 
    			handsShake.getCombinatoinCount());    	

        peopleCount = 50; 
    	handsShake = new HandsShake(peopleCount);
    	System.out.printf( "Combination count for %s people: %s\n", 
    			peopleCount, 
    			handsShake.getCombinatoinCount());    	
    	
        peopleCount = 100; 
    	handsShake = new HandsShake(peopleCount);
    	System.out.printf( "Combination count for %s people: %s\n", 
    			peopleCount, 
    			handsShake.getCombinatoinCount());
    }	
}

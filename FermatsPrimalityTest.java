//checks wheather a no is prime or not using fermats little theorem
class FermatsPrimalityTest{
	public FermatsPrimalityTest() {}
	//calculate GCD 
	private long gcd(long a, long b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b,a%b);
	}

	public boolean PTest(long n)
	{
		int counter = 0;
		while(true)
		{
			long max = n-2;
			long min = 2;
			long a = (int)Math.floor(Math.random()*(max-min+1)+min); //generate a random number between 2 and n-2
			
			if(gcd(a,n) != 1) //check if a and n are co primes
			{
				return false;  //return non prime
			}
			Power power = new Power();
			long b= power.power(a,n-1,n);  //calculate a^(n-1)%n == 1
			if(b != 1)
			{
				return false; //return non prime
			}
			
			counter++;
			if(counter>10) //Threshold for no of iterations
			{
				break;
			}
		}
		return true; //return probable prime
	}
	
	
}

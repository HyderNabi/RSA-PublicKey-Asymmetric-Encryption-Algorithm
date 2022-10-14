public class Power {
	//calculate a^(n-1)%n iteratively
		public long power(long a,long n, long p)
	    {
	        // Initialize result
	        long res = 1;
	         
	        // Update 'a' if 'a' >= p
	        a = a % p;
	     
	        while (n > 0)
	        {
	            // If n is odd, multiply 'a' with result
	            if ((n & 1) == 1)
	                res = (res * a) % p;
	     
	            // n must be even now
	            n = n >> 1; // n = n/2
	            a = (a * a) % p;
	        }
	        return res;
	    }

}

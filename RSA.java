//Author : Hyder Nabi
// TODO: implementation of the Cryptographic Algorithm RSA
//i.e; Rivest Shamir Adlemann : a public key encryption Algorithm


import java.util.Random;
//Class Rivest_Shamir_Adlemann is used to calculate the public key and private key
class Rivest_Shamir_Adlemann{
	private long p,q; //Two Prime Numbers
	private long n;	 //n = p*q
	private long z;   //z = (p-1) * (q-1)
	private long e;   //Encryption Key
	private long d;   //Decryption Key
	
	public Rivest_Shamir_Adlemann() {
		this.p = RandomPrime();
		this.q = RandomPrime();
		this.n = this.p * this.q;
		this.z = (this.p-1) * (this.q-1);
		this.e = Find_e();
		this.d = Find_d();
	}
	
	//Choose randomly p and q (p and q are random prime nos )
	private long RandomPrime() {
		Random random = new Random();
		FermatsPrimalityTest ob = new FermatsPrimalityTest();
		while(true) {
			long number = random.nextInt(1, 1000);
			if(ob.PTest(number)) {
				return number;
			}
		}
	}
	
	//find e such that 1<=e<z and e and z are co primes
	private long Find_e() {
		Random random = new Random();
		while(true)
		{
			long temp_e = random.nextLong(1, this.z); //generate a random number between 1(inclusive) and z(exclusive)
			if(GCD(temp_e,this.z) == 1)
			{
				return temp_e;
			}
		}
		
	}
	//Find d such that d*e = 1(mod z)
	private int Find_d()
	{
		int i = 1;
		double temp_d = (double)((this.z * i) + 1) / this.e;
		while((temp_d - Math.floor(temp_d)) != 0)
		{
			i++;
			temp_d = (double)((this.z * i) + 1) / this.e;
		}
		return (int)temp_d;
	}
	//check co primes by GCD function
	private long GCD(long a, long b)
	{
		if(b == 0)
		   return a;
	   else
		   return GCD(b,a%b);  

	}
	
	//Return Public key as (e,n)
	public long[] PublicKey() {
		long[] publickey = new long[2];
		publickey[0] = e;
		publickey[1] = n;
		return publickey;
	}
	//Return Private key as (d,n)
	public long[] PrivateKey() {
		long[] privatekey = new long[2];
		privatekey[0] = d;
		privatekey[1] = n;
		return privatekey;
	}
	
}
//Class EncrypDecrypt is used to encrypt the message and decrypt
class EncrypDecrypt{
	private Rivest_Shamir_Adlemann rsa;
	private long publickey[]; //(e,n)
	private long privatekey[]; //(d,n)
	public EncrypDecrypt() {
		 this.rsa = new Rivest_Shamir_Adlemann();
		 this.publickey = this.rsa.PublicKey();
		 this.privatekey = this.rsa.PrivateKey();
	}
	
	//Encrypt the plain Text (string P) and return the its cipher text (C) 
	public long[] Encryption(String str) {
		long cipherText[] = new long[str.length()];
		Power power = new Power();
		for(int i=0;i<str.length();i++)
		{
			//C = P^(e)%n
			cipherText[i] = power.power((int)str.charAt(i) ,this.publickey[0],this.publickey[1]);
		}
		return cipherText;
		
	}
	//Decrypt the cipher text(C) and return the plain text(string P)) text 
	public String Decryption(long cipherText[]) {
		String str = "";
		Power power = new Power();
		for(int i=0;i<cipherText.length;i++)
		{
			//P = C^(d)%n
			str += (char)power.power(cipherText[i] ,this.privatekey[0],this.privatekey[1]);
		}
		return str;
	}
}
//main class
public class RSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncrypDecrypt ob = new EncrypDecrypt(); //object of EncryptDecrypt class 
		long cipherText[] = ob.Encryption("Hello I am Hyder Nabi! ...\nI am looking for a project to contribute.\nI love open source contribution."); //Encrypt
		System.out.println(ob.Decryption(cipherText)); //Decrypt
	}
}
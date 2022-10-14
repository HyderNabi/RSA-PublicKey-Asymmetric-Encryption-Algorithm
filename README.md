# RSA-PublicKey-Asymmetric-Encryption-Algorithm
Rivest Shamir adlemann Asymmetric Encryption Algorithm
ALGORITHM:
1. CHOOSE TWO PRIME NUMBERS P AND Q
2. COMPUTE N = P*Q
3. COMPUTE Z = (P-1)*(Q-1)
4. CHOOSE E SUCH THAT 1<=E<Z AND Z AND E ARE COPRIMES 
5. DETERMINE D AS E*D = 1(MOD Z)
NOW THE PUBLIC KEY = (E,N)
AND PRIVATE KEY = (D,N)
TO ENCRYPT:
          C = P^E(MOD N)
TO DECRYPT: 
          P = C^D(MOD N)
 WHERE
         P : PLAIN TEXT
         C : CIPHER TEXT

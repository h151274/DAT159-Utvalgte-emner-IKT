/**
 * 
 */
package no.hvl.dat159.crypto;

/**
 * @author tdoy
 *
 */
public class Vignere {
	
	private char[][] encoder = new char[3][26];		// encryption array
	private char[][] decoder = new char[3][26];		// decryption array
	/**
	 * 
	 */
	public Vignere(char[] key) {
		
		// implement me
		int[] keys = new int[key.length]; 
		for (int k = 0; k < key.length; k ++) { 
			keys[k] = key[k] - 'A';
			
		}
		
		for (int i = 0; i <key.length; i++) { 
			for (int j = 0; j<26; j++) {
				encoder[i][j] = (char) ('A' + (i+keys[i]) % 26); 
				decoder[i][j] = (char) ('A' + (i-keys[i] + 26) % 26);
			}
		}
		
	} 
	
	/**
	 * 
	 * @param plaintext
	 * @return
	 */
	public String encrypt(String plaintext) {
		
		return operation(plaintext, encoder);
	}
	
	/**
	 * 
	 * @param ciphertext
	 * @return
	 */
	public String decrypt(String ciphertext) {
		
		return operation(ciphertext, decoder);
	}
	
	/**
	 * 
	 * @param input
	 * @param code
	 * @return
	 */
	private String operation(String input, char[][] code) {
		
		// implement me
		char[] msg = input.toCharArray(); 
		int counterOne = 0; 
		
		for (int i = 0; i < msg.length; i++) { 
			counterOne = 0; 
			for (int j = 0; j < code.length; j++) { 
				if (Character.isUpperCase(msg[j])) { 
					int k = msg[j] - 'A'; 
					msg[j] = code[j][k];
					counterOne ++; 
				}
				if (counterOne == j) { 
					break; 
				}
			}
		}
				
		return null;
	}

	/**
	 * @return the encoder
	 */
	public char[][] getEncoder() {
		return encoder;
	}

	/**
	 * @return the decoder
	 */
	public char[][] getDecoder() {
		return decoder;
	}

}

package edu.mtc.egr281.project14;

public class SubstitutionCipher implements MessageEncoder, MessageDecoder {

	private int shiftAmnt;
	private char[] register;
	private static String encodeOutput;
	
	public SubstitutionCipher(int shiftBy) {
		this.shiftAmnt = shiftBy;
	} // end constructor
	
	public String decode(String cipherText) {
		return this.shiftReg(cipherText, -this.shiftAmnt);
	} // end method

	public String encode(String plainText) {
		return this.shiftReg(plainText, this.shiftAmnt);
	} // end method
	
	private String shiftReg(String input, int shift) {
		this.register = new char[input.length()];
		for(int i = 0; i < register.length; ++i) {
			this.register[i] = input.charAt(i);
		} // end for
		for(int i = 0; i < register.length; ++i) {
			this.register[i] += shift;
		} // end for
		encodeOutput = new String(this.register);
		return encodeOutput;
	} // end method
	
} // end class

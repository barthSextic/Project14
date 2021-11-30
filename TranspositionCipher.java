package edu.mtc.egr281.project14;

public class TranspositionCipher implements MessageEncoder, MessageDecoder {

	private int n, index, i0, i1;
	private String register;
	private int moses;
	private char[] a, b, output;
	
	public TranspositionCipher(int n) {
		this.n = n;
	} // end constructor
	
	@Override
	public String decode(String cipherText) {
		register = cipherText;
		for (int i = 0; i < n; ++i) {
			register = this.antiShuffle(register);
		} // end for
		return this.register;
	} // end decode

	@Override
	public String encode(String plainText) {
		register = plainText;
		for (int i = 0; i < n; ++i) {
			register = this.shuffle(register);
		} // end for
		return this.register;
	} // end encode

	private String shuffle(String input) {
		this.moses = input.length()/2;
		this.index = 0;
		this.i0 = 0;
		this.i1 = 0;
		a = new char[input.length()-this.moses];
		b = new char[this.moses];
		output = new char[input.length()];
		for(int i = 0; i < a.length; ++i) {
			a[i] = input.charAt(i);
		} // end for
		for(int i = a.length; i < input.length(); ++i) {
			b[this.index] = input.charAt(i);
			++this.index;
		} // end for
//		System.out.println(a);
//		System.out.println(b);
		for(int i = 0; i < output.length; ++i) {
			if(i%2 == 0) {
				output[i] = a[i0];
				++i0;
			} else {
				output[i] = b[i1];
				++i1;
			} // end if else
		} // end for
		register = new String(this.output);
//		System.out.println(register);
		return register;
	} // end shuffler method
	
	private String antiShuffle(String input) {
		this.moses = input.length()/2;
		this.i0 = 0;
		this.i1 = 1;
		a = new char[input.length()-this.moses];
		b = new char[this.moses];
		output = new char[input.length()];
		for(int i = 0; i < a.length; ++i) {
			a[i] = input.charAt(i0);
			i0 += 2;
		} // end for
		for(int i = 0; i < b.length; ++i) {
			b[i] = input.charAt(i1);
			i1 += 2;
		} // end for
		this.i0 = 0;
		this.i1 = 0;
		for(int i = 0; i < output.length; ++i) {
			if(i < a.length) {
				output[i] = a[i0];
				++i0;
			} else {
				output[i] = b[i1];
				++i1;
			} // end if else
		} // end for
		register = new String(this.output);
		return register;
	} // end deshuffler
	
} // end class

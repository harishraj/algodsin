package math;

/*Add Binary

 Given two binary strings, return their sum (also a binary string).
 For example,
 a = "11"
 b = "1"
 Return "100".
 */

public class leetcode_Add_Binary {

	public static void main(String[] args) {
		System.out.println(addBinary("111", "11"));
	}

	// Note: don't try to convert to deci because the input String might
	// exceed int 2^32 range.
	public static String addBinary(String a, String b) {
		String retval = "";
		boolean offset = false;
		while (a.length() != b.length()) {
			if (a.length() > b.length()) {
				b = "0" + b;
			} else {
				a = "0" + a;
			}
		}
		for (int i = b.length() - 1; i >= 0; --i) {
			if (b.charAt(i) == '1' && a.charAt(i) == '1') {
				if (offset) {
					retval = "1" + retval;
				} else {
					retval = "0" + retval;
					offset = true;
				}
			} else if (b.charAt(i) == '0' && a.charAt(i) == '0') {
				if (offset) {
					retval = "1" + retval;
					offset = false;
				} else {
					retval = "0" + retval;
				}
			} else {
				if (offset) {
					retval = "0" + retval;
				} else {
					retval = "1" + retval;
				}
			}
		}
		return (offset) ? "1" + retval : retval;
	}
}

/*
 * Python Version
 * 
 * def addBinary(self, a, b): n = len(a) m = len(b) if m > n: a = '0' * (m - n)
 * + a else: b = '0' * (n - m) + b
 * 
 * idx = len(a) - 1 carry = False s = ''
 * 
 * while idx >= 0: if a[idx] == '1' and b[idx] == '1': if carry: s = '1' + s
 * else: s = '0' + s carry = True elif a[idx] == '0' and b[idx] == '0': if
 * carry: s = '1' + s carry = False else: s = '0' + s else: if carry: s = '0' +
 * s else: s = '1' + s idx -= 1
 * 
 * if carry: s = '1' + s
 * 
 * return s
 */

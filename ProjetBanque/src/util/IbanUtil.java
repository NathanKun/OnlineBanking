package util;

import java.math.BigDecimal;

/**
 * Util to generate IBAN and validate IBAN
 * 
 * @author Junyang HE
 *
 */
public class IbanUtil {
	/**
	 * Check if IBAN is validate
	 * 
	 * @param rib string of rib
	 * @return	if rib is validate
	 */
	public static boolean checkIban(String rib) {
		StringBuilder extendedIban = new StringBuilder();
		
		rib = rib.substring(4) + rib.subSequence(0, 4);
		
		for (char currentChar : rib.toCharArray()) {
			// Works on base 36
			int currentCharValue = Character.digit(currentChar, Character.MAX_RADIX);
			// Convert character to simple digit
			extendedIban.append(currentCharValue);
		}
		
		return new BigDecimal(extendedIban.toString()).remainder(new BigDecimal(97)).intValue() == 1;
	}

	/**
	 * Generate IBAN by client number and account type
	 * @param clientIdStr	client's id
	 * @param type	type of account, from 1 to 3
	 * @return	the IBAN generated
	 */
	public static String generateIban(String clientIdStr, int type) {
		// Format IBAN : FRkk BBBBB GGGGG CCC CCC CCC CC KK
		// B = code banque, G = code guichet, C = numéro de compte, K = clef
		int clientId = Integer.parseInt(clientIdStr);
		String iban = "";
		String country = "FR";
		String b = "88888";
		BigDecimal bdB = new BigDecimal(b);
		String g = "66666";
		BigDecimal bdG = new BigDecimal(g);
		String c = String.valueOf(type) + String.valueOf(clientId);
		BigDecimal bdC = new BigDecimal(c);
		String keyRib = new BigDecimal(97)
				.subtract(bdB.multiply(new BigDecimal(89)).add(bdG.multiply(new BigDecimal(15)))
						.add(bdC.multiply(new BigDecimal(3))).remainder(new BigDecimal(97)))
				.toString();
		/*String keyIban = new BigDecimal(b + g + c + keyRib.toString() + "152700").remainder(new BigDecimal(97))
				.multiply(new BigDecimal(-1)).add(new BigDecimal(98)).toString();
		if (keyIban.length() == 1) {
			keyIban = "0" + keyIban;
		}*/
		String keyIban = "76";
		
		iban = country + keyIban + b + g + c + keyRib;
		return iban;
	}

	public static void main(String[] args) {
		System.out.println(generateIban("1236784568", 2));
		System.out.println(checkIban(generateIban("1236784568", 2)));
	}
}

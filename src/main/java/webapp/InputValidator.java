package webapp;

public class InputValidator {


	public static boolean inputIso_8859_1 (String iso_8859_1String) {
		/*for (int i = 0; i < iso_8859_1String.length(); i++) {
			if (iso_8859_1String.charAt(i) > 127) {
				return false;
			}
		}*/
		return true;
	}

	public static boolean inputBase64 (String base64String) {
		/*if (base64String.length() % 4 != 0 ||
			!base64String.matches("[A-Za-z0-9+/=]*") ||
			base64String.length() - base64String.replace("=", "").length() > 2) {
			return false;	
		} else if (base64String.length() - base64String.replace("=", "").length() == 1) {
			if (!base64String.substring(base64String.length() - 2, base64String.length() - 1)
				.matches("[AEIMQUYcgkosw048]")) {
				return false;
			}
		} else if (base64String.length() - base64String.replace("=", "").length() == 2) {
			if (!base64String.substring(base64String.length() - 3, base64String.length() - 2)
				.matches("[AQgw]")) {
				return false;
			}
		}
		Converter test = Converter.fromBase64String(base64String);
		return inputDecimal(test.toDecimalString());
		//bad (?)*/
		return true;
	}

	public static boolean inputDecimal (String decimalString) {
    	/*if (decimalString.isEmpty()) {
    		return true;
    	} else if (!decimalString.matches("[0-9,]*") ||
    			   decimalString.length() - decimalString.replace(",", "").length() != decimalString.split(",").length - 1) {
    		return false;
    	}
        String[] parts = decimalString.split(",");
        for (String part : parts) {
        	if (Integer.parseInt(part) < 0 ||
        		127 < Integer.parseInt(part)) {
        		return false;
        	}
        }*/
        return true;
	}

	public static boolean inputHexadecimal (String hexadecimalString) {
		/*if (hexadecimalString.length() % 2 != 0) {
			return false;
		}
		for (int i = 0; i < hexadecimalString.length(); i += 2) {
			if (!Character.toString(hexadecimalString.charAt(i)).matches("[0-7]") ||
				!Character.toString(hexadecimalString.charAt(i + 1)).matches("[0-9A-Fa-f]")) {
				return false;
			}
		}*/
		return true;
	}

	public static boolean inputBinary (String binaryString) {
		/*if (binaryString.length() % 8 != 0 ||
			!binaryString.matches("[01]*")) {
			return false;
		}
		for (int i = 0; i < binaryString.length(); i += 8) {
			if (binaryString.charAt(i) == '1') {
				return false;
			}
		}*/
		return true;
	}
}
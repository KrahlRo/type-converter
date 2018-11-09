package webapp;

public class InputValidator {

	public static boolean inputIso_8859_1 (String iso_8859_1String) {
		//return Charset.forName("ISO_8859_1").newEncoder().canEncode(iso_8859_1String);
		return true;
	}

	public static boolean inputBase64 (String base64String) {
		if (base64String.length() - base64String.replace("=", "").length() > 2  ||
		   !base64String.matches("[A-Za-z0-9+/=]*") ||
		    base64String.length() % 4 != 0) {
			return false;
		} else if (base64String.length() - base64String.replace("=", "").length() == 2 &&
				  !base64String.substring(base64String.length() - 3, base64String.length() - 2).matches("[AQgw]")) {
			return false;		
		} else if (base64String.length() - base64String.replace("=", "").length() == 1 &&
				  !base64String.substring(base64String.length() - 2, base64String.length() - 1).matches("[AEIMQUYcgkosw048]")) {
			return false;
		}
		return true;
	}

	public static boolean inputDecimal (String decimalString) {
		if (decimalString.isEmpty()) {
			return true;
		} else if (decimalString.length() - decimalString.replace(",", "").length() != decimalString.split(",").length - 1 ||
				  !decimalString.matches("[0-9,]*")) {
			return false;
    	}
        String[] parts = decimalString.split(",");
        for (String part : parts) {
        	if (255 < Integer.parseInt(part)) {
        		return false;
        	}
        }
        return true;
	}

	public static boolean inputHexadecimal (String hexadecimalString) {
		if (!hexadecimalString.matches("[0-9A-Fa-f]*") ||
			 hexadecimalString.length() % 2 != 0) {
			return false;
		}
		return true;
	}

	public static boolean inputBinary (String binaryString) {
		if (!binaryString.matches("[01]*") ||
			 binaryString.length() % 8 != 0) {
			return false;
		}
		return true;
	}
}
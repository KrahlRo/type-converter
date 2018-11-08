package webapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class InputValidatorTest {

	@Test
	void validatingBase64_remainder () {
		String testString = "A";
		Assertions.assertEquals(false, InputValidator.inputBase64(testString));
	}
	
	@Test
	void validatingBase64_wrongChar () {
		String testString = "ÄÄÄÄ";
		Assertions.assertEquals(false, InputValidator.inputBase64(testString));
	}
	
	@Test
	void validatingBase64_toManyEquals () {
		String testString = "A===";
		Assertions.assertEquals(false, InputValidator.inputBase64(testString));
	}
	
	@Test
	void validatingBase64_wrongEnd1 () {
		String testString = "aaa=";
		Assertions.assertEquals(false, InputValidator.inputBase64(testString));
	}
	
	@Test
	void validatingBase64_wrongEnd2 () {
		String testString = "aa==";
		Assertions.assertEquals(false, InputValidator.inputBase64(testString));
	}
	
	@Test
	void validatingBase64 () {
		String testString = "AA==";
		Assertions.assertEquals(true, InputValidator.inputBase64(testString));
	}
	
	
	@Test
	void validatingDecimal_wrongChar () {
		String testString = "A";
		Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
	}

	@Test
	void validatingDecimal_toManyCommas () {
		String testString = "0,";
		Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
	}

	@Test
	void validatingDecimal_outOfRange () {
		String testString = "256";
		Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
	}

	@Test
	void validatingDecimal_specialCase () {
		String testString = "";
		Assertions.assertEquals(true, InputValidator.inputDecimal(testString));
	}
	
	@Test
	void validatingDecimal () {
		String testString = "0";
		Assertions.assertEquals(true, InputValidator.inputDecimal(testString));
	}


	@Test
	void validatingHexadecimal_remainder () {
		String testString = "0";
		Assertions.assertEquals(false, InputValidator.inputHexadecimal(testString));
	}
	
	@Test
	void validatingHexadecimal_wrongChar () {
		String testString = "0g";
		Assertions.assertEquals(false, InputValidator.inputHexadecimal(testString));
	}
	
	@Test
	void validatingHexadecimal () {
		String testString = "00";
		Assertions.assertEquals(true, InputValidator.inputHexadecimal(testString));
	}


	@Test
	void validatingBinary_remainder () {
		String testString = "0";
		Assertions.assertEquals(false, InputValidator.inputBinary(testString));
	}
	
	@Test
	void validatingBinary_wrongChar () {
		String testString = "0000000g";
		Assertions.assertEquals(false, InputValidator.inputBinary(testString));
	}
	
	@Test
	void validatingBinary () {
		String testString = "00000000";
		Assertions.assertEquals(true, InputValidator.inputBinary(testString));
	}
}
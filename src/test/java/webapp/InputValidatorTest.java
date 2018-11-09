package webapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;

class InputValidatorTest {
	
	@Nested
	class ValidatingBase64 {
			
		@Test
		void validatingBase64_toManyEquals () {
			String testString = "A===";
			Assertions.assertEquals(false, InputValidator.inputBase64(testString));
		}

		@Test
		void validatingBase64_wrongChar () {
			String testString = "AAAÄ";
			Assertions.assertEquals(false, InputValidator.inputBase64(testString));
		}

		@Test
		void validatingBase64_remainder () {
			String testString = "A";
			Assertions.assertEquals(false, InputValidator.inputBase64(testString));
		}

		@Test
		void validatingBase64_wrongEnding1 () {
			String testString = "AAa=";
			Assertions.assertEquals(false, InputValidator.inputBase64(testString));
		}

		@Test
		void validatingBase64_wrongEnding2 () {
			String testString = "Aa==";
			Assertions.assertEquals(false, InputValidator.inputBase64(testString));
		}

		@Test
		void validatingBase64_validInput () {
			String testString = "AA==";
			Assertions.assertEquals(true, InputValidator.inputBase64(testString));
		}
	}

	@Nested
	class ValidatingDecimal {
			
		@Test
		void validatingDecimal_toManyCommas () {
			String testString = "0,";
			Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
		}

		@Test
		void validatingDecimal_wrongChar () {
			String testString = "A";
			Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
		}

		@Test
		void validatingDecimal_outOfRange () {
			String testString = "256";
			Assertions.assertEquals(false, InputValidator.inputDecimal(testString));
		}

		@Test
		void validatingDecimal_cornerCase () {
			String testString = "";
			Assertions.assertEquals(true, InputValidator.inputDecimal(testString));
		}

		@Test
		void validatingDecimal_validInput () {
			String testString = "0";
			Assertions.assertEquals(true, InputValidator.inputDecimal(testString));
		}
	}

	@Nested
	class ValidatingHexadecimal {
		
		@Test
		void validatingHexadecimal_wrongChar () {
			String testString = "0g";
			Assertions.assertEquals(false, InputValidator.inputHexadecimal(testString));
		}

		@Test
		void validatingHexadecimal_remainder () {
			String testString = "0";
			Assertions.assertEquals(false, InputValidator.inputHexadecimal(testString));
		}

		@Test
		void validatingHexadecimal_validInput () {
			String testString = "00";
			Assertions.assertEquals(true, InputValidator.inputHexadecimal(testString));
		}
	}

	@Nested
	class ValidatingBinary {
		
		@Test
		void validatingBinary_wrongChar () {
			String testString = "0000000a";
			Assertions.assertEquals(false, InputValidator.inputBinary(testString));
		}

		@Test
		void validatingBinary_remainder () {
			String testString = "0";
			Assertions.assertEquals(false, InputValidator.inputBinary(testString));
		}
	
		@Test
		void validatingBinary_validInput () {
			String testString = "00000000";
			Assertions.assertEquals(true, InputValidator.inputBinary(testString));
		}
	}
}
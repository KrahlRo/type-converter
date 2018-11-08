package webapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ConverterTest {

	@Test
	void convertingIso_8859_1 () {
		String testString = " ÿ";
		Assertions.assertEquals(testString, Converter.fromIso_8859_1String(testString).toIso_8859_1String());
	}

	@Test
	void convertingBase64 () {
		String testString = "////AA==";
		Assertions.assertEquals(testString, Converter.fromBase64String(testString).toBase64String());
	}

	@Test
	void convertingDecimal () {
		String testString = "0,255";
		Assertions.assertEquals(testString, Converter.fromDecimalString(testString).toDecimalString());
	}

	@Test
	void convertingHexadecimal () {
		String testString = "00ff";
		Assertions.assertEquals(testString, Converter.fromHexadecimalString(testString).toHexadecimalString());
	}

	@Test
	void convertingBinary () {
		String testString = "0000000011111111";
		Assertions.assertEquals(testString, Converter.fromBinaryString(testString).toBinaryString());
	}
}

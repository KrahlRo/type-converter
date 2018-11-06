<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Type Converter</title>
	</head>
	<body>
		<h2>Type Converter</h2><hr>
		<form action="/login.do" method="post">
			<b>Ascii</b><br>
			<textarea rows="5" cols="100" name="asciiString" placeholder="Hello World!">${newAsciiString}</textarea>
			<input type="submit" name="submitAscii" value="Encode"><br>
			<b>Base64</b><br>
			<textarea rows="5" cols="100" name="base64String" placeholder="SGVsbG8gV29ybGQh">${newBase64String}</textarea>
			<input type="submit" name="submitBase64" value="Encode"><br>
			<b>Decimal</b><br>
			<textarea rows="5" cols="100" name="decimalString" placeholder="72,101,108,108,111,32,87,111,114,108,100,33">${newDecimalString}</textarea>
			<input type="submit" name="submitDecimal" value="Encode"><br>
			<b>Hexadecimal</b><br>
			<textarea rows="5" cols="100" name="hexadecimalString" placeholder="48656c6c6f20576f726c6421">${newHexadecimalString}</textarea>
			<input type="submit" name="submitHexadecimal" value="Encode"><br>
			<b>Binary</b><br>
			<textarea rows="5" cols="100" name="binaryString" placeholder="010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001">${newBinaryString}</textarea>
			<input type="submit" name="submitBinary" value="Encode"><br>
			<input type="submit" name="clear" value="Clear"><br>
			<font size="5" color="red">${error}</font>
		</form>
	</body>
</html>
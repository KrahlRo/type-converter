package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login.do")
public class Servlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Converter converter;
		if (request.getParameter("submitAscii") != null) {
			String string = request.getParameter("asciiString");
			if (InputValidator.inputAscii(string)) {
				converter = Converter.fromAsciiString(string);
			} else {
				request.setAttribute("error", "illegal input: Ascii");
				converter = Converter.fromAsciiString("");
			}			
		} else if (request.getParameter("submitBase64") != null) {
			String string = request.getParameter("base64String");
			if (InputValidator.inputBase64(string)) {
				converter = Converter.fromBase64String(string);
			} else {
				request.setAttribute("error", "illegal input: Base64");
				converter = Converter.fromBase64String("");
			}			
		} else if (request.getParameter("submitDecimal") != null) {
			String string = request.getParameter("decimalString");
			if (InputValidator.inputDecimal(string)) {
				converter = Converter.fromDecimalString(string);
			} else {
				request.setAttribute("error", "illegal input: Decimal");
				converter = Converter.fromDecimalString("");
			}		
		} else if (request.getParameter("submitHexadecimal") != null) {
			String string = request.getParameter("hexadecimalString");
			if (InputValidator.inputHexadecimal(string)) {
				converter = Converter.fromHexadecimalString(string);
			} else {
				request.setAttribute("error", "illegal input: Hexadecimal");
				converter = Converter.fromHexadecimalString("");
			}		
		} else if (request.getParameter("submitBinary") != null) {
			String string = request.getParameter("binaryString");
			if (InputValidator.inputBinary(string)) {
				converter = Converter.fromBinaryString(string);
			} else {
				request.setAttribute("error", "illegal input: Binary");
				converter = Converter.fromBinaryString("");
			}		
		} else {
			converter = Converter.fromAsciiString("");
		}	
	    request.setAttribute("newAsciiString", converter.toAsciiString());
	    request.setAttribute("newBase64String", converter.toBase64String());
	    request.setAttribute("newDecimalString", converter.toDecimalString());
	    request.setAttribute("newHexadecimalString", converter.toHexadecimalString());
	    request.setAttribute("newBinaryString", converter.toBinaryString());
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}
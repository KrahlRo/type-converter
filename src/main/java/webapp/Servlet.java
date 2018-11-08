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
		if (request.getParameter("submitIso_8859_1") != null) {
			String string = request.getParameter("iso_8859_1String");
			if (InputValidator.inputIso_8859_1(string)) {
				converter = Converter.fromIso_8859_1String(string);
			} else {
				request.setAttribute("iso_8859_1Error", "illegal input: ISO 8859-1");
				converter = Converter.fromIso_8859_1String("");
			}			
		} else if (request.getParameter("submitBase64") != null) {
			String string = request.getParameter("base64String");
			if (InputValidator.inputBase64(string)) {
				converter = Converter.fromBase64String(string);
			} else {
				request.setAttribute("base64Error", "illegal input: Base64");
				converter = Converter.fromBase64String("");
			}			
		} else if (request.getParameter("submitDecimal") != null) {
			String string = request.getParameter("decimalString");
			if (InputValidator.inputDecimal(string)) {
				converter = Converter.fromDecimalString(string);
			} else {
				request.setAttribute("decimalError", "illegal input: Decimal");
				converter = Converter.fromDecimalString("");
			}		
		} else if (request.getParameter("submitHexadecimal") != null) {
			String string = request.getParameter("hexadecimalString");
			if (InputValidator.inputHexadecimal(string)) {
				converter = Converter.fromHexadecimalString(string);
			} else {
				request.setAttribute("hexadecimalError", "illegal input: Hexadecimal");
				converter = Converter.fromHexadecimalString("");
			}		
		} else if (request.getParameter("submitBinary") != null) {
			String string = request.getParameter("binaryString");
			if (InputValidator.inputBinary(string)) {
				converter = Converter.fromBinaryString(string);
			} else {
				request.setAttribute("binaryError", "illegal input: Binary");
				converter = Converter.fromBinaryString("");
			}		
		} else {
			converter = Converter.fromIso_8859_1String("");
		}	
	    request.setAttribute("newIso_8859_1String", converter.toIso_8859_1String());
	    request.setAttribute("newBase64String", converter.toBase64String());
	    request.setAttribute("newDecimalString", converter.toDecimalString());
	    request.setAttribute("newHexadecimalString", converter.toHexadecimalString());
	    request.setAttribute("newBinaryString", converter.toBinaryString());
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}
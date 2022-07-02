package utils;


public class Validator {
	/**
	 * Kiểm tra xem chuỗi nhập vào có rỗng hay không.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		// Cắt và kiểm tra chuỗi có rỗng không
		if (str.trim().isEmpty()) {
			System.out.println(" (*) Not accept empty.");
			return false;
		} else {

			return true;
		}
	}

	/**
	 * Kiểm tra chuỗi nhập vào có nằm trong giới hạn quy định hay không
	 * 
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean isChoice(String str, int begin, int end) {
		// Kiểm tra chuỗi có rỗng không
		if (!isEmpty(str)) {
			return false;
		}

		// Kiểm tra người dung có nhập đúng số không.
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println(" (*) Input number please. ");
			return false;
		}

		// Kiểm tra xem người dung nhập vào có nằm trong giới hạn không
		if (Integer.parseInt(str) < begin || Integer.parseInt(str) > end) {
			System.out.println(" (*) Number must in list. ");
			return false;
		}
		return true;
	}
}
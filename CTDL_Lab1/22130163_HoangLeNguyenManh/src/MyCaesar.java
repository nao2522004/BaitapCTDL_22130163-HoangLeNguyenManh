public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n; // Số bước dịch (dịch sang phải)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		if (Character.isUpperCase(c)) {
			int index = c - 'A';
			int encryptedIndex = (index + n) % 26;
			return ALPHABET[encryptedIndex];
		} else {
			return c;
		}
	}

	// Mã hóa một đoạn văn bản sử dụng phương thức mã hóa ký tự ở trên
	public String encrypt(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (char c : input.toCharArray()) {
			encryptedText.append(encryptChar(c));
		}
		return encryptedText.toString();
	}

	// Giải mã một ký tự dựa trên số bước dịch cho trước
	// Giải mã: Dn(x) = (x - n + 26) mod 26. Ở đây, x là chỉ số của c trong mảng
	// ALPHABET
	public char decryptChar(char c) {
		if (Character.isUpperCase(c)) {
			int index = c - 'A';
			int decryptedIndex = (index - n + 26) % 26;
			return ALPHABET[decryptedIndex];
		} else {
			return c;
		}
	}

	// Giải mã một đoạn văn bản sử dụng phương thức giải mã ký tự ở trên
	public String decrypt(String input) {
		StringBuilder decryptedText = new StringBuilder();
		for (char c : input.toCharArray()) {
			decryptedText.append(decryptChar(c));
		}
		return decryptedText.toString();
	}

	public static void main(String[] args) {
		// Tạo một đối tượng MyCaesar với số bước dịch là 3
		MyCaesar caesar = new MyCaesar(3);
		// test encryptedChar
		char encryptedChar = caesar.encryptChar('A');
		System.out.println("Encrypted char: " + encryptedChar);
		// test encryptedText
		String encryptedText = caesar.encrypt("HELLO");
		System.out.println("Encrypted text: " + encryptedText);
		// test decryptedChar
		char decryptedChar = caesar.decryptChar('A');
		System.out.println("Decrypted char: " + decryptedChar);
		// test decryptedText
		String decryptedText = caesar.decrypt("HELLO");
		System.out.println("Decrypted text: " + decryptedText);
	}
}

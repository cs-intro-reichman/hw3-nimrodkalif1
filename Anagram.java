/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		System.out.println(preProcess("My Name is Nimrod Kalif id 123123123 phone number +97254654654564"));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		int j;
		for (int i = 0; i <= str1.length()-1; i++) {
			j = str2.indexOf(str1.charAt(i));
			if (j == -1)
				return false;
			if (j == 0)
				str2 = str2.substring(1);
			else
				str2 = str2.substring(0, j) + str2.substring(j+1);
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// Check if the character is alphabetic
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ') {
				result += c; // Append the alphabetic character to the result
			}
		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String result = "";
		int index;
		for (int i = str.length() - 1; i >= 0; i--) {
			index = (int) (Math.random() * i);
			result += str.charAt(index);
			str = str.substring(0, index) + str.substring(index + 1);
		}
		return result;
	}
}

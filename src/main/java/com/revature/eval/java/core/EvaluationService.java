package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {

		/*The code below was given, mine will be uncommented
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
		*/

		// Starts from the end of the string and appends each character to the reversed string as it iterates
		// to the beginning of the string.
		String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed;

	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acr = "";

		// Acronyms are capital letters so take input string to Upper Case, then put each word of the 
		// string in an array of strings using the split method
		phrase = phrase.toUpperCase();
		String[] words = phrase.split("\\s+");
		
		// Iterates through the array of all the words in the input string and takes the first letter of each
        for (String i : words) {
			acr += i.charAt(0);
			for (int j = 0; j < i.length(); j++) {

				// In the event that a word is hyphenated, you want both the first letter of the word
				// and the first letter after the hyphen
				if (i.charAt(j) == '-' && i.length() > j + 1) {
					acr += i.charAt(j + 1);
				}
			}
		}
        return acr;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration

			// If all three sides are equal return true
			// If side 1 = side 2 and side 2 = side 3 then of course side 3 = side 1 so all are the same length
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
			return false;
		}

		// First check to see if it is equilateral, if not then check to see if any two sides are the same length
		// if so return true
		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (isEquilateral()) {
				return false;
			}else if (sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne) {
				return true;
			}
			return false;
		}

		// If not equilateral and not Isosceles then it has to be scalene
		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (isEquilateral() || isIsosceles()) {
				return false;
			}
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		// Make input string upper case so don't have to use 'A' and 'a'
		string = string.toUpperCase();

		// Base case for recursive method, when the string is down to only one letter left
		// nested if else block to see value of last letter to check
		if (string.length() == 1 ) {
			if (string.charAt(0) == 'A' ||
				string.charAt(0) == 'E' ||
				string.charAt(0) == 'I' ||
				string.charAt(0) == 'O' ||
				string.charAt(0) == 'U' ||
				string.charAt(0) == 'L' ||
				string.charAt(0) == 'N' ||
				string.charAt(0) == 'R' ||
				string.charAt(0) == 'S' ||
				string.charAt(0) == 'T') {
					return 1;
			}else if (string.charAt(0) == 'D' || string.charAt(0) == 'G') {
					return 2;
			}else if (string.charAt(0) == 'B' ||
					  string.charAt(0) == 'C' ||
					  string.charAt(0) == 'M' ||
					  string.charAt(0) == 'P') {
					return 3;
			}else if (string.charAt(0) == 'F' ||
					  string.charAt(0) == 'H' ||
					  string.charAt(0) == 'V' ||
					  string.charAt(0) == 'W' ||
					  string.charAt(0) == 'Y') {
					return 4;
			}else if (string.charAt(0) == 'K'){
					return 5;
			}else if (string.charAt(0) == 'J' || string.charAt(0) == 'X') {
					return 8;
			}else {
				return 10;
			}
		}
		
		// recursive call extracting the first letter of the input string and sending the rest as the argument
		int sum = getScrabbleScore(string.substring(1));

		// checks value of the letter
		int numToAdd;
		if (string.charAt(0) == 'A' ||
				string.charAt(0) == 'E' ||
				string.charAt(0) == 'I' ||
				string.charAt(0) == 'O' ||
				string.charAt(0) == 'U' ||
				string.charAt(0) == 'L' ||
				string.charAt(0) == 'N' ||
				string.charAt(0) == 'R' ||
				string.charAt(0) == 'S' ||
				string.charAt(0) == 'T') {
					numToAdd = 1;
		}else if (string.charAt(0) == 'D' || string.charAt(0) == 'G') {
				numToAdd = 2;
		}else if (string.charAt(0) == 'B' ||
					string.charAt(0) == 'C' ||
					string.charAt(0) == 'M' ||
					string.charAt(0) == 'P') {
					numToAdd = 3;
		}else if (string.charAt(0) == 'F' ||
				  string.charAt(0) == 'H' ||
				  string.charAt(0) == 'V' ||
				  string.charAt(0) == 'W' ||
				  string.charAt(0) == 'Y') {
					numToAdd = 4;
		}else if (string.charAt(0) == 'K'){
				numToAdd = 5;
		}else if (string.charAt(0) == 'J' || string.charAt(0) == 'X') {
				numToAdd = 8;
		}else {
				numToAdd = 10;
		}

		// as long as string length is two or more return from previous recursive call
		if (string.length() - 1 > 0){
			return sum + numToAdd;
		}else{
			return sum;
		}
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		List<Character> phoneDigits = new ArrayList<>();
		int index = 0;
		String phoneNumber = "";

		// iterates through each character in input string, as long as it is a number then add to
		// phoneDigits array of characters
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
				phoneDigits.add(string.charAt(i));
				index++;
			}
		}

		// phone number can only be 10 or 11 digits in length if not then throw Illegal argument exception
		if (phoneDigits.size() < 10 || phoneDigits.size() > 11) {
			throw new IllegalArgumentException();
		}
		
		// Now iterate through the array of characters and append them to the phoneNumber string
		// which was previously empty
		for (int i = 0; i < phoneDigits.size(); i++) {
			phoneNumber += phoneDigits.get(i);
		}
		
		// if the first digit is a 1, then it is the country code and we don't need that 
		// so substring phoneNumber leaving the starting 1 off
		if (phoneNumber.charAt(0) == '1') {
			phoneNumber = phoneNumber.substring(1);
		}
		return phoneNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		// Using split method to split string by comma and whitespace, put each word into array
		String[] words = string.split("[, \\s]+");
		Map<String, Integer> occurences = new HashMap<>();

		// iterate through the words
		for (String i : words) {

			// if word is already in map then add 1 to the number occerences.
			// if not then just add word to map with occurence of 1
			if (occurences.containsKey(i)) {
				int update = occurences.get(i);
				update++;
				occurences.put(i, update);
			}else {
				occurences.put(i, 1);
			}
		}
		return occurences;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>>{
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration

			int lo = 0;
			int hi = sortedList.size() - 1;
			int mid;

			// if the high index is greater than or equal to the lower index then find mid index(average of the two)
			// and compare it to what we are trying to find. if equal then index is found
			// if not search the lower of higher half of the array depending on if the item we are looking for
			// is greater than or less than the item at the middle index. 
			while (hi >= lo) {
				mid = (hi + lo)/2;
				int cmp = sortedList.get(mid).compareTo(t);

				// if what we are looking for is greater than the item in the middle then
				// update the lower index to the middle + 1;
				if (cmp < 0){
					lo = mid + 1;
				}

				// if what we are looking for is less than the item in the middle then
				// update the higher index to middle - 1
				else if (cmp > 0) {
					hi = mid - 1;
				}
				
				// if not greater than and not less than then it must be equal so return the middle index
				else {
					return mid;
				}
			}

			// item not found in list
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration


		// split the phrase into a string array of words
		String[] words = string.split("\\s+");
		String pigLatin = "";
		int index = 0;

		// iterate through all the words
		for (String i : words) {
			i = i.toLowerCase();
			String ending = "";

			// if it starts with a vowel then just append "ay" to the end of the word
			if (i.charAt(0) == 'a' ||
					i.charAt(0) == 'e' ||
					i.charAt(0) == 'i' ||
					i.charAt(0) == 'o' ||
					i.charAt(0) == 'u') {
				i = i + "ay";
				
			}else {

				// if we get here then the word must not start with a vowel so iterate through the first letters
				// until a vowel is found. add all the leading consonants to the end of the word then add "ay"
				for (int j = 0; j < i.length(); j++) {
					if (!(i.charAt(j) == 'a' ||
						i.charAt(j) == 'e' ||
						i.charAt(j) == 'i' ||
						i.charAt(j) == 'o' ||
						i.charAt(j) == 'u')) {
							ending += i.charAt(j);
							index = j + 1;

							// special case when 'q' is involved, we need to take the 'u' with the 'q'
							if(i.charAt(j) == 'q') {
								ending += 'u';
								index++;
							}
					}else {
						ending += "ay";
						break;
					}
				}
			}
			pigLatin += i.substring(index) + ending + " ";
		}
		return pigLatin.substring(0, pigLatin.length() - 1);
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		int temp = input;
		int counter = 1;
		int sum = 0;
		int lastDigit;

		// keep dividing by 10 and increase the counter to find out how many digits are there
		while (temp >= 10) {
			temp = temp/10;
			counter++;
		}

		// keep extracting the last digit with the % operator with division by 10
		// add to the running total (sum) by the last digit extracted to the power of the counter
		temp = input;
		while(temp >= 10) {
			lastDigit = temp % 10;
			sum += Math.pow(lastDigit, counter);
			temp = temp/10;
		}
		sum += Math.pow(temp, counter);
		return (sum == input);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration

		List<Long> primeFactors = new ArrayList<>();
		List<Long> primes = new ArrayList<>();
		boolean isPrime;

		// just added the first two primes to the running list of primes
		primes.add(2L);
		primes.add(3L);

		// since first two primes are already added, let's start with the third prime which is 5 and iterate through 
		// all the numbers up to half of the input number. we only need to go halfway because there will not be 
		// another integer factor, prime or composite, between halfway and the number itself
		for (Long i = 5L; i < l/2; i++) {
			isPrime = true;

			// as we are running through the numbers from 5 to input divided by two, we check to see if that
			// number to check is divisible by other numbers. Here we only need to go to the square root
			// of the number to check (which is i)
			for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
			}
			// if it is a prime number add it to the list of primes
            if (isPrime)
            {
                primes.add(i);
            }

		}

		// now we have the list of primes up to half of the input number. Let's see which of these primes are factors
		for (int i = 0; i < primes.size(); i++) {
            while (l % primes.get(i) == 0) {
                primeFactors.add(primes.get(i));
                l = l/primes.get(i);
            }
        }
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration



			String encrypted = "";

			// iterate through each character in the input string
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);

				// if it is a capital letter then take the character and subtract 'A' from it
				// this is really taking the ascii values and subtracting. Then take that integer and add the 
				// key which is also an intege then add the ascii value of 'A' back and take
				// total and mod 26 to wrap around to the beginning of the alphabet if necessary.
				// This will shift each character by the key
				if (c >= 'A' && c <= 'Z') {
					int oldAlphabetPosition = c - 'A';
					int newAlphabetPosition = (oldAlphabetPosition + key) % 26;
					encrypted += (char)(newAlphabetPosition + 'A');

					// do the same with the lower case letters
				}else if (c >= 'a' && c <= 'z') {
					int oldAlphabetPosition = c - 'a';
					int newAlphabetPosition = (oldAlphabetPosition + key) % 26;
					encrypted += (char)(newAlphabetPosition + 'a');
				}else {
					encrypted += c;
				}
			}
			return encrypted;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration

		// make sure that the nth prime we are looking for is at least the first one
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		List<Integer> primes = new ArrayList<>();
		boolean isPrime;
		int numberToCheck = 3;
		primes.add(2);

		// same logic as before
		while (primes.size() <= i) {
			isPrime = true;
			for (int j = 2; j * j <= numberToCheck; j++)
            {
                if (numberToCheck % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                primes.add(numberToCheck);
			}
			numberToCheck++;
		}
		
		return primes.get(i - 1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.toLowerCase();
			String returnStringNoSpaces = "";
			String returnStringWithSpaces = "";

			// iterate through input string, if a letter is found then find letter same length from end
			// is the letter is from the beginning
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
					returnStringNoSpaces += (char)(26 - (string.charAt(i) - 'a' + 1) + 'a');

					// if a number is found then just add the number
				}else if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
					returnStringNoSpaces += string.charAt(i);
				}
			}
			
			// this separates the string into blocks of five charactes
			int counter = 0;
			for (int i = 0; i < returnStringNoSpaces.length(); i++) {
				returnStringWithSpaces += returnStringNoSpaces.charAt(i);
				if ((counter + 2) % 6 == 0) {
					returnStringWithSpaces += " ";
					counter++;
				}
				counter++;
				
			}

			// if last character is a space then remove it
			if (returnStringWithSpaces.length() % 6 == 0) {
				returnStringWithSpaces = returnStringWithSpaces.substring(0,  returnStringWithSpaces.length() - 1);
			}
			return returnStringWithSpaces;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration


			// same logic to decode. just copied and pasted beginning of previous code here
			String returnStringNoSpaces = "";
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
					returnStringNoSpaces += (char)(26 - (string.charAt(i) - 'a' + 1) + 'a');
				}else if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
					returnStringNoSpaces += string.charAt(i);
				}
			}
			return returnStringNoSpaces;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		String[] nums;
		int sum = 0;
		String s = "";

		// iterate through input string and add only the numbers separated by commas to a string s
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
				s += string.charAt(i);
				s += ",";
			}else if (string.charAt(i) == '-' || string.charAt(i) == 'X'){

				// if anything illegal in isbn string then return false
			}else {
				return false;
			}
		}

		// since all digits in string then parse and keep a running total of the sum and see if divisible by 11
		nums = s.split(",");
		if (nums.length == 10) {
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(nums[i]) * (10 - i);
			}
			return ((sum % 11) == 0);

			// if length is 9 and still legal then last character is an 'X', so add 10 to total
		}else if (nums.length == 9 && string.charAt(string.length() - 1) == 'X') {
			for (int i = 0; i < 9; i++) {
				sum += Integer.parseInt(nums[i]) * (10 - i);
			}
			sum += 10;

			// check to see if divisible by 11
			return ((sum % 11) == 0);
			
		}else {
			return false;
		}
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration

		// make all characters lowercase
		string = string.toLowerCase();

		// since sets only contain unique values if only letters in set and cardinality of the set is 26
		// then all letters must have been used
		Set<Character> s = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
				s.add(string.charAt(i));
			}
		}

		if (s.size() == 26) {
			return true;
		}
		
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 10^9 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration


		// since years don't have consistent 365 days in them (because of leap years) and months have different
		// days. I found it easier just to find number of days as they are consistent, then number of hours, minutes,
		// and seconds
		int days = 1000000000/(3600 * 24);
		int secondsLeftOver = 1000000000 % (3600 * 24);
		int hours = secondsLeftOver / 3600;
		int secondsLeft = secondsLeftOver % 3600;
		int minutes = secondsLeft/60;
		int seconds = secondsLeft % 60;

		// adjust the given temporal by the amount of days, hours, minutes, and seconds that 1,000,000,000 seconds
		// corresponds to.
		try {
			given = given.plus(days, ChronoUnit.DAYS);
			given = given.plus(hours, ChronoUnit.HOURS);
			given = given.plus(minutes, ChronoUnit.MINUTES);
			given = given.plus(seconds, ChronoUnit.SECONDS);

			// some temporals only have the date not the time so since the days have already been added to given,
			// because in the try block it didn't catch an exception until given = given.plus(hours.ChronoUnit.HOURS)
			// from that point we can extract the new year, month, and day and parse them to integers to create
			// a new temporal t and add the hours, minutes and seconds
		}catch(Exception e) {
			String s = given.toString();
			String y = s.substring(0,  4);
			int ye = Integer.parseInt(y);
			String m = s.substring(5, 7);
			int mo = Integer.parseInt(m);
			String d = s.substring(8, 10);
			int da = Integer.parseInt(d);
			Temporal t = LocalDateTime.of(ye,  mo,  da,  hours,  minutes,  seconds);
			return t;
			
			
			
		}
		
		return given;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration

		Set<Integer> s = new TreeSet<>();
		int sum = 0;

		// iterate through the input array
		for(int j = 0; j < set.length; j++) {

			// while iterating through the array, iterate through the natural numbers and take multiples of the 
			// input array until taking the next multiple would be greater than the given input number
			for (int k = 1; k * set[j] < i; k++) {
				s.add(k * set[j]);
			}
		}
		
		// iterate through all the numbers we took and sum them up
		for (int j : s) {
			sum += j;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration

		// take all the spaces out of the input string and put the blocks into an array
		String[] noSpaces = string.split("\\s+");
		String ns = "";
		long digit;
		long sum = 0;

		// iterate through all the blocks and append them to the initially empty string
		for (int i = 0; i < noSpaces.length; i++) {
			ns += noSpaces[i];
		}
	
		// this could be a very long number so parse as a long
		try {
			long l = Long.parseLong(ns);
			
			// iterate through the string representation of the number as it will be the same length
			// i starts at 1 so it starts with an odd number so this won't get doubled
			// doubling will start when i = 2 as the if block indicates
			for (int i = 1; i <= ns.length(); i++) {
				digit = l % 10;
				if ((i % 2) == 0) {
					digit = digit * 2;
					if (digit > 9) {
						digit -= 9;
					}
				}

				// keep a running total of the sum of each number
				sum += digit;
				l = l/10;
			}
			
			// if the sum is divisible by 10 return true
			if (sum % 10 == 0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

		// split input string into string array where each token is separated by whitespace
		String[] s = string.split("\\s+");

		// extracts the last question mark from the string
		s[s.length - 1] = s[s.length - 1].substring(0, s[s.length - 1].length() - 1);

		// the third and fifth elements in the array should by the two numbers we are operating on so parse them
		// if the operation is plus or minus
		try {
			int num1 = Integer.parseInt(s[2]);
			int num2 = Integer.parseInt(s[4]);

			// now we have the numbers lets find out what operation to perform
			if (s[3].equals("plus")) {
				return num1 + num2;
			}else if (s[3].equals("minus")) {
				return num1 - num2;
			}

			// if we get to the catch block then the fifth element wasn't a number. this means that the sixth element is
			// so parse them
		}catch(Exception ex) {
			try {
				int num1 = Integer.parseInt(s[2]);
				int num2 = Integer.parseInt(s[5]);

				// now we have the numbers lets find out what operation to perform
				if (s[3].equals("multiplied")) {
					return num1 * num2;
				}else if (s[3].equals("divided")) {
					return num1 / num2;
				}
			}catch(Exception e) {
				ex.getMessage();
				return 0;
			}
		}
		return 0;
	}

}

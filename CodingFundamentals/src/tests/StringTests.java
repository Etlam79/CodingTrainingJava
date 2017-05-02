package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static strings.ReverseString.reverse;
import static strings.RotateMatrix.rotate;
import static strings.RotateMatrix.rotateInPlace;
import static strings.StringCompression.compress;
import static strings.TransformMatrix.tansform;
import static strings.UniqueCharacterCheck.hasUniqueCharacters;
import static strings.UniqueCharacterCheck.hasUniqueCharactersNoBuffer;

import org.junit.Test;

import strings.FindSubstring;

public class StringTests {

	
	@Test
	public void testMissingSubstring() {
		
		assertEquals(4,FindSubstring.findMissingSubstring("1235678"));
		assertEquals(627,FindSubstring.findMissingSubstring("625626628"));
		assertEquals(999,FindSubstring.findMissingSubstring("9979981000"));
		assertEquals(626,FindSubstring.findMissingSubstring("624625627"));
		

		
	}
	
	@Test
	public void testHasUniqueCharacters() {		
		assertTrue(hasUniqueCharacters("a"));
		assertTrue(hasUniqueCharacters("ab"));
		assertFalse(hasUniqueCharacters("aa"));
		assertFalse(hasUniqueCharacters("aab"));		
		assertTrue(hasUniqueCharacters("qwertzuiopüäölkjhgfdsayxcvbnmQWERTZUIOPÜÄÖLKJHGFDSAYXCVBNM1234567890"));	
	}
	
	@Test
	public void testHasUniqueCharactersNoBuffer() {		
		assertTrue(hasUniqueCharactersNoBuffer("a"));
		assertTrue(hasUniqueCharactersNoBuffer("ab"));
		assertFalse(hasUniqueCharactersNoBuffer("aa"));
		assertFalse(hasUniqueCharactersNoBuffer("aab"));
		assertFalse(hasUniqueCharactersNoBuffer("aba"));
		assertTrue(hasUniqueCharactersNoBuffer("qwertzuiopüäölkjhgfdsayxcvbnmQWERTZUIOPÜÄÖLKJHGFDSAYXCVBNM1234567890"));
	}

	@Test
	public void testReverseString() {
		assertEquals("ba", reverse("ab"));		
		assertEquals("baba", reverse("abab"));
		assertEquals("aba", reverse("aba"));
		assertEquals("bab", reverse("bab"));
		assertEquals("abba", reverse("abba"));
		assertEquals("bbbba", reverse("abbbb"));		
	}
	
	@Test
	public void testStringCompress() {
		assertEquals("a", compress("a"));
		assertEquals("aa", compress("aa"));
		assertEquals("a3", compress("aaa"));
		assertEquals("abdf", compress("abdf"));
		assertEquals("abbff", compress("abbff"));
		assertEquals("a1b3f3", compress("abbbfff"));
	}
	
	@Test
	public void testRotateMatrix() { {
		assertEquals(new byte[][]{{0,1},{1,0}}, 
					rotate(new byte[][]{{1,0}, {0, 1}}));
		
		
		byte[][] a = new byte[][] {{101, 111, 010},
				                   {111, 110, 111},
				                   {001, 000, 101}};
		
		
		byte[][] b = new byte[][] {{001, 111, 101},
								   {000, 110, 111},
								   {101, 111, 010}};
		
		assertEquals(b, rotate(a));
		
		
		
		}
	}
	

	@Test
	public void testTransformMatrix() {
		int[][] m = { {1, 2, 3, 6, 5},
					  {1, 0, 3, 6, 5},
					  {1, 2, 3, 6, 5},
					  {1, 2, 0, 6, 5},
					  {1, 2, 3, 6, 5}
		};
		
		tansform(m);
	}
	
	
	@Test
	public void testRotateMatrixInPlace() { 
		assertEquals(new byte[][]{{0,1},{1,0}}, 
				rotateInPlace(new byte[][]{{1,0}, {0, 1}}));
		
		
		byte[][] a = new byte[][] {{7, 4, 1},
				                   {8, 5, 2},
				                   {9, 6, 3}};
		
		
		byte[][] b = new byte[][] {{1, 2, 3},
								   {4, 5, 6},
								   {7, 8, 9}};

		assertEquals(a, rotateInPlace(b));
		
		
		
		
	}
}

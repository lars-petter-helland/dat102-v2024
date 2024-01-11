package dat102.f02.comparable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {
		
		Student stud345 = new Student(345, "Anne");
		Student stud123 = new Student(123, "Knut");
		
		assertTrue(stud345.compareTo(stud123) > 0);
		assertTrue(stud123.compareTo(stud345) < 0);
		assertTrue(stud123.compareTo(stud123) == 0);
		
		assertFalse(stud345.equals(stud123));
		assertTrue(stud345.equals(stud345));
		
	}

}

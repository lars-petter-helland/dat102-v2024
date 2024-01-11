package dat102.f02.comparable;

import java.util.Objects;

public class Student {
	
	private int studentnr;
	private String navn;
	
	public Student(int studentnr, String navn) {
		this.studentnr = studentnr;
		this.navn = navn;
	}
	
	
	
	/*
	 * Bør/skal samsvare med compareTo
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentnr == other.studentnr;
	}

	/*
	 * Bør/skal samsvare med equals
	 */
	@Override
	public int hashCode() {
		return Objects.hash(studentnr);
	}
	
	public int getStudentnr() {
		return studentnr;
	}
	
	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "[studentnr=" + studentnr + ", navn=" + navn + "]";
	}
}

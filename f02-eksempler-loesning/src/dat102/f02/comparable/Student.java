package dat102.f02.comparable;

import java.util.Objects;

public class Student implements Comparable<Student> {
	
	private int studentnr;
	private String navn;
	
	public Student(int studentnr, String navn) {
		this.studentnr = studentnr;
		this.navn = navn;
	}
	
	@Override
	public int compareTo(Student other) {
		return this.studentnr - other.studentnr;
	}
	
	/* equals() bør/skal alltid samsvare med compareTo() */
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

	/* hashCode() bør/skal alltid samsvare med equals() */
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

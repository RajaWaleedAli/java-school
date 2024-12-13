package PersonTest;

public final class PersonTest2 {
	private PersonTest2() {
	}

	public static void main(final String[] args) {
		final Person p1 = new Person("Willi", "Weg 3");
		final Person p1Clone = p1.clone();

		System.out.println("Testing clone() for Person:");
		System.out.println("Original Person: " + p1);
		System.out.println("Cloned Person: " + p1Clone);
		System.out.println("Are they equal? " + p1.equals(p1Clone));
		System.out.println("Are they the same object? " + (p1 == p1Clone));
		System.out.println();

		final Student s1 = new Student("Maja", "Allee 2", 521);
		final Student s1Clone = s1.clone();

		System.out.println("Testing clone() for Student:");
		System.out.println("Original Student: " + s1);
		System.out.println("Cloned Student: " + s1Clone);
		System.out.println("Are they equal? " + s1.equals(s1Clone));
		System.out.println("Are they the same object? " + (s1 == s1Clone));
		System.out.println();

		// Modifying the clone to ensure the original object remains unaffected
		s1Clone.changeCode(999);
		System.out.println("After changing code in cloned Student:");
		System.out.println("Original Student: " + s1);
		System.out.println("Cloned Student (with modified code): " + s1Clone);
	}
}

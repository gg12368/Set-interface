import java.util.HashSet;

class Student {
	String id;
	String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return id + ":" + name;
	}
}

public class TestDemo {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		Student stu1 = new Student("1", "Bob");
		Student stu2 = new Student("2", "Lily");
		Student stu3 = new Student("2", "Lily");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}

自然排序要求向TreeSet集合中存储的元素所在类必须实现Comparable接口，
并重写compareTo()方法，然后TreeSet集合就会对该类型元素使用compareTo()方法进行比较，并默认进行升序排序。

import java.util.TreeSet;

class Teacher implements Comparable {
	String name;
	int age;

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}

	// 重写CompareTo接口的compareTo()方法
	public int compareTo(Object obj) {
		Teacher s = (Teacher) obj;
		// 定义比较方式，先比较年龄age，再比较name
		if (this.age - s.age > 0) {
			return 1;
		}
		if (this.age - s.age == 0) {
			return this.name.compareTo(s.name);
		}
		return -1;
	}
}

public class TestDemo {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Teacher("Bob", 19));
		ts.add(new Teacher("Lily", 18));
		ts.add(new Teacher("Tom", 19));
		ts.add(new Teacher("Lily", 18));
		System.out.println(ts);
	}
}

解释：Teacher类实现了Comparable接口，并重写了compareTo()方法。
在coppareTo()方法中，首先针对age值进行比较，根据比较结果返回-1和1，当age相同时，再对name进行比较。
TreeSet集合会将重复的元素去掉。

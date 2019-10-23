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

	// 重写hashCode方法
	public int hashCode() {
		return id.hashCode();// 返回id属性的哈希值
	}

	// 重写equals方法
	public boolean equals(Object obj) {
		if (this == obj) { // 判断是否是同一个对象
			return true; // 如果是，直接返回true
		}
		if (!(obj instanceof Student)) { // 判断对象是否是Studeng类型
			return false; // 如果对象不是Student类型，返回false
		}
		Student stu = (Student) obj; // 将对象强转为Student类型
		boolean b = this.id.contentEquals(stu.id);// 判断id值是否相同
		return b;// 返回判断结果
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
}
上一个实例中，运行结果出现了两个相同的学生信息“1：Lily”，这样的学生信息应该被视为重复元素，不允许同时出现在HashSet集合中？
之所以没有去掉重复元素是因为在定义Student类时没有重写hashCode()和equals()方法，
因此创建的这两个学生对象stu2和stu3所引用的对象地址不同，所以HashSet集合会认为这是两个不同的对象。

本次示例，解释：
Student类重写了Object类的hashCode()和equals()方法。
在hashCode()方法中返回id属性的哈希值，在equals()方法中比较对象的id值是否相等，并返回结果。
当调用HashSet集合的add()方法添加stu3对象时，发现它的哈希值与stu2对象相同，
而且stu2.equals(stu3)返回true，HashSet集合认为两个对象相同，因此重复的Student对象被舍弃。


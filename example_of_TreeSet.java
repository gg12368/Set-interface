import java.util.TreeSet;

public class TestDemo {
	public static void main(String[] args) {
		// 创建Set集合
		TreeSet ts = new TreeSet();
		// 1.向TreeSet集合中添加元素
		ts.add(3);
		ts.add(9);
		ts.add(2);
		ts.add(20);
		System.out.println("创建的TreeSet集合为：" + ts);

		// 2.获取首尾元素
		System.out.println("TreeSet集合首元素为：" + ts.first());
		System.out.println("TreeSet集合尾元素为：" + ts.last());

		// 3.比较并获取元素
		System.out.println("集合中小于或等于9的最大的一个元素为：" + ts.floor(9));
		System.out.println("集合中大于10的最小的一个元素为：" + ts.higher(10));
		System.out.println("集合中大于100的最小的一个元素为：" + ts.higher(100));

		// 删除元素
		Object first = ts.pollFirst();
		System.out.println("删除的第一个元素是：" + first);
		System.out.println("删除第一个元素后TreeSet集合变为" + ts);
	}
}

这些元素都能按照一定的顺序排列，原因是每次向TreeSet集合中存入一个元素时，就会将该元素与其它元素进行比较，最后将它插入到有序的对象序列中。
集合中的元素在进行比较时，都会调用CompareTo()方法，
该方法是Compararble接口中定义的，因此要想对集合中的元素进行排序，就必须实现Comparable接口。
Java中大部分的类都实现了Comparable接口，并默认实现了接口中的CompareTo()方法，如：Integer、Double、String。
在实际开发中，除了会向TreeSet集合中存储一些Java中默认的类型数据外，还会存储一些用户自定义的类型数据，如Student类型数据等。
由于这些自定义类型的数据没有实现Comparable接口，因此也就无法直接在TreeSet集合中进行排序操作。为了解决这个问题，Java提供了两种TreeSet排序规则，分别为：自然排序和定制排序。


有时候，用户自定义的类型数据所在的类没有实现Comparable接口或者对于实现了Comparable接口的类不想按照定义的compareTo()方法进行排序。例如希望存储在TreeSet集合中的字符串可以按照长度而不是英文字母的顺序来进行排序，这时，可以通过在创建TreeSet集合时就自定义一个比较器来对元素进行定制排序。

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator {
	public int compare(Object obj1, Object obj2) {// 定制排序方式
		String s1 = (String) obj1;
		String s2 = (String) obj2;
		int temp = s1.length() - s2.length();
		return temp;
	}
}

public class TestDemo {
	public static void main(String[] args) {
		// 1.创建集合时，传入Comparator接口实现定制排序规则
		TreeSet ts = new TreeSet(new MyComparator());
		ts.add("Bob");
		ts.add("Lily");
		ts.add("Tomee");
		System.out.println(ts);
		// 2.创建集合时，使用Lambda表达式定制排序规则
		TreeSet ts2 = new TreeSet((obj1, obj2) -> {
			String s1 = (String) obj1;
			String s2 = (String) obj2;
			return s1.length() - s2.length();
		});
		ts2.add("Bob");
		ts2.add("Lily");
		ts2.add("Tomee");
		System.out.println(ts2);
	}


解释：
    上例中，使用TreeSet集合的public TreeSet(Comparator<? super E>comparator)有参构造方法，
分别传入Comparable接口实现MyComparator以及Lambda表达式两种参数方式创建了定制排序规则的TreeSet集合，
当向集合中添加元素时，TreeSet集合就会按照定制的排序规则进行比较，从而使存入TreeSet集合中的字符串按照长度进行排序。
    注意：在使用TreeSet集合存储数据时，TreeSet集合会对存入元素进行比较排序，
    所以为了保证程序的正常运行，一定要保证存入TreeSet集合中的元素是同一种数据类型。

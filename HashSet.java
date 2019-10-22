import java.util.HashSet;

public class TestDemo {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("001");
		set.add("002");
		set.add("003");
		set.add("003");
		System.out.println(set);
	}
}
    HashSet是Set接口的一个实现类，它所存储的元素是不可重复的，并且元素都是无序的。
    当向HashSet集合中添加一个元素时，
首先会调用该元素的hashCode()方法来确定元素的存储位置，
然后再调用该元素对象的equals()方法来确保该位置没有重复元素。

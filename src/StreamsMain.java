import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// regular();
		// streamFilter();
		// streamFilter1();
		// stream2();
		// streamMap();
		// streamSort();
		// streamAdd();
		// collect();
		example();
	}

	/*
	 * In streams concept there are 3 steps involved 1. Collections (Need arrays,
	 * array lists or lists) 2. Intermediate operation (from below coding filter is
	 * the intermediate operation ) 3. Terminal Operation (from below coding count
	 * is the Terminal operation )
	 * 
	 * with out terminal operation we cann't get the output if the intermediate
	 * operation is fail then no use of terminal operation
	 * 
	 * Collections will check one after one but the streams will check parallel
	 * ForEach will check all
	 */

	// Normal way we how can we get the names start with letter M
	public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Nagaraju");
		names.add("Mahesh");
		names.add("Varun");
		names.add("Bhanu");
		names.add("Devansh");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("M")) {
				count++;
			}
			System.out.println(count);
		}
	}

	// By using stream we can find the names start with letter M by single below
	// statement
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Nagaraju");
		names.add("Mahesh");
		names.add("Varun");
		names.add("Bhanu");
		names.add("Devansh");
		Long c = names.stream().filter(s -> s.startsWith("M")).count();
		System.out.println(c);
	}

	// Instead of writing collection we can pass the values directly to stream
	public static void streamFilter1() {
		Long c = Stream.of("Nagaraju", "Mahesh", "Varun", "Bhanu", "Devansh").filter(s -> s.startsWith("M")).count();
		System.out.println(c);
	}

	// Print the names with more than 4 letters
	public static void stream2() {
		Stream.of("Nagaraju", "Mahesh", "Varun", "Bhanu", "Devansh").filter(s -> s.length() > 4)
				.forEach(s -> System.out.println(s));

		// To get the only one name i.e, 1st name
		Stream.of("Nagaraju", "Mahesh", "Varun", "Bhanu", "Devansh").filter(s -> s.length() > 4).limit(1)
				.forEach(s -> System.out.println(s));
	}

	// To get the name ends with h letter with capital letters and also to get the text
	public static void streamMap() {
		Stream.of("Nagaraju", "Mahesh", "Varun", "Bhanu", "Devansh").filter(s -> s.endsWith("h"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	}

	// Print the names which have first letter as N with upper case and sorted
	public static void streamSort() {
		List<String> names = Arrays.asList("Nagaraju", "Mahesh", "Varun", "Bhanu", "Ndevansh");
		names.stream().filter(s -> s.startsWith("N")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	// Merging to different lists and also finding the list contain match item what
	// we provided
	public static void streamAdd() {
		// define two array lists
		List<String> kalluri = Arrays.asList("Nagaraju", "Mahesh", "Varun", "Bhanu");
		List<String> sakhamuri = Arrays.asList("Nagaraju", "Aparna", "Devansh");
		// Stream<String> newStream =Stream.concat(kalluri.stream(),khamuri.stream());
		// newStream.sorted().forEach(s->System.out.println(s));

		// If need to print the result as boolean if the name mahesh is present
		Stream<String> newStream = Stream.concat(kalluri.stream(), sakhamuri.stream());
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Mahesh"));
		// anyMatch method will return boolean value
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	// Need to change in collections and to get the out put in collection there is a
	// method called Collect
	public static void collect() {
		List<String> li = Stream.of("Nagaraju", "Mahesh", "Varun", "Bhanu").filter(s -> s.startsWith("M"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(li.get(0));
	}
	
	
	// Example:				distinct method return unique numbers
	public static void example()
	{
	 List<Integer>  values = Arrays.asList(3,2,2,7,5,1,9,7);
	 // print the unique number from the array
	 // sort the array
	 //values.stream().distinct().forEach(s->System.out.println(s));			// output: 1,2,3,5,7,9 
	  List<Integer>  lis =values.stream().distinct().sorted().collect(Collectors.toList());
	 System.out.print(lis.get(2));
	}
}

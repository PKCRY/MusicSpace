import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
 
class Person
{
    String name;
    String group;
    int score;
    
	public Person() {
		this(" ", " ",0);
	}

 
	Person(String name, String grade, Integer marks)
    {
        this.name = name;
        this.group = grade;
        this.score = marks;
    }
 
    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getScore() { return score; }
 
    @Override
    public String toString() { return getName(); }
}
 
class Main
{
    public static void main(String[] args)
    {
     
		Scanner in = new Scanner(System.in);
		System.out.println("Number of people to input:");
		Scanner z = new Scanner(System.in);
		int n = in.nextInt();
				
		ArrayList<Person> student = new ArrayList<Person>();
	    for(int m = 0; m < n ; m++) {
	    	System.out.println("Input name, group, score:");
			Person per = new Person();
				per.name = in.next();
				per.group = in.next();
				per.score = in.nextInt();
	    	student.add(per);
	    }
	    
	    Map<String, Double> memberScore = student.stream()
	    		// .sorted(Collections.reverseOrder(Person::getScore))
                .collect(Collectors.groupingBy(Person::getGroup,
                Collectors.averagingInt(Person::getScore)));
	  
	    /* for showing names or if you want to show more add more getters from toString
	    for(Person num : student) {
		System.out.println((student.toString()));
		}
		*/
        for (Map.Entry<String, Double> entry: memberScore.entrySet()) {
            System.out.println("Members with group " + entry.getKey() +
            " have average score of " + entry.getValue());
        }
    }
}

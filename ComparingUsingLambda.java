import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student1 {
	String firstName;
	String lastName;
	Integer rollNo;
	String city;

	Student1(Integer rollNo, String firstName, String lastName, String city) {
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNo = rollNo;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "\n[" + this.rollNo + "," + this.firstName + "," + this.lastName + "," + this.city + "]";
	}

}

public class ComparingUsingLambda {
		public static void main(String[] args) {
			List<Student1> studentsList  = new ArrayList<>();
			
			studentsList.add(new Student1(6,"Arman", "Chopra", "Mumbai"));
			studentsList.add(new Student1(2,"Kamlesh", "Sharma", "Delhi"));
			studentsList.add(new Student1(3,"Titu", "Yaadav", "Banglore"));
			studentsList.add(new Student1(5,"Ricky", "Kamte", "Gurgaon"));
			studentsList.add(new Student1(4,"Vicky", "Hedge", "Chennai"));
			studentsList.add(new Student1(8,"Sao", "Subbu", "Noida"));
			studentsList.add(new Student1(7,"Karan", "Kumar", "Siachin"));
			studentsList.add(new Student1(1,"Vikas", "Gupta", "Lucknow"));
			studentsList.add(new Student1(9,"Dhruv", "Bissi", "Nagpur"));
			studentsList.add(new Student1(10,"Ramesh", "Ramachandran", "Hyderabdad"));
			System.out.println("Before Sorting");
			System.out.println(studentsList);
			System.out.println("After Sorting on basis of FirstName");
			studentsList.sort(Comparator.comparing(s->s.getFirstName()));
			System.out.println(studentsList);
			System.out.println("Now Reversing it...");
			Comparator<Student1> comparator = Comparator.comparing(s->s.getFirstName()); //just to get comparator 
			studentsList.sort(comparator.reversed());
			System.out.println(studentsList);			
			System.out.println("Again sorting");
			studentsList.sort(Comparator.comparing(Student1::getFirstName));
			System.out.println(studentsList);
			System.out.println("Now sorting by last name ");
			studentsList.sort(Comparator.comparing(Student1::getLastName));
			System.out.println(studentsList);
			System.out.println("Now sorting first by firstname and then by LastName");
			studentsList.sort(Comparator.comparing(Student1::getFirstName).thenComparing(Student1::getLastName));
			System.out.println(studentsList);
			System.out.println("Let's now check some Prallel Sorting..");
			Student1[] studentsArray = studentsList.toArray(new Student1[studentsList.size()]);
			Comparator<Student1> groupByComparator =Comparator.comparing(Student1::getFirstName).thenComparing(Student1::getLastName); 
			Arrays.parallelSort(studentsArray,groupByComparator);
			System.out.println(studentsList);
			
	}}

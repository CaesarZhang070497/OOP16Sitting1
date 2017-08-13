import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UG1Student extends Student{
	private char mainSchedule;

	public UG1Student(String name, String uun,char mainSchedule) {
		super(name, uun, 1);
		this.mainSchedule = mainSchedule;
	}
	
	public UG1Student() {
		this("not set","not set", 'X');
	}
	
	public boolean addCourse(Course course){
	 
		if(course.getLevel() == 7||course.getLevel() ==8){
			return super.addCourse(course);
		}
			return false;
	}
	
	public boolean addCourses(Course[] courses){
		boolean result = true;
		for (Course course:courses){
			boolean output = addCourse(course);
			result = result&&output;
		}
		return result;
	}
	
	public String toString(){
		String output = super.toString()+"\n";
		output += "Main schedule "+ mainSchedule +" courses:"+"\n";
		Course[] a = super.getCourses();
		for(Course course:a){
			output += course.getName()+"\n";
		}
		return output;
	}
	
	public static Set<Integer> sums(ArrayList<Integer> beads,int n){
		Integer[] beadss =  beads.toArray(new Integer[beads.size()]);
		
		
		Set<Integer> list = new HashSet<Integer>();
		
		for(int i = 0 ;i<beadss.length;i++){
			int sum = 0;
			for(int j = 0;j<n;j++){
				sum += beadss[(i+j)%beads.size()];
			}
		  list.add(sum);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> beads = new ArrayList<Integer>();
		beads.add(1);
		beads.add(1);
		beads.add(1);
//		beads.add(2);
//		beads.add(3);
//		beads.add(4);
		System.out.println(sums(beads,0));
	}
}

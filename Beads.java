import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Beads {
	
	public static Set<Integer> sums(ArrayList<Integer> beads,int n){
		
		Integer[] beadss =  beads.toArray(new Integer[beads.size()]);
		
		
		
		Set<Integer> list = new HashSet<Integer>();
		
		if(n == 0){
			return list;
		}
		for(int i = 0 ;i<beadss.length;i++){
			int sum = 0;
			for(int j = 0;j<n;j++){
				sum += beadss[(i+j)%beads.size()];
			}
		  list.add(sum);
		}
		return list;
	}
	
	public static Set<Integer> allSums(ArrayList<Integer> a){
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0;i<=a.size();i++){
			result.addAll(sums(a,i));
		}
		return result;
	}
	
	public static int findMax(Set<Integer> set){
		int index = 1;
		while(set.contains(index)){
			index++;
		}
		
		return index-1;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> beads = new ArrayList<Integer>();
//		
		for(int i = 0;i<args.length;i++){
			beads.add(Integer.parseInt(args[i]));
		}
		
		int max = findMax(allSums(beads));
		
	
		System.out.println(max);
	}
}

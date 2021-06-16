
public class BSearch {
	
	static int middle; // current search candidate
	

	public static void main(String[] args) {	
		double[] nums = {5.6, 5.8, 6.3, 6.3, 6.8, 7.2}; 
		System.out.println(binSearch(nums,7.2)); 

	}

	public static int binSearch (double[] list, double item){
		int bottom = 0; // lower bound of searching
		int top = list.length - 1; // upper bound of searching
		
		int btcopy = bottom;
		int tpCopy = top;
		
		boolean found = false;
		int location = -1; // location of item, -1 for failure

		while (bottom <= top && !found){
			middle = (bottom + top)/2; // integer division, auto-truncate
			if (list[middle] == item){
				location = middle; // success!
				found = true;
			}else if (list[middle] < item){
				bottom = middle + 1; // look only in top half			
				
			}
			else if (list[middle] > item){
				top = middle - 1; // look only in bottom half

			}
		}

		if(location == -1){
			if(item > list[tpCopy]){
				location = tpCopy;

			}else if(item < list[btcopy]){
				location = btcopy;
			}
			else if(item < list[middle]){
				if(item - list[middle] >= list[middle-1] - item){
					location = middle - 1;

				}else{
					location = middle;

				}
			}
			else{
				if(item - list[middle] >= list[middle+1] - item){
					location = middle + 1;

				}else{
					location = middle;

				}
			}
		}

		return location;
	}
}

package Java;

public class NestedForEx {

	public static void main(String[] args) {
		
		for(int i=1;i<=10;i++) {
			for(int j = 1;j<=10;j++) {
				if(j==5) {
					continue;
				}
				System.out.println("i value is:" + i +", "+ "j value is:" + j);
			}
		}

	}

}

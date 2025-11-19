package MovieTicketBooking;
import java.util.*; 

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n--MOVIE TICKET BOOKING--"); 
			System.out.println("CHOICE 1 - Manage Users\n"); 
			System.out.println("CHOICE 2 - Manage Movies\n"); 
			System.out.println("CHOICE 3 - Manage Theatres\n"); 
			System.out.println("Enter Your Choice\n"); 
			int choice = sc.nextInt(); 
			switch(choice) {
			case 1:
				System.out.println("A) Add a user\n"); 
				System.out.println("B) Display all the  users\n"); 
				System.out.println("C) Update a user\n"); 
				System.out.println("D) Remove a user\n"); 
				System.out.println("Enter your choice now\n"); 
				int option = sc.next().charAt(0); 
				switch(option) {
				case 'A':
					System.out.println("Enter first name of the user:"); 
					String fn = sc.nextLine(); 
					System.out.println("Enter last name of the user"); 
					String ln = sc.nextLine(); 
					System.out.println("Enter email"); 
					String email = sc.nextLine(); 
					System.out.println("Enter phonenumber"); 
					long phnno = sc.nextLong(); 
					sc.nextLine(); 
					System.out.println("Enter password"); 
					String pw = sc.nextLine(); 
					break; 
				}
				
				
			}
			
		}
		
		// TODO Auto-generated method stub

	}

}

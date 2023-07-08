package implementstack.array;

public class Main {

	public static void main(String[] args) {

		Stack st = new Stack(6);

		st.push1(12);
		st.push1(13);
		st.push1(15);
		st.push2(156);
		st.push2(145);
		st.push2(23);
		
		System.out.println("STACK1: " + st.displayStack1()); 

		System.out.println("STACK2: " + st.displayStack2()); 
		
		st.pop1();
		
		System.out.println("STACK1: " + st.displayStack1()); 

		System.out.println("STACK2: " + st.displayStack2()); 
	}
}

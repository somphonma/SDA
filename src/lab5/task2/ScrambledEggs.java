package lab5.task2;

//public class lab5.task2.ScrambledEggs {
//	public void crackEggs(int num) {
//		System.out.println("Cracking " + num + " eggs");
//	}
//
//	public void stirEggs() {
//		System.out.println("Stirring and adding milk to the eggs");
//	}
//
//	public void cooking() {
//		System.out.println("Scrambling the eggs.");
//	}
//
//	public void serve() {
//		System.out.println("Placing the eggs on the plate.");
//	}
//
//}
public class ScrambledEggs extends AbstractBreakfast{
	public void prepareEggs(){
		System.out.println(("Stirring and adding milk to the eggs"));
	}
	public void cook(){
		System.out.println("Scrambling the eggs.");
	}
}

public class TestFlyweight {
	public static void main (String args[]) {
		String names[] = {"Ralph", "Alice", "Sam"};
		int ids[] = {1001, 1002, 1003};
		int scores[] = {45, 55, 65};
		double total = 0, averageScore = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
		}

		averageScore = total/scores.length;
		Student student = new Student(averageScore);


		for (int i = 0; i < scores.length; i++) {
			student.setName(names[i]);
			student.setId(ids[i]);
			student.setScore(scores[i]);

			System.out.println("Name: " + student.getName());
			System.out.println("Standing: "+ Math.round(student.getStanding()));
			System.out.println("");
		}
	}
}


package basic.tutorial.innerClass;

public class Parcel4 {

	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;

			private PDestination(String whereTo) {
				System.out.println("whereTo");
				label = whereTo;
			}

			public String readLabel() {
				System.out.println("label");
				return label;
			}
		}
		return new PDestination(s);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Destination d = p.destination("Tasmania");
		d.readLabel();
	}

}

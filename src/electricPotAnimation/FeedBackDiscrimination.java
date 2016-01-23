package electricPotAnimation;

public class FeedBackDiscrimination {

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

	public FeedBackDiscrimination() {
		if (cm.startToOff()) {
			System.out.println("ok");
		}
		if (cm.offToOn()) {
			System.out.println("ok");
		}
		if (cm.onToOff()) {
			System.out.println("ok");
		}
		if (cm.subStartToBoil()) {
			System.out.println("ok");
		}
		if (cm.subBoilToKeep()) {
			System.out.println("ok");
		}
		if (cm.subKeepToBoil()) {
			System.out.println("ok");
		}
		if (cm.onTrigger()) {
			System.out.println("ok");
		}
		if (cm.offTrigger()) {
			System.out.println("ok");
		}
		if (cm.subBoilTrigger()) {
			System.out.println("ok");
		}
		if (cm.subBoilButtonTrigger()) {
			System.out.println("ok");
		}
	}
}

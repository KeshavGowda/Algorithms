import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
	
	private static class App {
		String name;
		int rating;
		App(String name, int rating) {
			this.name = name;
			this.rating = rating;
		}
	}
	
	List<App> apps = new ArrayList<>();
	
	@Override
	public void putNewRating(String app, int rating) {
		// YOUR CODE HERE
		App appl = new App(app, rating);
		apps.add(appl);
	}

	@Override
	public double getAverageRating(String app) {
		// YOUR CODE HERE
		int sumRating = apps.stream().filter(a -> a.name.equals(app)).collect(Collectors.summingInt(a -> a.rating));
		int totalRating = getRatingsCount(app);
		return sumRating / (double)totalRating;
	}

	@Override
	public int getRatingsCount(String app) {
		// YOUR CODE HERE
		return (int) apps.stream().filter(a -> a.name.equals(app)).count();
	}
}
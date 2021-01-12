public interface RatingStatisticsCollector {
	// Ratings feed will call this method when new app rating information is
	// received. This is input to your class. ratings is a non negative integer
	// between 0 to 10.
	public void putNewRating(String app, int rating);

	// Report the average rating of the app.
	public double getAverageRating(String app);

	// Report the total number of rating for an app.
	public int getRatingsCount(String app);
}

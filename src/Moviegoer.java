class Moviegoer {
    private final String name;
    private final double arrivalTime;
    private final double windowTime;
    private final int movieGoerID;
    private static int counter = 0; // keeps track of total customers regardless of line joined

    public Moviegoer() {
        counter++;
        movieGoerID = counter; // may seem redundant, but it's necessary because counter may be updated before movieGoerID is referenced
        arrivalTime = FancyTimer.seconds;
        windowTime = 8 + (int)(Math.random() * 8); // randomly gives each moviegoer a random windowTime between 8 and 15 seconds
        name = "Moviegoer #" + movieGoerID + ", who takes " + windowTime + " seconds at the window,";
    }

    public String getName() {
        return name;
    }
    public double getArrivalTime() {
        return arrivalTime;
    }
    public double getWindowTime() {
        return windowTime;
    }
    public int getMovieGoerID() {
        return movieGoerID;
    }
}
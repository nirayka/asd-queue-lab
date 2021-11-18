import java.util.*;

class Theatre extends TimerTask {

    public static void main(String[] args) {
        Timer basicTimer = new Timer();
        TimerTask fancierTimer = new FancyTimer();
        Theatre myTheatre = new Theatre();

        System.out.println("Welcome to Nirayka's Theatre! The Ticket Window simulation is about to begin." +
            "\nPlease note that the line with the shortest wait time at any given moment is indicated by the" +
                " most recent customer's choice of line.\n");

        int customerArrivalFrequency = (3 + (int)(Math.random() * 4)) * 1000;   // randomly determine how often customers arrive
        basicTimer.schedule(fancierTimer, 2000, 1000); // begins after two seconds, repeats every second
        basicTimer.schedule(myTheatre, 3000, customerArrivalFrequency); // begins after three seconds, repeats every customerArrivalFrequency seconds
    }

    ArrayList<Queue<Moviegoer>> ticketLines = new ArrayList<>();

    public static Queue<Moviegoer> lineOne = new LinkedList<>();
    public static int lineOneLastID = -1;

    public static Queue<Moviegoer> lineTwo = new LinkedList<>();
    public static int lineTwoLastID = -1;

    public static Queue<Moviegoer> lineThree = new LinkedList<>();
    public static int lineThreeLastID = -1;

    public static Queue<Moviegoer> lineFour = new LinkedList<>();
    public static int lineFourLastID = -1;


    public Theatre() {
        ticketLines.add(lineOne);
        ticketLines.add(lineTwo);
        ticketLines.add(lineThree);
        ticketLines.add(lineFour);
    }

    public void run() {
        Moviegoer newMovieGoer = new Moviegoer();
        returnShortestLine().add(newMovieGoer); // adds a movieGoer to the shortest line at that moment

        // following statements determine which line the customer has been added to
        if (lineOne.peek() != null && lineOne.peek().getCustomerID() != lineOneLastID) { // 2nd statement ensures that "Moviegoer #x joined" print statement isn't repeated
            System.out.println(lineOne.peek().getName() + " has joined Line 1.");
            lineOneLastID = lineOne.peek().getCustomerID();
        }
        if (lineTwo.peek() != null && lineTwo.peek().getCustomerID() != lineTwoLastID) {
            System.out.println(lineTwo.peek().getName() + " has joined Line 2.");
            lineTwoLastID = lineTwo.peek().getCustomerID();
        }
        if (lineThree.peek() != null && lineThree.peek().getCustomerID() != lineThreeLastID) {
            System.out.println(lineThree.peek().getName() + " has joined Line 3.");
            lineThreeLastID = lineThree.peek().getCustomerID();
        }
        if (lineFour.peek() != null && lineFour.peek().getCustomerID() != lineFourLastID) {
            System.out.println(lineFour.peek().getName() + " has joined Line 4.");
            lineFourLastID = lineFour.peek().getCustomerID();
        }
    }

    public Queue<Moviegoer> returnShortestLine() {
        int shortestWaitTime = 100000000;
        Queue<Moviegoer> shortestLine = lineOne;

        for (int k = 0; k < 4; k++) {
            int  thisLinesWaitTime = 0;
            for (Moviegoer thisMovieGoer : ticketLines.get(k)) {
                thisLinesWaitTime += thisMovieGoer.getWindowTime(); // gets total waiting time for each line
            }
            if (thisLinesWaitTime < shortestWaitTime) {
                shortestWaitTime = thisLinesWaitTime; // finds shortest wait time
                shortestLine = ticketLines.get(k); // determines the line which has shortest wait time
            }
        }

        return shortestLine;
    }

}
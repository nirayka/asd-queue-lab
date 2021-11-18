import java.util.*;

class FancyTimer extends TimerTask {
    public static double seconds = 0;
    public void run() {
        if (seconds == 0) {
            System.out.println(++seconds + " second has passed.");
        } else {
            System.out.println(++seconds + " seconds have passed.");
        }

        // following statements check each line to see if someone is at the front and if it's time for someone to leave
        if (Theatre.lineOne.peek() != null && Theatre.lineOne.peek().getArrivalTime() + Theatre.lineOne.peek().getWindowTime() == seconds) {
            System.out.println(Theatre.lineOne.peek().getName() + " has finished purchasing tickets and has left Line 1.");
            Theatre.lineOne.remove();
        }

        if (Theatre.lineTwo.peek() != null && Theatre.lineTwo.peek().getArrivalTime() + Theatre.lineTwo.peek().getWindowTime() == seconds) {
            System.out.println(Theatre.lineTwo.peek().getName() + " has finished purchasing tickets and has left Line 2.");
            Theatre.lineTwo.remove();
        }

        if (Theatre.lineThree.peek() != null && Theatre.lineThree.peek().getArrivalTime() + Theatre.lineThree.peek().getWindowTime() == seconds) {
            System.out.println(Theatre.lineThree.peek().getName() + " has finished purchasing tickets and has left Line 3.");
            Theatre.lineThree.remove();
        }

        if (Theatre.lineFour.peek() != null && Theatre.lineFour.peek().getArrivalTime() + Theatre.lineFour.peek().getWindowTime() == seconds) {
            System.out.println(Theatre.lineFour.peek().getName() + " has finished purchasing tickets and has left Line 4.");
            Theatre.lineFour.remove();
        }
    }
}
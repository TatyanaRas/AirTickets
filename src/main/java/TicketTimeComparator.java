import java.util.Comparator;

//import static jdk.vm.ci.sparc.SPARC.o1;
//import static jdk.vm.ci.sparc.SPARC.o2;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        // ваш код
        int time1 = o1.getTimeTo() - o1.getTimeFrom();
        int time2 = o2.getTimeTo() - o2.getTimeFrom();

        if (time1 < time2) {
            return -1;
        } else if (time1 > time2) {
            return 1;
        } else {
            return 0;
        }
    }
}
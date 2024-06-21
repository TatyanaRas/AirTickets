//import jdk.internal.jimage.ImageStrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class AviaSoulsTest {

    @Test

    public void priceСomparison1() {
        AviaSouls ticket = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Париж", 60000, 8, 24);
        Ticket ticket2 = new Ticket("Москва", "Париж", 30000, 8, 18);
        Ticket ticket3 = new Ticket("Москва", "Париж", 43000, 10, 16);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 10000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 7000, 9, 14);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] actual = ticket.search("Москва", "Париж");
        Ticket[] expected = {ticket2, ticket3, ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void priceСomparison2() {
        AviaSouls ticket = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Генуя", 20000, 8, 24);
        Ticket ticket2 = new Ticket("Москва", "Париж", 20000, 8, 18);
        Ticket ticket3 = new Ticket("Москва", "Париж", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 20000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 20000, 9, 14);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] actual = ticket.search("Москва", "Генуя");
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void priceСomparison3() {
        AviaSouls ticket = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Париж", 20000, 8, 24);
        Ticket ticket2 = new Ticket("Москва", "Париж", 30000, 8, 18);
        Ticket ticket3 = new Ticket("Москва", "Париж", 43000, 10, 16);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 10000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 7000, 9, 14);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] actual = ticket.search("Москва", "Волгоград");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
// сортировка по времени перелета
    public void sortTicket() {
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comporator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Париж", 20000, 8, 24);//24-8=16
        Ticket ticket2 = new Ticket("Москва", "Париж", 30000, 8, 18);//18-8=10
        Ticket ticket3 = new Ticket("Москва", "Париж", 43000, 10, 16);//16-10=6
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 10000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 7000, 9, 14);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] actual = ticket.search("Москва", "Париж", comporator);
        Ticket[] expected = {ticket3, ticket2, ticket1};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void sortTicketSameTime() {//одинаковое время
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comporator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Генуя", 20000, 8, 24);
        Ticket ticket2 = new Ticket("Москва", "Париж", 30000, 8, 18);
        Ticket ticket3 = new Ticket("Москва", "Париж", 43000, 10, 16);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 10000, 8, 12);//4
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 7000, 9, 13);//4

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);


        Ticket[] actual = ticket.search("Москва", "Генуя", comporator);
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void sortTicketSameTime2() {
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comporator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Генуя", 20000, 8, 24);
        Ticket ticket2 = new Ticket("Москва", "Париж", 30000, 8, 18);
        Ticket ticket3 = new Ticket("Москва", "Париж", 43000, 10, 16);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 10000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 7000, 9, 13);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);


        Ticket[] actual = ticket.search("Москва", "Волгоград", comporator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);


    }

}



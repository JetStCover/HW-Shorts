package re.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AviaSoulsTest {
    @Test
    public void sortTicketsFromToTime() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "USA", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("MSK", "USA", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("CAN", "MSK", 700, 5, 13);

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchAndSortBy("MSK", "USA", timeComparator);
        Ticket[] expected = {ticket3, ticket2, ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsFromTo() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "USA", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "NY", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "USA", 700, 5, 13);

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MSK", "USA");
        Ticket[] expected = {ticket5, ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortAllTicketsFromTime() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "CAN", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "NY", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("CAN", "MSK", 700, 5, 13);

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket3, ticket2, ticket5, ticket1, ticket4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void findAllTickets() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "CAN", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "NY", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("CAN", "MSK", 700, 5, 13);

        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortPriceFirstMoreSecond() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "CAN", 4_000, 9, 12);


        int actual = ticket1.compareTo(ticket2);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortPriceSecondMoreFirst() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "CAN", 4_000, 9, 12);


        int actual = ticket2.compareTo(ticket1);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortPriceSecondSameFirst() {

        Ticket ticket1 = new Ticket("MSK", "USA", 4_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "CAN", 4_000, 9, 12);


        int actual = ticket2.compareTo(ticket1);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void findOneTicket() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "USA", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "NY", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "USA", 700, 5, 13);

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("NY", "MSK");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void notFoundTicket() {

        Ticket ticket1 = new Ticket("MSK", "USA", 1_000, 7, 15);
        Ticket ticket2 = new Ticket("MSK", "USA", 4_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "NY", 9_000, 3, 9);
        Ticket ticket4 = new Ticket("NY", "MSK", 900, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "USA", 700, 5, 13);

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("VOL", "JAP");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
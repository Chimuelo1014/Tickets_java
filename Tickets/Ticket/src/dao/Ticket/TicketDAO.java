package dao.Ticket;

import java.util.ArrayList;
import domain.Ticket;
public interface TicketDAO {
    void createTicket();
    Ticket getTicketById();
    ArrayList<Ticket> getAllTickets();
    ArrayList<Ticket> getTicketByUser();
    void updateTicket();
    void deleteTicket();

}

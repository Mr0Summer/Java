package helloweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import helloweb.databace.Ticketdb;

import helloweb.ticket.TicketPur;

import org.springframework.ui.ModelMap;
@Controller
public class TicketController {
	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public ModelAndView ticket(ModelMap model) throws Exception{
		model.addAttribute("ti", Ticketdb.TicketMessage());
		return new ModelAndView("ticket", "command", new TicketPur());
	}   
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String purchase(@ModelAttribute("SpringWeb")TicketPur ticket, 
	ModelMap model) throws Exception{
		
		model.addAttribute("lest", ticket.getCost());
		if(Ticketdb.TicketExist(ticket.getPlace()) == 0) {
			return "result1";
		}
		
		model.addAttribute("place", ticket.getPlace());
		model.addAttribute("cost", Ticketdb.TicketCost(ticket.getPlace()));
		
		if(Ticketdb.TicketNum(ticket.getPlace()) > 0) {
			if(Ticketdb.TicketCost(ticket.getPlace()) <= ticket.getCost()) {
				Ticketdb.TicketGet(ticket.getPlace());
				model.addAttribute("lest", (ticket.getCost()-Ticketdb.TicketCost(ticket.getPlace())));
				return "result";
			}
		}
		
		return "result1";
	}
}
package helloweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import helloweb.databace.Ticketdb;

import org.springframework.ui.ModelMap;

@Controller

public class NewController {
	@RequestMapping(value = "/Manage", method = RequestMethod.GET)
	public String printNewFile() {
		return "NewFile";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String printCreate(ModelMap model) throws Exception{
		Ticketdb.create();
		Ticketdb.addData("Beijin", 1000, 6);
		Ticketdb.addData("Shanghai", 600, 5);
		Ticketdb.addData("Guangzhou", 600, 5);
		model.addAttribute("mess", "成功创建!");
		return "home";
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) throws Exception{
		model.addAttribute("message", Ticketdb.TicketMessage1());
		return "hello";
	}
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String returnHome() {
		return "home";
	}
}

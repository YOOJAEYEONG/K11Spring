package com.kosmo.k11spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import transaction.TicketDAO;
import transaction.TicketDTO;

@Controller
public class TransactionController {

	/*
	트랜잭션 매니저를 활용한 트랜잭션 처리를 위해
	servlet-context.xml에서 미리 생성한 DAO빈을 자동 주입받는다.
	*/
	private TicketDAO dao;
	@Autowired
	public void setDao(TicketDAO dao) {
		this.dao = dao;
		System.out.println("@Autowired=>TicketDAO주입성공");
	}

	//티켓 구매페이지
	@RequestMapping("/transaction/buyTicketMain.do")
	public String buyTicketMain() {
		return "08Transaction/buyTicketMain";
	}
	
	//티켓구매처리
	@RequestMapping("/transaction/buyTicketAction.do")
	public String buyTicketAction(TicketDTO ticketDTO, Model model) {
		dao.buyTicket(ticketDTO);//커맨드객체
		model.addAttribute("ticketInfo", ticketDTO);
		return "08Transaction/buyTicketAction";
	}
}



















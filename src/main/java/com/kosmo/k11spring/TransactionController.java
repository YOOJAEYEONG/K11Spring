package com.kosmo.k11spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import transaction.TicketDAO;
import transaction.TicketDTO;
import transaction.TicketTplDAO;

@Controller
public class TransactionController {

	/************************************
	방법1. 트랜잭션 매니저를 활용한 트랜잭션 처리를 위해
	servlet-context.xml에서 미리 생성한 DAO빈을 자동 주입받는다.
	트랜잭션 템플릿과 동시에 사용할 수 없으므로 주석처리함.
	*/
	private TicketDAO dao;
	/*
	@Autowired 
	public void setDao(TicketDAO dao) { 
		this.dao = dao;
		System.out.println("@Autowired=>TicketDAO주입성공"); 
	}
	*/

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
	//////////////////////////////////////////////////////////////////////
	
	
	/********************************
	방법2. 트랜잭션 템플릿을 활용한 처리
	*/
	private TicketTplDAO daoTpl;
	
	//setvlet-context.xml에서 생성한 TicketTplDAO타입의 빈을 Autowired 받음
	@Autowired
	public void setDaoTpl(TicketTplDAO daoTpl) {
		this.daoTpl = daoTpl;
	}

	//티켓구매페이지
	@RequestMapping("/transaction/buyTicketTpl.do")
	public String buyTicketTpl() {
		return "08Transaction/buyTicketTpl";
	}
	
	//티켓구매처리를 페이지
	@RequestMapping("/transaction/buyTicketTplAction.do")
	public String buyTicketTplAction(TicketDTO ticketDTO, Model model) {
		
		//티켓 구매처리를 위한 DAO호출
		boolean isBool = daoTpl.buyTicket(ticketDTO);
		if(isBool==true) {
			model.addAttribute("successOrFail", "티켓구매가 정상 처리 되었습니다.");
		}else {
			model.addAttribute("successOrFail", "티켓구매가 취소 되었습니다.");
		}
		//뷰로 전달할 데이터 저장
		model.addAttribute("ticketInfo", ticketDTO);
		
		return "08Transaction/buyTicketTplAction";
	}
}



















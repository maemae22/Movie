package com.example.movie.service;


import com.example.movie.dto.TicketDTO;
import com.example.movie.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TicketService {

	private final TicketRepository repo;

	@Autowired
	public TicketService(TicketRepository TicketRepository) {
		this.repo = TicketRepository;
	}

	public int insertTicket(TicketDTO dto) {
		log.info("dto = {}", dto);
		int result = 0;
		try {
			result = repo.insertTicket(dto);
			System.out.println(result);
		} catch (Exception e){
			result = -1;
		}
		return result;

	}

	public TicketDTO getTicket() {
		TicketDTO ticket = repo.getTicket();
		return ticket;
	}

	public List<TicketDTO> getTicketList(String userId) {
		List<TicketDTO> list = new ArrayList<TicketDTO>();
		list = repo.getTicketList(userId);
		return list;
	}
}

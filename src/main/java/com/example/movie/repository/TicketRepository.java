package com.example.movie.repository;

import com.example.movie.dto.TicketDTO;
import com.example.movie.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

	private final TicketMapper mapper;

	@Autowired public TicketRepository(TicketMapper mapper) {
		this.mapper = mapper;
	}

	public int insertTicket(TicketDTO dto) {
		return mapper.insertTicket(dto);
	}

	public TicketDTO getTicket() {

		return mapper.getTicket();
	}

	public List<TicketDTO> getTicketList(String userId) {

		return mapper.getTicketList(userId);
	}
	
	

}

package com.example.movie.mapper;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TicketDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TicketMapper {

	public int insertTicket(TicketDTO dto);

	public int updateTicket(Long id);

	public List<MovieDTO> getMovieList();

	public MovieDTO getMovieDTO(String movieTitle);

	public TicketDTO getTicket();

	public List<TicketDTO> getTicketList(String userId);

	TicketDTO selectOrderById(Long member_id);
	ArrayList<TicketDTO> selectOrderByMember(Long member_id);
	ArrayList<TicketDTO> selectCancelOrder(Long member_id);
	int updateOrderStatus(Long id);
}

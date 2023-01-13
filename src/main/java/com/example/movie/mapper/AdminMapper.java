package com.example.movie.mapper;

import com.example.movie.admin.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    AdminDTO selectAdmin(AdminDTO adminDTO);
}

package com.hackathon.server.mappers;

import com.hackathon.server.dto.GradeDto;
import com.hackathon.server.entity.Grade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = InvestitionMapper.class)
public interface GradeMapper {

    Grade gradeDtoToGrade(GradeDto dto);

    GradeDto gradeToGradeDto(Grade entity);
}

package com.hackathon.server.mappers;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Investition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UsersMapper.class})
public interface InvestitionMapper {

    @Mappings({
            @Mapping(target = "creator.username", source = "creator")
    })
    Investition investitionDtoToInvestition(InvestitionDto dto);

    @Mappings({
            @Mapping(target = "creator", source = "entity.creator.username")
    })
    InvestitionDto investiotionToInvestitionDto(Investition entity);
}

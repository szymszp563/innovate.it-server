package com.hackathon.server.rest.response;

import com.hackathon.server.dto.InvestitionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvestitionsResponse extends BasicResponse {
    List<InvestitionDto> investitionDtos;
}

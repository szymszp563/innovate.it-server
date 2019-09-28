package com.hackathon.server.rest.response;

import com.hackathon.server.dto.InvestitionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvestitionResponse extends BasicResponse {
    InvestitionDto investitionDto;
}

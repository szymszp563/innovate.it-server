package com.hackathon.server.rest.request;

import lombok.*;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvestitionRequest {
    Optional<String> city;
    Optional<String> creator;
}

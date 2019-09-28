package com.hackathon.server.rest.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicResponse {

    private int status;
    private  String message;
    private long timeStamp;
}

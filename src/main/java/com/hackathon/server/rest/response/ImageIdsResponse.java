package com.hackathon.server.rest.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageIdsResponse extends BasicResponse {
    List<Integer> imageIds;
}

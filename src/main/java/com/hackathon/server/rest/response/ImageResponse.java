package com.hackathon.server.rest.response;

import com.hackathon.server.dto.ImageDto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageResponse extends BasicResponse {
    ImageDto imageDto;
}

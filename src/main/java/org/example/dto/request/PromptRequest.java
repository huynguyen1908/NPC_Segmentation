package org.example.dto.request;

import lombok.Data;

@Data
public class PromptRequest {
    String question;
    Integer conversationId;
    Integer imageId;
}

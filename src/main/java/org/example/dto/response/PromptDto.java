package org.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PromptDto {
    Integer id;
    String question;
    List<String> answers;
    Integer imageId;
    String imageUrl;
    Integer conversationId;
}

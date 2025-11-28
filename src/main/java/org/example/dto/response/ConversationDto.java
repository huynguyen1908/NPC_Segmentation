package org.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ConversationDto {
    private Integer id;
    private Integer userId;
    private String title;
    private List<PromptDto> prompts;
}

package org.example.service;

import org.example.dto.request.PromptRequest;
import org.example.dto.response.ApiResponse;
import org.example.dto.response.PromptDto;
import org.example.entity.Prompt;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PromptService {
    ApiResponse<Prompt> getPrompt(Integer promptId);
    ApiResponse<Prompt> createPrompt(PromptRequest prompt);
    ApiResponse<String> createResponse(PromptRequest request);
    ApiResponse<String> createResponseWithImage(String question, Integer conversationId, MultipartFile image) throws IOException;
}

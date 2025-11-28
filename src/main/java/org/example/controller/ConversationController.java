package org.example.controller;

import org.example.dto.request.PromptRequest;
import org.example.dto.response.ApiResponse;
import org.example.dto.response.ConversationDto;
import org.example.dto.response.PromptDto;
import org.example.entity.Conversation;
import org.example.entity.Prompt;
import org.example.service.ConversationService;
import org.example.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @Autowired
    private PromptService promptService;

    @GetMapping("/{id}")
    public ApiResponse<ConversationDto> getConversations(@PathVariable Integer id) {
        return conversationService.getConversation(id);
    }

    @PostMapping()
    public ApiResponse<Conversation> createConversation() {
        return conversationService.createConversation();
    }

    @PostMapping("/response")
    public ApiResponse<String> createConversationResponse(@RequestBody PromptRequest request) {
        return promptService.createResponse(request);
    }

    @GetMapping("/list")
    public ApiResponse<Object> getListConversations(Pageable pageable) {
        return conversationService.getListConversations(pageable);
    }

    @PostMapping("/response-with-image")
    public ApiResponse<String> createConversationResponseWithImage(@RequestParam String question, @RequestParam Integer conversationId
            , @RequestParam MultipartFile image) throws IOException {
        return promptService.createResponseWithImage(question,conversationId, image);
    }

}

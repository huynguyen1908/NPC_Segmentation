package org.example.service;

import org.example.dto.response.ApiResponse;
import org.example.dto.response.ConversationDto;
import org.springframework.data.domain.Pageable;
import org.example.entity.Conversation;


public interface ConversationService {
    ApiResponse<ConversationDto> getConversation(Integer conversationId);
    ApiResponse<Conversation> createConversation();
    ApiResponse<Object> getListConversations(Pageable pageable);
}

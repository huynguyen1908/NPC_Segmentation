package org.example.service.impl;

import org.example.dto.response.ApiResponse;
import org.example.dto.response.ConversationDto;
import org.example.dto.response.PageResponse;
import org.example.dto.response.PromptDto;
import org.example.entity.Conversation;
import org.example.repository.ImageRepository;
import org.springframework.data.domain.Pageable;
import org.example.mapper.ConversationMapper;
import org.example.mapper.PromptMapper;
import org.example.repository.AnswerRepository;
import org.example.repository.ConversationRepository;
import org.example.repository.PromptRepository;
import org.example.service.ConversationService;
import org.example.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private ConversationMapper conversationMapper;

    @Autowired
    private PromptService promptService;

    @Autowired
    private PromptRepository promptRepository;
    @Autowired
    private PromptMapper promptMapper;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ApiResponse<ConversationDto> getConversation(Integer id) {
        Conversation conversation = conversationRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Conversation not found")
        );
        ConversationDto conversationDto = conversationMapper.toDto(conversation);

        // getPrompts
        List<PromptDto> prompts = promptRepository.findByConversationId(id).stream().map(promptMapper::toDto).map(
                promptDto -> {
                    //get answers
                    List<String> answers = answerRepository.findResponseByPromptId(promptDto.getId());
                    promptDto.setAnswers(answers);
                    if (promptDto.getImageId() != null) {
                        String imageUrl = imageRepository.findImageUrlById(promptDto.getImageId());
                        promptDto.setImageUrl(imageUrl);
                    }
                    return promptDto;
                }
        ).toList();

        conversationDto.setPrompts(prompts);
        return new ApiResponse<>(1000, null, "Conversation retrieved successfully", conversationDto);
    }

    @Override
    public ApiResponse<Conversation> createConversation(){
        Conversation conversation = new Conversation();
        String userIdStr = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = Integer.parseInt(userIdStr);
        conversation.setUserId(userId);
        conversationRepository.save(conversation);
        return new ApiResponse<>(1000, null, "Conversation Created successfully", conversation);
    }

    @Override
    public ApiResponse<Object> getListConversations(Pageable pageable) {
        Page<Conversation> conversationPage = conversationRepository.findAll(pageable);
        return ApiResponse.builder()
                .code(1000)
                .message("Conversation list retrieved successfully")
                .data(new PageResponse<>(
                        conversationPage.getContent(),
                        conversationPage.getTotalPages(),
                        conversationPage.getTotalElements()
                ))
                .build();
    }

}

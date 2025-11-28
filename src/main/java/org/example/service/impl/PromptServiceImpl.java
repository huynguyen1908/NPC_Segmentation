package org.example.service.impl;

import jakarta.transaction.Transactional;
import org.example.dto.request.PromptRequest;
import org.example.dto.response.ApiResponse;
import org.example.dto.response.PromptDto;
import org.example.entity.Answer;
import org.example.entity.Conversation;
import org.example.entity.Image;
import org.example.entity.Prompt;
import org.example.mapper.PromptMapper;
import org.example.repository.AnswerRepository;
import org.example.repository.ConversationRepository;
import org.example.repository.ImageRepository;
import org.example.repository.PromptRepository;
import org.example.service.GeminiService;
import org.example.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class PromptServiceImpl implements PromptService {
    @Autowired
    private PromptRepository promptRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private GeminiService geminiService;

    @Autowired
    private PromptMapper promptMapper;

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ApiResponse<Prompt> getPrompt(Integer promptId){
        Prompt prompt = promptRepository.findById(promptId).orElse(null);
        if (prompt == null) {
            return ApiResponse.<Prompt>builder()
                    .code(404)
                    .message("Prompt not found")
                    .data(null)
                    .build();
        }
        return ApiResponse.<Prompt>builder()
                .code(200)
                .message("Success")
                .data(prompt)
                .build();
    }

    @Override
    public ApiResponse<Prompt> createPrompt(PromptRequest prompt){
        Prompt newPrompt = new Prompt();
        newPrompt.setQuestion(prompt.getQuestion());
        newPrompt.setConversationId(prompt.getConversationId());
        if(prompt.getImageId() != null){
            newPrompt.setImageId(prompt.getImageId());
        }
        promptRepository.save(newPrompt);
        return ApiResponse.<Prompt>builder()
                .code(201)
                .message("Prompt created successfully")
                .data(newPrompt)
                .build();
    }

    @Override
    @Transactional
    public ApiResponse<String> createResponse(PromptRequest request) {
        Prompt newPrompt = promptMapper.requestToEntity(request);
        if(!conversationRepository.existsById(request.getConversationId())) {
            Conversation conversation = new Conversation();
            String userIdStr = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Integer userId = Integer.parseInt(userIdStr);
            conversation.setUserId(userId);
            conversation.setId(request.getConversationId());
            conversationRepository.save(conversation);
            newPrompt.setConversationId(conversation.getId());
        }
        promptRepository.save(newPrompt);

        String response = geminiService.generate(request.getQuestion());
        Answer answer = new Answer();
        answer.setResponse(response);
        answer.setPromptId(newPrompt.getId());

        answerRepository.save(answer);
        return ApiResponse.<String>builder()
                .code(1000)
                .message("Response created successfully")
                .data(response)
                .build();
    }

    @Override
    @Transactional
    public ApiResponse<String> createResponseWithImage(String question, Integer conversationId, MultipartFile image) throws IOException {
        String userIdStr = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = Integer.parseInt(userIdStr);

        //conversation and prompt
        Prompt newPrompt = new Prompt();
        newPrompt.setQuestion(question);
        newPrompt.setConversationId(conversationId);

        if(!conversationRepository.existsById(conversationId)) {
            Conversation conversation = new Conversation();
            conversation.setUserId(userId);
            conversation.setId(conversationId);
            conversationRepository.save(conversation);
            newPrompt.setConversationId(conversation.getId());
        }


        byte[] imageBytes = null;
        if (image != null && !image.isEmpty()) {
            imageBytes = image.getBytes();
//            String uploadDir = "uploads";
            String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // Save image to local storage
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            String path = uploadDir + File.separator + fileName;
            image.transferTo(new File(path));

            Image newImage = new Image();
            newImage.setUrl("uploads/" + fileName);
            newImage.setUserId(userId);
            imageRepository.save(newImage);

            newPrompt.setImageId(newImage.getId());
        }

        promptRepository.save(newPrompt);

        // answer
        String response = geminiService.generateWithImage(question, imageBytes);
        Answer answer = new Answer();
        answer.setResponse(response);
        answer.setPromptId(newPrompt.getId());
        answerRepository.save(answer);

        return ApiResponse.<String>builder()
                .code(1000)
                .message("Response created successfully")
                .data(response)
                .build();
    }
}

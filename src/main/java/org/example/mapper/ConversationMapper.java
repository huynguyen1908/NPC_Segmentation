package org.example.mapper;

import org.example.dto.response.ConversationDto;
import org.example.entity.Conversation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {
    ConversationDto toDto(Conversation conversation);
}

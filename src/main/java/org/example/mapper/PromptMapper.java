package org.example.mapper;

import org.example.dto.request.PromptRequest;
import org.example.dto.response.PromptDto;
import org.example.entity.Prompt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PromptMapper {

    @Mapping(target = "id", source = "id")
    PromptDto toDto(Prompt prompt);

    Prompt toEntity(PromptDto promptDto);

    @Mapping(target = "id", ignore = true)
    Prompt requestToEntity(PromptRequest request);
}

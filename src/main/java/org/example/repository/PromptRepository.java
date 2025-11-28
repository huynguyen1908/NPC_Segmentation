package org.example.repository;

import org.example.entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Integer> {

    @Query(value = "SELECT p FROM Prompt p WHERE p.conversationId = :conversationId order by p.createdAt asc")
    List<Prompt> findByConversationId(Integer conversationId);
}

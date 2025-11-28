package org.example.repository;

import org.example.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByPromptId(Integer promptId);

    @Query(value = "SELECT a.response FROM Answer a WHERE a.promptId = :promptId order by a.createdAt asc")
    List<String> findResponseByPromptId(Integer promptId);
}

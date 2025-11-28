package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api-key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create("https://generativelanguage.googleapis.com");

    public String generate(String prompt) {

        String url = "/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;

        Map<String, Object> body = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        return webClient.post()
                .uri(url)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .map(res -> extractText(res))
                .block();
    }

    private String extractText(Map res) {
        var candidates = (java.util.List) res.get("candidates");
        var content = (Map) ((Map) candidates.get(0)).get("content");
        var parts = (java.util.List) content.get("parts");
        return (String) ((Map) parts.get(0)).get("text");
    }

    public String generateWithImage(String prompt, byte[] imageBytes) {

        String url = "/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;
        if (imageBytes == null || imageBytes.length == 0) {
            Map<String, Object> body = Map.of(
                    "contents", new Object[]{
                            Map.of("parts", new Object[]{
                                    Map.of("text", prompt)
                            })
                    }
            );

            return webClient.post()
                    .uri(url)
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .map(res -> extractText(res))
                    .block();
        } else {

            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            Map<String, Object> body = Map.of(
                    "contents", List.of(
                            Map.of("parts", List.of(
                                    Map.of("inline_data", Map.of(
                                            "mime_type", "image/jpeg",
                                            "data", base64Image
                                    )),
                                    Map.of("text", prompt)
                            ))
                    )
            );

            return webClient.post()
                    .uri(url)
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .map(this::extractTextWithImage)
                    .block();
        }
    }

    private String extractTextWithImage(Map res) {
        var candidates = (List<Map>) res.get("candidates");
        var content = (Map) candidates.get(0).get("content");
        var parts = (List<Map>) content.get("parts");
        return (String) parts.get(0).get("text");
    }
}


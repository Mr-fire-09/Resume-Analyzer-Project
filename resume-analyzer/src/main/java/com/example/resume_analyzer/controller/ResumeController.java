package com.example.resume_analyzer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class ResumeController {

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> analysis = new HashMap<>();
        if (file.isEmpty()) {
            analysis.put("error", "No file uploaded.");
            return analysis;
        }

        String content = new String(file.getBytes());

        // Example Analysis Logic
        int wordCount = content.split("\\s+").length;
        List<String> skills = Arrays.asList("Java", "Spring", "Python", "SQL", "JavaScript");
        List<String> foundSkills = new ArrayList<>();

        for (String skill : skills) {
            if (content.toLowerCase().contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }

        // Build the response
        analysis.put("wordCount", wordCount);
        analysis.put("foundSkills", foundSkills);
        analysis.put("rawContent", content);

        return analysis;
    }
}

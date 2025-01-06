package com.example.resume_analyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ResumeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadResume(MultipartFile file, Model model) {
        try {
            String content = new String(file.getBytes());
            model.addAttribute("content", content);
            return "result";
        } catch (IOException e) {
            model.addAttribute("error", "Failed to upload resume");
            return "index";
        }
    }
}
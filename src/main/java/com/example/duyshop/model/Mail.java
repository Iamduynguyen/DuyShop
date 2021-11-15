package com.example.duyshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Mail {
    private final String from = "Đồng hồ Duyshop";
    private String subject;
    private String content;
    private String toEmail;
}

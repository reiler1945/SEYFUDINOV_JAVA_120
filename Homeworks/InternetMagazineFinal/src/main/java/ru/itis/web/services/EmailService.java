package ru.itis.web.services;

public interface EmailService {
    void sendEmail(String email, String subject, String text);
}
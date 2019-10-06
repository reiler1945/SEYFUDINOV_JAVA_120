package ru.itis.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.web.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}

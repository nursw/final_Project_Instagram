package start.final_project_instagram.service;

import org.springframework.stereotype.Service;
import start.final_project_instagram.entities.User;

import java.util.List;
@Service
public interface FollowerService {
    // Поиск пользователей по имени пользователя или полному имени
    // Возвращает список найденных пользователей (может быть пустым)
    List<User> search(String usernameOrFullName);

    // Подписка пользователя на профиль
    // Возвращает профиль пользователя, на который подписались
    User subscribe(Long userId, Long profileId);

    // Получение всех подписчиков для пользователя
    // Возвращает список подписчиков пользователя (может быть пустым)
    List<User> getAllSubscribersByUserId(Long userId);

    // Получение всех подписок пользователя
    // Возвращает список пользователей, на которых подписан пользователь (может быть пустым)
    List<User> getAllSubscriptionsByUserId(Long userId);
}


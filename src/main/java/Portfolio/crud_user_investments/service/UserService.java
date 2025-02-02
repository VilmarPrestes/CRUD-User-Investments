package Portfolio.crud_user_investments.service;

import Portfolio.crud_user_investments.controller.CreateUserDto;
import Portfolio.crud_user_investments.entity.User;
import Portfolio.crud_user_investments.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(CreateUserDto createUserDto){

        // DTO -> ENTITY
        var entity = new User(UUID.randomUUID(), createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null);

        userRepository.save();
    }
}

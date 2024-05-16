package net.haxjakt.springtest.service.auth;

import lombok.AllArgsConstructor;
import net.haxjakt.springtest.repository.mongo.UserRepository;
import net.haxjakt.springtest.dto.UserResponseDTO;
import net.haxjakt.springtest.repository.entity.auth.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDTO addUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserResponseDTO getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public boolean checkUserExistance(String username, String email) {
        var usernameOpt = userRepository.findByUsername(username);
        var emailOpt = userRepository.findByEmail(email);
        return usernameOpt.isPresent() || emailOpt.isPresent();
    }
}

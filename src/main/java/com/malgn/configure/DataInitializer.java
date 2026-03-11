package com.malgn.configure;

import com.malgn.domain.user.User;
import com.malgn.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("1234"))
                    .role("ROLE_ADMIN")
                    .build());
        }

        if (userRepository.findByUsername("user1").isEmpty()) {
            userRepository.save(User.builder()
                    .username("user1")
                    .password(passwordEncoder.encode("1234"))
                    .role("ROLE_USER")
                    .build());
        }
    }
}

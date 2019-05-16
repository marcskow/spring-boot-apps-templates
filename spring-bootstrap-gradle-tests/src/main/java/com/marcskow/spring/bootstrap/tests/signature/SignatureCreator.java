package com.marcskow.spring.bootstrap.tests.signature;

import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import com.marcskow.spring.bootstrap.tests.unit.DateReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Service
public class SignatureCreator {
    private final UserRepository userRepository;
    private final DateReader dataReader;

    public Signature createSignature(Long userId, String date) {
        ZonedDateTime zonedDateTime = dataReader.readZonedDateTime(date);
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchUserException(userId));

        return new Signature(user.getName(), zonedDateTime);
    }
}

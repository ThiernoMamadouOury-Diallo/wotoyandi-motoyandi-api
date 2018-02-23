package fr.wotoyandi.service.impl;

import fr.wotoyandi.model.User;
import fr.wotoyandi.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthRepository authRepository;

    public List<User> getAllUsers(String name) {
        try {

            if (name == null)
                return new ArrayList<>();
            else
                return authRepository.findAll();

        }catch (Exception e){};

        return new ArrayList<>();

    }

}

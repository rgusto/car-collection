package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.EntityInUseException;
import com.ricardo.carcollection.domain.exception.UserEmailAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.UserLoginAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.UserNotFoundException;
import com.ricardo.carcollection.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarService carService;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public User create(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserEmailAlreadyExistsException(user.getId(), user.getEmail());
        }
        optionalUser = userRepository.findByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            throw new UserLoginAlreadyExistsException(user.getId(), user.getLogin());
        }
        User userSaved = userRepository.save(user);
        user.getCars().forEach(car -> car.setUser(userSaved));
        carService.create(user.getCars(), userSaved);
        return userSaved;
    }

    @Transactional
    public void delete(UUID id) {
        try {
            User userDb = this.findById(id);
            userRepository.deleteById(userDb.getId());
            userRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("User with id %s is in use and cannot be removed".formatted(id));
        }
    }

    @Transactional
    public User update(User user) {
        User userDb = this.findById(user.getId());

        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setBirthday(user.getBirthday());
        userDb.setPhone(user.getPhone());

        userRepository.save(userDb);
        return userDb;
    }

}

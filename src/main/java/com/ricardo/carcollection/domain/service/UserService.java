package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User create(User user) {
        User userSaved = userRepository.save(user);
        user.getCars().forEach(car -> car.setUser(userSaved));
        carService.create(user.getCars(), userSaved);
        return userSaved;
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
        userRepository.flush();
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

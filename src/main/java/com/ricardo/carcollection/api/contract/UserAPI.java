package com.ricardo.carcollection.api.contract;

import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.UserInput;
import com.ricardo.carcollection.api.model.input.UserInputUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/users")
public interface UserAPI {

    @GetMapping
    List<UserModel> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UserModel> findById(@NotNull @PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel create(@RequestBody @Valid UserInput input);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<?> delete(@NotNull @PathVariable Long id);

    @PutMapping("/{id}")
    public UserModel update(@NotNull @PathVariable Long id, @RequestBody @Valid UserInputUpdate input);

}

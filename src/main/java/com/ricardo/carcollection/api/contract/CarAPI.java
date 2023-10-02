package com.ricardo.carcollection.api.contract;

import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.api.model.input.CarInputUpdate;
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

@RequestMapping("/api/cars")
public interface CarAPI {

    @GetMapping
    List<CarModel> findAll();

    @GetMapping("/{id}")
    ResponseEntity<CarModel> findById(@NotNull @PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel create(@RequestBody @Valid CarInput input);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<?> delete(@NotNull @PathVariable Long id);

    @PutMapping("/{id}")
    public CarModel update(@NotNull @PathVariable Long id, @RequestBody @Valid CarInputUpdate input);

}

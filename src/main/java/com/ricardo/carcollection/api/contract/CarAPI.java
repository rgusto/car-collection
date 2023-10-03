package com.ricardo.carcollection.api.contract;

import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.api.model.input.CarInputUpdate;
import com.ricardo.carcollection.domain.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/cars")
public interface CarAPI {

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    List<CarModel> findAll(@AuthenticationPrincipal User authenticatedUser);

    @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ResponseEntity<CarModel> findById(@NotNull @PathVariable UUID id, @AuthenticationPrincipal User authenticatedUser);

    @PostMapping
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel create(@RequestBody @Valid CarInput input, @AuthenticationPrincipal User authenticatedUser);

    @DeleteMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<?> delete(@NotNull @PathVariable UUID id, @AuthenticationPrincipal User authenticatedUser);

    @PutMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CarModel update(@NotNull @PathVariable UUID id, @RequestBody @Valid CarInputUpdate input, @AuthenticationPrincipal User authenticatedUser);

}

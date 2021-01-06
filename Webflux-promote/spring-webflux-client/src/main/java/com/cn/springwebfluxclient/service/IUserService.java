package com.cn.springwebfluxclient.service;

import com.cn.springwebfluxclient.annotation.APIServer;
import com.cn.springwebfluxclient.entity.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@APIServer(value = "http://localhost:8080/user")
public interface IUserService {

    @GetMapping("/")
    Flux<User> findAll();

    @GetMapping("/{id}")
    Mono<User> findById(@PathVariable("id") String id);

    @PostMapping("/")
    Mono<User> createUser(@RequestBody Mono<User> user);

    @DeleteMapping("/{id}")
    Mono<Void> deleteUser(@PathVariable("id") String id);

}

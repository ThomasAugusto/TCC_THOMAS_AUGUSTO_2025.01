package edu.senairs.api_requisicoes.service;

import java.util.List;

public interface IUserService<T, R> {
    String insertUser(T user);
    String updateUser(T user);
    String deleteUser(String id);
    List<R> findAll();
}

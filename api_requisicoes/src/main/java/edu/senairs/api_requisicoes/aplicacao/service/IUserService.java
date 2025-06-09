package edu.senairs.api_requisicoes.aplicacao.service;


import java.util.List;

public interface IUserService<T, R> {
    String insertUser(T user);
    String updateUser(T user);
    String deleteUserById(String id);
    List<R> findAll();
}

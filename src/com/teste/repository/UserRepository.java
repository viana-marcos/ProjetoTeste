package com.teste.repository;

import java.util.List;

import com.teste.model.User;


public interface  UserRepository { 
   List<User> findAll();
}

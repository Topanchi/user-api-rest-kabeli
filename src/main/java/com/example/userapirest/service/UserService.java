package com.example.userapirest.service;

import com.example.userapirest.model.Phone;
import com.example.userapirest.model.Response;
import com.example.userapirest.model.User;

import java.util.List;

public interface UserService {
    /* Método que guarda usuarios
     * @author Francisco Fuentes Schreiber
     * @param user que se va a guardar
     * @return retorna un objeto user
     */
    Response createUser(User user);

    /* Método que obtiene todos los usuarios
     * @author Francisco Fuentes Schreiber
     * @return retorna un objeto user
     */
    List<User> getAllUsers();

    /* Método que obtiene un usuario por su id
     * @author Francisco Fuentes Schreiber
     * @param id del usuario a buscar
     * @return retorna un objeto user
     */
    User getUserById(Long id);

    /* Método que actualiza usuarios
     * @author Francisco Fuentes Schreiber
     * @param user que se va a actualizar
     * @return retorna un objeto user
     */
    User updateUser(User user);

    /* Método que elimina usuarios
     * @author Francisco Fuentes Schreiber
     * @param is que se va a eliminar
     * @return nada
     */
    void deleteUser(Long id);

}

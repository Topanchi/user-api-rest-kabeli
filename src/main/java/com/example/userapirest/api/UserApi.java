package com.example.userapirest.api;

import com.example.userapirest.model.Phone;
import com.example.userapirest.model.Response;
import com.example.userapirest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("user")
public interface UserApi {
    /* Método que guarda usuarios
     * @author Francisco Fuentes Schreiber
     * @param user que se va a guardar
     * @return retorna un objeto user
     */
    @PostMapping(value = "/save")
    ResponseEntity<Response> createUser(@RequestBody User user);

    /* Método que obtiene todos los usuarios
     * @author Francisco Fuentes Schreiber
     * @return retorna un objeto user
     */
    @GetMapping("/list-users")
    ResponseEntity<List<User>> getAllUsers();

    /* Método que obtiene un usuario por su id
     * @author Francisco Fuentes Schreiber
     * @param id del usuario a buscar
     * @return retorna un objeto user
     */
    @GetMapping("/get-user/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id);

    /* Método que actualiza usuarios
     * @author Francisco Fuentes Schreiber
     * @param user que se va a actualizar
     * @return retorna un objeto user
     */
    @PutMapping("/update-user")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user);

    /* Método que elimina un usuario
     * @author Francisco Fuentes Schreiber
     * @param id del usuario a eliminar
     * @return retorna nada
     */
    @DeleteMapping("/delete-user/{id}")
    HttpStatus deleteUser(@PathVariable("id") Long id);

}

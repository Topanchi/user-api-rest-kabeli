package com.example.userapirest.service.impl;

import com.example.userapirest.exception.ResourceNotFoundException;
import com.example.userapirest.model.Phone;
import com.example.userapirest.model.Response;
import com.example.userapirest.model.User;
import com.example.userapirest.repository.PhoneRepository;
import com.example.userapirest.repository.UserRepository;
import com.example.userapirest.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Log LOGGER = LogFactory.getLog(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response createUser(User user) {
        LOGGER.info("Creating user: " + user.toString());
        Response response = new Response();
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}";

        if(user.getPassword().matches(pattern)){
            List<User> userDB = this.userRepository.findAll();
            User busqueda = userDB
                    .stream()
                    .filter(email -> email.getEmail().equals(user.getEmail()))
                    .findFirst()
                    .orElse(null);

            if(busqueda == null) {
                this.setObject(user);
                User userOut = this.userRepository.save(user);
                userOut.getUser_id();

                Phone phone = new Phone();

                for (int i = 0; i < user.getPhoneList().size(); i++) {
                    phone.setNumber(user.getPhoneList().get(i).getNumber());
                    phone.setContryCode(user.getPhoneList().get(i).getContryCode());
                    phone.setCityCode(user.getPhoneList().get(i).getCityCode());
                    phone.setUser_id(userOut.getUser_id());
                }

                response.setMensaje("Usario creado exitosamente");
                response.setUser(userOut);
            }else{
                response.setMensaje("El correo ya existe");
            }
        }else{
            response.setMensaje("La contraseña debe tener al menos una letra mayuscula, una minuscula, y dos numero como mínimo");
        }


        return response;
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        LOGGER.info("Getting user by id: " + id);
        Optional<User> userDB = this.userRepository.findById(id);

        if(userDB.isPresent()) {
            return userDB.get();
        }else{
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public User updateUser(User user) {
        LOGGER.info("Updating user: " + user);
        Optional<User> userDB = this.userRepository.findById(user.getUser_id());

        if(userDB.isPresent()) {
            User userUpdate = userDB.get();
            userUpdate.setUser_id(user.getUser_id());
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setModifiedAt(user.getModifiedAt());
            this.userRepository.save(userUpdate);
            return userUpdate;
        }else{
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        LOGGER.info("Deleting user by id: " + id);
        Optional<User> userDB = this.userRepository.findById(id);

        if(userDB.isPresent()) {
            this.userRepository.delete(userDB.get());
        }else{
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

    }

    private void setObject(User user) {
        user.setIsActive(true);
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setPhoneList(user.getPhoneList());
    }

}

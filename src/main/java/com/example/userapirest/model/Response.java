package com.example.userapirest.model;

import java.util.Objects;

public class Response {
    private String mensaje;
    private User user;

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(mensaje, response.mensaje) && Objects.equals(user, response.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensaje, user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("mensaje='").append(mensaje).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}

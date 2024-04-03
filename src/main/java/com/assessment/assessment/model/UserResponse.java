package com.assessment.assessment.model;

public class UserResponse {
    private String mensaje;
    private User user;

    // Constructor
    public UserResponse(String mensaje, User user) {
        this.mensaje = mensaje;
        this.user = user;
    }

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
}
package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class CouponsBody {

    /**
     * id : 1
     * token : w8fvwtwUIx4jaHX6Bpa5HM4nl8rLxM1tp/xKLs+1aWwJbqRJPYhsOxVuZTDBP+iwwiQCTz+CBD3sM32g+kU5LIkt6rd3I+rYY074st9YrdFd4agZCwMjE53xWfc6WwqlDUxbMz/GiMSSuhuAIceOWgV6DyAT4+S5
     */

    private String id;
    private String token;

    public CouponsBody(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

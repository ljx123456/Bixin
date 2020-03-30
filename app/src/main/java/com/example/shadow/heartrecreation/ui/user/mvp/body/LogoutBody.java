package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class LogoutBody {

    /**
     * token : kZA2B/mLlhNDABa0oPhjKKE0QKMxrOC+Cm7TxHwbPGTXKqGJjwpdEG6tQjXAEWwhiCXDtzJ9ic2McXYsJkiBYDBJRt46+Tnr4vswcHtt0r87so8vdoJSVDJrXgqJzU6W
     */

    private String token;

    public LogoutBody(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

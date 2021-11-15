package com.example.myapplication_fitify;

import java.util.List;

public interface IResponse {
    void onSuccess(List<Exercitii> exercitii);
    void onError(String mesaj);
}

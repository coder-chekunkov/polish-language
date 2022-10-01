package com.example.polish_language.serverWorker;

import static com.example.polish_language.staticActions.ToastWorkerKt.showToastServer;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DownloadDictionaryFromServer {

    private final String TAG = "ConnectToServer";

    // Метод получения словаря с сервера:
    public void downloadDictionary(Context context) {

        // Связь с сервером:
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://-------")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServerWordsAPI wordsAPI = retrofit.create(ServerWordsAPI.class);
        Call<List<ServerWord>> dictionary = wordsAPI.getWords();

        // Получение словаря с сервера:
        if (dictionary != null) {
            dictionary.enqueue(new Callback<List<ServerWord>>() {
                @Override
                public void onResponse(@NonNull Call<List<ServerWord>> call, @NonNull Response<List<ServerWord>> response) {
                    if (response.isSuccessful()) {
                        // Данные получены успешно:
                        new SaveAndReadDictionaryStorage().saveDictionary(context, response.body());
                    } else {
                        // Произошла ошибка:
                        Log.d(TAG, response.message());
                        showToastServer(false);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<ServerWord>> call, @NonNull Throwable t) {
                    // Произошла ошибка:
                    Log.d(TAG, t.getMessage());
                    showToastServer(false);
                }
            });
        }
    }
}

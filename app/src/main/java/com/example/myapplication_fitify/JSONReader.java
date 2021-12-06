package com.example.myapplication_fitify;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlpath, IResponse response){
        try {
            URL url=new URL(urlpath);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream input=connection.getInputStream();
            InputStreamReader inputReader=new InputStreamReader(input);
            BufferedReader reader=new BufferedReader(inputReader);
            StringBuilder result=new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null){
                result.append(line);

            }
            reader.close();
            inputReader.close();
            input.close();

            List<Exercitii> list=parsare(result.toString());
            response.onSuccess(list);


        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }

    }
    private List<Exercitii> parsare(String jsonString)
    {
        List<Exercitii> lista=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonString);
            JSONArray jsonArray=jsonObject.getJSONArray("exercitii");
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject currentObject=jsonArray.getJSONObject(i);
                String denumire=currentObject.getString("denumire");
                float durata=currentObject.getInt("durata");
                String descriere=currentObject.getString("descriere");
                Exercitii exercitii=new Exercitii(denumire, (int) durata, descriere);
                lista.add(exercitii);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;

    }

}

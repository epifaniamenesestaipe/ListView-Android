package com.example.aplicacion01.models;

import java.util.ArrayList;

public class Contacto {
    public String phone;
    public String nickname;
    public String image;

    public  String getSmallImage(){
        return  this.image;
    }

    public Contacto(String _phone, String _nickname, String _image) {
        this.phone = _phone;
        this.nickname = _nickname;
        this.image = _image;
    }

    public static ArrayList getCollection() {
        ArrayList<Contacto> collection = new ArrayList<>();
        collection.add(new Contacto("981999923", "Dia","https://mymodernmet.com/wp/wp-content/uploads/2019/05/even-tryggstrand-norway-photos-4.jpeg"));
        collection.add(new Contacto("9859913923", "Noche","https://mymodernmet.com/wp/wp-content/uploads/2019/05/even-tryggstrand-norway-photos-19.jpg"));
        collection.add(new Contacto("981914213", "Aurora","https://mymodernmet.com/wp/wp-content/uploads/2019/05/even-tryggstrand-norway-photos-22.jpg"));
        collection.add(new Contacto("981914213", "paisaje","https://mymodernmet.com/wp/wp-content/uploads/2019/05/even-tryggstrand-norway-photos-3.jpg\n"));
        return collection;
    }
}
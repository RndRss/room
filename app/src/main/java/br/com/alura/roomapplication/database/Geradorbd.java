package br.com.alura.roomapplication.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class Geradorbd {

    public Database gera(Context contexto) {
        Database bd = Room.databaseBuilder(contexto, Database.class, "database").allowMainThreadQueries().build();
        return bd;
    }
}

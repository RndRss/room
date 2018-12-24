package br.com.alura.roomapplication.database;

import android.arch.persistence.room.RoomDatabase;

import br.com.alura.roomapplication.models.Aluno;

@android.arch.persistence.room.Database(entities = {Aluno.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract AlunoDao getAlunoDao();

}

package br.com.alura.roomapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.alura.roomapplication.AlunosDelegate;
import br.com.alura.roomapplication.R;
import br.com.alura.roomapplication.fragments.FormularioAlunosFragment;
import br.com.alura.roomapplication.fragments.ListaAlunosFragment;

public class AlunosActivity extends AppCompatActivity implements AlunosDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);
        exibe(new ListaAlunosFragment(), false);
    }

    public void exibe(Fragment fragment, boolean empilhado) {
        FragmentManager gerenciadorDeFragment = getSupportFragmentManager();
        FragmentTransaction transacao = gerenciadorDeFragment.beginTransaction();
        transacao.replace(R.id.alunos_frame, fragment);
        if (empilhado) {
            transacao.addToBackStack(null);
        }
        transacao.commit();

    }

    @Override
    public void lidaComClickFAB() {
        exibe(new FormularioAlunosFragment(), true);
    }

    @Override
    public void voltaParaTelaAnterior() {
        onBackPressed();
    }

    @Override
    public void alteraNomeDaActivity(String nome) {
        setTitle(nome);

    }
}

package br.com.alura.roomapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.alura.roomapplication.AlunosDelegate;
import br.com.alura.roomapplication.R;
import br.com.alura.roomapplication.activities.AlunosActivity;
import br.com.alura.roomapplication.database.AlunoDao;
import br.com.alura.roomapplication.database.Database;
import br.com.alura.roomapplication.database.Geradorbd;
import br.com.alura.roomapplication.models.Aluno;

public class ListaAlunosFragment extends Fragment {

    private AlunosDelegate delegate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (AlunosDelegate) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.alteraNomeDaActivity("Lista de alunos");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        configuraComponentesDa(view);
        return view;
    }

    private void configuraComponentesDa(View view) {
        configuraLista(view);
        configuraFAB(view);
    }

    private void configuraFAB(View view) {
        FloatingActionButton botaoAdd = view.findViewById(R.id.fragment_lista_fab);
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.lidaComClickFAB();
            }

        });
    }

    private void configuraLista(View view) {
        final ListView lista = view.findViewById(R.id.fragment_lista);

        Geradorbd geradorbd = new Geradorbd();
        Database database = geradorbd.gera(getContext());
        AlunoDao alunoDao = database.getAlunoDao();

        List<Aluno> alunos = alunoDao.busca();
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, alunos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Aluno aluno = (Aluno) lista.getItemAtPosition(pos);

                delegate.lidaComAlunoSelecionado(aluno);

            }
        });


    }
}

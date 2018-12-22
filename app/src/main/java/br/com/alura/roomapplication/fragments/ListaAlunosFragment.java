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

import br.com.alura.roomapplication.AlunosDelegate;
import br.com.alura.roomapplication.R;
import br.com.alura.roomapplication.activities.AlunosActivity;

public class ListaAlunosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        FloatingActionButton botaoAdd = view.findViewById(R.id.fragment_lista_fab);
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlunosDelegate delegate = (AlunosDelegate) getActivity();
                delegate.lidaComClickFAB();
            }

        });
        return view;
    }
}

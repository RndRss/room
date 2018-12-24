package br.com.alura.roomapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.roomapplication.AlunosDelegate;
import br.com.alura.roomapplication.R;
import br.com.alura.roomapplication.database.AlunoDao;
import br.com.alura.roomapplication.database.Geradorbd;
import br.com.alura.roomapplication.models.Aluno;

public class FormularioAlunosFragment extends Fragment {

    private Aluno aluno = new Aluno();

    private EditText campoNome;
    private EditText campoemail;
    private AlunosDelegate delegate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (AlunosDelegate) getActivity();
        delegate.alteraNomeDaActivity("Cadastro de alunos");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_alunos, container, false);
        configuraComponentes(view);
        return view;
    }

    private void configuraComponentes(View view) {
        this.campoemail = view.findViewById(R.id.formulario_alunos_email);
        this.campoNome = view.findViewById(R.id.formulario_alunos_nome);


        Button cadastrar = view.findViewById(R.id.formulario_alunos_cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaInformacoesDoAluno();
                Geradorbd geradorbd = new Geradorbd();
                AlunoDao alunoDao = geradorbd.gera(getContext()).getAlunoDao();
                alunoDao.insere(aluno);
                delegate.voltaParaTelaAnterior();
            }
        });
    }

    private void atualizaInformacoesDoAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEmail(campoemail.getText().toString());
    }
}

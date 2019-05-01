package studio.dayvidson.curriculoti.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import studio.dayvidson.curriculoti.R;
import studio.dayvidson.curriculoti.controller.Usuario;
import studio.dayvidson.curriculoti.ws.UsuarioWS;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNomeCompleto;
    private EditText edtWhatsApp;
    private EditText edtUsuario;
    private EditText edtSenha;

    private Button btnConfirmar;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNomeCompleto = findViewById(R.id.edtCadastroNome);
        edtWhatsApp = findViewById(R.id.edtCadastroNumero);
        edtUsuario = findViewById(R.id.edtCadastroUser);
        edtSenha = findViewById(R.id.edtCadastroSenha);
        btnConfirmar = findViewById(R.id.btnCadastroConfirmar);

        btnConfirmar.setEnabled(false);

        TextWatcher verificaTextos = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nome = edtNomeCompleto.getText().toString();
                String senha = edtSenha.getText().toString();
                String whatspp = edtWhatsApp.getText().toString();
                String user = edtUsuario.getText().toString();

                if(nome.isEmpty()||senha.length()<8||whatspp.length()<11||user.length()<3){
                    btnConfirmar.setEnabled(false);
                }else{
                    btnConfirmar.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        };

        edtSenha.addTextChangedListener(verificaTextos);
        edtNomeCompleto.addTextChangedListener(verificaTextos);
        edtUsuario.addTextChangedListener(verificaTextos);
        edtWhatsApp.addTextChangedListener(verificaTextos);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpAsynccTask().execute();
            }
        });

    }

    private class HttpAsynccTask extends AsyncTask<String, Void, String> {
        private Usuario preencheValores(){
            Usuario usuario = new Usuario();

            usuario.setNomeCompleto(edtNomeCompleto.getText().toString());
            usuario.setPhoneWhatsApp(edtWhatsApp.getText().toString());
            usuario.setUsuario(edtUsuario.getText().toString());
            usuario.setSenha(edtSenha.getText().toString());

            return usuario;
        }

        protected String doInBackground(String... params){
            UsuarioWS ws = new UsuarioWS();

            usuario = preencheValores();

            String result = ws.insertUsuario(usuario);

            return result;
        }


    }
}

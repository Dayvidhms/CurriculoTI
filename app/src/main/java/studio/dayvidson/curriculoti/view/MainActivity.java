package studio.dayvidson.curriculoti.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import studio.dayvidson.curriculoti.R;
import studio.dayvidson.curriculoti.ws.UsuarioWS;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnCadastrar;

    private EditText edtUser;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnLoginEntrar);
        btnCadastrar = findViewById(R.id.btnLoginCadastrar);

        btnEntrar.setEnabled(false);
        btnEntrar.setBackgroundResource(R.drawable.btn_shape_disabled);

        edtUser = findViewById(R.id.edtLoginUser);
        edtSenha = findViewById(R.id.edtLoginSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String user = edtUser.getText().toString();
                String senha = edtSenha.getText().toString();

                if(user.isEmpty()||senha.isEmpty()){
                    btnEntrar.setBackgroundResource(R.drawable.btn_shape_disabled);
                    btnEntrar.setEnabled(false);
                }else{
                    btnEntrar.setBackgroundResource(R.drawable.btn_shape);
                    btnEntrar.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioWS ws = new UsuarioWS();
                String a = ws.selectLogin(edtUser.getText().toString(), edtSenha.getText().toString());
                Log.e("RETORNO DO SELECT TAOK", a);
            }
        });

        edtSenha.addTextChangedListener(textWatcher);
        edtUser.addTextChangedListener(textWatcher);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });
    }
}

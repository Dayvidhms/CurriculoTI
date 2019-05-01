package studio.dayvidson.curriculoti.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import studio.dayvidson.curriculoti.R;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar.setEnabled(false);

        btnEntrar = findViewById(R.id.btnLoginEntrar);
        btnCadastrar = findViewById(R.id.btnLoginCadastrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });
    }
}

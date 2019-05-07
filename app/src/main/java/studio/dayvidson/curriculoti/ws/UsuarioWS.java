package studio.dayvidson.curriculoti.ws;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.StrictMode;

import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import studio.dayvidson.curriculoti.controller.Usuario;

import static android.os.Looper.getMainLooper;

public class UsuarioWS {
    private static final String URL_INSERT = "http://192.168.15.69:8080/CurriculoWS/curriculoWS/usuario/postInsert";
    private static final String URL_LOGIN = "http://192.168.15.69:8080/CurriculoWS/curriculoWS/usuario/login";

    public String insertUsuario(Usuario usuario) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL_INSERT);

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.accumulate("nomeCompleto", usuario.getNomeCompleto());
            jsonObject.accumulate("phoneWhatsApp", usuario.getPhoneWhatsApp());
            jsonObject.accumulate("usuario", usuario.getUsuario());
            jsonObject.accumulate("senha", usuario.getSenha());

            String json = jsonObject.toString();

            StringEntity stringEntity = new StringEntity(json);

            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity((stringEntity));

            httpClient.execute(httpPost);
            return "true";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String selectLogin(String usuario, String senha){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL_LOGIN+"?user="+usuario+"&senha="+senha);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        //Processa respostas vindas do servidor e a transforma em determinado tipo
        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        //executa a chamada
        String respostaServidor = null;
        try {
            respostaServidor = httpClient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respostaServidor;
    }
}








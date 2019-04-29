package studio.dayvidson.curriculoti.ws;

import org.json.JSONObject;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import studio.dayvidson.curriculoti.controller.Usuario;

public class UsuarioWS {
    private static final String URL_INSERT = "http://192.168.15.69:8080/CurriculoWS/curriculoWS/usuario/postInsert";

    public String insertUsuario(Usuario usuario){
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
                return "false";
            }
        }

    }

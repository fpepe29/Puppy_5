package com.ferncuy.curso3semana5;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {
    private EditText etContactoNombre;
    private EditText etContactoEmail;
    private EditText etContactoMensaje;
    private Button btnEnviarEmail;

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etContactoNombre = (EditText) findViewById(R.id.etContactoNombre);
        etContactoEmail = (EditText) findViewById(R.id.etContactoEmail);
        etContactoMensaje = (EditText) findViewById(R.id.etContactoMensaje);
        btnEnviarEmail = (Button) findViewById(R.id.btnEnviarEmail);
        btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //permisos
                ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                //propiedades de conexion
                Properties properties = System.getProperties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.user", Login.USER);
                properties.put("mail.smtp.password", Login.PASSWORD);
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.port", "587");
                session = Session.getDefaultInstance(properties);
                MimeMessage message = new MimeMessage(session);
                try {
                    Toast.makeText(ActivityContacto.this, "Enviando mensaje...", Toast.LENGTH_LONG).show();
                    message.setFrom(new InternetAddress(Login.EMAIL));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(etContactoEmail.getText().toString().trim()));
                    message.setSubject("Mensaje de " + etContactoNombre.getText().toString());
                    message.setText(etContactoMensaje.getText().toString());
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", Login.USER, Login.PASSWORD);
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                    Toast.makeText(ActivityContacto.this, "Mensaje enviado", Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(ActivityContacto.this, "No se pudo enviar el mail", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public class Login {
        public static final String EMAIL = "nandopepe05@gmail.com";
        public static final String USER = "nandopepe05@gmail.com";
        public static final String PASSWORD = "pepe1234";
    }
}
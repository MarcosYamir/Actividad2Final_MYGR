package mx.marcosyamir.actividad2final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre_completo = parametros.getString(getResources().getString(R.string.pnombre_completo));
        String fecha_nacimiento = parametros.getString(getResources().getString(R.string.pfecha_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion_contacto));

        final TextView tvNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        final TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        final TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        final TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        final TextView tvDescripcionContacto = (TextView) findViewById(R.id.tvDescripcionContacto);

        tvNombreCompleto.setText(nombre_completo);
        tvFechaNacimiento.setText(fecha_nacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcionContacto.setText(descripcion);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre_completo),tvNombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha_nacimiento),tvFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion_contacto),tvDescripcionContacto.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){
        if (keycode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keycode,event);
    }
}


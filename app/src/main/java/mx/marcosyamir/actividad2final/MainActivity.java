package mx.marcosyamir.actividad2final;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int request_code = 1;
    private EditText etNombreCompleto;
    private EditText etFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreCompleto =(EditText) findViewById(R.id.etNombreCompleto);
        etFechaNacimiento =(EditText) findViewById(R.id.etFechaNacimiento);
        etTelefono =(EditText) findViewById(R.id.etTelefono);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etDescripcion =(EditText) findViewById(R.id.etDescripcion);

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre_completo),etNombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha_nacimiento),etFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion_contacto),etDescripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
    public void onStart(){
        super.onStart();
        EditText etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etFechaNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    DateDialog dialog=new DateDialog(v);
                    FragmentTransaction ft =getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");

                }
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent ){
        if ((requestCode == request_code) && (resultCode == RESULT_OK)){
            Bundle parametros = getIntent().getExtras();
            String nombre_completo = parametros.getString(getResources().getString(R.string.pnombre_completo));
            String fecha_nacimiento = parametros.getString(getResources().getString(R.string.pfecha_nacimiento));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion_contacto));

            etNombreCompleto.setText(nombre_completo);
            etFechaNacimiento.setText(fecha_nacimiento);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }
    }

}

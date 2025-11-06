package com.ad.viewtransaccion;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ad.core.db.DbConexion;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.ad.core.entity.Ecuenta;
import com.ad.core.io.AppDatabase;
import com.ad.core.io.DaoCuenta;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spOrigen, spDestino, spBienSv,spProduct;
    private EditText etTitle;
    private int idorigen,iddestino,idbiensv;
    private Ecuenta selectedOrigen, selectedDestino;
    private TextView tvData;

    private String producto[][]= {
            {"Renta","Agua","Luz","Gas","Mtto","Bolsas"},
            {"Papel higiénico","Café","Azucar","Sal","Pimienta","Jabón trastes","Fibra esponja","Aceite"},
            {"Préstamo","Nomina", "ISSFAM","BlaBlaCar","Apuestas Caballo","Alimentos p/casa", "Leche","Pan","Movistar","Desayuno","Comida","Cena"},
            {"Ropa adulto", "Ropa niños", "Accesorios", "Zapato", "Tenis"},
            {"Transferencia","Pago", "Retiro"},
            {"Medicamento", "Dentista", "Gastos médicos", "Pasatiempo" },
            {"Gasolina WRX", "Trasporte público", "Taxi/uber", "Mtto carro agencia", "Refacciones carro", "Neumáticos", "Lavado","Reparacion carro", "Seguro de carro", "Casetas"},
            {"Cine", "Teatro", "Gimnasio", "Piscina", "Cursos/formacion", "pasatiempo", "Revistas", "Libros", "Equipo electrónico" },
            {"Cosmeticos","Accesorios", "Peluqueria", "Salon de belleza", "Productos de limpieza" },
            {"Regalos", "Mascota", "Vacaciones", "Veterinario", "Caridad","Hospedaje" }
    };

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this,"ON CREATE",Toast.LENGTH_SHORT).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        idorigen = R.id.sporigen;
        iddestino = R.id.spdestino;
        idbiensv = R.id.spbienservicio;
        spOrigen = (Spinner) findViewById(R.id.sporigen);
        spDestino = (Spinner) findViewById(R.id.spdestino);
        etTitle = (EditText) findViewById(R.id.title);
        etTitle.setText("Prueba de titulo");
        spBienSv = (Spinner) findViewById(R.id.spbienservicio);
        spProduct = (Spinner) findViewById(R.id.spproducto);
        tvData = (TextView) findViewById(R.id.data);
        llenarOrigen();

        Button btnCrearDb = (Button) findViewById(R.id.creardb);
        btnCrearDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DbConexion conexion = new DbConexion(getApplicationContext());
//                if (conexion == null)
//                    Toast.makeText(MainActivity.this,"No se creo la Base de datos", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(MainActivity.this,"SE CREO la Base de datos SATISFACTORIAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

        Button myButton = findViewById(R.id.save);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CargaDatosDB();
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveButton(){

    }

    private void llenarOrigen(){

        ArrayList origen = new ArrayList<Ecuenta>();
        origen.add(new Ecuenta(1,"1234567835341","Efectivo",0,"@1"));
        origen.add(new Ecuenta(2,"1234567835342","BBVA",0,"@1"));
        origen.add(new Ecuenta(3,"1234567835343","BanjercitoYo",0,"@1"));
        origen.add(new Ecuenta(4,"1234567835344","BanjercitoMa",0,"@1"));
        origen.add(new Ecuenta(5,"1234567835345","Banamex Debito",0,"@1"));
        origen.add(new Ecuenta(6,"1234567835346","Banamex crédito",0,"@1"));
        origen.add(new Ecuenta(7,"1234567835347","Santander",0,"@1"));
        origen.add(new Ecuenta(8,"1234567835348","gasto",0,"@1"));
        origen.add(new Ecuenta(9,"1234567835349","otras_cuentas",0,"@1"));
        origen.add(new Ecuenta(10,"1234567835310","foraneas",0,"@1"));

        ArrayAdapter<Ecuenta> aorigen = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,origen);//db.daoCuenta().getAll());

        spOrigen.setAdapter(aorigen);
        spOrigen.setOnItemSelectedListener(this);
        spDestino.setAdapter(aorigen);

        spDestino.setOnItemSelectedListener(this);

        String bienSv[]  = {"B303","B105","Personal","RopaCalzado","Tarjeta","Salud","Transporte","Recreativos","Higiene","Otros"};

        ArrayAdapter<String> aabienSv = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,bienSv);



        spBienSv.setAdapter(aabienSv);
        spBienSv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                llenarProducto(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    private void llenarProducto(int seleccion){
        ArrayAdapter<String> aaProduct = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,producto[seleccion]);
        spProduct.setAdapter(aaProduct);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"ITEM SELECTED "+parent.getSelectedView(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void CargaDatosDB(){
        // bienservicio

        AppDatabase adb = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,DbConexion.DB_NAME)
                .allowMainThreadQueries().build();

    }

    public void LoadAccount(AppDatabase adb){
        ArrayList origen = new ArrayList<Ecuenta>();
        origen.add(new Ecuenta(0,"1234567835341","Efectivo",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835342","BBVA",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835343","BanjercitoYo",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835344","BanjercitoMa",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835345","Banamex Debito",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835346","Banamex crédito",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835347","Santander",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835348","gasto",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835349","otras_cuentas",0,"@1"));
        origen.add(new Ecuenta(0,"1234567835310","foraneas",0,"@1"));
        try{

            adb.daoCuenta().insertCuentas(origen);
            List<Ecuenta> cuents = adb.daoCuenta().getAll();
            String text = "";
            if (cuents.size()>0)
                for (int i = 0; i < cuents.size(); i++){
                    text = text + " id " + cuents.get(i).getCuentaid() +
                            " " + cuents.get(i).getNombre() +
                            " " + cuents.get(i).getEmail() +
                            " " + cuents.get(i).getClabe() +
                            " " + cuents.get(i).getSaldo() + " \n";
                }
            else text = "Sin datos";

            tvData.setText(text);

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        };
    }

    public void LoadProduct(AppDatabase adb){
        String producto[][]= {
                {"Renta","Agua","Luz","Gas","Mtto","Bolsas"},
                {"Papel higiénico","Café","Azucar","Sal","Pimienta","Jabón trastes","Fibra esponja","Aceite"},
                {"Préstamo","Nomina", "ISSFAM","BlaBlaCar","Apuestas Caballo","Alimentos p/casa", "Leche","Pan","Movistar","Desayuno","Comida","Cena"},
                {"Ropa adulto", "Ropa niños", "Accesorios", "Zapato", "Tenis"},
                {"Transferencia","Pago", "Retiro"},
                {"Medicamento", "Dentista", "Gastos médicos", "Pasatiempo" },
                {"Gasolina WRX", "Trasporte público", "Taxi/uber", "Mtto carro agencia", "Refacciones carro", "Neumáticos", "Lavado","Reparacion carro", "Seguro de carro", "Casetas"},
                {"Cine", "Teatro", "Gimnasio", "Piscina", "Cursos/formacion", "pasatiempo", "Revistas", "Libros", "Equipo electrónico" },
                {"Cosmeticos","Accesorios", "Peluqueria", "Salon de belleza", "Productos de limpieza" },
                {"Regalos", "Mascota", "Vacaciones", "Veterinario", "Caridad","Hospedaje" }
        };




    }
}
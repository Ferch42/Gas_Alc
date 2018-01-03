package alcgas.studio.com.gas_alc;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button BtnAVSG, BtnQntRoda, BtnRegister;
    final Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BtnAVSG = (Button) findViewById(R.id.BtnAVSG);
        BtnQntRoda = (Button) findViewById(R.id.BtnQntRoda);
        BtnRegister = (Button) findViewById(R.id.BtnRegister);

        BtnAVSG.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Dialog gasAlcDialog = new Dialog(c);
                gasAlcDialog.setContentView(R.layout.gasalc_dialog);
                gasAlcDialog.setTitle("alcool ou gasolina?");

                Button BtnComparar = (Button) gasAlcDialog.findViewById(R.id.BtnComparar);
                BtnComparar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        EditText edtGas, edtAlc;
                        edtGas = (EditText) gasAlcDialog.findViewById(R.id.edtGas);
                        edtAlc = (EditText) gasAlcDialog.findViewById(R.id.edtAlc);
                        double alcool = Double.parseDouble(edtAlc.getText().toString());
                        double gasolina = Double.parseDouble(edtGas.getText().toString());
                        String resp = "";
                        if(alcool/gasolina > 0.7){
                            resp = "eh melhor ir de gasolina, cara";
                        }else if (alcool/gasolina == 0.7)   {
                            resp = "vai na fe";
                        }else{
                            resp = "acredito que a melhor opcao seja utilizar alcool desta vez, senhor(a)";
                        }
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(c);
                            alertDialogBuilder.setTitle("Resposta");
                            alertDialogBuilder.setMessage(resp);
                            AlertDialog aDial = alertDialogBuilder.create();
                            aDial.show();
                    }
                });


                gasAlcDialog.show();

            }
        });
        BtnQntRoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, prevActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

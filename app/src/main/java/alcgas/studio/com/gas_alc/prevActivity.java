package alcgas.studio.com.gas_alc;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class prevActivity extends AppCompatActivity {
    private Button BtnCalcular;
    final Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev);
        BtnCalcular = (Button) findViewById(R.id.BtnCalcular);
        BtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog prevDialog = new Dialog(c);
                prevDialog.setContentView(R.layout.prev_dialog);
                prevDialog.setTitle("Previsao de rodacao");

                EditText edtKmRodados, edtAbasteceu, edtMedia;
                edtKmRodados = (EditText) findViewById(R.id.edtKmRodados);
                edtAbasteceu = (EditText) findViewById(R.id.edtAbasteceu);
                edtMedia = (EditText) findViewById(R.id.edtMedia);

                TextView textKm, textResp;
                textKm = (TextView) prevDialog.findViewById(R.id.textKm);
                textResp = (TextView) prevDialog.findViewById(R.id.textResp);


                double kmRodado = Double.parseDouble(edtKmRodados.getText().toString());
                double abasteceu = Double.parseDouble(edtAbasteceu.getText().toString());
                double media = Double.parseDouble(edtMedia.getText().toString());
                double km = abasteceu*media;
                double aux = kmRodado + km;

                String resp = "" + km + " km";
                textKm.setText(resp);

                resp = "" + aux + " km";
                textResp.setText(resp);
                prevDialog.show();
            }
        });
    }
}

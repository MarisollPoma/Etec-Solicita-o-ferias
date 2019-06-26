package br.com.etechoracio.etec_solicitao_ferias;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import br.com.etechoracio.etec_solicitao_ferias.Utils.DateTimeUtils;


public class SolicitacaoActivity extends AppCompatActivity {

    private Spinner spnQtdeDias;
    private Button btnDataInicio;
    private Button btnRegistrar;
    private Button btnDataFim;
    private RadioGroup groupAbonoPecuniario;
    private RadioButton radioSim;
    private RadioButton radioNao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

    spnQtdeDias = findViewById(R.id.spnQtdeDias);
    spnQtdeDias.setAdapter(getAbonoSim());
    btnRegistrar = findViewById(R.id.btnRegistrar);
    btnDataInicio = findViewById(R.id.btnDataInicio);
    btnDataFim = findViewById(R.id.btnDataFim);
    groupAbonoPecuniario = findViewById(R.id.groupAbonoPecuniario);
    radioSim = findViewById(R.id.radioSim);
    radioNao = findViewById(R.id.radioNao);

}

    private ArrayAdapter getAbonoSim() {

        return new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdowns_item,
                Arrays.asList(20,30));
    }

    private ArrayAdapter  getAbonoNao() {

        return new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(10,15,20,30));

    }

    private DatePickerDialog.OnDateSetListener dataListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker datePicker, int dia, int mes, int ano) {

            String.valueOf(dia);
            String.valueOf(mes + 1);
            String.valueOf(ano);
        }
    };


        public void OnRadioClick(View view) {

        if (view.getId() == R.id.radioSim) {
            spnQtdeDias.setAdapter(getAbonoSim());
        } else {
            spnQtdeDias.setAdapter(getAbonoNao());
        }

    }


    private DatePickerDialog.OnDateSetListener dataRegistrar = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker datePicker, int dia, int mes, int ano) {

            btnDataInicio.setText(DateTimeUtils.formatDate(dia, mes, ano));
        }
    };

    protected Dialog onCreateDialog(int id) {

        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.YEAR);


        switch (id) {
            case R.id.btnRegistrar:
                return new DatePickerDialog(this, dataRegistrar,dia, mes,ano);
        }
        return null;

    }

    public void OnRegistrar(View view)  {

        Date dataInicio = DateTimeUtils.toDate(btnDataInicio.getText().toString());
        DateTimeUtils.osDias(dataInicio);

        if (DateTimeUtils.toDate(btnDataInicio.getText().toString());
        Toast toast = Toast.makeText(this,"selecione sempre Segunda-Feira", Toast.LENGTH_SHORT);
        toast.show();
    }else { int dias = Integer.parseInt(spnQtdeDias.getSelectedItem().toString());
            Date dataFim = DateTimeUtils.adicionarDias(Date  , int dia );
            btnRegistrar.setText(DateTimeUtils.formatDate(dataFim));
        }

    }
















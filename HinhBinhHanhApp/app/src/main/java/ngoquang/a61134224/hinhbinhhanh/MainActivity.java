package ngoquang.a61134224.hinhbinhhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText canhday = findViewById(R.id.edtCday);
        EditText canhben = findViewById(R.id.edtCben);
        EditText chieucao = findViewById(R.id.edtCcao);
        Button tinhchuvi = findViewById(R.id.btnCvi);
        Button tinhdientich = findViewById(R.id.btnDtich);
        TextView ketqua = findViewById(R.id.tvKqua);

        tinhdientich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ccao = Integer.parseInt(chieucao.getText().toString());
                int cday = Integer.parseInt(canhday.getText().toString());
                int kqua = cday * ccao;
                ketqua.setText("Diện tích hình bình hành là: " + kqua);
            }
        });

        tinhchuvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cday = Integer.parseInt(canhday.getText().toString());
                int cben = Integer.parseInt(canhben.getText().toString());
                int kqua = 2 * (cday + cben);
                ketqua.setText("Chu vi hình bình hành là: " + kqua);
            }
        });
    }
}
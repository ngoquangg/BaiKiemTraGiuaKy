package ngoquang.a61134224.quanlythoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase databaseVerse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseVerse = SQLiteDatabase.openOrCreateDatabase("/data/data/ntu.verse/MyVerse.db", null);
        TaoBangVaThemDuLieu();
        NapSachvaoListview();
    }
    void NapSachvaoListview(){
        ListView listView = (ListView) findViewById(R.id.lvTho);
        ArrayList<String> dsTho = new ArrayList<String>();
        Cursor cs = databaseVerse.rawQuery("SELECT * FROM VERSES",null);
        cs.moveToFirst();
        while (true)
        {
            if(cs.isAfterLast()==true) break;
            int ms = cs.getInt(0);
            String tenTho = cs.getString(1);
            Float gia = cs.getFloat(3);
            String dong = String.valueOf(ms) + "..." + tenTho + "..." + String.valueOf(gia);
            dsTho.add(dong);
            cs.moveToNext();
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsTho);
        listView.setAdapter(adapter);
    }
    void TaoBangVaThemDuLieu() {
        String sqlXoaBang ="DROP TABLE IF EXISTS VERSES";
        databaseVerse.execSQL(sqlXoaBang);
        String sqlTaoBang ="CREATE TABLE VERSES(VerseID integer PRIMARY KEY, " +
                "   VerseName text, " +
                "   Page integer, "+
                "   Price Float, "+
                "   Description text)";
        databaseVerse.execSQL(sqlTaoBang);
        //Them bản ghi
        String sqlThem1= "INSERT INTO VERSES VALUES(1, 'Nguyên Tiêu', 100, 9.99, 'Sách của Hồ Chí Minh')";
        databaseVerse.execSQL(sqlThem1);
        String sqlThem2= "INSERT INTO VERSES VALUES(2, 'Sư đoàn', 320, 19.00, 'Phạm Ngọc Cảnh')";
        databaseVerse.execSQL(sqlThem2);
        String sqlThem3= "INSERT INTO VERSES VALUES(3, 'Tạm biệt Huế', 120, 0.99, 'Thu Bồn') ";
        databaseVerse.execSQL(sqlThem3);
        String sqlThem4= "INSERT INTO VERSES VALUES(4, 'Núi Đôi', 1000, 29.50, 'Vũ Cao')";
        databaseVerse.execSQL(sqlThem4);
    }
}
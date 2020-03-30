package id.ac.uty.javarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(setDataList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public DataList[] setDataList(){
        DataList[] myListData = new DataList[] {
                new DataList( R.drawable.img7, "Title 1", "20$"),
                new DataList( R.drawable.img8, "Title 2", "30$"),
                new DataList( R.drawable.img10, "Title 3", "40$"),
                new DataList( R.drawable.img11, "Title 3", "50$"),
                new DataList( R.drawable.img12, "Title 3", "60$")
        };
        return myListData;
    }
}

package danish.com.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnOne = findViewById(R.id.btn_one);
        Button btnTwo = findViewById(R.id.btn_two);
        Button btnThree = findViewById(R.id.btn_three);
        Button btnFour = findViewById(R.id.btn_four);
        Button btnEven = findViewById(R.id.btn_even);
        Button btnOdd = findViewById(R.id.btn_odd);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });

        btnEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });

        btnOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList.clear();
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                modelArrayList.add(new Model(R.drawable.what_hot));
                setSpanValue();

            }
        });


    }

    private void setSpanValue() {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        if (modelArrayList.size() == 1) {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        } else if (modelArrayList.size() == 2) {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        } else if (modelArrayList.size() == 3) {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        } else {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.hasFixedSize();
        Adapter adapter = new Adapter(this, modelArrayList, checkEvenOrOdd(modelArrayList.size()));
        recyclerView.setAdapter(adapter);
    }


    private boolean checkEvenOrOdd(int n) {
        if ((n % 2) == 0) {
            // number is even
            return true;

        } else {
            // number is odd
            return false;
        }
    }
}

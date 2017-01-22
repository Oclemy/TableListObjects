package com.tutorials.hp.tablelistobjects;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class MainActivity extends AppCompatActivity {

    String[] spaceProbeHeaders={"ID","Name","Propellant","Destination"};
    String[][] spaceProbes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(4);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));

        //POPULATE
        populateData();

         //ADAPTERS
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,spaceProbeHeaders));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, spaceProbes));

        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(MainActivity.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void populateData()
    {
        Spaceprobe spaceprobe=new Spaceprobe();
        ArrayList<Spaceprobe> spaceprobeList=new ArrayList<>();


        spaceprobe.setId("1");
        spaceprobe.setName("Pioneer");
        spaceprobe.setPropellant("Solar");
        spaceprobe.setDestination("Venus");
        spaceprobeList.add(spaceprobe);

        spaceprobe=new Spaceprobe();
        spaceprobe.setId("2");
        spaceprobe.setName("Casini");
        spaceprobe.setPropellant("Nuclear");
        spaceprobe.setDestination("Jupiter");
        spaceprobeList.add(spaceprobe);

        spaceprobe=new Spaceprobe();
        spaceprobe.setId("3");
        spaceprobe.setName("Apollo");
        spaceprobe.setPropellant("Chemical");
        spaceprobe.setDestination("Moon");
        spaceprobeList.add(spaceprobe);

        spaceprobe=new Spaceprobe();
        spaceprobe.setId("4");
        spaceprobe.setName("Enterpise");
        spaceprobe.setPropellant("Anti-Matter");
        spaceprobe.setDestination("Andromeda");
        spaceprobeList.add(spaceprobe);

        spaceProbes= new String[spaceprobeList.size()][4];
        // spaceProbes= new String[][]{{}};


        for (int i=0;i<spaceprobeList.size();i++) {

            Spaceprobe s=spaceprobeList.get(i);

            spaceProbes[i][0]=s.getId();
            spaceProbes[i][1]=s.getName();
            spaceProbes[i][2]=s.getPropellant();
            spaceProbes[i][3]=s.getDestination();


        }





    }


}

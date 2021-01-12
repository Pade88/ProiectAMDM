package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.NameValueDataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.charts.Venn;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ChartActivity extends AppCompatActivity
{
    DataBaseHelper myDb;
    int COLS_NO = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        myDb = new DataBaseHelper(this);
        String ChartId = getIntent().getStringExtra("ID");

        switch(Integer.parseInt(ChartId))
        {
            case 1:
            {
                generateChartCPJ(fetchData());
                break;
            }
            case 2:
            {
                generateChartVPJ(fetchData());
                break;
            }
            case 3:
            {
                generateChartCNPJ(fetchData());
                break;
            }
            case 4:
            {
                generateChartVNPJ(fetchData());
                break;
            }

            case 5:
            {
                generateLineChartDolj(fetchData());
                break;
            }
        }
    }

    public Vector<String> fetchData()
    {
        Cursor myCursor = myDb.getAllData();
        Vector<String> function_output = new Vector<String>();

        if (myCursor.getCount() > 0)
        {
            while (myCursor.moveToNext())
            {
                function_output.addElement(myCursor.getString(1));
                function_output.addElement(myCursor.getString(2));
                function_output.addElement(myCursor.getString(3));
                function_output.addElement(myCursor.getString(4));
                function_output.addElement(myCursor.getString(5));

            }
        }

        return function_output;
    }

    public void generateChartCPJ(Vector<String> function_input)
    {
        Pie pie = AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        for(int index = 0; index < function_input.size(); index += COLS_NO)
        {
            data.add(new ValueDataEntry(function_input.elementAt(index), Integer.parseInt(function_input.elementAt(index+2))));
        }
        pie.data(data);
        AnyChartView anyCharView = findViewById(R.id.any_chart_view);
        anyCharView.setChart(pie);
    }

    public void generateChartVPJ(Vector<String> function_input)
    {
        Cartesian cartesian = AnyChart.column();
        List<DataEntry> data = new ArrayList<>();
        for(int index = 0; index < function_input.size(); index += COLS_NO)
        {
            data.add(new ValueDataEntry(function_input.elementAt(index), Integer.parseInt(function_input.elementAt(index+4))));
        }
        Column column = cartesian.column(data);
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Topul judetelor dupa numarul de vaccinuri totale:");
        cartesian.yScale().minimum(0d);
        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);
        cartesian.xAxis(0).title("Judet");
        cartesian.yAxis(0).title("vaccinuri");

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setChart(cartesian);
    }

    public void generateChartCNPJ(Vector<String> function_input)
    {
        Pie pie = AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        for(int index = 0; index < function_input.size(); index += COLS_NO)
        {
            data.add(new ValueDataEntry(function_input.elementAt(index), Integer.parseInt(function_input.elementAt(index+1))));
        }
        pie.data(data);
        AnyChartView anyCharView = findViewById(R.id.any_chart_view);
        anyCharView.setChart(pie);
    }

    public void generateChartVNPJ(Vector<String> function_input)
    {
        Cartesian cartesian = AnyChart.column();
        List<DataEntry> data = new ArrayList<>();
        for(int index = 0; index < function_input.size(); index += COLS_NO)
        {
            data.add(new ValueDataEntry(function_input.elementAt(index), Integer.parseInt(function_input.elementAt(index+3))));
        }
        Column column = cartesian.column(data);
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Topul judetelor dupa numarul de vaccinuri in ultimele 24 de ore:");
        cartesian.yScale().minimum(0d);
        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);
        cartesian.xAxis(0).title("Judet");
        cartesian.yAxis(0).title("vaccinuri");

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setChart(cartesian);
    }

    public void generateLineChartDolj(Vector<String> function_input)
    {
        Venn venn = AnyChart.venn();
        List<DataEntry> data = new ArrayList<>();
        for(int index = 0; index < function_input.size(); index += COLS_NO)
        {
            if(function_input.elementAt(index).equals("Dolj"))
            {
                data.add(new NameValueDataEntry("A", "Dolj", Integer.parseInt(function_input.elementAt(index+1))));
            }
            else
            {
                data.add(new NameValueDataEntry("B", "Romania", Integer.parseInt(function_input.elementAt(index+2))));
            }
        }

        venn.data(data);

        venn.stroke("2 #FFFFFF");

        venn.labels().format("{%Name}");

        venn.intersections().hovered().fill("black", 0.25d);

        venn.intersections().labels().fontWeight("bold");
        venn.intersections().labels().format("{%Name}");

        venn.tooltip().titleFormat("{%Name}");
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setChart(venn);
    }
}
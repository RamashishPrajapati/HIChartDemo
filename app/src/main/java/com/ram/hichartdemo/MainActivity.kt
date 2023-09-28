package com.ram.hichartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.highsoft.highcharts.common.hichartsclasses.HIChart
import com.highsoft.highcharts.common.hichartsclasses.HICredits
import com.highsoft.highcharts.common.hichartsclasses.HIDataLabels
import com.highsoft.highcharts.common.hichartsclasses.HIExporting
import com.highsoft.highcharts.common.hichartsclasses.HIOptions
import com.highsoft.highcharts.common.hichartsclasses.HIPie
import com.highsoft.highcharts.common.hichartsclasses.HIPlotOptions
import com.highsoft.highcharts.common.hichartsclasses.HISeries
import com.highsoft.highcharts.common.hichartsclasses.HIStyle
import com.highsoft.highcharts.common.hichartsclasses.HITitle
import com.ram.hichartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initHIChart()
    }

    private fun initHIChart() {

        val options = HIOptions()

        val chart = HIChart()
        chart.type = "pie"
        options.chart = chart

        // Setting the title of pie chart
        val title = HITitle()
        title.text = "Attendance OlverView"
        options.title = title

        //hide the hamburger icon from view
        val exporting = HIExporting()
        exporting.enabled = false
        options.exporting = exporting

        // hiding the credit details
        val credit = HICredits()
        credit.enabled = false
        options.credits = credit

        // Create the semi-circle series
        val series = HIPie()
        series.name = ""
        series.type = "pie"
        series.innerSize = "0%"
        series.startAngle = -90
        series.endAngle = 90
        series.center = ArrayList<String>(mutableListOf("50%", "75%"))
        series.size = "100%"


        val plotOptions = HIPlotOptions()
        plotOptions.pie = HIPie()
        plotOptions.pie.allowPointSelect = true
        plotOptions.pie.cursor = "pointer"

        // Set the data labels for the semi-circle series
        val dataLabels = HIDataLabels()
        dataLabels.enabled = true
        dataLabels.format = "<b>{point.name}</b>: {point.percentage:.1f} %"
        dataLabels.distance = -50
        dataLabels.style = HIStyle()
        dataLabels.style.fontWeight = "normal"

        val dataLabelsArray = ArrayList<HIDataLabels>()
        dataLabelsArray.add(dataLabels)
        plotOptions.pie.dataLabels = dataLabelsArray
        options.plotOptions = plotOptions

        //adding the value to show on the each section
        val map1 = HashMap<String, Any>()
        map1["name"] = "Present"
        map1["y"] = 30

        val map2 = HashMap<String, Any>()
        map2["name"] = "OnLeave"
        map2["y"] = 20

        val map3 = HashMap<String, Any>()
        map3["name"] = "Half Day"
        map3["y"] = 20

        val map4 = HashMap<String, Any>()
        map4["name"] = "Week Off"
        map4["y"] = 10

        val map5 = HashMap<String, Any>()
        map5["name"] = "Absent"
        map5["y"] = 20

        series.data = (ArrayList<Any>(
            mutableListOf(
                map1, map2, map3, map4, map5
            )
        ))

        options.series = ArrayList<HISeries>(mutableListOf(series))
        binding.hiCV.options = options

    }


}
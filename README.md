# HIChartDemo
The app demonstrate how to use HighCharts with using kotlin language.

# How to use HighCharts in project
1) Add highcharts-android.aar file in lib folder of project, You can download the .aar file from below link
https://github.com/highcharts/highcharts-android/releases

2) Add lib folder with .aar file path in Gradle file 
implementation(files("libs/highcharts-android.aar"))

3) Add below view in XML layout
<com.highsoft.highcharts.core.HIChartView
                android:id="@+id/hiCV"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent" />
   
4) Create a HIOptions() object and add aother attribute as per desire pie-chart view.

# Screenshort

![Screenshot_20230928_213337](https://github.com/RamashishPrajapati/HIChartDemo/assets/13693026/ce287ba0-0291-4597-8169-5d2167428aa1)

# Note
To check more options you can use below link of offical website of Highcharts

https://www.highcharts.com/demo/android/line-basic







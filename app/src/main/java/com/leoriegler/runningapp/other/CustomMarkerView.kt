package com.leoriegler.runningapp.other

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.leoriegler.runningapp.models.Run
import com.leoriegler.runningapp.utils.TrackingUtility
import kotlinx.android.synthetic.main.marker_view.view.*
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView (
    val runs: List<Run>,
    c: Context,
    layoutId: Int
) : MarkerView(c, layoutId){

    override fun getOffset(): MPPointF {

        return MPPointF(-width / 2f, -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if(e == null){
            return
        }

        val currentRunId = e.x.toInt()
        val run = runs[currentRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        tvDateM .text = dateFormat.format(calendar.time)

        val avgSpeed = "${run.averageSpeedInKmH}km/h"
        tvAverageSpeed.text = avgSpeed

        val distanceInKm = "${run.distanceInMeters / 1000f}km"
        tvDistanceM.text = distanceInKm

        tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

        val caloriesBurned = "${run.caloriesBurned}kcal"
        tvCaloriesBurned.text = caloriesBurned

    }


}
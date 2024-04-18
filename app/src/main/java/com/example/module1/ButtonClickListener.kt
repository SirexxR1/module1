package com.example.module1

import android.app.Activity
import android.content.Intent
import android.view.View

class ButtonClickListener(private val activity: Activity) : View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_Events -> {
                startActivity(MainActivity::class.java)
            }
            R.id.tv_Tickets -> {
                startActivity(TicketsActivity::class.java)
            }
            R.id.tv_Records -> {
                startActivity(RecordsActivity::class.java)
            }
        }
    }

    private fun startActivity(destinationActivity: Class<*>) {
        val intent = Intent(activity, destinationActivity)
        activity.startActivity(intent)
    }
}

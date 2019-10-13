package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

const val ACTION_BAR_ADD_TITLE = "Create a Portal"
const val EMPTY_FIELDS = "Fill in all fields"
const val PORTAL_EXTRA = "PORTAL_EXTRA"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ACTION_BAR_ADD_TITLE

        btnAddPortal.setOnClickListener { onAddPortalClick() }
    }

    private fun onAddPortalClick() {
        val portalTitle = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        if (portalTitle.isNotBlank() && portalUrl.isNotBlank()) {
            val portal = Portal(portalTitle, portalUrl)
            val resultIntent = Intent()
            resultIntent.putExtra(PORTAL_EXTRA, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this, EMPTY_FIELDS, Toast.LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else ->return super.onOptionsItemSelected(item)
        }
    }

}

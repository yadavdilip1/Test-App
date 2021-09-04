package com.example.testapp.utils

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun Fragment.snackbar(message: String) {
    Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError -> {
            snackbar(
                "Please check your internet connection"
            )
            val error = failure.errorBody?.string().toString()
            Log.e("Error",error)
        }
        else -> {
            val error = failure.errorBody?.string().toString()
            snackbar(error)
        }
    }

}


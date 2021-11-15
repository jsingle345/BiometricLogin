package com.example.citizenslogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import com.example.citizenslogin.R
import com.example.citizenslogin.common.BiometricAuthListener
import com.example.citizenslogin.util.BiometricUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), BiometricAuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        showBiometricLoginOption()
    }

    fun onClickLogin(view: View) {
        navigateToHomeActivity()
    }

    fun onClickBiometrics(view: View) {
        BiometricUtil.showBiometricPrompt(
            activity = this,
            listener = this,
            cryptoObject = null,
            allowDeviceCredential = true
        )
    }

    override fun onBiometricAuthenticationSuccess(result: BiometricPrompt.AuthenticationResult) {
        navigateToHomeActivity()
    }

    override fun onBiometricAuthenticationError(errorCode: Int, errorMessage: String) {
        Toast.makeText(this, "Biometric login failed. Error: $errorMessage", Toast.LENGTH_LONG)
            .show()
    }

    private fun navigateToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    fun showBiometricLoginOption() {
        buttonBiometricsLogin.visibility =
            if (BiometricUtil.isBiometricReady(this)) View.VISIBLE
            else View.GONE

        rememberMe.visibility =
            if (BiometricUtil.isBiometricReady(this)) View.GONE
            else View.VISIBLE

        rememberMeSwitch.visibility =
            if (BiometricUtil.isBiometricReady(this)) View.GONE
            else View.VISIBLE
    }
}
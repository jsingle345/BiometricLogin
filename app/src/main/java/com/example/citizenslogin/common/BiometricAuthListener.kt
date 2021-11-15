package com.example.citizenslogin.common

import androidx.biometric.BiometricPrompt

//  Interface to listen to Biometric Authentication callbacks

interface BiometricAuthListener {
    fun onBiometricAuthenticationSuccess(result: BiometricPrompt.AuthenticationResult)
    fun onBiometricAuthenticationError(errorCode: Int, errorMessage: String)
}
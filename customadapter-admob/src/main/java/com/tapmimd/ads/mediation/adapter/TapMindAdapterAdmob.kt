package com.tapmimd.ads.mediation.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.VersionInfo
import com.google.android.gms.ads.mediation.Adapter
import com.google.android.gms.ads.mediation.InitializationCompleteCallback
import com.google.android.gms.ads.mediation.MediationAdLoadCallback
import com.google.android.gms.ads.mediation.MediationAppOpenAd
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration
import com.google.android.gms.ads.mediation.MediationBannerAd
import com.google.android.gms.ads.mediation.MediationBannerAdCallback
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration
import com.google.android.gms.ads.mediation.MediationConfiguration
import com.google.android.gms.ads.mediation.MediationInterstitialAd
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration
import com.google.android.gms.ads.mediation.MediationNativeAdCallback
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration
import com.google.android.gms.ads.mediation.MediationRewardedAd
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration
import com.google.android.gms.ads.mediation.NativeAdMapper

class TapMindAdapterAdmob() : Adapter() {

    private val TAG = "APP@@@"
    private val TAG1 = "TapMindAdapterAdmob"

    override fun initialize(context: Context, initializationCallback: InitializationCompleteCallback, mediationConfigurations: List<MediationConfiguration>) {
        initializationCallback.onInitializationSucceeded()
//        Log.d(TAG, "$TAG1 initialize")

//        val request = object : TapMindsAdapterInitializationParameters{
//            override fun getAdUnitId(): String {
//                return ""
//
//            }
//        }
//
//        TapMindFacebookAdapter.initialize(request,context,object : TapMindsAdapter.OnCompletionListener{
//            override fun onCompletion(var1: TapMindsAdapter.InitializationStatus?, var2: String?) {
//                Log.d(TAG, "$TAG1 initializee")
//
//                initializationCallback.onInitializationSucceeded()
//            }
//        })


    }

    override fun getVersionInfo(): VersionInfo {
        // Your adapter version (you define this)
        val major = 1
        val minor = 0
        val micro = 0
        return VersionInfo(major, minor, micro)
    }

    override fun getSDKVersionInfo(): VersionInfo {
        // The SDK version of your internal TapMind SDK
        val version = "1.2.3" // example: replace with your SDK version

        val parts = version.split(".")
        val major = parts.getOrNull(0)?.toIntOrNull() ?: 1
        val minor = parts.getOrNull(1)?.toIntOrNull() ?: 0
        val micro = parts.getOrNull(2)?.toIntOrNull() ?: 0

        return VersionInfo(major, minor, micro)
    }


    override fun loadBannerAd(
        adConfig: MediationBannerAdConfiguration,
        callback: MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback>
    ) {
        Log.d(TAG, "$TAG1 loadBannerAd")
        val data = SampleBannerCustomEventLoader.getInstance(adConfig,callback)
        data.loadAdd()
    }

    override fun loadNativeAdMapper(
        p0: MediationNativeAdConfiguration,
        p1: MediationAdLoadCallback<NativeAdMapper?, MediationNativeAdCallback?>
    ) {
        Log.d(TAG, "$TAG1 loadNativeAdMapper")
        SampleNativeCustomEventLoader.getInstance(p0,p1).loadAd()
    }



    override fun loadInterstitialAd(
        adConfig: MediationInterstitialAdConfiguration,
        callback: MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback>
    ) {
        Log.d(TAG, "$TAG1 loadInterstitialAd")
        val loader = SampleInterstitialCustomEventLoader(adConfig, callback)
        loader.loadAd()
    }


    override fun loadAppOpenAd(
        p0: MediationAppOpenAdConfiguration,
        callback: MediationAdLoadCallback<MediationAppOpenAd?, MediationAppOpenAdCallback?>
    ) {
        Log.d(TAG, "$TAG1 loadAppOpenAd")
    }

    override fun loadRewardedAd(
        adConfig: MediationRewardedAdConfiguration,
        callback: MediationAdLoadCallback<MediationRewardedAd?, MediationRewardedAdCallback?>
    ) {
        Log.d(TAG, "$TAG1 loadRewardedAd")
        val data = SampleRewardedCustomEventLoader.getInstance(adConfig,callback!!)
        data.loadAd()

    }


    override fun loadRewardedInterstitialAd(
        p0: MediationRewardedAdConfiguration,
        callback: MediationAdLoadCallback<MediationRewardedAd?, MediationRewardedAdCallback?>
    ) {
        Log.d(TAG, "$TAG1 loadRewardedInterstitialAd")
    }
}
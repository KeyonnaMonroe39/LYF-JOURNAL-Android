@file:Suppress("DEPRECATION")
package com.keyonnamonroe.lyfjournal.framework.android.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.telephony.TelephonyManager
import com.keyonnamonroe.lyfjournal.framework.android.R
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger

private const val NETWORK_WEAK = "[MOBILE DATA] WEAK: "
private const val NETWORK_STRONG = "[MOBILE DATA] STRONG: "

// network speed constants
private const val SPEED_KBPS_50_100 = "~50-100 Kbps"
private const val SPEED_KBPS_14_64 = "~14-64 Kbps"
private const val SPEED_KBPS_400_1000 = "~400-1000 Kbps"
private const val SPEED_KBPS_600_1400 = "~600-1400 Kbps"
private const val SPEED_KBPS_100 = "~100 Kbps"
private const val SPEED_KBPS_700_1700 = "~700-1700 Kbps"
private const val SPEED_KBPS_400_7000 = "~400-7000 Kbps"
private const val SPEED_KBPS_25 = "~25 Kbps"
private const val SPEED_MBPS_2_14 = "~2-14 Mbps"
private const val SPEED_MBPS_1_23 = "~1-23 Mbps"
private const val SPEED_MBPS_1_2 = "~1-2 Mbps"
private const val SPEED_MBPS_5 = "~5 Mbps"
private const val SPEED_MBPS_10_20 = "~10-20 Mbps"
private const val SPEED_MBPS_10 = "~10+ Mbps"
private const val SPEED_UNKNOWN = "No Network Info"

internal object NetworkUtils {
    private val TAG = NetworkUtils::class.java.simpleName

    /**
     * Method [isConnected] is used to check is network is available e.g.
     * both connected and available.
     *
     * @param context Interface to global information about an application environment.
     * @return True if network is available, otherwise false.
     */
    private fun isConnected(context: Context): Boolean {
        // Class that answers queries about the state of network connectivity.
        // It also notifies applications when network connectivity changes.
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        connectivityManager.run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                    // Returns a Network object corresponding to the currently active default
                    // data network. In the event that the current active default data network
                    // disconnects, the returned Network object will no longer be usable.
                    // This will return null when there is no default network.
                    return hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                }
            } else {
                // Returns details about the currently active default data network.
                // When connected, this network is the default route for outgoing connections.
                // You should always check NetworkInfo.isConnected() before initiating network
                // traffic. This may return null when there is no default network. Note that if
                // the default network is a VPN, this method will return the NetworkInfo for
                // one of its underlying networks instead, or null if the VPN agent did
                // not specify any.
                return connectivityManager.activeNetworkInfo != null &&
                        connectivityManager.activeNetworkInfo?.isConnected == true
            }
        }
        Logger.i(TAG, "No Connection")
        return false
    }

    /**
     * Get network speeds.
     *
     * @param context Interface to global information about an application environment.
     * @return Approximation of network speed.
     */
    fun getNetworkSpeed(
        context: Context
    ): String {
        if (!isConnected(context)) {
            return SPEED_UNKNOWN
        }

        // method is used to get the network info
        val info = getNetworkInfo(context)
        val type = info?.type ?: ConnectivityManager.TYPE_WIFI
        val subType = info?.subtype ?: SPEED_UNKNOWN

        when (type) {
            ConnectivityManager.TYPE_WIFI -> {
                val wifiManager = context.applicationContext.getSystemService(
                    Context.WIFI_SERVICE
                ) as WifiManager
                val wifiInfo: WifiInfo = wifiManager.connectionInfo
                return context.getString(R.string.wifi_network_speed, wifiInfo.linkSpeed.toString())
            }
            ConnectivityManager.TYPE_MOBILE -> {
                when (subType) {
                    TelephonyManager.NETWORK_TYPE_1xRTT -> {
                        // ~50-100 Kbps
                        return "$NETWORK_WEAK$SPEED_KBPS_50_100"
                    }
                    TelephonyManager.NETWORK_TYPE_CDMA -> {
                        // ~14-64 Kbps
                        return "$NETWORK_WEAK$SPEED_KBPS_14_64"
                    }
                    TelephonyManager.NETWORK_TYPE_EDGE -> {
                        // ~50-100 Kbps
                        return "$NETWORK_WEAK$SPEED_KBPS_50_100"
                    }
                    TelephonyManager.NETWORK_TYPE_EVDO_0 -> {
                        // ~400-1000 Kbps
                        return "$NETWORK_STRONG$SPEED_KBPS_400_1000"
                    }
                    TelephonyManager.NETWORK_TYPE_EVDO_A -> {
                        // ~600-1400 Kbps
                        return "$NETWORK_STRONG$SPEED_KBPS_600_1400"
                    }
                    TelephonyManager.NETWORK_TYPE_GPRS -> {
                        // ~100 Kbps
                        return "$NETWORK_WEAK$SPEED_KBPS_100"
                    }
                    TelephonyManager.NETWORK_TYPE_HSDPA -> {
                        // ~2-14 Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_2_14"
                    }
                    TelephonyManager.NETWORK_TYPE_HSPA -> {
                        // ~700-1700 Kbps
                        return "$NETWORK_STRONG$SPEED_KBPS_700_1700"
                    }
                    TelephonyManager.NETWORK_TYPE_HSUPA -> {
                        // ~1-23 Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_1_23"
                    }
                    TelephonyManager.NETWORK_TYPE_UMTS -> {
                        // ~400-7000 Kbps
                        return "$NETWORK_STRONG$SPEED_KBPS_400_7000"
                    }
                    /*
                     * Above API level 7, make sure to set android:targetSdkVersion
                     * to appropriate level to use these
                     */
                    TelephonyManager.NETWORK_TYPE_EHRPD -> {
                        // API level 11
                        // ~1-2 Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_1_2"
                    }
                    TelephonyManager.NETWORK_TYPE_EVDO_B -> {
                        // API level 9
                        // ~5 Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_5"
                    }
                    TelephonyManager.NETWORK_TYPE_HSPAP -> {
                        // API level 13
                        // ~10-20 Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_10_20"
                    }
                    TelephonyManager.NETWORK_TYPE_IDEN -> {
                        // API level 8
                        // ~25 Kbps
                        return "$NETWORK_WEAK$SPEED_KBPS_25"
                    }
                    TelephonyManager.NETWORK_TYPE_LTE -> {
                        // API level 11
                        // ~10+ Mbps
                        return "$NETWORK_STRONG$SPEED_MBPS_10"
                    }
                    // Unknown
                    else -> return SPEED_UNKNOWN
                }
            }
            else -> {
                return SPEED_UNKNOWN
            }
        }
    }

    /**
     * Method is used to get the network info.
     *
     * @param context Interface to global information about an application environment.
     * @return Details about the currently active default data network.
     */
    private fun getNetworkInfo(
        context: Context
    ): NetworkInfo? {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        return connectivityManager.activeNetworkInfo
    }
}
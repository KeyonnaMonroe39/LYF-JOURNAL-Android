package com.keyonnamonroe.lyfjournal.framework.android.utils

import com.keyonnamonroe.lyfjournal.framework.android.constants.Constants
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

internal object Utils {
    private const val DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss"

    /**
     * Method is used to get formatted date and time.
     *
     * @return Current date and time.
     */
    val currentDateTime: String
        get() {
            val calendar = Calendar.getInstance()
            val formatter = SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT, Locale.US)
            return formatter.format(calendar.time)
        }

    /**
     * Method is used to compare a start date and end date, and confirm that the start date
     * is at least x-min before the end date.
     *
     * @param startDate String Start date/time.
     * @param endDate String End date/time.
     * @param timeDifference Int x-min representing the desired time difference between the
     * start and end dates.
     * @return [Boolean] True if time difference is x-min.
     */
    fun isTimeDifferenceValid(
        startDate: String,
        endDate: String,
        timeDifference: Int
    ): Boolean {
        val calStartDate = Calendar.getInstance()
        val calEndDate = Calendar.getInstance()
        val formatter = SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT, Locale.US)

        try {
            // set calendar object date/time
            calStartDate.time = formatter.parse(startDate) as Date
            calEndDate.time = formatter.parse(endDate) as Date
            // add time difference requirement
            calStartDate.add(Calendar.MINUTE, timeDifference)
            return calStartDate.before(calEndDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
        }
        return false
    }

    /**
     * Method is used to sanitize urls.
     *
     * <p>Add `https` if omitted.</p>
     *
     * @param url String The url to sanitize.
     * @return String The url with proper form.
     */
    fun sanitizeUrl(url: String): String {
        return url.let {
            if (!it.endsWith("/")) {
                "$it/"
            } else {
                it
            }
        }.let {
            if (it.startsWith("http://") || it.startsWith("https://")) {
                it
            } else {
                "https://$it"
            }
        }
    }
}
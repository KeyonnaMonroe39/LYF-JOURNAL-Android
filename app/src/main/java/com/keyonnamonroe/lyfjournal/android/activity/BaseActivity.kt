package com.keyonnamonroe.lyfjournal.android.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.keyonnamonroe.lyfjournal.android.R
import com.keyonnamonroe.lyfjournal.framework.android.constants.Constants
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    // the FragmentManager for interacting with fragments associated with this activity
    private var fragmentManager: FragmentManager = supportFragmentManager

    /**
     * Method is used to add fragment to the current stack using container id
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity
     * @param containerViewId Identifier of the container this fragment is to be placed in.
     * If 0, it will not be placed in a container.
     */
    protected fun addFragment(
        fragment: Fragment,
        containerViewId: Int
    ) {
        // check if the fragment has been added already
        val temp = fragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if (temp != null && temp.isAdded) {
            return
        }

        // add fragment and transition with animation
        val transaction = fragmentManager.beginTransaction().setCustomAnimations(
            R.anim.slide_in_from_bottom,
            R.anim.slide_out_to_bottom,
            R.anim.slide_in_from_bottom,
            R.anim.slide_out_to_bottom
        ).add(
            containerViewId,
            fragment,
            fragment.javaClass.simpleName
        ).addToBackStack(fragment.javaClass.simpleName)
        try {
            transaction.commit()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
            transaction.commitAllowingStateLoss()
        }
    }

    /**
     * Method is used to retrieve the current fragment the user is on
     *
     * @return Returns the TopFragment if there is one, otherwise returns null
     */
    val topFragment: Fragment?
        get() {
            return if (fragmentManager.fragments.isNotEmpty()) {
                fragmentManager.fragments[0]
            } else {
                null
            }
        }

    /**
     * Method is used to pop the top state off the back stack by name
     */
    protected fun popBackStack(name: String?) {
        fragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    /**
     * Method is used to re-direct to a different Activity with no transition.
     *
     * @param context Interface to global information about an application environment.
     * @param activity The in-memory representation of a Java class.
     * @param intent An intent is an abstract description of an operation to be performed.
     * @param isClearBackStack True to clear Activity backstack, otherwise false.
     */
    protected fun goToActivity(
        context: Context,
        activity: Class<*>,
        intent: Intent?,
        isClearBackStack: Boolean? = false
    ) {
        // handle null intent case. Instantiate without any special properties
        val i: Intent = intent ?: Intent(context, activity)
        if (isClearBackStack == true) {
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        } else {
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        startActivity(i)
    }
}

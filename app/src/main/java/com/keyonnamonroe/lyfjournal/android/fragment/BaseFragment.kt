/**
 * Copyright 2013-present Tatum Games, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keyonnamonroe.lyfjournal.android.fragment

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.keyonnamonroe.lyfjournal.android.R
import com.keyonnamonroe.lyfjournal.framework.android.constants.Constants
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger

open class BaseFragment : Fragment() {

    /**
     * Listener that will be executed when the current fragment
     * is removed form the screen.
     */
    private var onRemoveFragmentListener: OnRemoveFragmentListener? = null

    /**
     * Set [onRemoveFragmentListener] used for inheritance.
     *
     * @param onRemoveFragmentListener The Fragment to be removed.
     */
    internal fun setOnRemoveListener(onRemoveFragmentListener: OnRemoveFragmentListener) {
        this.onRemoveFragmentListener = onRemoveFragmentListener
    }

    /**
     * Interface used to perform any action require after removing the current fragment.
     */
    interface OnRemoveFragmentListener {
        /**
         * This method will be called when the current fragment is removed
         * from the screen.
         */
        fun onRemoveFragment()
    }

    override fun onDetach() {
        super.onDetach()
        onRemoveFragmentListener?.onRemoveFragment()
        onRemoveFragmentListener = null
    }

    /**
     * Method is used to add fragment to the current stack using container id.
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param containerViewId Identifier of the container this fragment is to be placed in.
     * If 0, it will not be placed in a container.
     */
    protected fun addFragment(
        fragment: Fragment,
        containerViewId: Int
    ) {
        // check if the fragment has been added already
        val temp = activity?.supportFragmentManager?.findFragmentByTag(
            fragment.javaClass.simpleName
        )
        if (temp?.isAdded == true) {
            return
        }

        // add fragment and transition with animation
        val transaction = activity?.supportFragmentManager?.beginTransaction()?.setCustomAnimations(
            R.anim.slide_in_from_bottom,
            R.anim.slide_out_to_bottom,
            R.anim.slide_in_from_bottom,
            R.anim.slide_out_to_bottom
        )?.add(
            containerViewId,
            fragment,
            fragment.javaClass.simpleName
        )?.addToBackStack(fragment.javaClass.simpleName)
        try {
            transaction?.commit()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
            transaction?.commitAllowingStateLoss()
        }
    }

    /**
     * Method is used to pop the top state off the back stack. Returns true if there
     * was one to pop, else false. This function is asynchronous -- it enqueues the
     * request to pop, but the action will not be performed until the application
     * returns to its event loop.
     */
    protected fun popBackStack() {
        try {
            activity?.supportFragmentManager?.popBackStack()
        } catch (e: Exception) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
        }
    }

    /**
     * Method for removing the Fragment view.
     */
    protected fun remove() {
        try {
            val ft = activity?.supportFragmentManager?.beginTransaction()
            ft?.setCustomAnimations(
                R.anim.slide_in_from_bottom,
                R.anim.slide_out_to_bottom
            )
            ft?.remove(this)?.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
        }
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

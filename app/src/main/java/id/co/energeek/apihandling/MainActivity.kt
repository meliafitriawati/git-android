package id.co.energeek.apihandling

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mProgressDialog = ProgressDialog(this)

        apiTesting()
    }

    private fun apiTesting() {
        showLoading()

        val apiService = ApiClient.getClient().create(ApiInterfaces::class.java)
        apiService
            .mixResp()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { hideLoading() }
            .subscribe(
                { resp ->
                    hideLoading()
                    Log.e("main_activity:success ", resp.toString())
                    showResponse(resp)
                },
                { error ->
                    hideLoading()
                    Log.e("main_activity:error ", error.message)
                }
            )
    }

    private fun showResponse(resp: ApiResp) {
        for (i in resp.data){
            try {
                Log.e("main_activity:success ",i.id.toString() + " " + i.type + " " + i.attributes.isAvailable.toString())
            } catch (e: Exception) {
                Log.e("main_activity:error ", e.message)
            }
        }
    }

    fun showLoading() {
        mProgressDialog?.setMessage("Loading")
        mProgressDialog?.show()
    }

    fun hideLoading() {
        mProgressDialog?.setMessage("Loading")
        mProgressDialog?.hide()
    }
}

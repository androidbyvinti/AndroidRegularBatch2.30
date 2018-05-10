package fetchingjson.bmpl.com.fetchingjson

import android.util.Log

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL

class HttpHandler {

    fun makeServiceCall(reqUrl: String): String? {
        var response: String? = null
        try {

            val url = URL(reqUrl)//step-1: url passed to URL class
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"   // request get

            val `in` = BufferedInputStream(conn.inputStream) // StringBuilder or StringBuffer--> modification string
            response = convertStreamToString(`in`)

        } catch (e: MalformedURLException) {
            Log.e(TAG, "MalformedURLException: " + e.message)
        } catch (e: ProtocolException) {
            Log.e(TAG, "ProtocolException: " + e.message)
        } catch (e: IOException) {
            Log.e(TAG, "IOException: " + e.message)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: " + e.message)
        }

        return response
    }

    private fun convertStreamToString(`is`: InputStream): String {
        val reader = BufferedReader(InputStreamReader(`is`))
        val sb = StringBuilder()

        var line: String
        try {
            while ((line = reader.readLine()) != null) {// --> '\0'
                sb.append(line).append('\n')
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return sb.toString()
    }

    companion object {

        private val TAG = "HttpHandler.this"
    }
}

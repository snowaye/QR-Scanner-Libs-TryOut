package mm.com.solutionbasket.qrlibstryout

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.SparseArray
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic
import com.google.android.gms.vision.barcode.Barcode
import kotlinx.android.synthetic.main.activity_main.*
import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever

class MainActivity : AppCompatActivity(), BarcodeRetriever {

    private val permissionCode = 1000
    private lateinit var barcodeCapture: BarcodeCapture


    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var etScanResult: EditText
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etScanResult = etScan
        setupUI()
        setupListener()
    }

    private fun setupUI() {
//        btnZxing = findViewById<Button>(R.id.btnZxing)
//        btnCodeScanner = findViewById<Button>(R.id.btnCodeScanner)
//        btnReaderView = findViewById<Button>(R.id.btnReaderView)
//        btnReader = findViewById<Button>(R.id.btnQrReader)
//        btnQrParse = findViewById<Button>(R.id.btnQrParse)
//        btnFirebase = findViewById<Button>(R.id.btnFirebaseQr)
//        btnMobileVision = findViewById<Button>(R.id.btnMobileVision)
    }

    private fun setupListener() {
        btnZxing.setOnClickListener {
            scanByZxing()
        }
        btnCodeScanner.setOnClickListener {
            scanByCodeScanner()
        }
        btnReaderView.setOnClickListener {
            scanByReaderView()
        }
        btnQrReader.setOnClickListener {
            scanByReader()
        }
        btnQrParse.setOnClickListener {
            scanByQrParse()
        }
//        btnFirebaseQr.setOnClickListener {
//            scanByFirebaseQR()
//        }
        btnMobileVision.setOnClickListener {
            scanByMobileVision()
        }
    }

    private fun isPermissionGranted(): Boolean {
        return if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                permissionCode
            )
            return false
        } else {
           true
        }
    }

    private fun scanByZxing() {
        if (isPermissionGranted())
            startActivity(Intent(this, ZxingActivity::class.java))
    }

    private fun scanByCodeScanner() {
        if (isPermissionGranted())
            startActivity(Intent(this, CodeScannerActivity::class.java))
    }

    private fun scanByReaderView() {
        if (isPermissionGranted())
            startActivity(Intent(this, QrReaderViewActivity::class.java))
    }

    private fun scanByReader() {
        if (isPermissionGranted())
            startActivity(Intent(this, QrReaderActivity::class.java))
    }

    private fun scanByQrParse() {
        startActivity(Intent(this, ZxingActivity::class.java))
    }

    private fun scanByFirebaseQR() {
        //startActivity(Intent(this, MLScannerActivity::class.java))
    }

    private fun scanByMobileVision() {
        if (isPermissionGranted()) {
            barcodeCapture = supportFragmentManager.findFragmentById(R.id.barcode) as BarcodeCapture
            barcodeCapture.setRetrieval(this)
            fragmentLayout.visibility = VISIBLE
            normalLayout.visibility = GONE
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == permissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED
            ) {
                //permission from popup was granted
                //openCamera()
            } else {
                //permission from popup was denied
                val info = getString(R.string.lbl_permission_denied)
                Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRetrieved(barcode: Barcode?) {
        Handler(Looper.getMainLooper()).postDelayed({
            Log.i("MobileVis", "scanResult=${barcode?.displayValue}")
            etScan.setText("")
            etScan.setText(barcode?.displayValue)
            fragmentLayout.visibility = GONE
            normalLayout.visibility = VISIBLE

        }, 1000)
    }





    override fun onRetrievedMultiple(
        closetToClick: Barcode?,
        barcode: MutableList<BarcodeGraphic>?
    ) {

    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>?) {

    }

    override fun onRetrievedFailed(reason: String?) {

    }

    override fun onPermissionRequestDenied() {

    }
}
package mm.com.solutionbasket.qrlibstryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import github.nisrulz.qreader.QRDataListener
import github.nisrulz.qreader.QREader
import kotlinx.android.synthetic.main.activity_qr_reader.*

class QrReaderActivity : AppCompatActivity() {
    private lateinit var qrReader: QREader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_reader)
        qrReader = QREader.Builder(this, camera_view
        ) { text ->
            runOnUiThread {
                MainActivity.etScanResult.setText("")
                MainActivity.etScanResult.setText(text)
                finish()
            }
        }
            .facing(QREader.BACK_CAM)
            .enableAutofocus(true)
            .height(camera_view.height)
            .width(camera_view.width)
            .build()
    }

    override fun onResume() {
        super.onResume()
        qrReader.initAndStart(camera_view)
    }

    override fun onPause() {
        super.onPause()
        qrReader.releaseAndCleanup()
    }
}
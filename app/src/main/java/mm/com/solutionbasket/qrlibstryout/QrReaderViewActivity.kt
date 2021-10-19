package mm.com.solutionbasket.qrlibstryout


import android.graphics.PointF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import com.dlazaro66.qrcodereaderview.QRCodeReaderView.OnQRCodeReadListener
import kotlinx.android.synthetic.main.activity_qr_reader_view.*


class QrReaderViewActivity : AppCompatActivity(), OnQRCodeReadListener{

    private lateinit var qrCodeReaderView: QRCodeReaderView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_reader_view)
        qrCodeReaderView = qr

        qrCodeReaderView.setOnQRCodeReadListener(this)

        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true)

        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(2000L)

        // Use this function to enable/disable Torch
        qrCodeReaderView.setTorchEnabled(true)

        // Use this function to set front camera preview
        qrCodeReaderView.setFrontCamera()

        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera()
    }

    // Called when a QR is decoded
    // "text" : the text encoded in QR
    // "points" : points where QR control points are placed in View
    override fun onQRCodeRead(text: String, points: Array<PointF>) {
        MainActivity.etScanResult.setText("")
        MainActivity.etScanResult.setText(text)
        finish()
    }

    override fun onResume() {
        super.onResume()
        qrCodeReaderView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        qrCodeReaderView.stopCamera()
    }


}
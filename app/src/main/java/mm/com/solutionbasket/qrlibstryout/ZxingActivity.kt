package mm.com.solutionbasket.qrlibstryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ZxingActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var mScannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZXingScannerView(this)   // Programmatically initialize the scanner view
        setContentView(mScannerView)
        mScannerView.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView.startCamera()
    }

    override fun handleResult(rawResult: Result) {
        val result = rawResult.text.toString()
        MainActivity.etScanResult.setText("")
        MainActivity.etScanResult.setText(result)
        finish()
    }
}
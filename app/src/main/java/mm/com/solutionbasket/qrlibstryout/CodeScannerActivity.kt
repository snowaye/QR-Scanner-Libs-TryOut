package mm.com.solutionbasket.qrlibstryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.budiyev.android.codescanner.CodeScanner
import kotlinx.android.synthetic.main.activity_code_scanner.*

class CodeScannerActivity : AppCompatActivity() {
    private lateinit var mCodeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_scanner)
        mCodeScanner = CodeScanner(this, scanner_view)
        mCodeScanner.startPreview()
        mCodeScanner.setDecodeCallback {
            runOnUiThread {
                Log.i("Yuidev", "text=${it.text}")
                MainActivity.etScanResult.setText("")
                MainActivity.etScanResult.setText(it.text)
                finish()
                //Toast.makeText(this@YuidevScannerActivity, it.text, Toast.LENGTH_LONG).show() }
            }
        }
    }
}
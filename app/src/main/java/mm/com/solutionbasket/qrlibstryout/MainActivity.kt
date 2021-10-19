package mm.com.solutionbasket.qrlibstryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var btnZxing: Button
    lateinit var btnCodeScanner: Button
    lateinit var btnReaderView: Button
    lateinit var btnReader: Button
    lateinit var btnQrParse: Button
    lateinit var btnFirebase: Button
    lateinit var btnMobileVision: Button
    lateinit var etScanResult: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupListener()
    }

    private fun setupUI() {
        etScanResult = findViewById(R.id.etScanResult)
        btnZxing = findViewById<Button>(R.id.btnZxing)
        btnCodeScanner = findViewById<Button>(R.id.btnCodeScanner)
        btnReaderView = findViewById<Button>(R.id.btnReaderView)
        btnReader = findViewById<Button>(R.id.btnQrReader)
        btnQrParse = findViewById<Button>(R.id.btnQrParse)
        btnFirebase = findViewById<Button>(R.id.btnFirebaseQr)
        btnMobileVision = findViewById<Button>(R.id.btnMobileVision)
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
        btnReader.setOnClickListener {
            scanByReader()
        }
        btnQrParse.setOnClickListener {
            scanByQrParse()
        }
        btnFirebase.setOnClickListener {
            scanByFirebaseQR()
        }
        btnMobileVision.setOnClickListener {
            scanByMobileVision()
        }
    }

    private fun scanByZxing() {

    }

    private fun scanByCodeScanner() {

    }

    private fun scanByReaderView() {

    }

    private fun scanByReader() {

    }

    private fun scanByQrParse() {

    }

    private fun scanByFirebaseQR() {

    }

    private fun scanByMobileVision() {

    }
}
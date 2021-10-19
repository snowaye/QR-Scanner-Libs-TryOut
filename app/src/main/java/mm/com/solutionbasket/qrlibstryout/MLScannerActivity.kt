package mm.com.solutionbasket.qrlibstryout

import androidx.appcompat.app.AppCompatActivity

//
//import android.Manifest
//import android.app.Activity
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Environment
//import android.provider.MediaStore
//import android.util.Log
//import android.widget.Toast
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.core.content.FileProvider
//import com.google.firebase.ml.vision.FirebaseVision
//import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode
//import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions
//import com.google.firebase.ml.vision.common.FirebaseVisionImage
//import kotlinx.android.synthetic.main.activity_m_l_scanner.*
//import java.io.File
//import java.io.IOException
//import java.text.SimpleDateFormat
//import java.util.*
//
//
class MLScannerActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_m_l_scanner)
//        btnCapture.setOnClickListener {
//            captureImage()
//        }
//    }
//
//    private fun captureImage() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.CAMERA
//            )
//            != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//            )
//            != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//        ) {
//            Log.i("UploadNrc", "no camera permission")
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(
//                    android.Manifest.permission.CAMERA,
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                    Manifest.permission.READ_EXTERNAL_STORAGE
//                ),
//                100
//            )
//        } else {
//            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
//                // Ensure that there's a camera activity to handle the intent
//                takePictureIntent.resolveActivity(this.packageManager)?.also {
//                    // Create the File where the photo should go
//                    val photoFile: File? = try {
//                        createImageFileFront()
//                    } catch (ex: IOException) {
//                        // Error occurred while creating the File
//                        null
//                    }
//                    // Continue only if the File was successfully created
//                    photoFile?.also {
//                        val photoURI: Uri = FileProvider.getUriForFile(
//                            this,
//                            FILE_PROVIDER,
//                            it
//                        )
//                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//                        takePictureIntent.putExtra("crop", "true")
//                        takePictureIntent.putExtra("aspectX", 4)
//                        takePictureIntent.putExtra("aspectY", 3)
//                        takePictureIntent.putExtra("outputX", 1366)
//                        takePictureIntent.putExtra("outputY", 768)
//                        takePictureIntent.putExtra("noFaceDetection", true)
//                        startActivityForResult(takePictureIntent, 10)
//                    }
//                }
//            }
//        }
//    }
//
//    @Throws(IOException::class)
//    private fun createImageFileFront(): File {
//        // Create an image file name
//        //frontPath = ""
//        val timeStamp: String = SimpleDateFormat("yyyyMMdd_hhmmss").format(Date())
//        val storageDir: File = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
//
//        return File.createTempFile(
//            "front_JPEG_${timeStamp}", /* prefix */
//            ".jpg", /* suffix */
//            storageDir /* directory */
//        ).apply {
//            // Save a file: path for use with ACTION_VIEW intents
//            //frontPath = absolutePath
//        }
//    }
//
//    private fun getQRCodeDetails(bitmap: Bitmap) {
//        val options = FirebaseVisionBarcodeDetectorOptions.Builder()
//            .setBarcodeFormats(
//                FirebaseVisionBarcode.FORMAT_ALL_FORMATS)
//            .build()
//        val detector = FirebaseVision.getInstance().getVisionBarcodeDetector(options);
//        val image = FirebaseVisionImage.fromBitmap(bitmap)
//        detector.detectInImage(image)
//            .addOnSuccessListener {
//                for (firebaseBarcode in it) {
//                    Log.i("ML Scanner", "resultData=${firebaseBarcode.displayValue}")
//                    MainActivity.etScanResult.setText("")
//                    MainActivity.etScanResult.setText(firebaseBarcode.displayValue.toString())
//                    //codeData.text = firebaseBarcode.displayValue //Display contents inside the barcode
//                    //sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//                }
//            }
//            .addOnFailureListener {
//                it.printStackTrace()
//                Toast.makeText(baseContext, "Sorry, something went wrong!", Toast.LENGTH_SHORT).show()
//            }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            if (resultCode == 10) {
//                val bitmap = getBitmapFromUri(data?.data!!)
//                getQRCodeDetails(bitmap)
//            }
//        }
//    }
//
//    @Throws(IOException::class)
//    private fun getBitmapFromUri(uri: Uri): Bitmap {
//        val parcelFileDescriptor = this.contentResolver.openFileDescriptor(uri, "r")
//        val fileDescriptor = parcelFileDescriptor?.fileDescriptor
//        val image: Bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)
//        parcelFileDescriptor?.close()
//        return image
//    }
}
package com.example.monpiss;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityFileKC extends AppCompatActivity implements View.OnClickListener {

    public static final String KODE_CABANG = "kode_cabang";
    public static final String KODE_IMAGE1 = "kode_image1";
    public static final String KODE_IMAGE2 = "kode_image2";
    public static final String KODE_IMAGE3 = "kode_image3";
    public static final String KODE_DATA1 = "kode_data1";
    public static final String KODE_DATA2 = "kode_data2";
    public static final String KODE_DATA3 = "kode_data3";
    public static final String KODE_HASIL = "kode_hasil";

    public ImageView  imgFileParkir1, imgFileParkir2, imgFileParkir3;
    private ImageView imgBack, imgDownloadFile;
    public TextView nameReport, mStandar1, mStandar2, mStandar3, mHasilMonitoring, mDate;
    Bitmap bitmap, scaleBitmap;
    int pageWidth = 1200;
    String dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_kc);

        imgDownloadFile = findViewById(R.id.download_fileKC);
        imgBack = findViewById(R.id.back_layoutkc);
        nameReport = findViewById(R.id.name_file_kc);
        imgFileParkir1 = findViewById(R.id.img_fileparkir1);
        imgFileParkir2 = findViewById(R.id.img_fileparkir2);
        imgFileParkir3 = findViewById(R.id.img_fileparkir3);
        mStandar1 = findViewById(R.id.standar_tidakStandar1);
        mStandar2 = findViewById(R.id.standar_tidakStandar2);
        mStandar3 = findViewById(R.id.standar_tidakStandar3);
        mHasilMonitoring = findViewById(R.id.hasil_report);
        mDate = findViewById(R.id.date);

        imgDownloadFile.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        String mKodeCabang = getIntent().getStringExtra(KODE_CABANG);
        int mImg1 = getIntent().getIntExtra(KODE_IMAGE1, 0);
        int mImg2 = getIntent().getIntExtra(KODE_IMAGE2,0);
        int mImg3 = getIntent().getIntExtra(KODE_IMAGE3, 0);
        String mStandarTidak1 = getIntent().getStringExtra(KODE_DATA1);
        String mStandarTidak2 = getIntent().getStringExtra(KODE_DATA2);
        String mStandarTidak3 = getIntent().getStringExtra(KODE_DATA3);
        String mHasil = getIntent().getStringExtra(KODE_HASIL);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy");
        dateTime = dateFormat.format(calendar.getTime());


        nameReport.setText(mKodeCabang);
        imgFileParkir1.setImageResource(mImg1);
        imgFileParkir2.setImageResource(mImg2);
        imgFileParkir3.setImageResource(mImg3);
        mStandar1.setText(mStandarTidak1);
        mStandar2.setText(mStandarTidak2);
        mStandar3.setText(mStandarTidak3);
        mHasilMonitoring.setText(mHasil);
        mDate.setText(dateTime);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layoutkc:
                finish();
                break;
            case R.id.download_fileKC:
                createPDF();
                break;
        }
    }

    private void createPDF(){

        if (nameReport.getText().toString().length() == 0 ||
                mDate.getText().toString().length() == 0 ||
                mHasilMonitoring.getText().toString().length() == 0 ||
                mStandar1.getText().toString().length() == 0 ||
                mStandar2.getText().toString().length() == 0 ||
                mStandar3.getText().toString().length() == 0 ){
            Toast.makeText(ActivityFileKC.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {

            PdfDocument pdfDocument = new PdfDocument();
            Paint paint = new Paint();
            Paint titlePaint = new Paint();

            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);

            Canvas canvas = page.getCanvas();
            //canvas.drawBitmap(scaleBitmap, 0, 0, paint);

            canvas.drawText("Laporan Monitoring : " + nameReport.getText(), 20, 590, paint);
            canvas.drawText("Tanggal : " + mDate.getText(), 20,640, paint);
            canvas.drawText("Hasil : " + mHasilMonitoring.getText(), 20, 690, paint);

            titlePaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Parkir", pageWidth / 2, 740, titlePaint);

            canvas.drawText("" + mStandar1.getText(), 20, 790, paint);
            canvas.drawText("" + mStandar2.getText(), pageWidth - 20, 790, paint);
            canvas.drawText("" + mStandar3.getText(), 20, 840, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            canvas.drawRect(20,70, pageWidth - 20, 860, paint);

            pdfDocument.finishPage(page);

            File file = new File(Environment.getExternalStorageDirectory(), "report monitoring.pdf");
            try {
                pdfDocument.writeTo(new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //pdfDocument.close();
            Toast.makeText(ActivityFileKC.this, "File tersimpan", Toast.LENGTH_SHORT).show();

        }


    }
}
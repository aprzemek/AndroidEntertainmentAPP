package com.example.lotto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DownloadActivity extends AppCompatActivity {

    Button btnDownload;
    DownloadManager downloadManager;
    Uri downloadUri;
    final String downloadLink = "http://192.168.43.254/test.pdf";
    String itemName="test";
    long downloadId;
    public static final int RequestPermissionCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        btnDownload = (Button) findViewById(R.id.btndownload);




        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile(itemName, downloadLink);
            }
        });
        if(!checkPermission()){
            ActivityCompat.requestPermissions(DownloadActivity.this, new String[]
                    {
                            READ_EXTERNAL_STORAGE,
                            WRITE_EXTERNAL_STORAGE
                    }, RequestPermissionCode);

        }
    }
    public void downloadFile(String name, String url){
        downloadUri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(downloadUri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE ).setAllowedOverRoaming(true);
        request.setAllowedOverRoaming(false);
        request.setTitle(name + ".pdf");
        request.setDescription("Downloading " + name + ".pdf");
        request.setVisibleInDownloadsUi(true);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS.toString(), "/" + itemName + ".pdf");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadId = downloadManager.enqueue(request);

    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),READ_EXTERNAL_STORAGE );
        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
        SecondPermissionResult == PackageManager.PERMISSION_GRANTED;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case RequestPermissionCode:

                if (grantResults.length > 0) {

                    boolean ReadStoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean WriteStoragePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (ReadStoragePermission && WriteStoragePermission) {

                      Toast.makeText(DownloadActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(DownloadActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                        finish();

                    }
                }

                break;
        }
    }}
package com.example.deneme2;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//192.168.1.39
//10.191.2.120
public class MessageSender extends AsyncTask<String,Void,Void> {
    DataOutputStream dataOutputStream;
    Socket socket;

    @Override
    protected Void doInBackground(String... voids) {
        String message =voids[0];
        try
        {
            // socket oluşturup servera bağlanma
            this.socket = new Socket( "192.168.1.38" , 8080 );//serverın ip sini ve serverın çalıştığı port numarasını sockete gir
            this.dataOutputStream = new DataOutputStream( new BufferedOutputStream( this.socket.getOutputStream() ) );//sockete yazma işlemi yapabilmek için dataoutput stream tanımla
            this.dataOutputStream.writeUTF( message);//writeUTF ile stringi yazma işlemi (send butonuyla alınan mesaj)
            this.dataOutputStream.flush();//mesajı gönder
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}

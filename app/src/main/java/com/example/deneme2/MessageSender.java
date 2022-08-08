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
            // create new socket and connect to the server
            this.socket = new Socket( "192.168.1.57" , 8080 );
        }
        catch( IOException e )
        {
            System.out.println( "failed to create socket" );
            e.printStackTrace();
        }

        System.out.println( "connected" );

        try
        {
            this.dataOutputStream = new DataOutputStream( new BufferedOutputStream( this.socket.getOutputStream() ) );
        }
        catch ( IOException e )
        {
            System.out.println( "failed to create streams" );
            e.printStackTrace();
        }

        try
        {
            this.dataOutputStream.writeUTF( message);
            this.dataOutputStream.flush();
        }
        catch ( IOException e )
        {
            System.out.println( "failed to send" );
            e.printStackTrace();
        }

        return null;
    }
}

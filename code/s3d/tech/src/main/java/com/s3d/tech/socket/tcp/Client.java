package com.s3d.tech.socket.tcp;

import com.s3d.tech.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Client {
    private Logger logger = LoggerFactory.getLogger(Client.class);
    public String ipAddress = "localhost";// server address
    public int serverPort = 55555;//port
    public int heartBeatInterval = 5000;

    private Socket socket;
    private Keeper keeper;

    public Client() {

    }

    public boolean connect(String ipAddress, int serverPort, int heartBeatInterval) {
        this.ipAddress = ipAddress;
        this.serverPort = serverPort;
        this.heartBeatInterval = heartBeatInterval;
        if (!this.openConnection()) {
            return false;
        }
        if (!this.startKeeper()) {
            this.closeConnection();
            return false;
        }
        return true;
    }

    public void close() {
        if (keeper != null) {
            keeper.stop();
        }
        this.closeConnection();
    }

    private boolean openConnection() {
        boolean ifInitialized = false;
        try {
            socket = new Socket(this.ipAddress, this.serverPort);
            ifInitialized = true;
        } catch (IOException e) {
            logger.error("Initialized failed", e);
        } finally {
            if (!ifInitialized) {
                this.closeConnection();
            }
        }
        return ifInitialized;
    }

    private boolean reopenConnection() {
        this.closeConnection();
        return this.openConnection();
    }

    private void closeConnection() {
        try {
            if (socket != null) {
                socket.close();
                socket = null;
            }
        } catch (IOException e) {
            socket = null;
            logger.error("Close socket failed.", e);
        }
    }

    private boolean startKeeper() {
        boolean started = false;
        try {
            keeper = new Keeper();
            keeper.start();
            started = true;
        } catch (Exception e) {
            logger.error("Keeper start failed.", e);
        }
        return started;
    }

    private boolean isConnected() {
        boolean isOk = true;
        if (socket == null) {
            isOk = false;
        } else if (!socket.isConnected() || socket.isClosed()) {
            isOk = false;
        }
        return isOk;
    }

    public boolean writeData(String data) {
        boolean ifWriteOk = false;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(data);
            ifWriteOk = true;
        } catch (IOException e) {
            logger.error("Read data failed by socket", e);
        } finally {

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                logger.error("Write failed", e);
            }

        }
        return ifWriteOk;
    }

    synchronized public String readData() {
        String ret = null;
        DataInputStream input = null;
        try {
            //read data buffer
            input = new DataInputStream(socket.getInputStream());
            ret = input.readUTF();
        } catch (IOException e) {
            logger.error("Write data failed by socket", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("Write data failed by socket", e);
                }
            }
        }
        return ret;
    }

    class Keeper implements Runnable {
        private Thread keeperThread;

        Keeper() {

        }

        @Override
        public void run() {
            while (true) {
                if (isConnected()) {
                    writeData("test" + System.currentTimeMillis());
                } else {
                    if (reopenConnection()) {
                        writeData("reconnected test" + System.currentTimeMillis());
                    }
                }
            }
        }

        public void start() {
            keeperThread = new Thread(this);
            keeperThread.start();
        }

        public void stop() {
            keeperThread.interrupt();
        }
    }
}
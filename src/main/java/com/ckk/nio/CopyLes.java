package com.ckk.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyLes {

	public static void main(String[] args) throws Exception {

		RandomAccessFile aFile = new RandomAccessFile("C:/nicot/aa.txt", "rw");
		RandomAccessFile bFile = new RandomAccessFile("C:/nicot/bb.txt", "rw");
		
		FileChannel inChannel = aFile.getChannel();
		FileChannel outChannel = bFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			buf.flip();

			while (buf.hasRemaining()) {
				outChannel.write(buf);
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
		bFile.close();
	}
}

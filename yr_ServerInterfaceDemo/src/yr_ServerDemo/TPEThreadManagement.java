package yr_ServerDemo;

import java.net.Socket;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TPEThreadManagement implements IThreadManagement {

	private ThreadPoolExecutor threadPoolExecutor;

	@Override
	public void creatThreadPool(String threadPoolConfig) {
		// TODO Auto-generated method stub
		threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
	}

	@Override
	public void addThread(ISocketThread socketThread) {
		// TODO Auto-generated method stub
		
		if (socketThread != null) {			
			//socketThread.setIdentifyAuthority(checkIdentify(socketThread));
			socketThread.setIdentifyAuthority((byte) new Random().nextInt(10));
			threadPoolExecutor.execute(socketThread);			
		}
	}

	@Override
	public void closeClient(Socket socket) {
		// TODO Auto-generated method stub

	}

	@Override
	public void blackList(String blackListConfig) {
		// TODO Auto-generated method stub

	}

	@Override
	public void whiteList(String whiteListConfig) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte checkIdentify(ISocketThread socketThread) {
		// TODO Auto-generated method stub
		return -1;
	}
	
	@Override
	public void closeThreadPool() {
		// TODO Auto-generated method stub

	}
}

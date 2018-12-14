package yr_ServerDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyLogSystem implements ILogSystem {

	private File file;
	private BufferedWriter out;

	@Override
	public boolean openLogFile() {
		// TODO Auto-generated method stub
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date = dateFormat.format(now);
		file = new File(date + ".txt");

		try {
			if (file.exists()) {
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
				return file.exists();
			} else {
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
				return file.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean printLogContent(String logContent) {
		// TODO Auto-generated method stub
		try {
			out.write(logContent + "\r\n");
			out.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void finishLogging() {
		// TODO Auto-generated method stub
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package in.penzebra.gyan.com.starwar.utillity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


public class ConnectionDetector {
	
	private Context _context;
	
	public ConnectionDetector(Context context){
		this._context = context;
	}

	public final boolean isInternetOn() {

		ConnectivityManager connec =
				(ConnectivityManager)_context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
				connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
				connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
				connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {

			return true;

		} else if (
				connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
						connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {

			return false;
		}
		return false;
	}
}




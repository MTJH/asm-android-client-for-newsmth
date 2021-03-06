package com.athena.asm.util.task;

import com.athena.asm.viewmodel.MailViewModel;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class LoadMailContentTask extends AsyncTask<String, Integer, String> {
	private ProgressDialog pdialog;
	
	private MailViewModel m_viewModel;

	public LoadMailContentTask(Context context, MailViewModel viewModel) {
		pdialog = new ProgressDialog(context);
		m_viewModel = viewModel;
	}

	@Override
	protected void onPreExecute() {
		pdialog.setMessage("努力加载中...");
		pdialog.show();
	}

	@Override
	protected String doInBackground(String... params) {
		m_viewModel.getCurrentMailContent();		
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		pdialog.cancel();
		m_viewModel.notifyCurrentMailContentChanged();
	}

}

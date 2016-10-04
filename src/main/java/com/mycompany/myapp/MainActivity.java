package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends Activity 
{
	Button bn ;
	Button bn2;
	TextView t ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		bn = (Button)findViewById(R.id.join);
		final  String url  ="mqqwpa://im/chat?chat_type=wpa&uin=756365439";
		bn2 = (Button) findViewById(R.id.editor);
		bn2.setOnClickListener( new View.OnClickListener(){
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); 
			} 
			
		});
		t = (TextView)findViewById(R.id.text);
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (joinQQGroup("v-OiRJoa5cuMfB-FqODapRPcVLsLmjJC")==false)
				{
					System.out.println("未连接网络或QQ未安装等");
				}
			}
			
		});
		/*if (joinQQGroup("v-OiRJoa5cuMfB-FqODapRPcVLsLmjJC")==false)
		{
			System.out.println("未连接网络或QQ未安装等");
		}*/
    }
	/****************
	 *
	 * 发起添加群流程。群号：南海华附IT社(103136571) 的 key 为： v-OiRJoa5cuMfB-FqODapRPcVLsLmjJC
	 * 调用 joinQQGroup(v-OiRJoa5cuMfB-FqODapRPcVLsLmjJC) 即可发起手Q客户端申请加群 南海华附IT社(103136571)
	 *
	 * @param key 由官网生成的key
	 * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
	 ******************/
	public boolean joinQQGroup(String key) {
		Intent intent = new Intent();
		intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
		// 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		try {
			startActivity(intent);
			return true;
		} catch (Exception e) {
			// 未安装手Q或安装的版本不支持
			return false;
		}
	}
	}

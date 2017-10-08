package juzi.com.replacefontsdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lzt.replacefonts.view.FontFreeFangView;
import com.lzt.replacefonts.view.FontFreeView;
import com.lzt.replacefonts.view.global.Utils;

import juzi.com.replacefontsdemo.R;
import juzi.com.replacefontsdemo.view.global.Configs;
import juzi.com.replacefontsdemo.view.global.SPUtil;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mFontSystemRG;
    private RadioGroup mFontFreeRG;
    private FontFreeView mFontFreeFV;
    private FontFreeFangView mFontFangFV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        mFontSystemRG = (RadioGroup) findViewById(R.id.rg_font_systemtest);
        mFontFreeRG = (RadioGroup) findViewById(R.id.rg_font_test);
        mFontFreeFV = (FontFreeView) findViewById(R.id.ffv_test);
        mFontFangFV = (FontFreeFangView) findViewById(R.id.fffv_test);
        String systemPath = SPUtil.getString(SPUtil.FONT_PATH_SYSTEM,Configs.FONTS_XHJ);
        int position = 0;
        if(Configs.FONTS_XHF.equals(systemPath)){
            position=1;
        }else if(Configs.FONTS_CHJ.equals(systemPath)){
            position=2;
        }else if(Configs.FONTS_YRJ.equals(systemPath)){
            position=3;
        }
        ((RadioButton) mFontSystemRG.getChildAt(position)).setChecked(true);
        String freePath = SPUtil.getString(SPUtil.FONT_PATH_FREE,Configs.FONTS_XHJ);
         position = 0;
        if(Configs.FONTS_XHF.equals(freePath)){
            position=1;
        }else if(Configs.FONTS_CHJ.equals(freePath)){
            position=2;
        }else if(Configs.FONTS_YRJ.equals(freePath)){
            position=3;
        }
        ((RadioButton) mFontFreeRG.getChildAt(position)).setChecked(true);
        mFontFreeFV.setFontPath(freePath);
        mFontFangFV.setFontPath(freePath);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initListener() {

        mFontSystemRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_lf_jian){
                    SPUtil.setString(SPUtil.FONT_PATH_SYSTEM, Configs.FONTS_XHJ);
                }else if(checkedId==R.id.rb_lf_fan){
                    SPUtil.setString(SPUtil.FONT_PATH_SYSTEM, Configs.FONTS_XHF);
                }else if(checkedId==R.id.rb_bzjian){
                    SPUtil.setString(SPUtil.FONT_PATH_SYSTEM, Configs.FONTS_CHJ);
                }else if(checkedId==R.id.rb_yrjian){
                    SPUtil.setString(SPUtil.FONT_PATH_SYSTEM, Configs.FONTS_YRJ);
                }
            }
        });

        mFontFreeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_lf_j){
                    mFontFreeFV.setFontPath(Configs.FONTS_XHJ);
                    mFontFangFV.setFontPath(Configs.FONTS_XHJ);
                    SPUtil.setString(SPUtil.FONT_PATH_FREE, Configs.FONTS_XHJ);
                }else if(checkedId==R.id.rb_lf_f){
                    mFontFreeFV.setFontPath(Configs.FONTS_XHF);
                    mFontFangFV.setFontPath(Configs.FONTS_XHF);
                    SPUtil.setString(SPUtil.FONT_PATH_FREE, Configs.FONTS_XHF);
                }else if(checkedId==R.id.rb_bz){
                    mFontFreeFV.setFontPath(Configs.FONTS_CHJ);
                    mFontFangFV.setFontPath(Configs.FONTS_CHJ);
                    SPUtil.setString(SPUtil.FONT_PATH_FREE, Configs.FONTS_CHJ);
                }else if(checkedId==R.id.rb_yr){
                    mFontFreeFV.setFontPath(Configs.FONTS_YRJ);
                    mFontFangFV.setFontPath(Configs.FONTS_YRJ);
                    SPUtil.setString(SPUtil.FONT_PATH_FREE, Configs.FONTS_YRJ);
                }
            }
        });

        (findViewById(R.id.btn_reset)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.restartApp(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.mxm.baseproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mxm.baseproject.adapter.MenuAdapter;
import com.mxm.baseproject.model.QMenu;
import com.mxm.baseproject.subView.BlurActivity;
import com.mxm.baseproject.subView.GlideActivity;
import com.mxm.baseproject.subView.PhotoViewActivity;
import com.mxm.baseproject.subView.TinkerPlateformActivity;
import com.mxm.baseproject.subView.subView2.ColorFullTextview.ColorFullActivity;
import com.mxm.baseproject.subView.subView2.MVP.LoginActivity;
import com.mxm.baseproject.subView.subView2.MVVM.MVVMActivity;
import com.mxm.baseproject.subView.subView2.MyView.MyViewActivity;
import com.mxm.baseproject.subView.subView2.Refresh.RefreshActivity;
import com.mxm.baseproject.subView.subView2.Retrofit.RxJava_RetrofitActivity;
import com.mxm.baseproject.subView.subView2.SlidingMenu.SlidingMenuActivity;
import com.mxm.baseproject.subView.subView2.Welcome.WelcomeActivity;
import com.mxm.baseproject.util.DefaultParameter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<QMenu> list = getMenuData();
        MenuAdapter menuAdapter = new MenuAdapter(R.layout.item_menu, list);
        menuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.i("onItemClick:" + position);
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, GlideActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, PhotoViewActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, MyViewActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, BlurActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, RxJava_RetrofitActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, MVVMActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, SlidingMenuActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, RefreshActivity.class));
                        break;
                    case 10:
                        // startActivity(new Intent(MainActivity.this, TinkerActivity.class));
                        startActivity(new Intent(MainActivity.this, TinkerPlateformActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, ColorFullActivity.class));
                        break;
                }
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(menuAdapter);

    }

    private List<QMenu> getMenuData() {
        List<QMenu> list = new ArrayList<>();
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "Glide图片加载", "使用Glide进行图片加载,高斯模糊，圆角图片"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "PhotoView", "点击放大,并且可以左右滑动"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "自定义View", "自定义View的初步实现"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "高斯模糊", "RenderScript实现高斯模糊"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "Retrofit2.0+RxJava2.0", "Retrofit2.0+RxJava2.0使用实例"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "MVP模式", "MVP模式实现登录"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "MVVM模式", "MVVM模式实现登录(未完成)"));

        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "欢迎页", "实现常用欢迎页"));

        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "侧边菜单", "DrawerLayout实现"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "下拉刷新上拉加载", "smartrefresh实现"));
        // list.add(new QMenu(DefaultParameter.MiniImgUrl1, "tinker热更新", "demo,暂时使用tinkerplateform"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "tinkerplateform热更新", "demo,tinkerplateform"));
        list.add(new QMenu(DefaultParameter.MiniImgUrl1, "彩色字体霓虹灯字体", "LinearGradient颜色渐变"));

        return list;
    }
}

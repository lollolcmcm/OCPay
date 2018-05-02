package com.ocpay.wallet.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ocpay.wallet.R;
import com.ocpay.wallet.adapter.WalletManageListsAdapter;
import com.ocpay.wallet.databinding.ActivityWalletManageBinding;
import com.ocpay.wallet.greendao.WalletInfo;
import com.ocpay.wallet.greendao.manager.WalletInfoDaoUtils;
import com.snow.commonlibrary.recycleview.BaseAdapter;

import java.util.List;

public class TokenTransactionsActivity extends BaseActivity implements View.OnClickListener {


    private ActivityWalletManageBinding binding;
    private WalletManageListsAdapter manageListsAdapter;

    public static void startTokenTransactionActivity(Activity activity) {
        Intent intent = new Intent(activity, TokenTransactionsActivity.class);
        activity.startActivity(intent);

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(TokenTransactionsActivity.this, R.layout.activity_token_details);
        initActionBar();
        init();


    }

    private void initActionBar() {
        binding.includeActionBar.actionBarTitle.setText(R.string.activity_wallet_manager);
        binding.includeActionBar.ivBack.setImageResource(R.mipmap.ic_back);
        binding.includeActionBar.ivBack.setOnClickListener(this);

    }

    private void init() {

        manageListsAdapter = new WalletManageListsAdapter(TokenTransactionsActivity.this);
        List<WalletInfo> walletInfos = WalletInfoDaoUtils.sqlAll(TokenTransactionsActivity.this);
        manageListsAdapter.setData(walletInfos);

        binding.rlWalletManageList.setLayoutManager(new LinearLayoutManager(TokenTransactionsActivity.this));
        binding.rlWalletManageList.setAdapter(manageListsAdapter);
        manageListsAdapter.notifyDataSetChanged();
        binding.includeBottomButton.rlCreateWallet.setOnClickListener(this);
        binding.includeBottomButton.rlImportWallet.setOnClickListener(this);
        manageListsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView.Adapter adapter, Object data, int position) {
                if (data instanceof WalletInfo) {
                    WalletDetailActivity.startWalletDetailActivity(TokenTransactionsActivity.this, ((WalletInfo) data).getWalletAddress(), ((WalletInfo) data).getWalletName());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_create_wallet:
                WalletCreateActivity.startActivity(this);
                break;
            case R.id.rl_import_wallet:
                WalletImportActivity.startActivity(this);
                break;
        }
    }
}
package com.example.datedating.ui.screen.core;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.example.datedating.R;
import com.example.datedating.databinding.FragmentCoreBinding;
import com.example.datedating.ui.MainActivity;
import com.example.datedating.ui.screen.core.adapter.CardsAdapter;
import com.yandex.mobile.ads.common.AdError;
import com.yandex.mobile.ads.common.AdRequestConfiguration;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.common.ImpressionData;
import com.yandex.mobile.ads.interstitial.InterstitialAd;
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener;
import com.yandex.mobile.ads.interstitial.InterstitialAdLoadListener;
import com.yandex.mobile.ads.interstitial.InterstitialAdLoader;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class CoreFragment extends Fragment {
    @Nullable
    private InterstitialAd mInterstitialAd = null;
    @Nullable
    private InterstitialAdLoader mInterstitialAdLoader = null;

    private CoreViewModel mViewModel;
    private FragmentCoreBinding binding;
    private int countDirection = 0;
    private String[] listGif = new String[]{"https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif",
            "https://compote.slate.com/images/697b023b-64a5-49a0-8059-27b963453fb1.gif",
            "https://user-images.githubusercontent.com/14011726/94132137-7d4fc100-fe7c-11ea-8512-69f90cb65e48.gif",
            "https://hips.hearstapps.com/pop.h-cdn.co/assets/17/24/640x320/landscape-1497533116-not-dead.gif?resize=640:*",
            "https://www.socialpilot.co/wp-content/uploads/2023/02/gif.gif",
            "https://i.pinimg.com/originals/f7/b3/db/f7b3db9036f64203f261a894b1c6333b.gif",
            "https://i0.wp.com/www.printmag.com/wp-content/uploads/2021/02/4cbe8d_f1ed2800a49649848102c68fc5a66e53mv2.gif?fit=476%2C280&ssl=1",
            "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif",
            "https://compote.slate.com/images/697b023b-64a5-49a0-8059-27b963453fb1.gif",
            "https://user-images.githubusercontent.com/14011726/94132137-7d4fc100-fe7c-11ea-8512-69f90cb65e48.gif",
            "https://hips.hearstapps.com/pop.h-cdn.co/assets/17/24/640x320/landscape-1497533116-not-dead.gif?resize=640:*",
            "https://www.socialpilot.co/wp-content/uploads/2023/02/gif.gif",
            "https://i.pinimg.com/originals/f7/b3/db/f7b3db9036f64203f261a894b1c6333b.gif",
            "https://i0.wp.com/www.printmag.com/wp-content/uploads/2021/02/4cbe8d_f1ed2800a49649848102c68fc5a66e53mv2.gif?fit=476%2C280&ssl=1",
            "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif",
            "https://compote.slate.com/images/697b023b-64a5-49a0-8059-27b963453fb1.gif",
            "https://user-images.githubusercontent.com/14011726/94132137-7d4fc100-fe7c-11ea-8512-69f90cb65e48.gif",
            "https://hips.hearstapps.com/pop.h-cdn.co/assets/17/24/640x320/landscape-1497533116-not-dead.gif?resize=640:*",
            "https://www.socialpilot.co/wp-content/uploads/2023/02/gif.gif",
            "https://i.pinimg.com/originals/f7/b3/db/f7b3db9036f64203f261a894b1c6333b.gif",
            "https://i0.wp.com/www.printmag.com/wp-content/uploads/2021/02/4cbe8d_f1ed2800a49649848102c68fc5a66e53mv2.gif?fit=476%2C280&ssl=1"};
    private CardsAdapter cardsAdapter;
    private CardStackLayoutManager cardStackLayoutManager;



    public static CoreFragment newInstance() {
        return new CoreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCoreBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        CardStackView cardStackView = binding.layoutCards;
        cardStackLayoutManager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {}
            @Override
            public void onCardSwiped(Direction direction) {
                if (direction == Direction.Right){
                    Toast.makeText(getContext(), "Direction Right", Toast.LENGTH_SHORT).show();
                    countDirection++;
                    if (countDirection==5) {
                        showAd();
                        countDirection = 0;
                    }
                }
                if (direction == Direction.Left){
                    Toast.makeText(getContext(), "Direction Left", Toast.LENGTH_SHORT).show();
                    countDirection++;
                    if (countDirection==5) {
                        showAd();
                        countDirection = 0;
                    }
                }
            }
            @Override
            public void onCardRewound() {}
            @Override
            public void onCardCanceled() {}
            @Override
            public void onCardAppeared(View view, int position) {}
            @Override
            public void onCardDisappeared(View view, int position) {}
        });

        cardStackLayoutManager.setStackFrom(StackFrom.Top);
        cardStackLayoutManager.setVisibleCount(3);
        cardStackLayoutManager.setTranslationInterval(12.0f);
        cardStackLayoutManager.setScaleInterval(0.90f);
        cardStackLayoutManager.setSwipeThreshold(0.3f);
        cardStackLayoutManager.setMaxDegree(0.0f);
        cardStackLayoutManager.setDirections(Direction.HORIZONTAL);
        cardStackLayoutManager.setCanScrollVertical(false);
        cardStackLayoutManager.setCanScrollHorizontal(true);
        cardStackLayoutManager.setSwipeableMethod(SwipeableMethod.Manual);
        cardStackLayoutManager.setOverlayInterpolator(new LinearInterpolator());
        cardsAdapter = new CardsAdapter(listGif);
        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.setAdapter(cardsAdapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
        mInterstitialAdLoader = new InterstitialAdLoader(getContext());
        mInterstitialAdLoader.setAdLoadListener(new InterstitialAdLoadListener() {
            @Override
            public void onAdLoaded(@NonNull final InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                // The ad was loaded successfully. Now you can show loaded ad.
            }

            @Override
            public void onAdFailedToLoad(@NonNull final AdRequestError adRequestError) {
                // Ad failed to load with AdRequestError.
                // Attempting to load a new ad from the onAdFailedToLoad() method is strongly discouraged.
            }
        });
        loadInterstitialAd();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadInterstitialAd() {
        if (mInterstitialAdLoader != null ) {
            final AdRequestConfiguration adRequestConfiguration =
                    new AdRequestConfiguration.Builder("demo-interstitial-yandex").build();
            mInterstitialAdLoader.loadAd(adRequestConfiguration);
        }
    }
    private void showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.setAdEventListener(new InterstitialAdEventListener() {
                @Override
                public void onAdShown() {
                    // Called when ad is shown.
                }

                @Override
                public void onAdFailedToShow(@NonNull final AdError adError) {
                    Log.d("TAG","qwe");
                }

                @Override
                public void onAdDismissed() {
                    // Called when ad is dismissed.
                    // Clean resources after Ad dismissed
                    if (mInterstitialAd != null) {
                        mInterstitialAd.setAdEventListener(null);
                        mInterstitialAd = null;
                    }

                    // Now you can preload the next interstitial ad.
                    loadInterstitialAd();
                }

                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.
                }

                @Override
                public void onAdImpression(@Nullable final ImpressionData impressionData) {
                    // Called when an impression is recorded for an ad.
                }
            });
            mInterstitialAd.show(getActivity());
        }
    }
}
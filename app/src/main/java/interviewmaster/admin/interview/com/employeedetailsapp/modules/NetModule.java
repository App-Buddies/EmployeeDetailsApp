package interviewmaster.admin.interview.com.employeedetailsapp.modules;

import android.app.Application;
import android.content.Context;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    String mBaseurl;
    Context mContext;

    public NetModule(String url) {
        this.mBaseurl = url;
    }


    @Provides
    @Singleton
    GsonConverterFactory providegsonconverterfactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory providerxfactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    OkHttpClient okHttpClient(Cache cache) {
        return new OkHttpClient.Builder().
                cache(cache).
                build();
    }

    @Singleton
    @Provides
    Cache providecache(Application application) {
        int size = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), size);
        return cache;
    }

    @Singleton
    @Provides
    Gson getsson() {
        return new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                create();
    }

    @Singleton
    @Provides
    Retrofit getRetrofit(Gson gson, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return new Retrofit.Builder().
                baseUrl(mBaseurl).
                addConverterFactory(gsonConverterFactory).
                addCallAdapterFactory(rxJavaCallAdapterFactory).
                client(okHttpClient).
                build();
    }

    @Provides
    @Singleton
    Context providecontext() {
        return mContext;
    }


}

package com.roygf.coinapp.dependency_injection

import com.roygf.coinapp.data.repositories.NetworkRepositoryImpl
import com.roygf.coinapp.data.repositories.StorageRepositoryImpl
import com.roygf.coinapp.domain.NetworkRepository
import com.roygf.coinapp.domain.StorageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    @Singleton
    abstract fun provideStorageRepository(storageRepositoryImpl: StorageRepositoryImpl): StorageRepository

}
package com.sgupta.basicsetup.di

import com.sgupta.basicsetup.data.repoimpl.NewsRepoImpl
import com.sgupta.basicsetup.domain.repo.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindAlbumRepoImpl(impl: NewsRepoImpl): NewsRepo
}
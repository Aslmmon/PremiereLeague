package com.example.premiereleague.di


import com.example.premiereleague.common.repo.MainRepository.MainRepo
import org.koin.dsl.module


val repositoryModule = module {
    single { MainRepo(get()) }
}
package com.example.premiereleague.feature.fixtures.main_fixtures

import android.service.autofill.FieldClassification
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.content.contentValuesOf
import androidx.lifecycle.MutableLiveData
import com.example.core.data_source.MainFixtureDataSource
import com.example.core.database.MatchDao
import com.example.core.model.*
import com.example.core.network.Api
import com.example.core.repository.MainFixtureRepository
import com.example.premiereleague.framework.MainFixturesDataSourceImpl
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainFixturesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var dataSource: MainFixtureDataSource
    @MockK
    lateinit var dataSourceImpl: MainFixturesDataSourceImpl
    @MockK
    lateinit var api: Api
    @MockK
    lateinit var matchDao: MatchDao
    @MockK
    lateinit var mainFixtureRepository: MainFixtureRepository
    @MockK
    lateinit var viewModel: MainFixturesViewModel
    @MockK
    lateinit var matchesResponse: MatchesResponse

    @Before
    fun setup() = MockKAnnotations.init(this, true)

    @Test
    fun `matchDetailsAreReturn`() {
       // mockkObject(MatchesResponse)
        var _MatchesDetails = MutableLiveData<MatchesResponse>()
        dataSourceImpl = MainFixturesDataSourceImpl(api, matchDao)
        var dataSource = spyk<MainFixtureDataSource>()
        every { dataSource.getMatchDetails(any()) } answers {
            print("ok")
        }
        mainFixtureRepository = MainFixtureRepository(dataSource)
        viewModel = MainFixturesViewModel(mainFixtureRepository)
        viewModel.getMatchDetails()
        verify(exactly = 1) { mainFixtureRepository.getMatchesDetails(_MatchesDetails) }

    }
}
package com.nordsec.locationapp.locations.ui.viewmodels


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.nordsec.locationapp.locations.data.repositories.LocationsRepository
import com.nordsec.locationapp.locations.domain.LocationsViewState
import com.nordsec.locationapp.rx.testObserver
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: LocationsRepository

    @Mock
    private lateinit var locationsViewState: LocationsViewState

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun `should emit locations list view state when getLocationsSortedByCityName is fetched`() {
        Mockito.`when`(repository.getLocationsSortedByCityName()).thenReturn(
            Observable.just(
                locationsViewState
            )
        )
        val responseObserver = mainViewModel.locationListData.testObserver()
        mainViewModel.getLocationsSortedByCityName()
        Truth.assertThat(responseObserver.observedValues).isEqualTo(listOf(locationsViewState))
    }

    @Test
    fun `should emit locations list view state when getLocationsSortedByDistance is fetched`() {
        Mockito.`when`(repository.getLocationsSortedByDistance("")).thenReturn(
            Observable.just(
                locationsViewState
            )
        )
        val responseObserver = mainViewModel.locationListData.testObserver()
        mainViewModel.getLocationsSortedByDistance("")
        Truth.assertThat(responseObserver.observedValues).isEqualTo(listOf(locationsViewState))
    }

}